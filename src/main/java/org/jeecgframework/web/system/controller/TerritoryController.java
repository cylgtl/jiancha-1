package org.jeecgframework.web.system.controller;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.ComboTree;
import org.jeecgframework.core.common.model.json.TreeGrid;
import org.jeecgframework.core.tag.vo.datatable.SortDirection;
import org.jeecgframework.core.tag.vo.easyui.ComboTreeModel;
import org.jeecgframework.core.tag.vo.easyui.TreeGridModel;
import org.jeecgframework.platform.constant.Globals;
import org.jeecgframework.platform.util.MutiLangUtils;
import org.jeecgframework.web.system.entity.TSTerritory;
import org.jeecgframework.web.system.service.MutiLangService;
import org.jeecgframework.web.system.service.ResourceService;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * 地域处理类
 * @author wushu
 */
@Scope("prototype")
@Controller
@RequestMapping("/territoryController")
public class TerritoryController extends BaseController {
	@Autowired
	private ResourceService resourceService;
	private String message = null;

    @Autowired
    private MutiLangService mutiLangService;

	@Autowired
	private SystemService systemService;

	/**
	 * 地域列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "territory")
	public ModelAndView function() {
		return new ModelAndView("system/territory/territoryList");
	}

	
	/**
	 * 地域列表
	 */
	@RequestMapping(params = "territoryGrid")
	@ResponseBody
	public List<TreeGrid> territoryGrid(HttpServletRequest request, TreeGrid treegrid) {
		CriteriaQuery cq = new CriteriaQuery(TSTerritory.class);
			if (treegrid.getId() != null) {
				cq.eq("TSTerritory.id", treegrid.getId());
			}
			if (treegrid.getId() == null) {
				cq.eq("TSTerritory.id","0");//这个是全国最高级
			}
		
		cq.addOrder("territorySort", SortDirection.asc);
		cq.add();
		List<TSTerritory> territoryList = systemService.findListByCq(cq, false);
		List<TreeGrid> treeGrids = new ArrayList<TreeGrid>();
		TreeGridModel treeGridModel = new TreeGridModel();
		treeGridModel.setIcon("");
		treeGridModel.setTextField("territoryName");
		treeGridModel.setParentText("TSTerritory_territoryName");
		treeGridModel.setParentId("TSTerritory_id");
		treeGridModel.setSrc("territoryCode");
		treeGridModel.setIdField("id");
		treeGridModel.setChildList("TSTerritorys");
		treeGridModel.setOrder("territorySort");
		treeGrids = resourceService.treegrid(territoryList, treeGridModel);
		return treeGrids;
	}
	/**
	 *地域列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSTerritory territory, HttpServletRequest req) {
		String functionid = req.getParameter("id");
		if (functionid != null) {
			territory = systemService.findEntity(TSTerritory.class, functionid);
			req.setAttribute("territory", territory);
		}
		if(territory.getTSTerritory()!=null && territory.getTSTerritory().getId()!=null){
			territory.setTSTerritory((TSTerritory)systemService.findEntity(TSTerritory.class, territory.getTSTerritory().getId()));
			req.setAttribute("territory", territory);
		}
		return new ModelAndView("system/territory/territory");
	}
	/**
	 * 地域父级下拉菜单
	 */
	@RequestMapping(params = "setPTerritory")
	@ResponseBody
	public List<ComboTree> setPTerritory(HttpServletRequest request, ComboTree comboTree) {
		CriteriaQuery cq = new CriteriaQuery(TSTerritory.class);
		if (comboTree.getId() != null) {
			cq.eq("TSTerritory.id", comboTree.getId());
		}
		if (comboTree.getId() == null) {
			cq.isNull("TSTerritory");
		}
		cq.add();
		List<TSTerritory> territoryList = systemService.findListByCq(cq, false);
		ComboTreeModel comboTreeModel = new ComboTreeModel("id", "territoryName", "TSTerritorys");
		List<ComboTree> comboTrees  = resourceService.ComboTree(territoryList, comboTreeModel, null, false);
		return comboTrees;
	}
	/**
	 * 地域保存
	 */
	@RequestMapping(params = "saveTerritory")
	@ResponseBody
	public AjaxJson saveTerritory(TSTerritory territory, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String functionOrder = territory.getTerritorySort();
		if(StringUtils.isEmpty(functionOrder)){
			territory.setTerritorySort("0");
		}
		if (territory.getTSTerritory().getId().equals("")) {
			territory.setTSTerritory(null);
		}else{
			TSTerritory parent = systemService.findEntity(TSTerritory.class, territory.getTSTerritory().getId());
			territory.setTerritoryLevel(Short.valueOf(parent.getTerritoryLevel()+1+""));
		}
		if (!StringUtils.isEmpty(territory.getId())) {
			message = "地域: " + territory.getTerritoryName() + "被更新成功";
			systemService.saveOrUpdate(territory);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);

            message = MutiLangUtils.paramUpdSuccess("common.area");
		} else {
			territory.setTerritorySort(territory.getTerritorySort());
			message = "地域: " + territory.getTerritoryName() + "被添加成功";
			systemService.save(territory);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);

            message = MutiLangUtils.paramAddSuccess("common.area");
        }

        j.setMsg(message);
		
		return j;
	}

	/**
	 * 地域删除
	 * 
	 * @param territory
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSTerritory territory, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		territory = systemService.findEntity(TSTerritory.class, territory.getId());
		message = "地域: " + territory.getTerritoryName() + "被删除成功";
		systemService.delete(territory);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

        message = MutiLangUtils.paramDelSuccess("common.area");
        j.setMsg(message);
		return j;
	}

}
