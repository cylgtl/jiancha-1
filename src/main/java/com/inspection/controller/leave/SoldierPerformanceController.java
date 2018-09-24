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


import com.inspection.entity.leave.SoldierPerformanceEntity;
import com.inspection.service.leave.SoldierPerformanceServiceI;

/**   
 * @Title: Controller
 * @Description: 个人平时表现
 * @author zhangdaihao
 * @date 2018-07-05 22:27:27
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/soldierPerformanceController")
public class SoldierPerformanceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SoldierPerformanceController.class);

	@Autowired
	private SoldierPerformanceServiceI soldierPerformanceService;
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
	 * 个人平时表现列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "soldierPerformance")
	public ModelAndView soldierPerformance(HttpServletRequest request) {
		return new ModelAndView("com/inspection/leave/soldierPerformanceList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param soldierPerformance
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SoldierPerformanceEntity soldierPerformance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SoldierPerformanceEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, soldierPerformance, request.getParameterMap());
		this.soldierPerformanceService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除个人平时表现
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SoldierPerformanceEntity soldierPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		soldierPerformance = systemService.findEntity(SoldierPerformanceEntity.class, soldierPerformance.getId());
		message = "个人平时表现删除成功";
		soldierPerformanceService.delete(soldierPerformance);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加个人平时表现
	 * 
	 * @param soldierPerformance
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SoldierPerformanceEntity soldierPerformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(soldierPerformance.getId())) {
			message = "个人平时表现更新成功";
			SoldierPerformanceEntity t = soldierPerformanceService.find(SoldierPerformanceEntity.class, soldierPerformance.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(soldierPerformance, t);
				soldierPerformanceService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "个人平时表现更新失败";
			}
		} else {
			message = "个人平时表现添加成功";
			soldierPerformanceService.save(soldierPerformance);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 个人平时表现列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SoldierPerformanceEntity soldierPerformance, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(soldierPerformance.getId())) {
			soldierPerformance = soldierPerformanceService.findEntity(SoldierPerformanceEntity.class, soldierPerformance.getId());
			req.setAttribute("soldierPerformancePage", soldierPerformance);
		}
		return new ModelAndView("com/inspection/leave/soldierPerformance");
	}
}
