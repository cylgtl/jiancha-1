package com.inspection.controller.partyMember;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.entity.partyMember.PartyMemberMain;
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

import com.inspection.entity.partyMember.PartyMemberAssessmentEntity;
import com.inspection.entity.partyMember.PartyMemberAuditEntity;
import com.inspection.entity.partyMember.PartyMemberEntity;
import com.inspection.entity.partyMember.PartyMemberPerformanceEntity;
import com.inspection.entity.partyMember.PartyMemberRecommendEntity;
import com.inspection.entity.partyMember.PartyMemberReportEntity;
import com.inspection.pojo.PartyMemberMainPage;
import com.inspection.service.partyMember.PartyMemberServiceI;

/**   
 * @Title: Controller
 * @Description: 党员发展
 * @author zhangdaihao
 * @date 2018-07-12 15:30:58
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/partyMemberController")
public class PartyMemberController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PartyMemberController.class);

	@Autowired
	private PartyMemberServiceI partyMemberService;
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
	 * 党员发展列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "partyMember")
	public ModelAndView partyMember(HttpServletRequest request) {
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
		return new ModelAndView("com/inspection/partyMember/partyMemberList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param partyMember
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(PartyMemberEntity partyMember,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PartyMemberEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
		/*String departCodes = SessionUtils.getCurrentDepartsCode();
		String departId = partyMember.getDepartId();
		if(StringUtils.isEmpty(departId)){
			//String[] codes = departCodes.split(",");
			cq.eq("departId", departCodes);
		}
		cq.add();*/
		String departId = partyMember.getDepartId();
		partyMember.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, partyMember, request.getParameterMap());
		this.partyMemberService.findDataGridReturn(cq, true);
		List<PartyMemberEntity> results= dataGrid.getResults();
		if(null != results && results.size() > 0 ){
			for(PartyMemberEntity sl:results){
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
	 * 删除党员发展
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PartyMemberEntity partyMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = partyMember.getId();
		partyMember = systemService.findEntity(PartyMemberEntity.class, partyMember.getId());
		message = "党员发展删除成功";
		systemService.executeSql("delete from jc_party_member_assessment where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_party_member_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_party_member_performance where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_party_member_recommend where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_party_member_report where OFFICER_ID=?", officerId);
		partyMemberService.delete(partyMember);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加党员发展
	 * 
	 * @param partyMember
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PartyMemberEntity partyMember, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(partyMember.getId())) {
			message = "党员发展更新成功";
			PartyMemberEntity t = partyMemberService.find(PartyMemberEntity.class, partyMember.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(partyMember, t);
				partyMemberService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "党员发展更新失败";
			}
		} else {
			message = "党员发展添加成功";
			partyMember.setDepartId(SessionUtils.getCurrentDepartsCode());
			partyMemberService.save(partyMember);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 党员发展列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "selectType")
	public ModelAndView selectType(PartyMemberEntity partyMember, HttpServletRequest req) {
		return new ModelAndView("com/inspection/partyMember/selectType");
	}
	
	/**
	 * 党员发展列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PartyMemberEntity partyMember, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(partyMember.getId())) {
			partyMember = partyMemberService.findEntity(PartyMemberEntity.class, partyMember.getId());
			req.setAttribute("partyMemberPage", partyMember);
		}else{
			req.setAttribute("swType", partyMember.getSwType());
		}
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		if(sexgroup!=null){
			req.setAttribute("sexList", sexgroup.getTSTypes());
		}
		String url = "com/inspection/partyMember/partyMember";
		if("1".equals(partyMember.getSwType())){
			url = "com/inspection/partyMember/partyMemberRdjjfz";
		}else if("2".equals(partyMember.getSwType())){
			url = "com/inspection/partyMember/partyMemberDyfz";
		}
		return new ModelAndView(url);
	}

	/**
	 * 党员发展列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdateRdjjfz")
	public ModelAndView addorupdateRdjjfz(PartyMemberEntity partyMember, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(partyMember.getId())) {
			partyMember = partyMemberService.findEntity(PartyMemberEntity.class, partyMember.getId());
			req.setAttribute("partyMemberPage", partyMember);
		}else{
			req.setAttribute("type", partyMember.getType());
		}
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		if(sexgroup!=null){
			req.setAttribute("sexList", sexgroup.getTSTypes());
		}
		return new ModelAndView("com/inspection/partyMember/partyMember");
	}
	
	
	/**
	 * 党员发展列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdateDyfz")
	public ModelAndView addorupdateDyfz(PartyMemberEntity partyMember, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(partyMember.getId())) {
			partyMember = partyMemberService.findEntity(PartyMemberEntity.class, partyMember.getId());
			req.setAttribute("partyMemberPage", partyMember);
		}else{
			req.setAttribute("type", partyMember.getType());
		}
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		if(sexgroup!=null){
			req.setAttribute("sexList", sexgroup.getTSTypes());
		}
		return new ModelAndView("com/inspection/partyMember/partyMember");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 处理详情
	 * @param partyMember
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMain")
	public ModelAndView viewMain(PartyMemberEntity partyMember, HttpServletRequest req) {
		String id = req.getParameter("id");
		/*if (StringUtils.isNotEmpty(id)) {
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
			req.setAttribute("officerLeavePage", officerLeave);
		}*/
		req.setAttribute("residuald", id);
		return new ModelAndView("com/inspection/partyMember/main");
	}
	
	/**
	 * 处理详情  查看
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(PartyMemberEntity partyMember, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):partyMember.getId();

		if (StringUtils.isNotEmpty(id)) {
			PartyMemberMain result = new PartyMemberMain();
			partyMember = partyMemberService.findEntity(PartyMemberEntity.class, id);
			result.setEntity(partyMember);
			req.setAttribute("partyMember", result);
		}
		return new ModelAndView("com/inspection/partyMember/mainDetial");
	}
	
	/**
	 * 个人基本信息详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMyselfInfo")
	public ModelAndView viewMyselfInfo(PartyMemberEntity partyMember, HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			partyMember = partyMemberService.findEntity(PartyMemberEntity.class, id);
			req.setAttribute("partyMemberPage", partyMember);
		}
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		if(sexgroup!=null){
			req.setAttribute("sexList", sexgroup.getTSTypes());
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/partyMember/myselfInfo");
		}else{
			return new ModelAndView("com/inspection/partyMember/myselfInfoDetial");
			
		}
	}
	
	/**
	 * 各级研究意见和结果详情
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewAuditing")
	public ModelAndView viewAuditing(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<PartyMemberAuditEntity> lists= partyMemberService.findAllAudits (id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/partyMember/auditing");
		}else{
			return new ModelAndView("com/inspection/partyMember/auditingDetial");
		}
	}
	
	/**
	 * 个人平时表现详情
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewPerformance")
	public ModelAndView viewPerformance(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<PartyMemberPerformanceEntity> lists= partyMemberService.findAllPerformances (id);
			req.setAttribute("lists", lists);
			req.setAttribute("residualId", id);
		}
		
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/partyMember/performance");
		}else{
			return new ModelAndView("com/inspection/partyMember/performanceDetial");
			
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
			List<PartyMemberRecommendEntity> lists= partyMemberService.findAllRecommends(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/partyMember/residualRecommend");
		}else{
			return new ModelAndView("com/inspection/partyMember/residualRecommendDetial");
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
			List<PartyMemberAssessmentEntity> lists= partyMemberService.findAllAssessments(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/partyMember/assessment");
		}else{
			return new ModelAndView("com/inspection/partyMember/assessmentDetial");
		}
	}
	
	/**
	 * 考核结果
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewReport")
	public ModelAndView viewReport(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<PartyMemberReportEntity> lists= partyMemberService.findAllReports(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/partyMember/report");
		}else{
			return new ModelAndView("com/inspection/partyMember/reportDetial");
		}
	}
	
	
	@RequestMapping(params = "viewDetailMain")
	public ModelAndView viewDetailMain(PartyMemberEntity partyMember, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):partyMember.getId();
		String isView =  req.getParameter("isView");
		PartyMemberMainPage result = new PartyMemberMainPage();
		if (StringUtils.isNotEmpty(id)) {
			partyMember = partyMemberService.findEntity(PartyMemberEntity.class, id);
			result.setPartyMember(partyMember);
			result.setPerformances(partyMemberService.findAllPerformances (id));
			result.setAudit(partyMemberService.findAllAudits (id));
			result.setRecommends(partyMemberService.findAllRecommends(id));
			result.setAssessments(partyMemberService.findAllAssessments(id));
			req.setAttribute("partyMemberPage", result);
		}
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		TSTypegroup sexgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","sex");
		req.setAttribute("sexList", sexgroup.getTSTypes());
		req.setAttribute("isView", isView);
		return new ModelAndView("com/inspection/partyMember/viewDetailMain");
	}
	
	/**
	 * 删除各级研究意见和结果信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteAuditing")
	@ResponseBody
	public AjaxJson deleteAuditing(PartyMemberAuditEntity  partyMemberAudit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			partyMemberAudit = systemService.findEntity(PartyMemberAuditEntity.class,id);
			partyMemberService.delete(partyMemberAudit);
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
	public AjaxJson deletePerformance(PartyMemberPerformanceEntity partyMemberPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			partyMemberPerformance = systemService.findEntity(PartyMemberPerformanceEntity.class,id);
			partyMemberService.delete(partyMemberPerformance);
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
	public AjaxJson deleteRecommend(PartyMemberRecommendEntity partyMemberRecommend, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			partyMemberRecommend = systemService.findEntity(PartyMemberRecommendEntity.class,id);
			partyMemberService.delete(partyMemberRecommend);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "民主评议/推荐信息删除成功";
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
	public AjaxJson  addorupdateOperate(PartyMemberMainPage partyMemberMainPage, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<PartyMemberPerformanceEntity>  performances =partyMemberMainPage.getPerformances();
		List<PartyMemberAuditEntity> audits = partyMemberMainPage.getAudit();
		List<PartyMemberRecommendEntity> recommends = partyMemberMainPage.getRecommends();
		List<PartyMemberAssessmentEntity> assessments = partyMemberMainPage.getAssessments();
		List<PartyMemberReportEntity> reports = partyMemberMainPage.getReport();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		if(StringUtils.isNotEmpty(officerId)){
			for(PartyMemberPerformanceEntity op:performances){
				op.setCreateTime(new Date());
				op.setCreateId(userId);
				op.setOfficerId(officerId);
				partyMemberService.saveOrUpdate(op);
			}
			
			for(PartyMemberAuditEntity oa:audits){
				oa.setCreateTime(new Date());
				oa.setCreateId(userId);
				oa.setOfficerId(officerId);
				partyMemberService.saveOrUpdate(oa);
			}
			for(PartyMemberRecommendEntity recommend:recommends){
				recommend.setCreateTime(new Date());
				recommend.setCreateId(userId);
				recommend.setOfficerId(officerId);
				partyMemberService.saveOrUpdate(recommend);
			}
			for(PartyMemberAssessmentEntity assessment:assessments){
				assessment.setCreateTime(new Date());
				assessment.setCreateId(userId);
				assessment.setOfficerId(officerId);
				partyMemberService.saveOrUpdate(assessment);
			}
			for(PartyMemberReportEntity report:reports){
				report.setCreateTime(new Date());
				report.setCreateId(userId);
				report.setOfficerId(officerId);
				partyMemberService.saveOrUpdate(report);
			}
		}
		result.setMsg("保存成功");
		return result;
	}

}
