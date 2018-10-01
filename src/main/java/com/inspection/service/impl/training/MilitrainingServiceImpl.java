package com.inspection.service.impl.training;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.training.MilitrainingServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("militrainingService")
@Transactional
public class MilitrainingServiceImpl extends CommonServiceImpl implements MilitrainingServiceI {
	
}