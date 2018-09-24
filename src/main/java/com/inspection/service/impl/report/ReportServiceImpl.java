package com.inspection.service.impl.report;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.report.ReportServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("reportService")
@Transactional
public class ReportServiceImpl extends CommonServiceImpl implements ReportServiceI {
	
}