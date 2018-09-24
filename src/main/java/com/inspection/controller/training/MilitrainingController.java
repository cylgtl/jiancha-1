package com.inspection.controller.training;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.BeanPropertyUtils;
import org.jeecgframework.core.util.ConvertUtils;
import org.jeecgframework.platform.common.tag.easyui.TagUtil;
import org.jeecgframework.platform.constant.Globals;
import org.jeecgframework.platform.util.MutiLangUtils;
import org.jeecgframework.web.common.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.web.system.controller.BaseController;
import org.jeecgframework.web.system.entity.TSIcon;
import org.jeecgframework.web.system.entity.TSTypegroup;
import org.jeecgframework.web.system.entity.TSUploadFile;
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.service.ResourceService;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.utils.DateUtils;
import org.jeecgframework.web.utils.ResourceUtils;
import org.jeecgframework.web.utils.SessionUtils;
import org.jeecgframework.web.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inspection.entity.training.MilitrainingEntity;
import com.inspection.service.training.MilitrainingServiceI;

/**   
 * @Title: Controller
 * @Description: 军训考核
 * @author zhangdaihao
 * @date 2018-06-27 22:35:06
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/militrainingController")
public class MilitrainingController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MilitrainingController.class);

	@Autowired
	private MilitrainingServiceI militrainingService;
	
	@Autowired
	private ResourceService resourceService;
	
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
	 * 军训考核列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "militraining")
	public ModelAndView militraining(HttpServletRequest request) {
		return new ModelAndView("com/inspection/training/militrainingList");
	}
	
	@RequestMapping(params = "militrainingList")
	public ModelAndView militrainingList(HttpServletRequest request) {
		return new ModelAndView("com/inspection/training/showMilitrainingList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param militraining
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(MilitrainingEntity militraining,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MilitrainingEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, militraining, request.getParameterMap());
		this.militrainingService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除军训考核
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(MilitrainingEntity militraining, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		militraining = systemService.findEntity(MilitrainingEntity.class, militraining.getId());
		message = "军训考核删除成功";
		militrainingService.delete(militraining);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加军训考核
	 * 
	 * @param militraining
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(MilitrainingEntity militraining, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		TSUser user = SessionUtils.getCurrentUser();
		
		if (StringUtils.isNotEmpty(militraining.getId())) {
			message = "军训考核更新成功";
			MilitrainingEntity t = militrainingService.find(MilitrainingEntity.class, militraining.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(militraining, t);
                t.setUpdateTime(new Date());
                t.setUpdateUserId(user.getId());
				militrainingService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "军训考核更新失败";
			}
		} else {
			message = "军训考核添加成功";
			String departs = SessionUtils.getCurrentDepartsCode();
			String  publicUrl=ResourceUtils.getResourcePublicURL();
			//String[] fileName = militraining.getFileId().split("/");
			militraining.setFileId(publicUrl  + militraining.getFileId());
			militraining.setDepartId(departs);
			militraining.setCreateUserId(user.getId());
			militraining.setCreateTime(new Date());
			militrainingService.save(militraining);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 军训考核列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(MilitrainingEntity militraining, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(militraining.getId())) {
			militraining = militrainingService.findEntity(MilitrainingEntity.class, militraining.getId());
			req.setAttribute("militrainingPage", militraining);
		}
		
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","traintype");
		req.setAttribute("typeList", typegroup.getTSTypes());
		return new ModelAndView("com/inspection/training/militraining");
	}
	
	
	  /**
     * 保存文件
     *
     * @param attachment
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "saveFiles", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson saveFiles(HttpServletRequest request,TSUploadFile attachment) {
        AjaxJson j = new AjaxJson();
        String fileKey = ConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
        String documentTitle = ConvertUtils.getString(request.getParameter("documentTitle"));// 文件标题

        Boolean  multi=ConvertUtils.getBoolean(request.getParameter("multi"));
        String  sessionKey=request.getParameter("sessionKey");

        if(!multi){
            List<TSUploadFile> attachments=this.systemService.findAllByProperty(TSUploadFile.class,"sessionKey",sessionKey);
            if(attachments.size()>0){
                Map<String, Object> attributes= buildAttributes(attachments.get(0));
                j.setAttributes(attributes);
                j.setMsg("你只能上传一个附件");
                j.setSuccess(false);
                return  j;
            }
        }

        if (StringUtils.isNotEmpty(fileKey)) {
            attachment.setId(fileKey);
            //attachment = systemService.findEntity(TSUploadFile.class, fileKey);
            //attachment.setName(documentTitle);
        }
        attachment.setSessionKey(sessionKey);
//		attachment.setSubclassname(MyClassLoader.getPackPath(attachment));
        attachment.setCreatedate(DateUtils.getTimestamp());
        UploadFile uploadFile = new UploadFile(request, attachment);
        String fileType=request.getParameter("fileType");
        if(StringUtils.isEmpty(fileType)){
            fileType="files";
        }
        uploadFile.setCusPath(fileType);
        
        attachment = resourceService.uploadFile(uploadFile);
        j.setMsg("文件添加成功");
        Map<String, Object> attributes= buildAttributes(attachment);
        j.setAttributes(attributes);
        return j;
    }


    /**
     * 封装map
     * 该map的值不能随便改动
     * @param attachment
     * @return
     */
    private Map<String, Object> buildAttributes(TSUploadFile attachment) {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("fileKey", attachment.getId());
        attributes.put("url", attachment.getPath());
        attributes.put("name", attachment.getName());
        attributes.put("viewhref", "resourceController.do?viewFile&fileKey=" + attachment.getId());
        attributes.put("delurl", "resourceController.do?deleteFile&fileKey=" + attachment.getId());
        return attributes;
    }
}
