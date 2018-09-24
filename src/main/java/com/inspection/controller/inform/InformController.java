package com.inspection.controller.inform;
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
import org.jeecgframework.web.system.entity.TSTypegroup;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.utils.SessionUtils;
import org.jeecgframework.web.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inspection.entity.inform.InformEntity;
import com.inspection.service.inform.InformServiceI;

/**   
 * @Title: Controller
 * @Description: 通知
 * @author zhangdaihao
 * @date 2018-07-06 23:29:52
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/informController")
public class InformController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(InformController.class);

	@Autowired
	private InformServiceI informService;
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
	 * 通知列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "inform")
	public ModelAndView inform(HttpServletRequest request) {
		return new ModelAndView("com/inspection/inform/informList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param inform
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(InformEntity inform,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(InformEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, inform, request.getParameterMap());
		this.informService.findDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通知
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(InformEntity inform, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		inform = systemService.findEntity(InformEntity.class, inform.getId());
		message = "通知删除成功";
		informService.delete(inform);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加通知
	 * 
	 * @param inform
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(InformEntity inform, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
//		inform.setUrl("com/inspection/inform/inform");//用于跳转到分类菜单的录入页面
		if("".equals(inform.getType())){
			
		}
		switch (inform.getType()) {
		case "士兵考学":
			inform.setUrl("soldiersApplyController.do?addorupdate");
			break;
		case "干部调整配备":
			inform.setUrl("adjustController.do?addorupdate");
			break;
		case "士官选取":
			inform.setUrl("soldierSelectController.do?addorupdate");
			break;
		case "大学毕业生士兵提干":
			inform.setUrl("soldierStudentController.do?addorupdate");
			break;
		case "表彰奖励":
			inform.setUrl("commendRewardController.do?addorupdate");
			break;
		case "优秀士兵保送入学":
			inform.setUrl("soldierSchoolController.do?addorupdate");
			break;
		case "骨干配备":
			inform.setUrl("backboneController.do?addorupdate");
			break;
		case "官兵评残":
			inform.setUrl("evaluationResidualController.do?addorupdate");
			break;
		case "技术学兵选调":
			inform.setUrl("personnelSelectionController.do?addorupdate");
			break;
		case "党员发展":
			inform.setUrl("partyMemberController.do?addorupdate");
			break;
		default:
			break;
		}
		if (StringUtils.isNotEmpty(inform.getId())) {
			message = "通知更新成功";
			InformEntity t = informService.find(InformEntity.class, inform.getId());
			try {
                BeanPropertyUtils.copyBeanNotNull2Bean(inform, t);
				informService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "通知更新失败";
			}
		} else {
			message = "通知添加成功";
			informService.save(inform);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 通知列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(InformEntity inform, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(inform.getId())) {
			inform = informService.findEntity(InformEntity.class, inform.getId());
		}
		String dict = "informtype";
		if(inform != null){
			req.setAttribute("informPage", inform);
		}
		//管理员
		boolean isAdmin = SessionUtils.isAdminRole("admin");
		//人力资源科
		boolean isRlzy = SessionUtils.isAdminRole("rlzy");
		//组织科
		boolean isZzk = SessionUtils.isAdminRole("zzk");
		//卫生科
		boolean isWsk = SessionUtils.isAdminRole("wsk");
		if(isAdmin){
			dict = "informtype";
		}else if(isRlzy){
			dict = "hr_inform";
		}else if(isZzk){
			dict = "zz_inform";
		}else if(isWsk){
			dict = "ws_inform";
		}
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode",dict);
		if(typegroup != null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		return new ModelAndView("com/inspection/inform/inform");
	}
	
	/**
	 * 通知列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdateView")
	public ModelAndView addorupdateView(InformEntity inform, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(inform.getId())) {
			inform = informService.findEntity(InformEntity.class, inform.getId());
		}
		if(inform != null){
			req.setAttribute("informPage", inform);
		}
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode","informtype");
		if(typegroup != null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		return new ModelAndView("com/inspection/inform/informView");
	}
	
	/**
	 * 通知列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdateEdit")
	public ModelAndView addorupdateEdit(InformEntity inform, HttpServletRequest req) {
		if (StringUtils.isNotEmpty(inform.getId())) {
			inform = informService.findEntity(InformEntity.class, inform.getId());
		}
		String dict = "informtype";
		if(inform != null){
			req.setAttribute("informPage", inform);
		}
		//管理员
		boolean isAdmin = SessionUtils.isAdminRole("admin");
		//人力资源科
		boolean isRlzy = SessionUtils.isAdminRole("rlzy");
		//组织科
		boolean isZzk = SessionUtils.isAdminRole("zzk");
		//卫生科
		boolean isWsk = SessionUtils.isAdminRole("wsk");
		if(isAdmin){
			dict = "informtype";
		}else if(isRlzy){
			dict = "hr_inform";
		}else if(isZzk){
			dict = "zz_inform";
		}else if(isWsk){
			dict = "ws_inform";
		}
		TSTypegroup typegroup=systemService.findUniqueByProperty(TSTypegroup.class,"typegroupcode",dict);
		if(typegroup != null){
			req.setAttribute("typeList", typegroup.getTSTypes());
		}
		return new ModelAndView("com/inspection/inform/inform");
	}
}
