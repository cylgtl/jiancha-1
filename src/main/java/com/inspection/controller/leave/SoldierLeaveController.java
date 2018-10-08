package com.inspection.controller.leave;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.entity.officerleave.OfficerLeaveMain;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.BeanPropertyUtils;
import org.jeecgframework.platform.common.tag.easyui.TagUtil;
import org.jeecgframework.platform.constant.Globals;
import org.jeecgframework.web.common.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.web.system.controller.BaseController;
import org.jeecgframework.web.system.entity.TSDepart;
import org.jeecgframework.web.system.entity.TSTypegroup;
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.service.DepartService;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.utils.ResourceUtils;
import org.jeecgframework.web.utils.SessionUtils;
import org.jeecgframework.web.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inspection.entity.leave.SoldierAuditingEntity;
import com.inspection.entity.leave.SoldierLeaveEntity;
import com.inspection.entity.leave.SoldierPerformanceEntity;
import com.inspection.pojo.SoldierLeaveMainPage;
import com.inspection.service.leave.SoldierAuditingServiceI;
import com.inspection.service.leave.SoldierLeaveServiceI;
import com.inspection.service.leave.SoldierPerformanceServiceI;

/**   
 * @Title: Controller
 * @Description: 战士请假
 * @author zhangdaihao
 * @date 2018-07-04 21:59:10
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/soldierLeaveController")
public class SoldierLeaveController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SoldierLeaveController.class);

	@Autowired
	private SoldierLeaveServiceI soldierLeaveService;
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private DepartService departService;
	
	@Autowired
	private SoldierPerformanceServiceI soldierPerformanceService;
	
	@Autowired
	private SoldierAuditingServiceI soldierAuditingService;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 战士请假列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "soldierLeave")
	public ModelAndView soldierLeave(HttpServletRequest request) {
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
		return new ModelAndView("com/inspection/leave/soldierLeaveList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param soldierLeave
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SoldierLeaveEntity soldierLeave,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SoldierLeaveEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
		String departId = soldierLeave.getDepartId();
		
		/*boolean isAdmin = SessionUtils.isAdminRole("admin");
		boolean isManager = SessionUtils.isAdminRole("manager");*/
		
	/*	if(StringUtils.isNotEmpty(departId) && !isAdmin){
			cq.eq("departId", departId);
		}
		
		//审核人员
		if(isManager){
			String departCodes = SessionUtils.getCurrentDepartsCode();
			String[] codes = departCodes.split(",");
			cq.in("departId", codes);
		}
		cq.add();*/
		//查询条件组装器
		soldierLeave.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);
		HqlGenerateUtil.installHql(cq, soldierLeave, request.getParameterMap());
		this.soldierLeaveService.findDataGridReturn(cq, true);
		List<SoldierLeaveEntity> results= dataGrid.getResults();
		if(null != results && results.size() > 0 ){
			for(SoldierLeaveEntity sl:results){
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
	 * 删除战士请假
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SoldierLeaveEntity soldierLeave, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String leaveId = soldierLeave.getId();
		soldierLeave = systemService.findEntity(SoldierLeaveEntity.class, leaveId);
	
		message = "战士请假删除成功";
		
		systemService.executeSql("delete from jc_soldier_auditing where LEAVE_ID=?", leaveId);
		systemService.executeSql("delete from jc_soldier_performance where LEAVE_ID=?", leaveId);
		
		soldierLeaveService.delete(soldierLeave);
		
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加战士请假
	 * 
	 * @param soldierLeave
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SoldierLeaveEntity soldierLeave, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
	
		if (StringUtils.isNotEmpty(soldierLeave.getId())) {
			message = "战士请假更新成功";
			SoldierLeaveEntity t = soldierLeaveService.find(SoldierLeaveEntity.class, soldierLeave.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(soldierLeave, t);
				soldierLeaveService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "战士请假更新失败";
			}
		} else {
			message = "战士请假添加成功";
			soldierLeave.setDepartId(SessionUtils.getCurrentDepartsCode());
			soldierLeaveService.save(soldierLeave);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 战士请假列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SoldierLeaveEntity soldierLeave, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(soldierLeave.getId())) {
			soldierLeave = soldierLeaveService.findEntity(SoldierLeaveEntity.class, soldierLeave.getId());
			req.setAttribute("soldierLeavePage", soldierLeave);
		}
		
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","leave_type");
		if(typegroup != null){
			req.setAttribute("leaveTypeList", typegroup.getTSTypes());
		}
		
		return new ModelAndView("com/inspection/leave/soldierLeave");
	}
	
	
	/**
	 * 
	 * @Title: addorupdateOperate
	 * @Description: 保存平时表现和审批结果
	 * @param soldierLeave
	 * @param req
	 * @return AjaxJson
	 * @author  kangjie1209@126.com
	 * @date 2018年7月5日 下午10:42:39
	 */
	@RequestMapping(params = "addorupdateOperate")
	@ResponseBody
	public AjaxJson  addorupdateOperate(SoldierLeaveMainPage soldierLeave, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		
		List<SoldierPerformanceEntity>  performances =soldierLeave.getPerformances();
		List<SoldierAuditingEntity> results = soldierLeave.getResults();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		
		String  publicUrl=ResourceUtils.getResourcePublicURL();
		
		for(SoldierPerformanceEntity sp:performances){
			sp.setCreateTime(new Date());
			sp.setCreateId(userId);
			sp.setFile(publicUrl  + sp.getFile());
			soldierPerformanceService.save(sp);
		}
		
		for(SoldierAuditingEntity sa:results){
			sa.setCreateTime(new Date());
			sa.setCreateId(userId);
			//String[] fileName = militraining.getFileId().split("/");
			sa.setFile(publicUrl  + sa.getFile());
			soldierAuditingService.save(sa);
		}
		result.setMsg("保存成功");
		return result;
	}

	@RequestMapping(params = "viewDetailMain")
	public ModelAndView viewDetailMain(SoldierLeaveEntity soldierEntity, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):soldierEntity.getId();
		String isView =  req.getParameter("isView");
		if (StringUtils.isNotEmpty(id)) {
			OfficerLeaveMain result = soldierLeaveService.findEntity(OfficerLeaveMain.class, id);
			if(result == null){
				result = new OfficerLeaveMain();
			}
			soldierEntity = soldierLeaveService.findEntity(SoldierLeaveEntity.class, id);
			result.setSoldierEntity(soldierEntity);
			req.setAttribute("soldierLeavePage", result);
		}
		req.setAttribute("id", id);
		if(isView.equals("true")){
			return new ModelAndView("com/inspection/leave/viewDetailMain");
		} else {
			return new ModelAndView("com/inspection/leave/processSoldierLeave");
		}
	}

	/**
	 * 处理页面
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "modifyProcess")
	@ResponseBody
	public AjaxJson modifyProcess(OfficerLeaveMain officerLeaveMain, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String id = req.getParameter("id");
		officerLeaveMain.setId(id);
		soldierLeaveService.saveOrUpdate(officerLeaveMain);
		result.setMsg("保存成功");
		return result;
	}
}
