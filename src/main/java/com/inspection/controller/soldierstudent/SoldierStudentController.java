package com.inspection.controller.soldierstudent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.controller.lib.JsonDateValueProcessor;
import com.inspection.entity.JunShiJiaFen;
import com.inspection.entity.soldierstudent.SoldierStudentMain;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
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
	 * 查看或处理
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(SoldierStudentEntity entity, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):entity.getId();
		if (StringUtils.isNotEmpty(id)) {
			SoldierStudentMain result = new SoldierStudentMain();
			result = soldierStudentService.findEntity(SoldierStudentMain.class, id);
			if (result == null) {
				result = new SoldierStudentMain();
			}
			entity = soldierStudentService.findEntity(SoldierStudentEntity.class, id);
			result.setEntity(entity);

			result.setShouJiangQingKuang(JSONArray.toList(JSONArray.fromObject(result.getShouJiangString())));

			String[] formats={"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd"};
			JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(formats));
			result.setJunShiJiaFen(JSONArray.toList(JSONArray.fromObject(result.getJiaFenString()),JunShiJiaFen.class));
			//System.out.println("sss"+((JunShiJiaFen)JSONObject.toBean(JSONObject.fromObject("{'detail':'加分1','time':'2018-10-01'}"),JunShiJiaFen.class)).getTime());


			req.setAttribute("soldierStudentPage", result);
		}
		String isView =  req.getParameter("isView");
        req.setAttribute("id", id);
        if(isView.equals("true")){
            return new ModelAndView("com/inspection/soldierstudent/mainDetial");
        } else {
            return new ModelAndView("com/inspection/soldierstudent/processSoldierStudent");
        }
	}

    // 大学生士兵提干调整-处理页面
    @RequestMapping(params = "modifyProcess")
    @ResponseBody
    public AjaxJson modifyProcess(SoldierStudentMain soldierStudentMain, HttpServletRequest req) {
        AjaxJson result = new AjaxJson();
        String id = req.getParameter("id");
		soldierStudentMain.setId(id);

        List<Date> times = soldierStudentMain.getTimes();
        List<String> details = soldierStudentMain.getDetails();
        List<JunShiJiaFen> jiaFen = new ArrayList<JunShiJiaFen>();
        for( int i = 0 ; i < times.size() ; i++) {
            if (times.get(i) != null) {
				jiaFen.add(new JunShiJiaFen(times.get(i),details.get(i)));
			}
        }

		if (jiaFen.size() > 0) {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
			soldierStudentMain.setJiaFenString(JSONArray.fromObject(jiaFen,jsonConfig).toString());
		}

		soldierStudentMain.setShouJiangString(JSONArray.fromObject(soldierStudentMain.getShouJiangQingKuang()).toString());

		soldierStudentService.saveOrUpdate(soldierStudentMain);

        result.setMsg("保存成功");
        return result;
    }
}
