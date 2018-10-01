package com.inspection.controller.purchasing;
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


import com.inspection.entity.purchasing.SuppliesPurchasingEntity;
import com.inspection.service.purchasing.SuppliesPurchasingServiceI;

/**   
 * @Title: Controller
 * @Description: 通用物资集中采购
 * @author zhangdaihao
 * @date 2018-07-04 22:10:30
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/suppliesPurchasingController")
public class SuppliesPurchasingController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SuppliesPurchasingController.class);

	@Autowired
	private SuppliesPurchasingServiceI suppliesPurchasingService;
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
	 * 通用物资集中采购列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "suppliesPurchasing")
	public ModelAndView suppliesPurchasing(HttpServletRequest request) {
		return new ModelAndView("com/inspection/purchasing/suppliesPurchasingList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param suppliesPurchasing
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SuppliesPurchasingEntity suppliesPurchasing,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SuppliesPurchasingEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, suppliesPurchasing, request.getParameterMap());
		this.suppliesPurchasingService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通用物资集中采购
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SuppliesPurchasingEntity suppliesPurchasing, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		suppliesPurchasing = systemService.findEntity(SuppliesPurchasingEntity.class, suppliesPurchasing.getId());
		message = "通用物资集中采购删除成功";
		suppliesPurchasingService.delete(suppliesPurchasing);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加通用物资集中采购
	 * 
	 * @param suppliesPurchasing
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SuppliesPurchasingEntity suppliesPurchasing, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		TSUser user = SessionUtils.getCurrentUser();
		if (StringUtils.isNotEmpty(suppliesPurchasing.getId())) {
			message = "通用物资集中采购更新成功";
			SuppliesPurchasingEntity t = suppliesPurchasingService.find(SuppliesPurchasingEntity.class, suppliesPurchasing.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(suppliesPurchasing, t);
                t.setUpdateTime(new Date());
                t.setUpdateUserId(user.getId());
				suppliesPurchasingService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "通用物资集中采购更新失败";
			}
		} else {
			message = "通用物资集中采购添加成功";
			String departs = SessionUtils.getCurrentDepartsCode();
			String  publicUrl=ResourceUtils.getResourcePublicURL();
			//String[] fileName = suppliesPurchasing.getFileId().split("/");
			suppliesPurchasing.setFileId(publicUrl  + suppliesPurchasing.getFileId());
			suppliesPurchasing.setDepartId(departs);
			suppliesPurchasing.setCreateUserId(user.getId());
			suppliesPurchasing.setCreateTime(new Date());
			suppliesPurchasingService.save(suppliesPurchasing);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 通用物资集中采购列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SuppliesPurchasingEntity suppliesPurchasing, HttpServletRequest req) {
		String id = suppliesPurchasing.getId();
		if (StringUtils.isEmpty(id)) {
			id = req.getParameter("id");
		}
		if(org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
			suppliesPurchasing = suppliesPurchasingService.findEntity(SuppliesPurchasingEntity.class, suppliesPurchasing.getId());
			req.setAttribute("suppliesPurchasingPage", suppliesPurchasing);
		}

		return new ModelAndView("com/inspection/purchasing/suppliesPurchasing");
	}
}
