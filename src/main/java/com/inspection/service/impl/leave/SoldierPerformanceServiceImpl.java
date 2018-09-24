package com.inspection.service.impl.leave;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.leave.SoldierPerformanceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("soldierPerformanceService")
@Transactional
public class SoldierPerformanceServiceImpl extends CommonServiceImpl implements SoldierPerformanceServiceI {
	
}