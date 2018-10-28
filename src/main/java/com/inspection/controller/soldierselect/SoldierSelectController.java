package com.inspection.controller.soldierselect;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.entity.soldierselect.SoldierSelectMain;
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
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.service.SystemService;

import com.inspection.entity.soldierselect.SoldierSelectAssessmentEntity;
import com.inspection.entity.soldierselect.SoldierSelectAuditingEntity;
import com.inspection.entity.soldierselect.SoldierSelectEntity;
import com.inspection.entity.soldierselect.SoldierSelectPerformanceEntity;
import com.inspection.entity.soldierselect.SoldierSelectRecommendEntity;
import com.inspection.pojo.SoldierSelectMainPage;
import com.inspection.service.soldierselect.SoldierselectServiceI;

/**   
 * @Title: Controller
 * @Description: 士兵选取信息
 * @author zhangdaihao
 * @date 2018-07-09 15:56:05
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/soldierSelectController")
public class SoldierSelectController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SoldierSelectController.class);

	@Autowired
	private SoldierselectServiceI soldierselectService;
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
	 * 士兵选取信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "soldierselect")
	public ModelAndView soldierselect(HttpServletRequest request) {
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
		request.setAttribute("currentDepart",SessionUtils.getCurrentUser().getCurrentDepart());
		return new ModelAndView("com/inspection/soldierselect/soldierSelectList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param soldierselect
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SoldierSelectEntity soldierselect,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SoldierSelectEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
		String departId = soldierselect.getDepartId();
		if (StringUtils.isEmpty(request.getParameter("search"))){
			departId = request.getParameter("currentDepartId");
		}
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
		soldierselect.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);

		//查询条件组装器
		HqlGenerateUtil.installHql(cq, soldierselect, request.getParameterMap());
		this.soldierselectService.findDataGridReturn(cq, true);
		List<SoldierSelectEntity> results= dataGrid.getResults();
		if(null != results && results.size() > 0 ){
			for(SoldierSelectEntity sl:results){
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
	 * 删除士兵选取信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SoldierSelectEntity soldierselect, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = soldierselect.getId();
		soldierselect = systemService.findEntity(SoldierSelectEntity.class, soldierselect.getId());
		systemService.executeSql("delete from jc_soldier_select_assessment where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_select_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_select_performance where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_soldier_select_recommend where OFFICER_ID=?", officerId);
		message = "士兵选取信息删除成功";
		soldierselectService.delete(soldierselect);
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
	public AjaxJson deleteAuditing(SoldierSelectAuditingEntity soldierSelectAuditing, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_select_audit where ID=?", id);
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
	public AjaxJson deletePerformance(SoldierSelectPerformanceEntity soldierSelectPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_select_performance where ID=?", id);
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
	public AjaxJson deleteRecommend(SoldierSelectRecommendEntity soldierSelectRecommend, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_select_recommend where ID=?", id);
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
	public AjaxJson deleteAssessment( SoldierSelectAssessmentEntity soldierSelectAssessment, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_soldier_select_assessment where ID=?", id);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "考核结果删除成功";
			j.setMsg(message);
		}
		return j;
	}

	/**
	 * 添加士兵选取信息
	 * 
	 * @param soldierselect
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SoldierSelectEntity soldierselect, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(soldierselect.getId())) {
			message = "士兵选取信息更新成功";
			SoldierSelectEntity t = soldierselectService.find(SoldierSelectEntity.class, soldierselect.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(soldierselect, t);
				soldierselectService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "士兵选取信息更新失败";
			}
		} else {
			message = "士兵选取信息添加成功";
			soldierselect.setDepartId(SessionUtils.getCurrentDepartsCode());
			soldierselectService.save(soldierselect);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 士兵选取信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SoldierSelectEntity soldierselect, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(soldierselect.getId())) {
			soldierselect = soldierselectService.findEntity(SoldierSelectEntity.class, soldierselect.getId());
			req.setAttribute("soldierselectPage", soldierselect);
		}
		return new ModelAndView("com/inspection/soldierselect/soldierSelect");
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
	public AjaxJson  addorupdateOperate(SoldierSelectMainPage SoldierSelectMainPage, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<SoldierSelectPerformanceEntity>  performances =SoldierSelectMainPage.getPerformances();
		List<SoldierSelectAuditingEntity> results = SoldierSelectMainPage.getResults();
		List<SoldierSelectRecommendEntity> recommends = SoldierSelectMainPage.getRecommends();
		List<SoldierSelectAssessmentEntity> assessments = SoldierSelectMainPage.getAssessments();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		String  publicUrl=ResourceUtils.getResourcePublicURL();
		if(StringUtils.isNotEmpty(officerId)){
		for(SoldierSelectPerformanceEntity op:performances){
			op.setCreateTime(new Date());
			op.setCreateId(userId);
			op.setOfficerId(officerId);
			op.setFileId(publicUrl+op.getFileId());
			soldierselectService.saveOrUpdate(op);
		}
		
		for(SoldierSelectAuditingEntity oa:results){
			oa.setCreateTime(new Date());
			oa.setCreateId(userId);
			oa.setOfficerId(officerId);
			oa.setFileId(publicUrl+oa.getFileId());
			soldierselectService.saveOrUpdate(oa);
		}
		for(SoldierSelectRecommendEntity recommend:recommends){
			recommend.setCreateTime(new Date());
			recommend.setCreateId(userId);
			recommend.setOfficerId(officerId);
			soldierselectService.saveOrUpdate(recommend);
		}
		for(SoldierSelectAssessmentEntity assessment:assessments){
			assessment.setCreateTime(new Date());
			assessment.setCreateId(userId);
			assessment.setOfficerId(officerId);
			assessment.setFileId(publicUrl+assessment.getFileId());
			soldierselectService.saveOrUpdate(assessment);
		}
		}
		result.setMsg("保存成功");
		return result;
	}

	/**
	 * 查看或处理页面
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(SoldierSelectEntity entity, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):entity.getId();

		if (StringUtils.isNotEmpty(id)) {
			SoldierSelectMain result = soldierselectService.findEntity(SoldierSelectMain.class, id);
			if (result == null){
				result = new SoldierSelectMain();
			}

			entity = soldierselectService.findEntity(SoldierSelectEntity.class, id);
			result.setEntity(entity);
			req.setAttribute("soldierSelectPage", result);
		}

		String isView = req.getParameter("isView");
		req.setAttribute("id", id);
		if(isView.equals("true")){
			return new ModelAndView("com/inspection/soldierselect/mainDetial");
		} else {
			return new ModelAndView("com/inspection/soldierselect/processSoldierSelect");
		}
	}

	// 士官选取调整-处理页面
	@RequestMapping(params = "modifyProcess")
	@ResponseBody
	public AjaxJson modifyProcess(SoldierSelectMain soldierSelectMain, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String id = req.getParameter("id");
		soldierSelectMain.setId(id);

		soldierselectService.saveOrUpdate(soldierSelectMain);
		result.setMsg("保存成功");
		return result;
	}
}
