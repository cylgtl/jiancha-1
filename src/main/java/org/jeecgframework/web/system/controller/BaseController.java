package org.jeecgframework.web.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.entity.TSRole;
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.interceptors.DateConvertEditor;
import org.jeecgframework.web.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 基础控制器，其他控制器需集成此控制器获得initBinder自动转换的功能
 * 
 * @author 张代浩
 * 
 */
@Controller
@RequestMapping("/baseController")
public class BaseController {

	/**
	 * 将前台传递过来的日期格式的字符串，自动转化为Date类型
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

	/**
	 * 验证是否为管理员
	 * 
	 * @return
	 */
	protected boolean isAdmin() {
		TSUser user = SessionUtils.getCurrentUser();
		if (user != null && CollectionUtils.isNotEmpty(user.getRoles())) {
			for (TSRole role : user.getRoles()) {
				if (Objects.equals(role.getRoleCode(), "admin")) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 分页公共方法(非easyui)
	 * 
	 * @author Alexander
	 * @date 20131022
	 */
	public List<?> pageBaseMethod(HttpServletRequest request, DetachedCriteria dc, CommonService commonService,
			int pageRow) {
		// 当前页
		// 总条数
		// 总页数

		int currentPage = 1;
		int totalRow = 0;
		int totalPage = 0;
		// 获取当前页
		String str_currentPage = request.getParameter("str_currentPage");
		currentPage = str_currentPage == null || "".equals(str_currentPage) ? 1 : Integer.parseInt(str_currentPage);
		// 获取每页的条数
		String str_pageRow = request.getParameter("str_pageRow");
		pageRow = str_pageRow == null || "".equals(str_pageRow) ? pageRow : Integer.parseInt(str_pageRow);

		// 统计的总行数
		dc.setProjection(Projections.rowCount());

		totalRow = Integer.parseInt(commonService.findByDetached(dc).get(0).toString());
		totalPage = (totalRow + pageRow - 1) / pageRow;

		currentPage = currentPage < 1 ? 1 : currentPage;
		currentPage = currentPage > totalPage ? totalPage : currentPage;
		// 清空统计函数
		dc.setProjection(null);
		List<?> list = commonService.findByDetached(dc, (currentPage - 1) * pageRow, pageRow);

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageRow", pageRow);
		request.setAttribute("totalRow", totalRow);
		request.setAttribute("totalPage", totalPage);
		return list;
	}

	/**
	 * 抽取由逗号分隔的主键列表
	 *
	 * @param ids
	 *            由逗号分隔的多个主键值
	 * @return 主键类表
	 * @author 张国明 2014-8-21 21:57:16
	 */
	protected List<String> extractIdListByComma(String ids) {
		List<String> result = new ArrayList<String>();
		if (StringUtils.hasText(ids)) {
			for (String id : ids.split(",")) {
				if (StringUtils.hasLength(id)) {
					result.add(id.trim());
				}
			}
		}

		return result;
	}

}