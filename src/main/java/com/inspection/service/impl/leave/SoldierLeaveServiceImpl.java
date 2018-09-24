package com.inspection.service.impl.leave;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.leave.SoldierLeaveServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("soldierLeaveService")
@Transactional
public class SoldierLeaveServiceImpl extends CommonServiceImpl implements SoldierLeaveServiceI {
	
}