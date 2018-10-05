package com.inspection.controller.cadresadjust;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.pojo.AdjustMain;
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

import com.inspection.entity.backbone.BackboneEntity;
import com.inspection.entity.cadresadjust.AdjustAssessmentEntity;
import com.inspection.entity.cadresadjust.AdjustAuditingEntity;
import com.inspection.entity.cadresadjust.AdjustEntity;
import com.inspection.entity.cadresadjust.AdjustPerformanceEntity;
import com.inspection.entity.cadresadjust.AdjustRecommendEntity;
import com.inspection.entity.leave.SoldierLeaveEntity;
import com.inspection.entity.officerleave.OfficerLeaveEntity;
import com.inspection.pojo.AdjustMainPage;
import com.inspection.service.cadresadjust.AdjustServiceI;

/**
 * @Title: Controller
 * @Description: 干部调整
 * @author zhangdaihao
 * @date 2018-07-08 19:06:29
 * @version V1.0
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/adjustController")
public class AdjustController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AdjustController.class);

	@Autowired
	private AdjustServiceI adjustService;
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
	 * 干部调整列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "adjust")
	public ModelAndView adjust(HttpServletRequest request) {
		List<TSDepart> departList = systemService.findByHql("from TSDepart where orgType=? ", new Object[] { "2" });
		List<TSDepart> list = new ArrayList<TSDepart>();
		if (null != departList && departList.size() > 0) {
			for (TSDepart depart : departList) {
				String departCode = depart.getOrgCode();
				if (departCode.length() == 2) {
					list.add(depart);
				}
			}
		}
		request.setAttribute("departList", list);
		return new ModelAndView("com/inspection/adjust/adjustList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param adjust
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(AdjustEntity adjust, HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AdjustEntity.class, dataGrid);
		// 默认查询当前用户所属部门下数据
		String departId = adjust.getDepartId();
		/*
		 * boolean isAdmin = SessionUtils.isAdminRole("admin"); boolean isManager =
		 * SessionUtils.isAdminRole("manager");
		 * 
		 * if(StringUtils.isNotEmpty(departId) && !isAdmin){ cq.eq("departId",
		 * departId); }
		 * 
		 * //审核人员 if(isManager){ String departCodes =
		 * SessionUtils.getCurrentDepartsCode(); String[] codes =
		 * departCodes.split(","); cq.in("departId", codes); } cq.add();
		 */
		// 查询条件组装器
		adjust.setDepartId(StringUtils.isNotEmpty(departId) ? departId : null);
		HqlGenerateUtil.installHql(cq, adjust, request.getParameterMap());
		this.adjustService.findDataGridReturn(cq, true);
		List<AdjustEntity> results = dataGrid.getResults();
		if (null != results && results.size() > 0) {
			for (AdjustEntity sl : results) {
				String jobTile = sl.getJobTitle();
				sl.setJobTitle("部职别：" + jobTile);
			}
		}
		dataGrid.setPage(dataGrid.getPage());
		dataGrid.setTotal(dataGrid.getTotal());
		dataGrid.setRows(dataGrid.getRows());

		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除干部调整
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(AdjustEntity adjust, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = adjust.getId();
		adjust = systemService.findEntity(AdjustEntity.class, adjust.getId());
		message = "干部调整删除成功";
		systemService.executeSql("delete from jc_cadres_adjust_assessment where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_cadres_adjust_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_cadres_adjust_recommend where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_cadres_adjust_performance where OFFICER_ID=?", officerId);
		adjustService.delete(adjust);
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
	public AjaxJson deleteAuditing(AdjustAuditingEntity adjustAuditing, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {

			systemService.executeSql("delete from jc_cadres_adjust_audit where ID=?", id);

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
	public AjaxJson deletePerformance(AdjustPerformanceEntity adjustPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_cadres_adjust_performance where ID=?", id);
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
	public AjaxJson deleteRecommend(AdjustRecommendEntity adjustRecommend, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_cadres_adjust_recommend where ID=?", id);
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
	public AjaxJson deleteAssessment(AdjustAssessmentEntity adjustAssessment, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			systemService.executeSql("delete from jc_cadres_adjust_assessment where ID=?", id);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "考核结果删除成功";
			j.setMsg(message);
		}
		return j;
	}

	/**
	 * 添加干部调整
	 * 
	 * @param adjust
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(AdjustEntity adjust, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(adjust.getId())) {
			message = "干部调整更新成功";
			AdjustEntity t = adjustService.find(AdjustEntity.class, adjust.getId());
			try {
				BeanPropertyUtils.copyBeanNotNull2Bean(adjust, t);
				adjustService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "干部调整更新失败";
			}
		} else {
			message = "干部调整添加成功";
			adjust.setDepartId(SessionUtils.getCurrentDepartsCode());
			adjustService.save(adjust);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 干部调整列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(AdjustEntity adjust, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(adjust.getId())) {
			adjust = adjustService.findEntity(AdjustEntity.class, adjust.getId());
			req.setAttribute("adjustPage", adjust);
		}
		return new ModelAndView("com/inspection/adjust/adjust");
	}

	/**
	 * 
	 * @Title: addorupdateOperate
	 * @Description: 保存平时表现和审批结果
	 * @param officerLeave
	 * @param req
	 * @return AjaxJson
	 * @author yxd
	 * @date 2018年7月6日 上午10:00:39
	 */
	@RequestMapping(params = "addorupdateOperate")
	@ResponseBody
	public AjaxJson addorupdateOperate(AdjustMainPage adjustMainPage, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<AdjustPerformanceEntity> performances = adjustMainPage.getPerformances();
		List<AdjustAuditingEntity> results = adjustMainPage.getResults();
		List<AdjustRecommendEntity> recommends = adjustMainPage.getRecommends();
		List<AdjustAssessmentEntity> assessments = adjustMainPage.getAssessments();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		String publicUrl = ResourceUtils.getResourcePublicURL();
		if (StringUtils.isNotEmpty(officerId)) {
			for (AdjustPerformanceEntity op : performances) {
				op.setCreateTime(new Date());
				op.setCreateId(userId);
				op.setOfficerId(officerId);
				op.setFileId(publicUrl + op.getFileId());
				adjustService.saveOrUpdate(op);
			}

			for (AdjustAuditingEntity oa : results) {
				oa.setCreateTime(new Date());
				oa.setCreateId(userId);
				oa.setOfficerId(officerId);
				oa.setFileId(publicUrl + oa.getFileId());
				adjustService.saveOrUpdate(oa);
			}
			for (AdjustRecommendEntity recommend : recommends) {
				recommend.setCreateTime(new Date());
				recommend.setCreateId(userId);
				recommend.setOfficerId(officerId);
				adjustService.saveOrUpdate(recommend);
			}
			for (AdjustAssessmentEntity assessment : assessments) {
				assessment.setCreateTime(new Date());
				assessment.setCreateId(userId);
				assessment.setOfficerId(officerId);
				assessment.setFileId(publicUrl + assessment.getFileId());
				adjustService.saveOrUpdate(assessment);
			}
		}
		result.setMsg("保存成功");
		return result;
	}

	/**
	 * 表彰奖励处理详情
	 * 
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMain")
	public ModelAndView viewMain(AdjustEntity adjustEntity, HttpServletRequest req) {
		String id = req.getParameter("id");
		/*
		 * if (StringUtils.isNotEmpty(id)) { officerLeave =
		 * officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
		 * req.setAttribute("officerLeavePage", officerLeave); }
		 */
		TSTypegroup typegroup = systemService.findUniqueByProperty(TSTypegroup.class, "typegroupcode", "bx_type");
		if (typegroup != null) {
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		TSTypegroup pxgroup = systemService.findUniqueByProperty(TSTypegroup.class, "typegroupcode", "px_type");
		if (pxgroup != null) {
			req.setAttribute("pxList", pxgroup.getTSTypes());
		}
		req.setAttribute("residuald", id);
		return new ModelAndView("com/inspection/adjust/main");
	}

	/**
	 * 表彰奖励个人基本信息详情
	 * 
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMyselfInfo")
	public ModelAndView viewMyselfInfo(AdjustEntity adjust, HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			adjust = adjustService.findEntity(AdjustEntity.class, id);
			req.setAttribute("adjustPage", adjust);
		}
		// 表彰奖励-提名类型
		TSTypegroup typegroup = systemService.findUniqueByProperty(TSTypegroup.class, "typegroupcode", "nor_type");
		if (typegroup != null) {
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		if (StringUtils.isEmpty(funname)) {
			return new ModelAndView("com/inspection/adjust/myselfInfo");
		} else {
			return new ModelAndView("com/inspection/adjust/myselfInfoDetial");

		}
	}

	/**
	 * 表彰奖励个人平时表现详情
	 * 
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewPerformance")
	public ModelAndView viewPerformance(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<AdjustPerformanceEntity> lists = adjustService.findAllPerformances(id);
			req.setAttribute("lists", lists);
			req.setAttribute("residualId", id);
		}

		TSTypegroup typegroup = systemService.findUniqueByProperty(TSTypegroup.class, "typegroupcode", "bx_type");
		if (typegroup != null) {
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		if (StringUtils.isEmpty(funname)) {
			return new ModelAndView("com/inspection/adjust/performance");
		} else {
			return new ModelAndView("com/inspection/adjust/performanceDetial");

		}

	}

	/**
	 * 表彰奖励上级意见结果详情
	 * 
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewAuditing")
	public ModelAndView viewAuditing(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<AdjustAuditingEntity> lists = adjustService.findAllAudits(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if (StringUtils.isEmpty(funname)) {
			return new ModelAndView("com/inspection/adjust/auditing");
		} else {
			return new ModelAndView("com/inspection/adjust/auditingDetial");
		}

	}

	/**
	 * 民族评议/推荐
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewResidualRecommend")
	public ModelAndView viewResidualRecommend(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<AdjustRecommendEntity> lists = adjustService.findAllRecommends(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		if (StringUtils.isEmpty(funname)) {
			return new ModelAndView("com/inspection/adjust/adjustRecommend");
		} else {
			return new ModelAndView("com/inspection/adjust/adjustRecommendDetial");
		}

	}

	/**
	 * 考核结果
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewAssessment")
	public ModelAndView viewAssessment(HttpServletRequest req) {
		String id = req.getParameter("id");
		String funname = req.getParameter("funname");
		if (StringUtils.isNotEmpty(id)) {
			List<AdjustAssessmentEntity> lists = adjustService.findAlltAssessments(id);
			req.setAttribute("lists", lists);
			req.setAttribute("officerId", id);
		}
		TSTypegroup pxgroup = systemService.findUniqueByProperty(TSTypegroup.class, "typegroupcode", "px_type");
		if (pxgroup != null) {
			req.setAttribute("pxList", pxgroup.getTSTypes());
		}
		if (StringUtils.isEmpty(funname)) {
			return new ModelAndView("com/inspection/adjust/assessment");
		} else {
			return new ModelAndView("com/inspection/adjust/assessmentDetial");
		}

	}

	/**
	 * 表彰奖励处理详情
	 * 
	 * @param soldierLeave
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(AdjustEntity adjust, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id")) ? req.getParameter("id") : adjust.getId();

		/*
		 * if (StringUtils.isNotEmpty(id)) { officerLeave =
		 * officerLeaveService.findEntity(OfficerLeaveEntity.class, id);
		 * req.setAttribute("officerLeavePage", officerLeave); }
		 */
		req.setAttribute("residualId", id);
		return new ModelAndView("com/inspection/adjust/mainDetial");
	}

/*	@RequestMapping(params = "viewDetailMain")
	public ModelAndView viewDetailMain(AdjustEntity adjust, HttpServletRequest req) {
		String id = req.getParameter("id");
		AdjustMainPage result = new AdjustMainPage();
		if (StringUtils.isNotEmpty(id)) {
			adjust = adjustService.findEntity(AdjustEntity.class, id);
			result.setAdjust(adjust);
			result.setPerformances(adjustService.findAllPerformances(id));
			result.setResults(adjustService.findAllAudits(id));
			result.setRecommends(adjustService.findAllRecommends(id));
			result.setAssessments(adjustService.findAlltAssessments(id));
			req.setAttribute("adjustPage", result);
		}
		TSTypegroup typegroup = systemService.findUniqueByProperty(TSTypegroup.class, "typegroupcode", "bx_type");
		if (typegroup != null) {
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		TSTypegroup pxgroup = systemService.findUniqueByProperty(TSTypegroup.class, "typegroupcode", "px_type");
		if (pxgroup != null) {
			req.setAttribute("pxList", pxgroup.getTSTypes());
		}
		String isView = req.getParameter("isView");
		req.setAttribute("isView", isView);
		req.setAttribute("id", id);
		return new ModelAndView("com/inspection/adjust/viewDetailMain");
	}*/

	@RequestMapping(params = "viewDetailMain")
	public ModelAndView viewDetailMain(AdjustEntity adjust, HttpServletRequest req) {
		String id = req.getParameter("id");
		AdjustMain result = new AdjustMain();
		if (StringUtils.isNotEmpty(id)) {
			ArrayList<String> jiaJianXiang = new ArrayList<String>();
			jiaJianXiang.add("加分项1");
			result.setJiaJianXiang(jiaJianXiang);
			req.setAttribute("adjustPage", result);
		}
		return new ModelAndView("com/inspection/adjust/viewDetailMain");
	}
}
