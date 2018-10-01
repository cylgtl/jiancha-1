package com.inspection.service.impl.inform;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.inform.InformServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("informService")
@Transactional
public class InformServiceImpl extends CommonServiceImpl implements InformServiceI {
	
}