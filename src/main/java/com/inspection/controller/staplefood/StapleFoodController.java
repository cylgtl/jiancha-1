package com.inspection.controller.staplefood;
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
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.service.SystemService;


import com.inspection.entity.staplefood.StapleFoodEntity;
import com.inspection.service.staplefood.StapleFoodServiceI;

/**   
 * @Title: Controller
 * @Description: 副食品定价信息
 * @author zhangdaihao
 * @date 2018-07-05 10:13:32
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/stapleFoodController")
public class StapleFoodController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(StapleFoodController.class);

	@Autowired
	private StapleFoodServiceI stapleFoodService;
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
	 * 副食品定价信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "stapleFood")
	public ModelAndView stapleFood(HttpServletRequest request) {
		return new ModelAndView("com/inspection/staplefood/stapleFoodList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param stapleFood
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(StapleFoodEntity stapleFood,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(StapleFoodEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, stapleFood, request.getParameterMap());
		this.stapleFoodService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除副食品定价信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(StapleFoodEntity stapleFood, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		stapleFood = systemService.findEntity(StapleFoodEntity.class, stapleFood.getId());
		message = "副食品定价信息删除成功";
		stapleFoodService.delete(stapleFood);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加副食品定价信息
	 * 
	 * @param stapleFood
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(StapleFoodEntity stapleFood, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		TSUser user = SessionUtils.getCurrentUser();
		if (StringUtils.isNotEmpty(stapleFood.getId())) {
			message = "副食品定价信息更新成功";		
			StapleFoodEntity t = stapleFoodService.find(StapleFoodEntity.class, stapleFood.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(stapleFood, t);
                t.setUpdateDate(new Date());
                t.setUpdateBy(user.getId());
				stapleFoodService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "副食品定价信息更新失败";
			}
		} else {
			message = "副食品定价信息添加成功";
			String departId = SessionUtils.getCurrentDepartsCode();
			String  publicUrl=ResourceUtils.getResourcePublicURL();
			//String[] fileName = militraining.getFileId().split("/");
			stapleFood.setFileId(publicUrl  + stapleFood.getFileId());
			stapleFood.setCreateBy(user.getId());
			stapleFood.setCerateDate(new Date());
			stapleFood.setDepartId(departId);
			stapleFoodService.save(stapleFood);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 副食品定价信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(StapleFoodEntity stapleFood, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(stapleFood.getId())) {
			stapleFood = stapleFoodService.findEntity(StapleFoodEntity.class, stapleFood.getId());
			req.setAttribute("stapleFoodPage", stapleFood);
		}
		return new ModelAndView("com/inspection/staplefood/stapleFood");
	}
	
	
	/**
	 * 查看副食品定价信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "viewFood")
	public ModelAndView viewFood(StapleFoodEntity stapleFood, HttpServletRequest req) {
		String id = stapleFood.getId();
		if (StringUtils.isEmpty(id)) {
			id = req.getParameter("id");
		}
		
		if(org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
			stapleFood = stapleFoodService.findEntity(StapleFoodEntity.class, stapleFood.getId());
			req.setAttribute("stapleFoodPage", stapleFood);
		}
		
		return new ModelAndView("com/inspection/staplefood/searchStapleFood");
	}
}
