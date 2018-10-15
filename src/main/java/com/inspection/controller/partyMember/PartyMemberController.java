package com.inspection.controller.partyMember;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.entity.JunShiJiaFen;
import com.inspection.entity.JunShiXunLian;
import com.inspection.entity.partyMember.PartyMemberMain;
import net.sf.json.JSONArray;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

	@RequestMapping(params = "viewDetailMain")
	public ModelAndView viewDetailMain(PartyMemberEntity entity, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):entity.getId();
		String isView =  req.getParameter("isView");
		if (StringUtils.isNotEmpty(id)) {
			PartyMemberMain result = partyMemberService.findEntity(PartyMemberMain.class, id);
			if (result==null){
				result = new PartyMemberMain();
			}
			entity = partyMemberService.findEntity(PartyMemberEntity.class, id);
			result.setEntity(entity);
			result.setJunShiXunLian(JSONArray.toList(JSONArray.fromObject(result.getXunLianString()),JunShiXunLian.class));
			result.setBiaoZhang(JSONArray.toList(JSONArray.fromObject(result.getBiaoZhangString())));
			req.setAttribute("partyMemberPage", result);
		}
		if(isView.equals("true")){
			return new ModelAndView("com/inspection/partyMember/viewDetailMain");
		} else {
			return new ModelAndView("com/inspection/partyMember/processPartyMember");
		}
	}

	// 党员发展-处理页面
	@RequestMapping(params = "modifyProcess")
	@ResponseBody
	public AjaxJson modifyProcess(PartyMemberMain partyMemberMain, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String id = req.getParameter("id");

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		MultipartFile file = multipartRequest.getFile("ruDangFile");
		if (file != null) {
			String fileName = file.getOriginalFilename();
			int size = (int) file.getSize();
			System.out.println("ddd "+fileName + "-->" + size);
		}

		partyMemberMain.setId(id);
		List<String> names = partyMemberMain.getNames();
		List<String> scores = partyMemberMain.getScores();
		List<JunShiXunLian> xunLian = new ArrayList<JunShiXunLian>();
		for( int i = 0 ; i < names.size() ; i++) {
			if (names.get(i) != null) {
				xunLian.add(new JunShiXunLian(names.get(i),scores.get(i)));
			}
		}
		partyMemberMain.setXunLianString(JSONArray.fromObject(xunLian).toString());
		partyMemberMain.setBiaoZhangString(JSONArray.fromObject(partyMemberMain.getBiaoZhang()).toString());

		partyMemberService.saveOrUpdate(partyMemberMain);


		result.setMsg("保存成功");
		return result;
	}
}
