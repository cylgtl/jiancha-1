package com.inspection.controller.backbone;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.pojo.BackboneMain;
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

import com.inspection.entity.backbone.BackboneAuditingEntity;
import com.inspection.entity.backbone.BackboneEntity;
import com.inspection.entity.backbone.BackbonePerformanceEntity;
import com.inspection.entity.backbone.BackboneRecommendEntity;
import com.inspection.entity.cadresadjust.AdjustAssessmentEntity;
import com.inspection.entity.cadresadjust.AdjustAuditingEntity;
import com.inspection.entity.cadresadjust.AdjustEntity;
import com.inspection.entity.cadresadjust.AdjustPerformanceEntity;
import com.inspection.entity.cadresadjust.AdjustRecommendEntity;
import com.inspection.entity.officerleave.OfficerLeaveEntity;
import com.inspection.pojo.AdjustMainPage;
import com.inspection.pojo.BackboneMainPage;
import com.inspection.service.backbone.BackboneServiceI;

/**   
 * @Title: Controller
 * @Description: 骨干配备信息
 * @author zhangdaihao
 * @date 2018-07-09 13:59:46
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/backboneController")
public class BackboneController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BackboneController.class);

	@Autowired
	private BackboneServiceI backboneService;
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
	 * 骨干配备信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "backbone")
	public ModelAndView backbone(HttpServletRequest request) {
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
		return new ModelAndView("com/inspection/backbone/backboneList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param backbone
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(BackboneEntity backbone,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BackboneEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
		String departId = backbone.getDepartId();
		//boolean isAdmin = SessionUtils.isAdminRole("admin");
		//boolean isManager = SessionUtils.isAdminRole("manager");
		
		/*if(StringUtils.isNotEmpty(departId) && !isAdmin){
			cq.eq("departId", departId);
		}
		
		//审核人员
		if(isManager){
			String departCodes = SessionUtils.getCurrentDepartsCode();
			String[] codes = departCodes.split(",");
			cq.in("departId", codes);
		}
		cq.add();*/
		backbone.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, backbone, request.getParameterMap());
		this.backboneService.findDataGridReturn(cq, true);
		List<BackboneEntity> results= dataGrid.getResults();
		if(null != results && results.size() > 0 ){
			for(BackboneEntity sl:results){
				String jobTile = sl.getJobTitle();
				sl.setJobTitle("部职别："+jobTile);
			}
		}
		TagUtil.datagrid(response, dataGrid);	
	}

	/**
	 * 删除骨干配备信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(BackboneEntity backbone, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = backbone.getId();
		backbone = systemService.findEntity(BackboneEntity.class, backbone.getId());
		message = "骨干配备信息删除成功";
		systemService.executeSql("delete from jc_backbone_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_backbone_performance where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_backbone_recommend where OFFICER_ID=?", officerId);
		backboneService.delete(backbone);
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
	public AjaxJson deleteAuditing(BackboneAuditingEntity  backboneAuditing, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			backboneAuditing = systemService.findEntity(BackboneAuditingEntity.class,id);
			backboneService.delete(backboneAuditing);
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
	public AjaxJson deletePerformance(BackbonePerformanceEntity backbonePerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			backbonePerformance = systemService.findEntity(BackbonePerformanceEntity.class,id);
			backboneService.delete(backbonePerformance);
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
	public AjaxJson deleteRecommend(BackboneRecommendEntity backboneRecommend, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			backboneRecommend = systemService.findEntity(BackboneRecommendEntity.class,id);
			backboneService.delete(backboneRecommend);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "民主推荐信息删除成功";
			j.setMsg(message);
		}
		return j;
	}
	

	/**
	 * 添加骨干配备信息
	 * 
	 * @param backbone
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(BackboneEntity backbone, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(backbone.getId())) {
			message = "骨干配备信息更新成功";
			BackboneEntity t = backboneService.find(BackboneEntity.class, backbone.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(backbone, t);
				backboneService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "骨干配备信息更新失败";
			}
		} else {
			message = "骨干配备信息添加成功";
			backbone.setDepartId(SessionUtils.getCurrentDepartsCode());
			backboneService.save(backbone);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 骨干配备信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(BackboneEntity backbone, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(backbone.getId())) {
			backbone = backboneService.findEntity(BackboneEntity.class, backbone.getId());
			req.setAttribute("backbonePage", backbone);
		}
		return new ModelAndView("com/inspection/backbone/backbone");
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
	public AjaxJson  addorupdateOperate(BackboneMainPage backboneMainPage, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<BackbonePerformanceEntity>  performances =backboneMainPage.getPerformances();
		List<BackboneAuditingEntity> results = backboneMainPage.getResults();
		List<BackboneRecommendEntity> recommends = backboneMainPage.getRecommends();
	
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		String  publicUrl=ResourceUtils.getResourcePublicURL();
		if(StringUtils.isNotEmpty(officerId)){
		for(BackbonePerformanceEntity op:performances){
			op.setCreateTime(new Date());
			op.setCreateId(userId);
			op.setOfficerId(officerId);
			op.setFileId(publicUrl+op.getFileId());
			backboneService.saveOrUpdate(op);
		}
		
		for(BackboneAuditingEntity oa:results){
			oa.setCreateTime(new Date());
			oa.setCreateId(userId);
			oa.setOfficerId(officerId);
			oa.setFileId(publicUrl+oa.getFileId());
			backboneService.saveOrUpdate(oa);
		}
		for(BackboneRecommendEntity recommend:recommends){
			recommend.setCreateTime(new Date());
			recommend.setCreateId(userId);
			recommend.setOfficerId(officerId);
			backboneService.saveOrUpdate(recommend);
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
	public ModelAndView viewMain(BackboneEntity backboneEntity, HttpServletRequest req) {
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
		return new ModelAndView("com/inspection/backbone/main");
	}
	
	/**
	 * 表彰奖励个人基本信息详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMyselfInfo")
	public ModelAndView viewMyselfInfo(BackboneEntity backboneEntity, HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			backboneEntity = backboneService.findEntity(BackboneEntity.class, id);
			req.setAttribute("backbonePage", backboneEntity);
		}
		//表彰奖励-提名类型
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","nor_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/backbone/myselfInfo");
		}else{
			return new ModelAndView("com/inspection/backbone/myselfInfoDetial");
			
		}
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
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<BackbonePerformanceEntity> lists= backboneService.findAllPerformances (id);
			req.setAttribute("lists", lists);
			req.setAttribute("residualId", id);
		}
		
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","bx_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/backbone/performance");
		}else{
			return new ModelAndView("com/inspection/backbone/performanceDetial");
			
		}
		
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
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<BackboneAuditingEntity> lists= backboneService.findAllAudits (id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/backbone/auditing");
		}else{
			return new ModelAndView("com/inspection/backbone/auditingDetial");
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
			List<BackboneRecommendEntity> lists= backboneService.findAllRecommends(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if(StringUtils.isEmpty(funname)){
			return new ModelAndView("com/inspection/backbone/backboneRecommend");
		}else{
			return new ModelAndView("com/inspection/backbone/backboneRcommendDetial");
		}
		
	}
	
	
	/**
	 * 表彰奖励处理详情
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetail")
	public ModelAndView viewMainDetail(BackboneEntity backbone, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):backbone.getId();

		if (StringUtils.isNotEmpty(id)) {
			BackboneMain result = new BackboneMain();
			backbone = backboneService.findEntity(BackboneEntity.class, id);
			result.setEntity(backbone);
			req.setAttribute("backbonePage", result);
			
		}
		String isView =  req.getParameter("isView");
		req.setAttribute("isView", isView);
		req.setAttribute("id", id);
		return new ModelAndView("com/inspection/backbone/mainDetial");
	}
}
