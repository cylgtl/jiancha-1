package com.inspection.service.impl.notice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.notice.NoticeServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("noticeService")
@Transactional
public class NoticeServiceImpl extends CommonServiceImpl implements NoticeServiceI {
	
}