package com.inspection.controller.message;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.BeanPropertyUtils;
import org.jeecgframework.platform.common.tag.easyui.TagUtil;
import org.jeecgframework.platform.constant.Globals;
import org.jeecgframework.web.common.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.web.system.controller.BaseController;
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.utils.SessionUtils;
import org.jeecgframework.web.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inspection.entity.message.MessageEntity;
import com.inspection.service.message.MessageServiceI;

/**   
 * @Title: Controller
 * @Description: 廉情公示消息
 * @author zhangdaihao
 * @date 2018-06-26 22:32:09
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/messageController")
public class MessageController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MessageController.class);

	@Autowired
	private MessageServiceI messageService;
	@Autowired
	private SystemService systemService;
	private String messages;
	
	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	/**
	 * 廉情公示消息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "slMessage")
	public ModelAndView slMessage(HttpServletRequest request) {
		request.setAttribute("type", "0");
		return new ModelAndView("com/inspection/message/slMessageList");
	}
	
	
	@RequestMapping(params = "fgMessage")
	public ModelAndView fgMessage(HttpServletRequest request) {
		request.setAttribute("type", "1");
		return new ModelAndView("com/inspection/message/fgMessageList");
	}
	
	
	@RequestMapping(params = "slShowMessage")
	public ModelAndView slShowMessage(HttpServletRequest request) {
		request.setAttribute("type", "0");
		return new ModelAndView("com/inspection/message/slShowMessageList");
	}
	
	
	@RequestMapping(params = "fgShowMessage")
	public ModelAndView fgShowMessage(HttpServletRequest request) {
		request.setAttribute("type", "1");
		return new ModelAndView("com/inspection/message/fgShowMessageList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param message
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(MessageEntity message,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MessageEntity.class, dataGrid);
		//查询条件组装器
		String type = request.getParameter("type");
		cq.eq("type", Integer.valueOf(type));
		HqlGenerateUtil.installHql(cq, message, request.getParameterMap());
		this.messageService.findDataGridReturn(cq, true);
		List<MessageEntity> list = dataGrid.getResults();
		/*if(null != list && list.size() > 0){
			for(MessageEntity me:list){
				me.setContent(DelTagsUtil.delHtmlTags(me.getContent()));
			}
		}*/
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除廉情公示消息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(MessageEntity message, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = systemService.findEntity(MessageEntity.class, message.getId());
		messages = "廉情公示消息删除成功";
		messageService.delete(message);
		systemService.addLog(messages, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(messages);
		return j;
	}


	/**
	 * 添加廉情公示消息
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(MessageEntity message, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		TSUser user = SessionUtils.getCurrentUser();
		if (StringUtils.isNotEmpty(message.getId())) {
			messages = "廉情公示消息更新成功";
			MessageEntity t = messageService.find(MessageEntity.class, message.getId());
			try {
				//message.setContent(StringEscapeUtils.escapeHtml(message.getContent()));
                BeanPropertyUtils.copyBeanNotNull2Bean(message, t);
				messageService.saveOrUpdate(t);
				t.setUpdateTime(new Date());
				systemService.addLog(messages, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				messages = "廉情公示消息更新失败";
			}
		} else {
			messages = "廉情公示消息添加成功";
			//message.setContent(StringEscapeUtils.escapeHtml(message.getContent()));
			message.setStatus("E");
			message.setCreateTime(new Date());
			message.setCreateUserId(user.getId());
			messageService.save(message);
			systemService.addLog(messages, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(messages);
		return j;
	}

	/**
	 * 廉情公示消息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "slAddorupdate")
	public ModelAndView slAddorupdate(MessageEntity message, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(message.getId())) {
			message = messageService.findEntity(MessageEntity.class, message.getId());
			req.setAttribute("messagePage", message);
		}
		req.setAttribute("type", "0");
		return new ModelAndView("com/inspection/message/message");
	}
	
	
	@RequestMapping(params = "fgAddorupdate")
	public ModelAndView fgAddorupdate(MessageEntity message, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(message.getId())) {
			message = messageService.findEntity(MessageEntity.class, message.getId());
			req.setAttribute("messagePage", message);
		}
		req.setAttribute("type", "1");
		return new ModelAndView("com/inspection/message/message");
	}
	
	
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(MessageEntity message, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(message.getId())) {
			message = messageService.findEntity(MessageEntity.class, message.getId());
			req.setAttribute("messagePage", message);
		}
		return new ModelAndView("com/inspection/message/message");
	}
}
