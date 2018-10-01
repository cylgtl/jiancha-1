package com.inspection.controller.delivery;
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
import org.jeecgframework.platform.common.tag.easyui.TagUtil;
import org.jeecgframework.platform.constant.Globals;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.web.utils.ResourceUtils;
import org.jeecgframework.web.utils.SessionUtils;
import org.jeecgframework.web.utils.StringUtils;
import org.jeecgframework.web.common.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.web.system.controller.BaseController;
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.service.SystemService;


import com.inspection.entity.delivery.DeliveryEntity;
import com.inspection.service.delivery.DeliveryServiceI;

/**   
 * @Title: Controller
 * @Description: 被装发放信息
 * @author zhangdaihao
 * @date 2018-07-04 11:25:47
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/deliveryController")
public class DeliveryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DeliveryController.class);

	@Autowired
	private DeliveryServiceI deliveryService;
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
	 * 被装发放信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "delivery")
	public ModelAndView delivery(HttpServletRequest request) {
		return new ModelAndView("com/inspection/delivery/deliveryList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param delivery
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DeliveryEntity delivery,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DeliveryEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, delivery, request.getParameterMap());
		this.deliveryService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除被装发放信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(DeliveryEntity delivery, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		delivery = systemService.findEntity(DeliveryEntity.class, delivery.getId());
		message = "被装发放信息删除成功";
		deliveryService.delete(delivery);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加被装发放信息
	 * 
	 * @param delivery
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(DeliveryEntity delivery, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		TSUser user = SessionUtils.getCurrentUser();
		if (StringUtils.isNotEmpty(delivery.getId())) {
			message = "被装发放信息更新成功";
			DeliveryEntity t = deliveryService.find(DeliveryEntity.class, delivery.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(delivery, t);
                t.setUpdateDate(new Date());
                t.setUpdateBy(user.getId());
				deliveryService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "被装发放信息更新失败";
			}
		} else {
			message = "被装发放信息添加成功";
			String departId = SessionUtils.getCurrentDepartsCode();
			String  publicUrl=ResourceUtils.getResourcePublicURL();
			//String[] fileName = militraining.getFileId().split("/");
			delivery.setFileId(publicUrl  + delivery.getFileId());
			delivery.setCreateBy(user.getId());
			delivery.setCerateDate(new Date());
			delivery.setDepartId(departId);
			deliveryService.save(delivery);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 被装发放信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "search")
	public ModelAndView search(DeliveryEntity delivery, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(delivery.getId())) {
			delivery = deliveryService.findEntity(DeliveryEntity.class, delivery.getId());
			req.setAttribute("deliveryPage", delivery);
		}
		return new ModelAndView("com/inspection/delivery/searchDelivery");
	}
	
	/**
	 * 被装发放信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addoredit")
	public ModelAndView addoredit(DeliveryEntity delivery, HttpServletRequest req) {
		String id = delivery.getId();
		if (StringUtils.isEmpty(id)) {
			id = req.getParameter("id");
		}
		
	   if(org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
			delivery = deliveryService.findEntity(DeliveryEntity.class, id);
			req.setAttribute("deliveryPage", delivery);
	   }
		return new ModelAndView("com/inspection/delivery/delivery");
	}
}
