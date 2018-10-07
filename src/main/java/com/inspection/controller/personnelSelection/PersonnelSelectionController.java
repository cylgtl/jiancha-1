package com.inspection.controller.personnelSelection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.pojo.PersonnelSelectionMain;
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
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.utils.SessionUtils;
import org.jeecgframework.web.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inspection.entity.personnelSelection.PersonnelSelectionAssessmentEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionAuditEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionPerformanceEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionRecommendEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionReportEntity;
import com.inspection.pojo.PersonnelSelectionMainPage;
import com.inspection.service.personnelSelection.PersonnelSelectionServiceI;

/**   
 * @Title: Controller
 * @Description: 技术学兵选调
 * @author zhangdaihao
 * @date 2018-07-08 22:57:43
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/personnelSelectionController")
public class PersonnelSelectionController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PersonnelSelectionController.class);

	@Autowired
	private PersonnelSelectionServiceI personnelSelectionService;
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
	 * 技术学兵选调列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "personnelSelection")
	public ModelAndView personnelSelection(HttpServletRequest request) {
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
		return new ModelAndView("com/inspection/personnelSelection/personnelSelectionList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param personnelSelection
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(PersonnelSelectionEntity personnelSelection,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PersonnelSelectionEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
		String departId = personnelSelection.getDepartId();
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
		personnelSelection.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);

		//查询条件组装器
		HqlGenerateUtil.installHql(cq, personnelSelection, request.getParameterMap());
		this.personnelSelectionService.findDataGridReturn(cq, true);
		List<PersonnelSelectionEntity> results= dataGrid.getResults();
		if(null != results && results.size() > 0 ){
			for(PersonnelSelectionEntity sl:results){
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
	 * 删除技术学兵选调
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PersonnelSelectionEntity personnelSelection, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = personnelSelection.getId();
		personnelSelection = systemService.findEntity(PersonnelSelectionEntity.class, personnelSelection.getId());
		message = "技术学兵选调删除成功";
		systemService.executeSql("delete from jc_technical_personnel_selection_assessment where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_technical_personnel_selection_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_technical_personnel_selection_performance where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_technical_personnel_selection_recommend where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_technical_personnel_selection_report where OFFICER_ID=?", officerId);
		personnelSelectionService.delete(personnelSelection);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加技术学兵选调
	 * 
	 * @param personnelSelection
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PersonnelSelectionEntity personnelSelection, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(personnelSelection.getId())) {
			message = "技术学兵选调更新成功";
			PersonnelSelectionEntity t = personnelSelectionService.find(PersonnelSelectionEntity.class, personnelSelection.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(personnelSelection, t);
				personnelSelectionService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "技术学兵选调更新失败";
			}
		} else {
			message = "技术学兵选调添加成功";
			personnelSelection.setDepartId(SessionUtils.getCurrentDepartsCode());
			personnelSelectionService.save(personnelSelection);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 技术学兵选调列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PersonnelSelectionEntity personnelSelection, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(personnelSelection.getId())) {
			personnelSelection = personnelSelectionService.findEntity(PersonnelSelectionEntity.class, personnelSelection.getId());
			req.setAttribute("personnelSelectionPage", personnelSelection);
		}
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		if(sexgroup!=null){
			req.setAttribute("sexList", sexgroup.getTSTypes());
		}
		TSTypegroup selectiongroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","selection");
		if(selectiongroup!=null){
			req.setAttribute("selectionList", selectiongroup.getTSTypes());
		}
		return new ModelAndView("com/inspection/personnelSelection/personnelSelection");
	}
	
	/**
	 * 删除各级研究意见和结果信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteAuditing")
	@ResponseBody
	public AjaxJson deleteAuditing(PersonnelSelectionAuditEntity  personnelSelectionAudit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			personnelSelectionAudit = systemService.findEntity(PersonnelSelectionAuditEntity.class,id);
			personnelSelectionService.delete(personnelSelectionAudit);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "各级研究意见和结果信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	
	/**
	 * 删除个人平时表现信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deletePerformance")
	@ResponseBody
	public AjaxJson deletePerformance(PersonnelSelectionPerformanceEntity personnelSelectionPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			personnelSelectionPerformance = systemService.findEntity(PersonnelSelectionPerformanceEntity.class,id);
			personnelSelectionService.delete(personnelSelectionPerformance);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "个人平时表现信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	
	/**
	 * 删除民主评议/推荐
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteRecommend")
	@ResponseBody
	public AjaxJson deleteRecommend(PersonnelSelectionRecommendEntity personnelSelectionRecommend, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			personnelSelectionRecommend = systemService.findEntity(PersonnelSelectionRecommendEntity.class,id);
			personnelSelectionService.delete(personnelSelectionRecommend);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "民主评议/推荐信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	
	/**
	 * 删除考核结果
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteAssessment")
	@ResponseBody
	public AjaxJson deleteAssessment(PersonnelSelectionAssessmentEntity personnelSelectionAssessment, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			personnelSelectionAssessment = systemService.findEntity(PersonnelSelectionAssessmentEntity.class,id);
			personnelSelectionService.delete(personnelSelectionAssessment);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "考核结果信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	
	/**
	 * 删除举报信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteReport")
	@ResponseBody
	public AjaxJson deleteReport(PersonnelSelectionReportEntity  personnelSelectionReport, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			personnelSelectionReport = systemService.findEntity(PersonnelSelectionReportEntity.class,id);
			personnelSelectionService.delete(personnelSelectionReport);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "举报信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	
	/**
	 * 
	 * @Title: addorupdateOperate
	 * @Description: 保存平时表现和审批结果
	 * @param req
	 * @return AjaxJson
	 * @author  ly
	 * @date 2018年7月8日16:00:11
	 */
	@RequestMapping(params = "addorupdateOperate")
	@ResponseBody
	public AjaxJson  addorupdateOperate(PersonnelSelectionMainPage personnelSelectionMainPage, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<PersonnelSelectionPerformanceEntity>  performances =personnelSelectionMainPage.getPerformances();
		List<PersonnelSelectionAuditEntity> results = personnelSelectionMainPage.getResults();
		List<PersonnelSelectionRecommendEntity> recommends = personnelSelectionMainPage.getRecommends();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		if(StringUtils.isNotEmpty(officerId)){
		for(PersonnelSelectionPerformanceEntity op:performances){
			op.setCreateTime(new Date());
			op.setCreateId(userId);
			op.setOfficerId(officerId);
			personnelSelectionService.saveOrUpdate(op);
		}
		
		for(PersonnelSelectionAuditEntity oa:results){
			oa.setCreateTime(new Date());
			oa.setCreateId(userId);
			oa.setOfficerId(officerId);
			personnelSelectionService.saveOrUpdate(oa);
		}
		for(PersonnelSelectionRecommendEntity recommend:recommends){
			recommend.setCreateTime(new Date());
			recommend.setCreateId(userId);
			recommend.setOfficerId(officerId);
			personnelSelectionService.saveOrUpdate(recommend);
		}
		}
		result.setMsg("保存成功");
		return result;
	}

	@RequestMapping(params = "viewDetailMain")
	public ModelAndView viewDetailMain(PersonnelSelectionEntity entity, HttpServletRequest req) {
        String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):entity.getId();
        PersonnelSelectionMain result = new PersonnelSelectionMain();
		if (StringUtils.isNotEmpty(id)) {
			entity = personnelSelectionService.findEntity(PersonnelSelectionEntity.class, id);
			result.setEntity(entity);
			req.setAttribute("personnelSelectionPage", result);
		}
		req.setAttribute("id", id);
		String isView =  req.getParameter("isView");
		if(isView.equals("true")){
			return new ModelAndView("com/inspection/personnelSelection/viewDetailMain");
		} else {
			return new ModelAndView("com/inspection/personnelSelection/processPersonnelSelection");
		}
	}

	/**
	 * 处理页面
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "modifyProcess")
	@ResponseBody
	public AjaxJson modifyProcess(PersonnelSelectionMain personnelSelectionMain, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String id = req.getParameter("id");

		result.setMsg("保存成功");
		return result;
	}
}
