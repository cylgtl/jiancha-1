package com.inspection.service.impl.staplefood;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.staplefood.StapleFoodServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("stapleFoodService")
@Transactional
public class StapleFoodServiceImpl extends CommonServiceImpl implements StapleFoodServiceI {
	
}