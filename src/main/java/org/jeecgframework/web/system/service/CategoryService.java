package org.jeecgframework.web.system.service;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.entity.TSCategoryEntity;

public interface CategoryService extends CommonService{
	/**
	 * 保存分类管理
	 * @param category
	 */
	void saveCategory(TSCategoryEntity category);
}
