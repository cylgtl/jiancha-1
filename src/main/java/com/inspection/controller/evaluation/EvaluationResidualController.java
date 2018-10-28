package com.inspection.controller.evaluation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.entity.JunShiXunLian;
import com.inspection.entity.evaluation.EvaluationResidualMain;
import net.sf.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
		request.setAttribute("currentDepart",SessionUtils.getCurrentUser().getCurrentDepart());
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
		if (StringUtils.isEmpty(request.getParameter("search"))){
			departId = request.getParameter("currentDepartId");
		}
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
		
		dataGrid.setPage(dataGrid.getPage());
		dataGrid.setTotal(dataGrid.getTotal());
		dataGrid.setRows(dataGrid.getRows());
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
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetial(EvaluationResidualEntity evaluationResidual, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):evaluationResidual.getId();

		if (StringUtils.isNotEmpty(id)) {
			EvaluationResidualMain result = evaluationResidualService.findEntity(EvaluationResidualMain.class, id);
			if ( result == null ){
				result = new EvaluationResidualMain();
			}

			if(result.getGeRenZiShu() != null && result.getGeRenZiShu().length > 0) {
				File dest = new File(req.getSession().getServletContext().getRealPath("/downloadFiles/evaluationResidual")
						+"/"+result.getId()+"/"+result.getZiShuFilename());
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					FileUtils.writeByteArrayToFile(dest, result.getGeRenZiShu());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if(result.getFuHeXing() != null && result.getFuHeXing().length > 0) {
				File dest = new File(req.getSession().getServletContext().getRealPath("/downloadFiles/evaluationResidual")
						+"/"+result.getId()+"/"+result.getFuHeFilename());
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					FileUtils.writeByteArrayToFile(dest, result.getFuHeXing());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if(result.getShenFenZheng() != null && result.getShenFenZheng().length > 0) {
				File dest = new File(req.getSession().getServletContext().getRealPath("/downloadFiles/evaluationResidual")
						+"/"+result.getId()+"/"+result.getShenFenZhengFilename());
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					FileUtils.writeByteArrayToFile(dest, result.getShenFenZheng());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if(result.getJunGuangZheng() != null && result.getJunGuangZheng().length > 0) {
				File dest = new File(req.getSession().getServletContext().getRealPath("/downloadFiles/evaluationResidual")
						+"/"+result.getId()+"/"+result.getJunGuangZhengFilename());
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					FileUtils.writeByteArrayToFile(dest, result.getJunGuangZheng());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if(result.getBaoZhangKa() != null && result.getBaoZhangKa().length > 0) {
				File dest = new File(req.getSession().getServletContext().getRealPath("/downloadFiles/evaluationResidual")
						+"/"+result.getId()+"/"+result.getBaoZhangKaFilename());
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					FileUtils.writeByteArrayToFile(dest, result.getBaoZhangKa());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if(result.getBingLi() != null && result.getBingLi().length > 0) {
				File dest = new File(req.getSession().getServletContext().getRealPath("/downloadFiles/evaluationResidual")
						+"/"+result.getId()+"/"+result.getBingLiFilename());
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					FileUtils.writeByteArrayToFile(dest, result.getBingLi());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			evaluationResidual = evaluationResidualService.findEntity(EvaluationResidualEntity.class, id);
			result.setEntity(evaluationResidual);
			req.setAttribute("evaluationResidualPage", result);
		}
		
		String isView =  req.getParameter("isView");
		if(isView.equals("true")){
			return new ModelAndView("com/inspection/evaluation/mainDetial");
		} else {
			return new ModelAndView("com/inspection/evaluation/processEvaluation");
		}
	}

	// 处理页面
	@RequestMapping(params = "modifyProcess")
	@ResponseBody
	public AjaxJson modifyProcess(EvaluationResidualMain evaluationResidualMain, HttpServletRequest req) {

		AjaxJson result = new AjaxJson();
		String id = req.getParameter("id");
		evaluationResidualMain.setId(id);

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		MultipartFile file = multipartRequest.getFile("ziShuFile");
		if (file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			try {
				evaluationResidualMain.setZiShuFilename(fileName);
				evaluationResidualMain.setGeRenZiShu(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("个人自述文件保存失败，请重试");
				return result;
			}
		}else {
			EvaluationResidualMain main = evaluationResidualService.findEntity(EvaluationResidualMain.class, id);
			if (main!=null){
				evaluationResidualMain.setZiShuFilename(main.getZiShuFilename());
				evaluationResidualMain.setGeRenZiShu(main.getGeRenZiShu());
			}
		}

		file = multipartRequest.getFile("fuHeFile");
		if (file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			try {
				evaluationResidualMain.setFuHeFilename(fileName);
				evaluationResidualMain.setFuHeXing(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("病情与致残标准符合性文件保存失败，请重试");
				return result;
			}
		}else {
			EvaluationResidualMain main = evaluationResidualService.findEntity(EvaluationResidualMain.class, id);
			if (main!=null){
				evaluationResidualMain.setFuHeFilename(main.getFuHeFilename());
				evaluationResidualMain.setFuHeXing(main.getFuHeXing());
			}
		}

		file = multipartRequest.getFile("shenFenFile");
		if (file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			try {
				evaluationResidualMain.setShenFenZhengFilename(fileName);
				evaluationResidualMain.setShenFenZheng(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("身份证图片保存失败，请重试");
				return result;
			}
		}else {
			EvaluationResidualMain main = evaluationResidualService.findEntity(EvaluationResidualMain.class, id);
			if (main!=null){
				evaluationResidualMain.setShenFenZhengFilename(main.getShenFenZhengFilename());
				evaluationResidualMain.setShenFenZheng(main.getShenFenZheng());
			}
		}

		file = multipartRequest.getFile("junGuanFile");
		if (file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			try {
				evaluationResidualMain.setJunGuangZhengFilename(fileName);
				evaluationResidualMain.setJunGuangZheng(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("军官证图片保存失败，请重试");
				return result;
			}
		}else {
			EvaluationResidualMain main = evaluationResidualService.findEntity(EvaluationResidualMain.class, id);
			if (main!=null){
				evaluationResidualMain.setJunGuangZhengFilename(main.getJunGuangZhengFilename());
				evaluationResidualMain.setJunGuangZheng(main.getJunGuangZheng());
			}
		}

		file = multipartRequest.getFile("baoZhangFile");
		if (file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			try {
				evaluationResidualMain.setBaoZhangKaFilename(fileName);
				evaluationResidualMain.setBaoZhangKa(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("保障卡图片保存失败，请重试");
				return result;
			}
		}else {
			EvaluationResidualMain main = evaluationResidualService.findEntity(EvaluationResidualMain.class, id);
			if (main!=null){
				evaluationResidualMain.setBaoZhangKaFilename(main.getBaoZhangKaFilename());
				evaluationResidualMain.setBaoZhangKa(main.getBaoZhangKa());
			}
		}

		file = multipartRequest.getFile("bingLiFile");
		if (file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			try {
				evaluationResidualMain.setBingLiFilename(fileName);
				evaluationResidualMain.setBingLi(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("病历图片保存失败，请重试");
				return result;
			}
		}else {
			EvaluationResidualMain main = evaluationResidualService.findEntity(EvaluationResidualMain.class, id);
			if (main!=null){
				evaluationResidualMain.setBingLiFilename(main.getBingLiFilename());
				evaluationResidualMain.setBingLi(main.getBingLi());
			}
		}

		evaluationResidualService.saveOrUpdate(evaluationResidualMain);
		result.setMsg("保存成功");
		return result;
	}
}
