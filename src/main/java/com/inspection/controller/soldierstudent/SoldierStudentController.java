package com.inspection.controller.soldierstudent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.pojo.SoldierStudentMain;
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

import com.inspection.entity.officerleave.OfficerLeaveEntity;
import com.inspection.entity.soldierselect.SoldierSelectEntity;
import com.inspection.entity.soldierstudent.SoldierStudentAssessmentEntity;
import com.inspection.entity.soldierstudent.SoldierStudentAuditingEntity;
import com.inspection.entity.soldierstudent.SoldierStudentEntity;
import com.inspection.entity.soldierstudent.SoldierStudentMeritEntity;
import com.inspection.entity.soldierstudent.SoldierStudentPerformanceEntity;
import com.inspection.entity.soldierstudent.SoldierStudentRecommendEntity;
import com.inspection.pojo.SoldierStudentMainPage;
import com.inspection.service.soldierstudent.SoldierStudentServiceI;

/**   
 * @Title: Controller
 * @Description: 大学生毕业生提干
 * @author zhangdaihao
 * @date 2018-07-10 15:35:12
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/soldierStudentController")
public class SoldierStudentController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SoldierStudentController.class);

	@Autowired
	private SoldierStudentServiceI soldierStudentService;
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
	 * 大学生毕业生提干列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "soldierStudent")
	public ModelAndView soldierStudent(HttpServletRequest request) {
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
		return new ModelAndView("com/inspection/soldierstudent/soldierStudentList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param soldierStudent
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SoldierStudentEntity soldierStudent,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SoldierStudentEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
				String departId = soldierStudent.getDepartId();
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
				soldierStudent.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);

				//查询条件组装器
				HqlGenerateUtil.installHql(cq, soldierStudent, request.getParameterMap());
				this.soldierStudentService.findDataGridReturn(cq, true);
				List<SoldierStudentEntity> results= dataGrid.getResults();
				if(null != results && results.size() > 0 ){
					for(SoldierStudentEntity sl:results){
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
	 * 删除大学生毕业生提干
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SoldierStudentEntity soldierStudent, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = soldierStudent.getId();
		soldierStudent = systemService.findEntity(SoldierStudentEntity.class, soldierStudent.getId());
		systemService.executeSql("delete from jc_soldier_student_assessment where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_student_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_student_merit where student_id=?", officerId);
		systemService.executeSql("delete from jc_soldier_student_performance where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_student_recommend where OFFICER_ID=?", officerId);
		message = "大学生毕业生提干删除成功";
		soldierStudentService.delete(soldierStudent);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}

	/**
	 * 删除表彰奖励意见和结果信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteAuditing")
	@ResponseBody
	public AjaxJson deleteAuditing(SoldierStudentAuditingEntity soldierStudentAuditing, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_student_audit where ID=?", id);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "表彰奖励意见和结果信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	
	/**
	 * 删除个人表现信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deletePerformance")
	@ResponseBody
	public AjaxJson deletePerformance(SoldierStudentPerformanceEntity soldierStudentPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_student_performance where ID=?", id);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "个人表现信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	
	/**
	 * 删除民主推荐
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteRecommend")
	@ResponseBody
	public AjaxJson deleteRecommend(SoldierStudentRecommendEntity soldierStudentRecommend, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_student_recommend where ID=?", id);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "民主推荐信息删除成功";
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
	public AjaxJson deleteAssessment( SoldierStudentAssessmentEntity soldierStudentAssessment, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_student_assessment where ID=?", id);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "考核结果删除成功";
			j.setMsg(message);
		}
		return j;
	}


	/**
	 * 添加大学生毕业生提干
	 * 
	 * @param soldierStudent
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SoldierStudentEntity soldierStudent,SoldierStudentMeritEntity soldierStudentMerit ,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(soldierStudent.getId())) {
			message = "大学生毕业生提干更新成功";
			SoldierStudentEntity t = soldierStudentService.find(SoldierStudentEntity.class, soldierStudent.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(soldierStudent, t);
				soldierStudentService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "大学生毕业生提干更新失败";
			}
		} else {
			message = "大学生毕业生提干添加成功";
			soldierStudent.setDepartId(SessionUtils.getCurrentDepartsCode());
			soldierStudentService.save(soldierStudent);
			soldierStudentMerit.setStudentId(soldierStudent.getId());
			soldierStudentService.save(soldierStudentMerit);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 大学生毕业生提干列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SoldierStudentEntity soldierStudent, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(soldierStudent.getId())) {
			soldierStudent = soldierStudentService.findEntity(SoldierStudentEntity.class, soldierStudent.getId());
			List<SoldierStudentMeritEntity> lists=soldierStudentService.findAllMerits(soldierStudent.getId());
			req.setAttribute("soldierStudentPage", soldierStudent);
			req.setAttribute("lists", lists);
		}
		return new ModelAndView("com/inspection/soldierstudent/soldierStudent");
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
	public AjaxJson  addorupdateOperate(SoldierStudentMainPage soldierstudentMainPage, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<SoldierStudentPerformanceEntity>  performances =soldierstudentMainPage.getPerformances();
		List<SoldierStudentAuditingEntity> results = soldierstudentMainPage.getResults();
		List<SoldierStudentRecommendEntity> recommends = soldierstudentMainPage.getRecommends();
		List<SoldierStudentAssessmentEntity> assessments = soldierstudentMainPage.getAssessments();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		String  publicUrl=ResourceUtils.getResourcePublicURL();
		if(StringUtils.isNotEmpty(officerId)){
		for(SoldierStudentPerformanceEntity op:performances){
			op.setCreateTime(new Date());
			op.setCreateId(userId);
			op.setOfficerId(officerId);
			op.setFileId(publicUrl+op.getFileId());
			soldierStudentService.saveOrUpdate(op);
		}
		
		for(SoldierStudentAuditingEntity oa:results){
			oa.setCreateTime(new Date());
			oa.setCreateId(userId);
			oa.setOfficerId(officerId);
			oa.setFileId(publicUrl+oa.getFileId());
			soldierStudentService.saveOrUpdate(oa);
		}
		for(SoldierStudentRecommendEntity recommend:recommends){
			recommend.setCreateTime(new Date());
			recommend.setCreateId(userId);
			recommend.setOfficerId(officerId);
			soldierStudentService.saveOrUpdate(recommend);
		}
		for(SoldierStudentAssessmentEntity assessment:assessments){
			assessment.setCreateTime(new Date());
			assessment.setCreateId(userId);
			assessment.setOfficerId(officerId);
			assessment.setFileId(publicUrl+assessment.getFileId());
			soldierStudentService.saveOrUpdate(assessment);
		}
		}
		result.setMsg("保存成功");
		return result;
	}

	/**
	 * 表彰奖励处理详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMain")
	public ModelAndView viewMain(SoldierStudentEntity soldierStudent, HttpServletRequest req) {
		String id = req.getParameter("id");
		/*if (StringUtils.isNotEmpty(id)) {
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
			req.setAttribute("officerLeavePage", officerLeave);
		}*/
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		TSTypegroup pxgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","px_type");
		if(pxgroup!=null){
			req.setAttribute("pxList", pxgroup.getTSTypes());
		}
		req.setAttribute("residuald", id);
		return new ModelAndView("com/inspection/soldierstudent/main");
	}
	
	/**
	 * 表彰奖励个人基本信息详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMyselfInfo")
	public ModelAndView viewMyselfInfo(SoldierStudentEntity soldierStudent, HttpServletRequest req) {
		String id = req.getParameter("id");
	
		if (StringUtils.isNotEmpty(id)) {
			soldierStudent = soldierStudentService.findEntity(SoldierStudentEntity.class, id);
			req.setAttribute("soldierStudentPage", soldierStudent);
		}
		//表彰奖励-提名类型
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","nor_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
	
			return new ModelAndView("com/inspection/soldierstudent/myselfInfo");
		
	}
	
	
	/**
	 * 表彰奖励个人平时表现详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewPerformance")
	public ModelAndView viewPerformance(HttpServletRequest req) {
		String id = req.getParameter("id");

		if (StringUtils.isNotEmpty(id)) {
			List<SoldierStudentPerformanceEntity> lists= soldierStudentService.findAllPerformances (id);
			req.setAttribute("lists", lists);
			req.setAttribute("residualId", id);
		}
		
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
	
			return new ModelAndView("com/inspection/soldierstudent/performance");
		
		
	}
	
	
	/**
	 * 表彰奖励上级意见结果详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewAuditing")
	public ModelAndView viewAuditing(HttpServletRequest req) {
		String id = req.getParameter("id");

		if (StringUtils.isNotEmpty(id)) {
			List<SoldierStudentAuditingEntity> lists= soldierStudentService.findAllAudits (id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		
			return new ModelAndView("com/inspection/soldierstudent/auditing");
		
		
	}
	/**
	 * 民族评议/推荐
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewResidualRecommend")
	public ModelAndView viewResidualRecommend(HttpServletRequest req) {
		String id = req.getParameter("id");
		
		if (StringUtils.isNotEmpty(id)) {
			List<SoldierStudentRecommendEntity> lists= soldierStudentService.findAllRecommends(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		
			return new ModelAndView("com/inspection/soldierstudent/soldierStudentRecommend");
		
		
	}
	
	/**
	 * 考核结果
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewAssessment")
	public ModelAndView viewAssessment(HttpServletRequest req) {
		String id = req.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			List<SoldierStudentAssessmentEntity> lists= soldierStudentService.findAlltAssessments(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		TSTypegroup pxgroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","px_type");
		if(pxgroup!=null){
			req.setAttribute("pxList", pxgroup.getTSTypes());
		}
		return new ModelAndView("com/inspection/soldierstudent/assessment");
		
		
	}

	/**
	 * 表彰奖励处理详情
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(SoldierStudentEntity soldierstudent, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):soldierstudent.getId();
		if (StringUtils.isNotEmpty(id)) {
			SoldierStudentMain result = new SoldierStudentMain();
			soldierstudent = soldierStudentService.findEntity(SoldierStudentEntity.class, id);
			result.setEntity(soldierstudent);
			req.setAttribute("soldierStudentPage", result);
		}
		String isView =  req.getParameter("isView");
		req.setAttribute("isView", isView);
		req.setAttribute("id", id);
		return new ModelAndView("com/inspection/soldierstudent/mainDetial");
	}
}
