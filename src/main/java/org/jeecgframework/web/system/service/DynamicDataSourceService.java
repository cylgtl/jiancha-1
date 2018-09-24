package org.jeecgframework.web.system.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.entity.DynamicDataSourceEntity;

public interface DynamicDataSourceService extends CommonService{
	
	public List<DynamicDataSourceEntity> initDynamicDataSource();
	
	public void refleshCache();
}
