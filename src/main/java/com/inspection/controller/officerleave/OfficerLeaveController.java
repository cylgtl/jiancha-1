package com.inspection.controller.officerleave;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.entity.officerleave.OfficerLeaveMain;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.util.BeanPropertyUtils;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.web.utils.ResourceUtils;
import org.jeecgframework.web.utils.SessionUtils;
import org.jeecgframework.web.utils.StringUtils;
import org.jeecgframework.platform.common.tag.easyui.TagUtil;
import org.jeecgframework.platform.constant.Globals;
import org.jeecgframework.web.common.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.web.system.controller.BaseController;
import org.jeecgframework.web.system.entity.TSDepart;
import org.jeecgframework.web.system.entity.TSTypegroup;
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.service.SystemService;

import com.inspection.entity.officerleave.OfficerAuditingEntity;
import com.inspection.entity.officerleave.OfficerLeaveEntity;
import com.inspection.entity.officerleave.OfficerPerformanceEntity;
import com.inspection.pojo.OfficerLeaveMainPage;
import com.inspection.service.officerleave.OfficerLeaveServiceI;

/**   
 * @Title: Controller
 * @Description: 军官请假信息
 * @author zhangdaihao
 * @date 2018-07-05 11:01:36
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/officerLeaveController")
public class OfficerLeaveController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OfficerLeaveController.class);

	@Autowired
	private OfficerLeaveServiceI officerLeaveService;
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
	 * 军官请假信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "officerLeave")
	public ModelAndView officerLeave(HttpServletRequest request) {
		List<TSDepart> departList = systemService.findByHql("from TSDepart where orgType=? ", new Object[]{"2"});
		List<TSDepart> list = new ArrayList<TSDepart>();
		if(null != departList && departList.size() > 0){
			for(TSDepart depart:departList){
				String departCode = depart.getOrgCode();
				if(departCode.length() == 2){
					list.add(depart);
				}
			}
		}
		request.setAttribute("departList", list);
		return new ModelAndView("com/inspection/officerleave/officerLeaveList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param officerLeave
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(OfficerLeaveEntity officerLeave,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(OfficerLeaveEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
				String departId = officerLeave.getDepartId();
				/*boolean isAdmin = SessionUtils.isAdminRole("admin");
				boolean isManager = SessionUtils.isAdminRole("manager");
				
				if(StringUtils.isNotEmpty(departId) && !isAdmin){
					cq.eq("departId", departId);
				}
				
				//审核人员
				if(isManager){
					String departCodes = SessionUtils.getCurrentDepartsCode();
					String[] codes = departCodes.split(",");
					cq.in("departId", codes);
				}
				cq.add();*/
				officerLeave.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);
				//查询条件组装器
				HqlGenerateUtil.installHql(cq, officerLeave, request.getParameterMap());
				this.officerLeaveService.findDataGridReturn(cq, true);
				List<OfficerLeaveEntity> results= dataGrid.getResults();
				if(null != results && results.size() > 0 ){
					for(OfficerLeaveEntity sl:results){
						String jobTile = sl.getJobTitle();
						sl.setJobTitle("部职别："+jobTile);
					}
				}
				
				dataGrid.setPage(dataGrid.getPage());
				dataGrid.setTotal(dataGrid.getTotal());
				dataGrid.setRows(dataGrid.getRows());
		TagUtil.datagrid(response, dataGrid);	
	}
	
	/**
	 * 删除军官请假信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(OfficerLeaveEntity officerLeave, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = officerLeave.getId();
		officerLeave = systemService.findEntity(OfficerLeaveEntity.class, officerLeave.getId());
		message = "军官请假信息删除成功";
		systemService.executeSql("delete from jc_officer_leave_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_officer_leave_performance where OFFICER_ID=?", officerId);
		officerLeaveService.delete(officerLeave);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 删除军官请假意见和结果信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteAuditing")
	@ResponseBody
	public AjaxJson deleteAuditing(OfficerAuditingEntity  officerAuditingEntity, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			officerAuditingEntity = systemService.findEntity(OfficerAuditingEntity.class,id);
	
		officerLeaveService.delete(officerAuditingEntity);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		message = "军官请假意见和结果信息删除成功";
		j.setMsg(message);
		}
		return j;
	}


	@RequestMapping(params = "deletePerformances")
	@ResponseBody
	public AjaxJson deletePerformances(OfficerPerformanceEntity  officerPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			officerPerformance = systemService.findEntity(OfficerPerformanceEntity.class,id);
	
		officerLeaveService.delete(officerPerformance);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		message = "信息删除成功";
		j.setMsg(message);
		}
		return j;
	}

	/**
	 * 添加军官请假信息
	 * 
	 * @param officerLeave
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(OfficerLeaveEntity officerLeave, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(officerLeave.getId())) {
			message = "军官请假信息更新成功";
			OfficerLeaveEntity t = officerLeaveService.find(OfficerLeaveEntity.class, officerLeave.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(officerLeave, t);
				officerLeaveService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "军官请假信息更新失败";
			}
		} else {
			message = "军官请假信息添加成功";
			officerLeave.setDepartId(SessionUtils.getCurrentDepartsCode());
			officerLeaveService.save(officerLeave);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}
	
	
	/**
	 * 
	 * @Title: addorupdateOperate
	 * @Description: 保存平时表现和审批结果
	 * @param officerLeave
	 * @param req
	 * @return AjaxJson
	 * @author  yxd
	 * @date 2018年7月6日 上午10:00:39
	 */
	@RequestMapping(params = "addorupdateOperate")
	@ResponseBody
	public AjaxJson  addorupdateOperate(OfficerLeaveMainPage officerLeave, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<OfficerPerformanceEntity>  performances =officerLeave.getPerformances();
		List<OfficerAuditingEntity> results = officerLeave.getResults();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		String  publicUrl=ResourceUtils.getResourcePublicURL();
		if(StringUtils.isNotEmpty(officerId)){
		for(OfficerPerformanceEntity op:performances){
			op.setCreateTime(new Date());
			op.setCreateId(userId);
			op.setOfficerId(officerId);
			op.setFileId(publicUrl+op.getFileId());
			officerLeaveService.saveOrUpdate(op);
		}
		
		for(OfficerAuditingEntity oa:results){
			oa.setCreateTime(new Date());
			oa.setCreateId(userId);
			oa.setOfficerId(officerId);
			oa.setFileId(publicUrl+oa.getFileId());
			officerLeaveService.saveOrUpdate(oa);
		}
		}
		result.setMsg("保存成功");
		return result;
	}

	/**
	 * 军官请假信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(OfficerLeaveEntity officerLeave, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(officerLeave.getId())) {
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, officerLeave.getId());
			req.setAttribute("officerLeavePage", officerLeave);
		}
		return new ModelAndView("com/inspection/officerleave/officerLeave");
	}
	
	/**
	 * 军官请假处理详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMain")
	public ModelAndView viewMain(OfficerLeaveEntity officerLeave, HttpServletRequest req) {
		String id = req.getParameter("id");
		/*if (StringUtils.isNotEmpty(id)) {
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
			req.setAttribute("officerLeavePage", officerLeave);
		}*/
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		req.setAttribute("officerLeaveId", id);
		return new ModelAndView("com/inspection/officerleave/main");
	}
	
	/**
	 * 军官请假个人基本信息详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMyselfInfo")
	public ModelAndView viewMyselfInfo(OfficerLeaveEntity officerLeave, HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
			req.setAttribute("officerLeavePage", officerLeave);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/officerleave/myselfInfo");
		}else{
			return new ModelAndView("com/inspection/officerleave/myselfInfoDetial");
			
		}
	}
	
	
	/**
	 * 军官请假个人平时表现详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewPerformance")
	public ModelAndView viewPerformance(HttpServletRequest req) {
		String officerId = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(officerId)) {
			List<OfficerPerformanceEntity> lists= officerLeaveService.findAllPerformances (officerId);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", officerId);
		}
		
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/officerleave/performance");
		}else{
			return new ModelAndView("com/inspection/officerleave/performanceDetial");
			
		}
		
	}
	
	
	/**
	 * 军官请假上级意见结果详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewAuditing")
	public ModelAndView viewAuditing(HttpServletRequest req) {
		String officerId = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(officerId)) {
			List<OfficerAuditingEntity> lists= officerLeaveService.findAllAudits (officerId);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", officerId);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/officerleave/auditing");
		}else{
			return new ModelAndView("com/inspection/officerleave/auditingDetial");
		}
		
	}
	
	
	/**
	 * 军官请假处理详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(OfficerLeaveEntity officerLeave, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):officerLeave.getId();
		String isView =  req.getParameter("isView");
		if (StringUtils.isNotEmpty(id)) {
			OfficerLeaveMain result = officerLeaveService.findEntity(OfficerLeaveMain.class, id);
			if(result == null) {
				result = new OfficerLeaveMain();
			}
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
			result.setEntity(officerLeave);
			req.setAttribute("officerLeavePage", result);
		}

		req.setAttribute("isView", isView);
		req.setAttribute("officerLeaveId", id);
		return new ModelAndView("com/inspection/officerleave/mainDetial");
	}
	

	
	
}
