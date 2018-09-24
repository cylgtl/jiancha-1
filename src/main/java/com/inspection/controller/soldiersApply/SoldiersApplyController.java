package com.inspection.controller.soldiersApply;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.inspection.entity.soldiersApply.SoldiersApplyAssessmentEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyAuditEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyPerformanceEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyRecommendEntity;
import com.inspection.pojo.SoldiersApplyMainPage;
import com.inspection.service.soldiersApply.SoldiersApplyServiceI;

/**   
 * @Title: Controller
 * @Description: 士兵考学
 * @author zhangdaihao
 * @date 2018-07-08 14:31:42
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/soldiersApplyController")
public class SoldiersApplyController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SoldiersApplyController.class);

	@Autowired
	private SoldiersApplyServiceI soldiersApplyService;
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
	 * 士兵处理详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMain")
	public ModelAndView viewMain(SoldiersApplyEntity soldiersApply, HttpServletRequest req) {
		String id = req.getParameter("id");
		/*if (StringUtils.isNotEmpty(id)) {
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
			req.setAttribute("officerLeavePage", officerLeave);
		}*/
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		if(sexgroup!=null){
			req.setAttribute("sexList", sexgroup.getTSTypes());
		}
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		TSTypegroup pxgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","px_type");
		if(pxgroup!=null){
			req.setAttribute("pxList", pxgroup.getTSTypes());
		}
		req.setAttribute("residuald", id);
		return new ModelAndView("com/inspection/soldiersApply/main");
	}
	
	/**
	 * 士兵考学处理详情  查看
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(SoldiersApplyEntity soldiersApply, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):soldiersApply.getId();
		
		/*if (StringUtils.isNotEmpty(id)) {
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
			req.setAttribute("officerLeavePage", officerLeave);
		}*/
		req.setAttribute("residualId", id);
		return new ModelAndView("com/inspection/soldiersApply/mainDetial");
	}


	/**
	 * 士兵考学列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "soldiersApply")
	public ModelAndView soldiersApply(HttpServletRequest request) {
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
		return new ModelAndView("com/inspection/soldiersApply/soldiersApplyList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param soldiersApply
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SoldiersApplyEntity soldiersApply,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SoldiersApplyEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
		String departId = soldiersApply.getDepartId();
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
		soldiersApply.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, soldiersApply, request.getParameterMap());
		this.soldiersApplyService.findDataGridReturn(cq, true);
		List<SoldiersApplyEntity> results= dataGrid.getResults();
		if(null != results && results.size() > 0 ){
			for(SoldiersApplyEntity sl:results){
				String jobTile = sl.getJobTitle();
				sl.setJobTitle("部职别："+jobTile);
			}
		}
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除士兵考学
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SoldiersApplyEntity soldiersApply, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = soldiersApply.getId();
		soldiersApply = systemService.findEntity(SoldiersApplyEntity.class, soldiersApply.getId());
		message = "士兵考学删除成功";
		systemService.executeSql("delete from jc_soldiers_apply_assessment where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldiers_apply_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldiers_apply_performance where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldiers_apply_recommend where OFFICER_ID=?", officerId);
		soldiersApplyService.delete(soldiersApply);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加士兵考学
	 * 
	 * @param soldiersApply
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SoldiersApplyEntity soldiersApply, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(soldiersApply.getId())) {
			message = "士兵考学更新成功";
			SoldiersApplyEntity t = soldiersApplyService.find(SoldiersApplyEntity.class, soldiersApply.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(soldiersApply, t);
				soldiersApplyService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "士兵考学更新失败";
			}
		} else {
			message = "士兵考学添加成功";
			soldiersApply.setDepartId(SessionUtils.getCurrentDepartsCode());
			soldiersApplyService.save(soldiersApply);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 士兵考学列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SoldiersApplyEntity soldiersApply, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(soldiersApply.getId())) {
			soldiersApply = soldiersApplyService.findEntity(SoldiersApplyEntity.class, soldiersApply.getId());
			req.setAttribute("soldiersApplyPage", soldiersApply);
		}
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		if(sexgroup!=null){
			req.setAttribute("sexList", sexgroup.getTSTypes());
		}
		return new ModelAndView("com/inspection/soldiersApply/soldiersApply");
	}
	
	/**
	 * 士兵考学个人基本信息详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMyselfInfo")
	public ModelAndView viewMyselfInfo(SoldiersApplyEntity soldiersApply, HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			soldiersApply = soldiersApplyService.findEntity(SoldiersApplyEntity.class, id);
			req.setAttribute("soldiersApplyPage", soldiersApply);
		}
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		if(sexgroup!=null){
			req.setAttribute("sexList", sexgroup.getTSTypes());
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/soldiersApply/myselfInfo");
		}else{
			return new ModelAndView("com/inspection/soldiersApply/myselfInfoDetial");
			
		}
	}
	
	/**
	 * 士兵考学各级研究意见和结果详情
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewAuditing")
	public ModelAndView viewAuditing(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<SoldiersApplyAuditEntity> lists= soldiersApplyService.findAllAudits (id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/soldiersApply/auditing");
		}else{
			return new ModelAndView("com/inspection/soldiersApply/auditingDetial");
		}
	}
	
	/**
	 * 士兵考学个人平时表现详情
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewPerformance")
	public ModelAndView viewPerformance(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<SoldiersApplyPerformanceEntity> lists= soldiersApplyService.findAllPerformances (id);
			req.setAttribute("lists", lists);
			req.setAttribute("residualId", id);
		}
		
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/soldiersApply/performance");
		}else{
			return new ModelAndView("com/inspection/soldiersApply/performanceDetial");
			
		}
	}
	
	/**
	 * 民族评议/推荐
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewResidualRecommend")
	public ModelAndView viewResidualRecommend(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<SoldiersApplyRecommendEntity> lists= soldiersApplyService.findAllRecommends(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/soldiersApply/residualRecommend");
		}else{
			return new ModelAndView("com/inspection/soldiersApply/residualRecommendDetial");
		}
	}
	
	/**
	 * 考核结果
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewAssessment")
	public ModelAndView viewAssessment(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<SoldiersApplyAssessmentEntity> lists= soldiersApplyService.findAllAssessments(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		TSTypegroup pxgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","px_type");
		if(pxgroup!=null){
			req.setAttribute("pxList", pxgroup.getTSTypes());
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/soldiersApply/assessment");
		}else{
			return new ModelAndView("com/inspection/soldiersApply/assessmentDetial");
		}
	}
	
	@RequestMapping(params = "viewDetailMain")
	public ModelAndView viewDetailMain(SoldiersApplyEntity soldiersApply, HttpServletRequest req) {
		String id = req.getParameter("id");
		SoldiersApplyMainPage result = new SoldiersApplyMainPage();
		if (StringUtils.isNotEmpty(id)) {
			soldiersApply = soldiersApplyService.findEntity(SoldiersApplyEntity.class, id);
			result.setSoldiersApply(soldiersApply);
			result.setPerformances(soldiersApplyService.findAllPerformances (id));
			result.setResults(soldiersApplyService.findAllAudits (id));
			result.setRecommends(soldiersApplyService.findAllRecommends(id));
			result.setAssessments(soldiersApplyService.findAllAssessments(id));
			req.setAttribute("soldiersApplyPage", result);
		}
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		TSTypegroup pxgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","px_type");
		if(pxgroup!=null){
			req.setAttribute("pxList", pxgroup.getTSTypes());
		}
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		req.setAttribute("sexList", sexgroup.getTSTypes());
		
		return new ModelAndView("com/inspection/soldiersApply/viewDetailMain");
	}
	
	/**
	 * 删除各级研究意见和结果信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteAuditing")
	@ResponseBody
	public AjaxJson deleteAuditing(SoldiersApplyAuditEntity  soldiersApplyAudit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			soldiersApplyAudit = systemService.findEntity(SoldiersApplyAuditEntity.class,id);
			soldiersApplyService.delete(soldiersApplyAudit);
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
	public AjaxJson deletePerformance(SoldiersApplyPerformanceEntity soldiersApplyPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			soldiersApplyPerformance = systemService.findEntity(SoldiersApplyPerformanceEntity.class,id);
			soldiersApplyService.delete(soldiersApplyPerformance);
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
	public AjaxJson deleteRecommend(SoldiersApplyRecommendEntity soldiersApplyRecommend, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			soldiersApplyRecommend = systemService.findEntity(SoldiersApplyRecommendEntity.class,id);
			soldiersApplyService.delete(soldiersApplyRecommend);
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
	public AjaxJson deleteAssessment(SoldiersApplyAssessmentEntity soldiersApplyAssessment, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			soldiersApplyAssessment = systemService.findEntity(SoldiersApplyAssessmentEntity.class,id);
			soldiersApplyService.delete(soldiersApplyAssessment);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "考核结果信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	
	/**
	 * 
	 * @Title: addorupdateOperate
	 * @Description: 保存平时表现和审批结果
	 * @param soldiersApplyMainPage
	 * @param req
	 * @return AjaxJson
	 * @author  ly
	 * @date 2018年7月8日16:00:11
	 */
	@RequestMapping(params = "addorupdateOperate")
	@ResponseBody
	public AjaxJson  addorupdateOperate(SoldiersApplyMainPage soldiersApplyMainPage, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<SoldiersApplyPerformanceEntity>  performances =soldiersApplyMainPage.getPerformances();
		List<SoldiersApplyAuditEntity> results = soldiersApplyMainPage.getResults();
		List<SoldiersApplyRecommendEntity> recommends = soldiersApplyMainPage.getRecommends();
		List<SoldiersApplyAssessmentEntity> assessments = soldiersApplyMainPage.getAssessments();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		if(StringUtils.isNotEmpty(officerId)){
			for(SoldiersApplyPerformanceEntity op:performances){
				op.setCreateTime(new Date());
				op.setCreateId(userId);
				op.setOfficerId(officerId);
				soldiersApplyService.saveOrUpdate(op);
			}
			for(SoldiersApplyAuditEntity oa:results){
				oa.setCreateTime(new Date());
				oa.setCreateId(userId);
				oa.setOfficerId(officerId);
				soldiersApplyService.saveOrUpdate(oa);
			}
			for(SoldiersApplyRecommendEntity recommend:recommends){
				recommend.setCreateTime(new Date());
				recommend.setCreateId(userId);
				recommend.setOfficerId(officerId);
				soldiersApplyService.saveOrUpdate(recommend);
			}
			for(SoldiersApplyAssessmentEntity assessment:assessments){
				assessment.setCreateTime(new Date());
				assessment.setCreateId(userId);
				assessment.setOfficerId(officerId);
				soldiersApplyService.saveOrUpdate(assessment);
			}
		}
		result.setMsg("保存成功");
		return result;
	}
	
}
