package com.inspection.controller.report;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.BeanPropertyUtils;
import org.jeecgframework.platform.common.tag.easyui.TagUtil;
import org.jeecgframework.platform.constant.Globals;
import org.jeecgframework.web.common.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.web.system.controller.BaseController;
import org.jeecgframework.web.system.entity.TSRole;
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.utils.SessionUtils;
import org.jeecgframework.web.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inspection.entity.report.ReportEntity;
import com.inspection.service.report.ReportServiceI;

/**   
 * @Title: Controller
 * @Description: 信访举报
 * @author zhangdaihao
 * @date 2018-06-25 20:51:21
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/reportController")
public class ReportController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReportController.class);

	@Autowired
	private ReportServiceI reportService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 信访举报列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "report")
	public ModelAndView report(HttpServletRequest request) {
		return new ModelAndView("com/inspection/report/reportList");
	}
	
	
	@RequestMapping(params = "reportDeal")
	public ModelAndView reportDeal(HttpServletRequest request) {
		return new ModelAndView("com/inspection/report/reportListDeal");
	}
	
	

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param report
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ReportEntity report,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ReportEntity.class, dataGrid);
		String isFilter = request.getParameter("isFilter");
		TSUser user = SessionUtils.getCurrentUser();
		
		if(StringUtils.isNotEmpty(isFilter)){
			boolean isSuperAdmin = false;
			if(CollectionUtils.isNotEmpty(user.getRoles())){
				int roleSize = user.getRoles().size();
				String[] roleIds = new String[roleSize];
				for (int i = 0; i < roleSize; i++) {
					TSRole role = user.getRoles().get(i);
					roleIds[i] = role.getId();
					if("admin".equals(role.getRoleCode())){
						isSuperAdmin = true;
						break;
					}
				}
				
				if(!isSuperAdmin){
					cq.in("roleId", roleIds);
				}
			}
		}
		
	/*	String notFiter = request.getParameter("notFiter");
		if(StringUtils.isNotEmpty(notFiter)){
			String roleCode = SessionUtils.getCurrentRoleCode();
			if(!roleCode.contains("admin")){
				cq.eq("createUserId", user.getId());
			}
		}*/
		
		boolean isVistor = SessionUtils.isAdminRole("vistor");
		if(isVistor){
			cq.isNotNull("replyContent");
		}
		
		cq.add();
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, report, request.getParameterMap());
		this.reportService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除信访举报
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ReportEntity report, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		report = systemService.findEntity(ReportEntity.class, report.getId());
		message = "信访举报删除成功";
		reportService.delete(report);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加信访举报
	 * 
	 * @param report
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ReportEntity report, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		TSUser user = SessionUtils.getCurrentUser();
		if (StringUtils.isNotEmpty(report.getId())) {
			message = "信访举报更新成功";
			ReportEntity t = reportService.find(ReportEntity.class, report.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(report, t);
                t.setReplyTime(new Date());
                t.setReplayUserId(user.getId());
                t.setStatus("E");
				reportService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "信访举报更新失败";
			}
		} else {
			message = "信访举报添加成功";
			String name = report.getPersonName();
			String phone =report.getPersonPhone();
			
			if(StringUtils.isNotEmpty(name) || StringUtils.isNotEmpty(phone)){
				report.setAnonymous("1");
			}else{
				report.setAnonymous("0");
			}
			report.setStatus("W");
			report.setCreateUserId(user.getId());
			report.setCreateTime(new Date());
			reportService.save(report);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 信访举报列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ReportEntity report, HttpServletRequest req) {
		String url = req.getParameter("url");
		String id = req.getParameter("id");
		
		String reportId = req.getParameter("reportId");
		
		if (StringUtils.isNotEmpty(report.getId())) {
			reportId = report.getId();
		}
		
		if(StringUtils.isNotEmpty(reportId)){
			report = reportService.findEntity(ReportEntity.class,reportId);
			req.setAttribute("reportPage", report);
		}
		
		if(StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(url)) {
			req.setAttribute("url", url+"&id="+id);
		}
		
		List<TSRole> roleList  = systemService.findByHql("from TSRole where roleCode in ('sjjjbm','bz','zr','cmz','fzw','cflz','jflz','zw','lz','jw')");
		req.setAttribute("roleList", roleList);
		
		return new ModelAndView("com/inspection/report/report");
	}
	
	
	/**
	 * 
	 * @Title: addorupdate
	 * @Description: 举报回复
	 * @param report
	 * @param req
	 * @return ModelAndView
	 * @author  kangjie1209@126.com
	 * @date 2018年6月26日 下午9:44:02
	 */
	@RequestMapping(params = "replyReport")
	public ModelAndView replyReport(ReportEntity report, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(report.getId())) {
			report = reportService.findEntity(ReportEntity.class, report.getId());
			req.setAttribute("reportPage", report);
		}
		
		List<TSRole> roleList  = systemService.findByHql("from TSRole where roleCode in ('sjjjbm','bz','zr','cmz','fzw','cflz','jflz','zw','lz','jw')");
		req.setAttribute("roleList", roleList);
		
		return new ModelAndView("com/inspection/report/replyReport");
	}
}
