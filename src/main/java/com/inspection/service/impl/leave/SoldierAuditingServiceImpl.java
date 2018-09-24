package com.inspection.service.impl.leave;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.leave.SoldierAuditingServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("soldierAuditingService")
@Transactional
public class SoldierAuditingServiceImpl extends CommonServiceImpl implements SoldierAuditingServiceI {
	
}