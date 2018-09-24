package com.inspection.service.impl.message;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.message.MessageServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("messageService")
@Transactional
public class MessageServiceImpl extends CommonServiceImpl implements MessageServiceI {
	
}