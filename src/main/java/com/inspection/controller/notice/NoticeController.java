package com.inspection.controller.notice;
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


import com.inspection.entity.notice.NoticeEntity;
import com.inspection.service.notice.NoticeServiceI;

/**   
 * @Title: Controller
 * @Description: 各种类型通知
 * @author zhangdaihao
 * @date 2018-07-01 15:09:09
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/noticeController")
public class NoticeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(NoticeController.class);

	@Autowired
	private NoticeServiceI noticeService;
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
	 * 各种类型通知列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "notice")
	public ModelAndView notice(HttpServletRequest request) {
		return new ModelAndView("com/inspection/notice/noticeList");
	}
	
	@RequestMapping(params = "showNotice")
	public ModelAndView showNotice(HttpServletRequest request) {
		return new ModelAndView("com/inspection/notice/showNoticeList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param notice
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(NoticeEntity notice,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(NoticeEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, notice, request.getParameterMap());
		this.noticeService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除各种类型通知
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(NoticeEntity notice, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		notice = systemService.findEntity(NoticeEntity.class, notice.getId());
		message = "各种类型通知删除成功";
		noticeService.delete(notice);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加各种类型通知
	 * 
	 * @param notice
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(NoticeEntity notice, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(notice.getId())) {
			message = "各种类型通知更新成功";
			NoticeEntity t = noticeService.find(NoticeEntity.class, notice.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(notice, t);
				noticeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "各种类型通知更新失败";
			}
		} else {
			message = "各种类型通知添加成功";
			noticeService.save(notice);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 各种类型通知列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(NoticeEntity notice, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(notice.getId())) {
			notice = noticeService.findEntity(NoticeEntity.class, notice.getId());
			req.setAttribute("noticePage", notice);
		}
		return new ModelAndView("com/inspection/notice/notice");
	}
	
	
	@RequestMapping(params = "addorupdateMany")
	public ModelAndView addorupdateMany(NoticeEntity notice, HttpServletRequest req) {
		return new ModelAndView("com/inspection/test/list");
	} 
	
	@RequestMapping(params = "addorupdateTabs")
	public ModelAndView addorupdateTabs(NoticeEntity notice, HttpServletRequest req) {
		return new ModelAndView("com/inspection/test/tabs");
	}
}
