package com.inspection.controller.evaluation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.inspection.entity.evaluation.EvaluationResidualAuditingEntity;
import com.inspection.entity.evaluation.EvaluationResidualEntity;
import com.inspection.entity.evaluation.EvaluationResidualPerformanceEntity;
import com.inspection.entity.evaluation.EvaluationResidualProveEntity;
import com.inspection.entity.officerleave.OfficerAuditingEntity;
import com.inspection.entity.officerleave.OfficerLeaveEntity;
import com.inspection.entity.soldierschool.SoldierSchoolEntity;
import com.inspection.pojo.EvaluationResidualLeaveMainPage;
import com.inspection.service.evaluation.EvaluationResidualServiceI;

/**   
 * @Title: Controller
 * @Description: 官兵评残信息
 * @author zhangdaihao
 * @date 2018-07-07 09:30:27
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/evaluationResidualController")
public class EvaluationResidualController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EvaluationResidualController.class);

	@Autowired
	private EvaluationResidualServiceI evaluationResidualService;
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
	 * 官兵评残信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "evaluationResidual")
	public ModelAndView evaluationResidual(HttpServletRequest request) {
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
		return new ModelAndView("com/inspection/evaluation/evaluationResidualList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param evaluationResidual
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(EvaluationResidualEntity evaluationResidual,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EvaluationResidualEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
		String departId = evaluationResidual.getDepartId();
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
		evaluationResidual.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, evaluationResidual, request.getParameterMap());
		this.evaluationResidualService.findDataGridReturn(cq, true);
		List<EvaluationResidualEntity> results= dataGrid.getResults();
		if(null != results && results.size() > 0 ){
			for(EvaluationResidualEntity sl:results){
				String jobTile = sl.getJobTitle();
				sl.setJobTitle("部职别："+jobTile);
			}
		}
		TagUtil.datagrid(response, dataGrid);	
	}

	/**
	 * 删除官兵评残信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(EvaluationResidualEntity evaluationResidual, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = evaluationResidual.getId();
		evaluationResidual = systemService.findEntity(EvaluationResidualEntity.class, evaluationResidual.getId());
		systemService.executeSql("delete from jc_evaluation__residual_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_evaluation_residual_performance where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_evaluation_residual_prove where OFFICER_ID=?", officerId);
		message = "官兵评残信息删除成功";
		evaluationResidualService.delete(evaluationResidual);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加官兵评残信息
	 * 
	 * @param evaluationResidual
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(EvaluationResidualEntity evaluationResidual, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(evaluationResidual.getId())) {
			message = "官兵评残信息更新成功";
			EvaluationResidualEntity t = evaluationResidualService.find(EvaluationResidualEntity.class, evaluationResidual.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(evaluationResidual, t);
				evaluationResidualService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "官兵评残信息更新失败";
			}
		} else {
			message = "官兵评残信息添加成功";
			evaluationResidual.setDepartId(SessionUtils.getCurrentDepartsCode());
			evaluationResidualService.save(evaluationResidual);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 官兵评残信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(EvaluationResidualEntity evaluationResidual, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(evaluationResidual.getId())) {
			evaluationResidual = evaluationResidualService.findEntity(EvaluationResidualEntity.class, evaluationResidual.getId());
			req.setAttribute("evaluationResidualPage", evaluationResidual);
		}
		return new ModelAndView("com/inspection/evaluation/evaluationResidual");
	}
	
	
	/**
	 * 删除军官请假意见和结果信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteAuditing")
	@ResponseBody
	public AjaxJson deleteAuditing(EvaluationResidualAuditingEntity  evaluationResidualAuditingEntity, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			evaluationResidualAuditingEntity = systemService.findEntity(EvaluationResidualAuditingEntity.class,id);
			evaluationResidualService.delete(evaluationResidualAuditingEntity);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "军官请假意见和结果信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	
	
	@RequestMapping(params = "deletePerformances")
	@ResponseBody
	public AjaxJson deletePerformances(EvaluationResidualPerformanceEntity  evaluationResidualPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			evaluationResidualPerformance = systemService.findEntity(EvaluationResidualPerformanceEntity.class,id);
			evaluationResidualService.delete(evaluationResidualPerformance);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "信息删除成功";
			j.setMsg(message);
		}
		return j;
	}

	@RequestMapping(params = "deleteProves")
	@ResponseBody
	public AjaxJson deleteProves(EvaluationResidualProveEntity evaluationResidualProve, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			evaluationResidualProve = systemService.findEntity(EvaluationResidualProveEntity.class,id);
			evaluationResidualService.delete(evaluationResidualProve);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "信息删除成功";
			j.setMsg(message);
		}
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
	public AjaxJson  addorupdateOperate(EvaluationResidualLeaveMainPage officerLeave, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<EvaluationResidualPerformanceEntity>  performances =officerLeave.getPerformances();
		List<EvaluationResidualAuditingEntity> results = officerLeave.getResults();
		List<EvaluationResidualProveEntity> proves = officerLeave.getProves();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		String  publicUrl=ResourceUtils.getResourcePublicURL();
		if(StringUtils.isNotEmpty(officerId)){
		for(EvaluationResidualPerformanceEntity op:performances){
			op.setCreateTime(new Date());
			op.setCreateId(userId);
			op.setOfficerId(officerId);
			op.setFileId(publicUrl+op.getFileId());
			evaluationResidualService.saveOrUpdate(op);
		}
		
		for(EvaluationResidualAuditingEntity oa:results){
			oa.setCreateTime(new Date());
			oa.setCreateId(userId);
			oa.setOfficerId(officerId);
			oa.setFileId(publicUrl+oa.getFileId());
			evaluationResidualService.saveOrUpdate(oa);
		}
		for(EvaluationResidualProveEntity prove:proves){
			prove.setCreateTime(new Date());
			prove.setCreateId(userId);
			prove.setOfficerId(officerId);
			evaluationResidualService.saveOrUpdate(prove);
		}
		}
		result.setMsg("保存成功");
		return result;
	}

	/**
	 * 官兵评残处理详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMain")
	public ModelAndView viewMain(EvaluationResidualEntity evaluationResidual, HttpServletRequest req) {
		String id = req.getParameter("id");
		/*if (StringUtils.isNotEmpty(id)) {
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
			req.setAttribute("officerLeavePage", officerLeave);
		}*/

		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		req.setAttribute("residuald", id);
		return new ModelAndView("com/inspection/evaluation/main");
	}
	
	/**
	 * 官兵评残个人基本信息详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMyselfInfo")
	public ModelAndView viewMyselfInfo(EvaluationResidualEntity evaluationResidual, HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			evaluationResidual = evaluationResidualService.findEntity(EvaluationResidualEntity.class, id);
			req.setAttribute("evaluationResidualPage", evaluationResidual);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/evaluation/myselfInfo");
		}else{
			return new ModelAndView("com/inspection/evaluation/myselfInfoDetial");
			
		}
	}
	
	
	/**
	 * 官兵评残个人平时表现详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewPerformance")
	public ModelAndView viewPerformance(HttpServletRequest req) {
		String residualId = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(residualId)) {
			List<EvaluationResidualPerformanceEntity> lists= evaluationResidualService.findAllPerformances (residualId);
			req.setAttribute("lists", lists);
			req.setAttribute("residualId", residualId);
		}
		
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/evaluation/performance");
		}else{
			return new ModelAndView("com/inspection/evaluation/performanceDetial");
			
		}
		
	}
	
	
	/**
	 * 官兵评残上级意见结果详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewAuditing")
	public ModelAndView viewAuditing(HttpServletRequest req) {
		String residualId = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(residualId)) {
			List<EvaluationResidualAuditingEntity> lists= evaluationResidualService.findAllAudits (residualId);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", residualId);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/evaluation/auditing");
		}else{
			return new ModelAndView("com/inspection/evaluation/auditingDetial");
		}
		
	}
	/**
	 * 证明材料
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewResidualProve")
	public ModelAndView viewResidualProve(HttpServletRequest req) {
		String residualId = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(residualId)) {
			List<EvaluationResidualProveEntity> lists= evaluationResidualService.findAllProves (residualId);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", residualId);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/evaluation/residualProve");
		}else{
			return new ModelAndView("com/inspection/evaluation/residualProveDetial");
		}
		
	}
	
	/**
	 * 官兵评残处理详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(EvaluationResidualEntity evaluationResidual, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):evaluationResidual.getId();
		
		/*if (StringUtils.isNotEmpty(id)) {
			officerLeave = officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
			req.setAttribute("officerLeavePage", officerLeave);
		}*/
		if (StringUtils.isNotEmpty(id)) {
			evaluationResidual = evaluationResidualService.findEntity(EvaluationResidualEntity.class, id);
			req.setAttribute("evaluationResidualPage", evaluationResidual);
		}
		if (StringUtils.isNotEmpty(id)) {
			List<EvaluationResidualPerformanceEntity> lists= evaluationResidualService.findAllPerformances (id);
			req.setAttribute("performanceLists", lists);
			
		}
		
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		
		if (StringUtils.isNotEmpty(id)) {
			List<EvaluationResidualAuditingEntity> lists= evaluationResidualService.findAllAudits (id);
			req.setAttribute("auditingLists", lists);
			
		}
		if (StringUtils.isNotEmpty(id)) {
			List<EvaluationResidualProveEntity> lists= evaluationResidualService.findAllProves (id);
			req.setAttribute("proveLists", lists);
			
		}
		String isView =  req.getParameter("isView");
		req.setAttribute("isView", isView);
		req.setAttribute("id", id);
		return new ModelAndView("com/inspection/evaluation/mainDetial");
	}
	
}
