package com.inspection.controller.file;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ConvertUtils;
import org.jeecgframework.web.system.controller.BaseController;
import org.jeecgframework.web.system.entity.TSUploadFile;
import org.jeecgframework.web.system.service.ResourceService;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.utils.DateUtils;
import org.jeecgframework.web.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @ClassName: FileController
 * @Description:文件上传公用 
 * @author  kangjie1209@126.com
 * @date 2018年7月9日 下午9:31:42
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/fileController")
public class FileController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FileController.class);

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
        
      /*  String id = ConvertUtils.getString(request.getParameter("name"));//ID参数
        if(org.apache.commons.lang3.StringUtils.isNoneEmpty(id)){
        	id = id.split("_")[0];
        	fileKey = id;
        }*/
        /*if(!multi){
            List<TSUploadFile> attachments=this.systemService.findAllByProperty(TSUploadFile.class,"sessionKey",sessionKey);
            if(attachments.size()>0){
                Map<String, Object> attributes= buildAttributes(attachments.get(0));
                j.setAttributes(attributes);
                j.setMsg("你只能上传一个附件");
                j.setSuccess(false);
                return  j;
            }
        }*/

        /*if (StringUtils.isNotEmpty(sessionKey)) {
            attachment.setId(sessionKey);
            //attachment = systemService.findEntity(TSUploadFile.class, fileKey);
            //attachment.setName(documentTitle);
        }*/
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
        attributes.put("sessionKey", attachment.getSessionKey());
        attributes.put("viewhref", "resourceController.do?viewFile&fileKey=" + attachment.getId());
        attributes.put("delurl", "resourceController.do?deleteFile&fileKey=" + attachment.getId());
        return attributes;
    }
}
