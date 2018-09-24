package com.inspection.controller.leave;
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
import org.jeecgframework.web.utils.StringUtils;
import org.jeecgframework.platform.common.tag.easyui.TagUtil;
import org.jeecgframework.platform.constant.Globals;
import org.jeecgframework.web.common.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.web.system.controller.BaseController;
import org.jeecgframework.web.system.service.SystemService;


import com.inspection.entity.leave.SoldierAuditingEntity;
import com.inspection.service.leave.SoldierAuditingServiceI;

/**   
 * @Title: Controller
 * @Description: 各级研究意见和结果
 * @author zhangdaihao
 * @date 2018-07-05 22:26:34
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/soldierAuditingController")
public class SoldierAuditingController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SoldierAuditingController.class);

	@Autowired
	private SoldierAuditingServiceI soldierAuditingService;
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
	 * 各级研究意见和结果列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "soldierAuditing")
	public ModelAndView soldierAuditing(HttpServletRequest request) {
		return new ModelAndView("com/inspection/leave/soldierAuditingList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param soldierAuditing
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SoldierAuditingEntity soldierAuditing,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SoldierAuditingEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, soldierAuditing, request.getParameterMap());
		this.soldierAuditingService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除各级研究意见和结果
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SoldierAuditingEntity soldierAuditing, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		soldierAuditing = systemService.findEntity(SoldierAuditingEntity.class, soldierAuditing.getId());
		message = "各级研究意见和结果删除成功";
		soldierAuditingService.delete(soldierAuditing);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加各级研究意见和结果
	 * 
	 * @param soldierAuditing
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SoldierAuditingEntity soldierAuditing, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(soldierAuditing.getId())) {
			message = "各级研究意见和结果更新成功";
			SoldierAuditingEntity t = soldierAuditingService.find(SoldierAuditingEntity.class, soldierAuditing.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(soldierAuditing, t);
				soldierAuditingService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "各级研究意见和结果更新失败";
			}
		} else {
			message = "各级研究意见和结果添加成功";
			soldierAuditingService.save(soldierAuditing);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 各级研究意见和结果列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SoldierAuditingEntity soldierAuditing, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(soldierAuditing.getId())) {
			soldierAuditing = soldierAuditingService.findEntity(SoldierAuditingEntity.class, soldierAuditing.getId());
			req.setAttribute("soldierAuditingPage", soldierAuditing);
		}
		return new ModelAndView("com/inspection/leave/soldierAuditing");
	}
}
