package com.inspection.controller.soldierschool;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.entity.soldierstudent.SoldierStudentMain;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inspection.entity.soldierschool.SoldierSchoolAssessmentEntity;
import com.inspection.entity.soldierschool.SoldierSchoolAuditingEntity;
import com.inspection.entity.soldierschool.SoldierSchoolEntity;
import com.inspection.entity.soldierschool.SoldierSchoolMeritEntity;
import com.inspection.entity.soldierschool.SoldierSchoolPerformanceEntity;
import com.inspection.entity.soldierschool.SoldierSchoolRecommendEntity;
import com.inspection.pojo.SoldierSchoolMainPage;
import com.inspection.service.soldierschool.SoldierSchoolServiceI;

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
@RequestMapping("/soldierSchoolController")
public class SoldierSchoolController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SoldierSchoolController.class);

	@Autowired
	private SoldierSchoolServiceI soldierSchoolService;
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
	@RequestMapping(params = "soldierSchool")
	public ModelAndView soldierSchool(HttpServletRequest request) {
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
		return new ModelAndView("com/inspection/soldierschool/soldierSchoolList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param soldierSchool
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SoldierSchoolEntity soldierSchool,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SoldierSchoolEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
				String departId = soldierSchool.getDepartId();
			/*	boolean isAdmin = SessionUtils.isAdminRole("admin");
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
				soldierSchool.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);
				//查询条件组装器
				HqlGenerateUtil.installHql(cq, soldierSchool, request.getParameterMap());
				this.soldierSchoolService.findDataGridReturn(cq, true);
				List<SoldierSchoolEntity> results= dataGrid.getResults();
				if(null != results && results.size() > 0 ){
					for(SoldierSchoolEntity sl:results){
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
	public AjaxJson del(SoldierSchoolEntity soldierSchool, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = soldierSchool.getId();
		soldierSchool = systemService.findEntity(SoldierSchoolEntity.class, soldierSchool.getId());
		systemService.executeSql("delete from jc_soldier_school_assessment where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_school_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_school_recommend where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_school_performance where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_school_merit where STUDENT_ID=?", officerId);
		message = "大学生毕业生提干删除成功";
		soldierSchoolService.delete(soldierSchool);
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
	public AjaxJson deleteAuditing(SoldierSchoolAuditingEntity soldierSchoolAuditing, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_school_audit where ID=?", id);
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
	public AjaxJson deletePerformance(SoldierSchoolPerformanceEntity soldierSchoolPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_school_performance where ID=?", id);
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
	public AjaxJson deleteRecommend(SoldierSchoolRecommendEntity soldierSchoolRecommend, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_school_recommend where ID=?", id);
			
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
	public AjaxJson deleteAssessment(SoldierSchoolAssessmentEntity soldierSchoolAssessment, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_school_assessment where ID=?", id);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "考核结果删除成功";
			j.setMsg(message);
		}
		return j;
	}


	/**
	 * 添加大学生毕业生提干
	 * 
	 * @param soldierSchool
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SoldierSchoolEntity soldierSchool,SoldierSchoolMeritEntity soldierSchoolMerit ,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(soldierSchool.getId())) {
			message = "大学生毕业生提干更新成功";
			SoldierSchoolEntity t = soldierSchoolService.find(SoldierSchoolEntity.class, soldierSchool.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(soldierSchool, t);
				soldierSchoolService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "大学生毕业生提干更新失败";
			}
		} else {
			message = "大学生毕业生提干添加成功";
			soldierSchool.setDepartId(SessionUtils.getCurrentDepartsCode());
			soldierSchoolService.save(soldierSchool);
			soldierSchoolMerit.setStudentId(soldierSchool.getId());
			soldierSchoolService.save(soldierSchoolMerit);
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
	public ModelAndView addorupdate(SoldierSchoolEntity soldierSchool, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(soldierSchool.getId())) {
			soldierSchool = soldierSchoolService.findEntity(SoldierSchoolEntity.class, soldierSchool.getId());
			List<SoldierSchoolMeritEntity> lists=soldierSchoolService.findAllMerits(soldierSchool.getId());
			req.setAttribute("soldierSchoolPage", soldierSchool);
			req.setAttribute("lists", lists);
		}
		return new ModelAndView("com/inspection/soldierschool/soldierSchool");
	}
	
	
	/**
	 * 
	 * @Title: addorupdateOperate
	 * @Description: 保存平时表现和审批结果
	 * @param req
	 * @return AjaxJson
	 * @author  yxd
	 * @date 2018年7月6日 上午10:00:39
	 */
	@RequestMapping(params = "addorupdateOperate")
	@ResponseBody
	public AjaxJson  addorupdateOperate(SoldierSchoolMainPage soldierSchoolMainPage, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<SoldierSchoolPerformanceEntity>  performances =soldierSchoolMainPage.getPerformances();
		List<SoldierSchoolAuditingEntity> results = soldierSchoolMainPage.getResults();
		List<SoldierSchoolRecommendEntity> recommends = soldierSchoolMainPage.getRecommends();
		List<SoldierSchoolAssessmentEntity> assessments = soldierSchoolMainPage.getAssessments();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		String  publicUrl=ResourceUtils.getResourcePublicURL();
		if(StringUtils.isNotEmpty(officerId)){
		for(SoldierSchoolPerformanceEntity op:performances){
			op.setCreateTime(new Date());
			op.setCreateId(userId);
			op.setOfficerId(officerId);
			op.setFileId(publicUrl+op.getFileId());
			soldierSchoolService.saveOrUpdate(op);
		}
		
		for(SoldierSchoolAuditingEntity oa:results){
			oa.setCreateTime(new Date());
			oa.setCreateId(userId);
			oa.setOfficerId(officerId);
			oa.setFileId(publicUrl+oa.getFileId());
			soldierSchoolService.saveOrUpdate(oa);
		}
		for(SoldierSchoolRecommendEntity recommend:recommends){
			recommend.setCreateTime(new Date());
			recommend.setCreateId(userId);
			recommend.setOfficerId(officerId);
			soldierSchoolService.saveOrUpdate(recommend);
		}
		for(SoldierSchoolAssessmentEntity assessment:assessments){
			assessment.setCreateTime(new Date());
			assessment.setCreateId(userId);
			assessment.setOfficerId(officerId);
			assessment.setFileId(publicUrl+assessment.getFileId());
			soldierSchoolService.saveOrUpdate(assessment);
		}
		}
		result.setMsg("保存成功");
		return result;
	}
	
	/**
	 * 表彰奖励个人基本信息详情
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMyselfInfo")
	public ModelAndView viewMyselfInfo(SoldierSchoolEntity soldierSchool, HttpServletRequest req) {
		String id = req.getParameter("id");
	
		if (StringUtils.isNotEmpty(id)) {
			soldierSchool = soldierSchoolService.findEntity(SoldierSchoolEntity.class, id);
			req.setAttribute("soldierSchoolPage", soldierSchool);
		}
		//表彰奖励-提名类型
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","nor_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
	
			return new ModelAndView("com/inspection/soldierschool/myselfInfo");
		
	}

	/**
	 * 查看或处理
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(SoldierSchoolEntity schoolEntity, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):schoolEntity.getId();
		if (StringUtils.isNotEmpty(id)) {
			SoldierStudentMain result = new SoldierStudentMain();
			schoolEntity = soldierSchoolService.findEntity(SoldierSchoolEntity.class, id);
			ArrayList<String> shouJiangQingKuang = new ArrayList<String>();
			shouJiangQingKuang.add("加分项1");
			shouJiangQingKuang.add("加分项2");
			result.setShouJiangQingKuang(shouJiangQingKuang);
			result.setSchoolEntity(schoolEntity);
			req.setAttribute("soldierSchoolPage", result);
		}
		req.setAttribute("id", id);
		String isView =  req.getParameter("isView");
		if(isView.equals("true")){
			return new ModelAndView("com/inspection/soldierschool/mainDetial");
		} else {
			return new ModelAndView("com/inspection/soldierschool/processSoldierSchool");
		}
	}

	/**
	 * 处理页面
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "modifyProcess")
	@ResponseBody
	public AjaxJson modifyProcess(SoldierStudentMain soldierStudentMain, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String id = req.getParameter("id");

		result.setMsg("保存成功");
		return result;
	}
}
