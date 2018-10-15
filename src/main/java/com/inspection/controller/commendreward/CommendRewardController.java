package com.inspection.controller.commendreward;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspection.entity.JunShiXunLian;
import com.inspection.entity.commendreward.CommendRewardMain;
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

import com.inspection.entity.commendreward.CommendRewardAuditEntity;
import com.inspection.entity.commendreward.CommendRewardEntity;
import com.inspection.entity.commendreward.CommendRewardPerformanceEntity;
import com.inspection.entity.commendreward.CommendRewardRecommendEntity;
import com.inspection.pojo.CommendRewardMainPage;
import com.inspection.service.commendreward.CommendRewardServiceI;

/**   
 * @Title: Controller
 * @Description: 表彰奖励详情信息
 * @author zhangdaihao
 * @date 2018-07-07 14:49:37
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/commendRewardController")
public class CommendRewardController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CommendRewardController.class);

	@Autowired
	private CommendRewardServiceI commendRewardService;
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
	 * 表彰奖励详情信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "commendReward")
	public ModelAndView commendReward(HttpServletRequest request) {
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
		return new ModelAndView("com/inspection/commendreward/commendRewardList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param commendReward
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(CommendRewardEntity commendReward,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CommendRewardEntity.class, dataGrid);
		//默认查询当前用户所属部门下数据
				String departId = commendReward.getDepartId();
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
				commendReward.setDepartId(StringUtils.isNotEmpty(departId)?departId:null);
				//查询条件组装器
				HqlGenerateUtil.installHql(cq, commendReward, request.getParameterMap());
				this.commendRewardService.findDataGridReturn(cq, true);
				List<CommendRewardEntity> results= dataGrid.getResults();
				if(null != results && results.size() > 0 ){
					for(CommendRewardEntity sl:results){
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
	 * 删除表彰奖励详情信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(CommendRewardEntity commendReward, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String officerId = commendReward.getId();
		commendReward = systemService.findEntity(CommendRewardEntity.class, commendReward.getId());
		message = "表彰奖励详情信息删除成功";
		commendRewardService.delete(commendReward);
		systemService.executeSql("delete from jc_commend_reward_audit where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_commend_reward_performance where OFFICER_ID=?", officerId);
		systemService.executeSql("delete from jc_commend_reward_recommend where OFFICER_ID=?", officerId);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加表彰奖励详情信息
	 * 
	 * @param commendReward
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(CommendRewardEntity commendReward, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(commendReward.getId())) {
			message = "表彰奖励详情信息更新成功";
			CommendRewardEntity t = commendRewardService.find(CommendRewardEntity.class, commendReward.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(commendReward, t);
				commendRewardService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "表彰奖励详情信息更新失败";
			}
		} else {
			message = "表彰奖励详情信息添加成功";
			commendReward.setDepartId(SessionUtils.getCurrentDepartsCode());
			commendRewardService.save(commendReward);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 表彰奖励详情信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(CommendRewardEntity commendReward, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(commendReward.getId())) {
			commendReward = commendRewardService.findEntity(CommendRewardEntity.class, commendReward.getId());
			req.setAttribute("commendRewardPage", commendReward);
		}
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","nor_type");
		if(typegroup!=null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		return new ModelAndView("com/inspection/commendreward/commendReward");
	}
	
	/**
	 * 删除表彰奖励意见和结果信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "deleteAuditing")
	@ResponseBody
	public AjaxJson deleteAuditing(CommendRewardAuditEntity  commendRewardAudit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			commendRewardAudit = systemService.findEntity(CommendRewardAuditEntity.class,id);
			commendRewardService.delete(commendRewardAudit);
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
	public AjaxJson deletePerformance(CommendRewardPerformanceEntity commendRewardPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			commendRewardPerformance = systemService.findEntity(CommendRewardPerformanceEntity.class,id);
			commendRewardService.delete(commendRewardPerformance);
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
	public AjaxJson deleteRecommend(CommendRewardRecommendEntity commendRewardRecommend, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			commendRewardRecommend = systemService.findEntity(CommendRewardRecommendEntity.class,id);
			commendRewardService.delete(commendRewardRecommend);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "民主推荐信息删除成功";
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
	public AjaxJson  addorupdateOperate(CommendRewardMainPage commendRewardMainPage, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String officerId = req.getParameter("id");
		List<CommendRewardPerformanceEntity>  performances =commendRewardMainPage.getPerformances();
		List<CommendRewardAuditEntity> results = commendRewardMainPage.getResults();
		List<CommendRewardRecommendEntity> recommends = commendRewardMainPage.getRecommends();
		TSUser user = SessionUtils.getCurrentUser();
		String userId = user.getId();
		String  publicUrl=ResourceUtils.getResourcePublicURL();
		if(StringUtils.isNotEmpty(officerId)){
		for(CommendRewardPerformanceEntity op:performances){
			op.setCreateTime(new Date());
			op.setCreateId(userId);
			op.setOfficerId(officerId);
			op.setFileId(publicUrl+op.getFileId());
			commendRewardService.saveOrUpdate(op);
		}
		
		for(CommendRewardAuditEntity oa:results){
			oa.setCreateTime(new Date());
			oa.setCreateId(userId);
			oa.setOfficerId(officerId);
			oa.setFileId(publicUrl+oa.getFileId());
			commendRewardService.saveOrUpdate(oa);
		}
		for(CommendRewardRecommendEntity recommend:recommends){
			recommend.setCreateTime(new Date());
			recommend.setCreateId(userId);
			recommend.setOfficerId(officerId);
			commendRewardService.saveOrUpdate(recommend);
		}
		}
		result.setMsg("保存成功");
		return result;
	}

	/**
	 * 表彰奖励处理详情
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "viewMainDetial")
	public ModelAndView viewMainDetail(CommendRewardEntity commendReward, HttpServletRequest req) {
		String id = StringUtils.isNotEmpty(req.getParameter("id"))?req.getParameter("id"):commendReward.getId();

		if (StringUtils.isNotEmpty(id)) {
			CommendRewardMain result = commendRewardService.findEntity(CommendRewardMain.class, id);
			if (result==null){
				result = new CommendRewardMain();
			}

			if(result.getShiJiCaiLiao() != null && result.getShiJiCaiLiao().length > 0) {
				File dest = new File(req.getSession().getServletContext().getRealPath("/downloadFiles/commendReward")
						+"/"+result.getId()+"/"+result.getShiJiFilename());
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					FileUtils.writeByteArrayToFile(dest, result.getShiJiCaiLiao());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			commendReward = commendRewardService.findEntity(CommendRewardEntity.class, id);
			result.setEntity(commendReward);
			result.setJunShiXunLian(JSONArray.toList(JSONArray.fromObject(result.getXunLianString()), JunShiXunLian.class));
			result.setBiaoZhang(JSONArray.toList(JSONArray.fromObject(result.getBiaoZhangString())));
			req.setAttribute("commendrewardPage", result);
		}

		String isView =  req.getParameter("isView");
		if(isView.equals("true")){
			return new ModelAndView("com/inspection/commendreward/mainDetial");
		} else {
			return new ModelAndView("com/inspection/commendreward/processCommendReward");
		}
	}

	// 处理页面
	@RequestMapping(params = "modifyProcess")
	@ResponseBody
	public AjaxJson modifyProcess(CommendRewardMain commendRewardMain, HttpServletRequest req) {
		AjaxJson result = new AjaxJson();
		String id = req.getParameter("id");
		commendRewardMain.setId(id);

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		MultipartFile file = multipartRequest.getFile("shiJiFile");
		if (file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			try {
				commendRewardMain.setShiJiFilename(fileName);
				commendRewardMain.setShiJiCaiLiao(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("文件保存失败，请重试");
				return result;
			}
		}

		List<String> names = commendRewardMain.getNames();
		List<String> scores = commendRewardMain.getScores();
		List<JunShiXunLian> xunLian = new ArrayList<JunShiXunLian>();
		for( int i = 0 ; i < names.size() ; i++) {
			if (names.get(i) != null) {
				xunLian.add(new JunShiXunLian(names.get(i),scores.get(i)));
			}
		}

		commendRewardMain.setXunLianString(JSONArray.fromObject(xunLian).toString());
		commendRewardMain.setBiaoZhangString(JSONArray.fromObject(commendRewardMain.getBiaoZhang()).toString());

		commendRewardService.saveOrUpdate(commendRewardMain);
		result.setMsg("保存成功");
		return result;
	}
}
