package com.inspection.service.officerleave;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.inspection.entity.officerleave.OfficerAuditingEntity;
import com.inspection.entity.officerleave.OfficerPerformanceEntity;


public interface OfficerLeaveServiceI extends CommonService{
	
    /**
     * 获取个人平时表现列表
     * @param officerId
     * @return
     */
	List<OfficerPerformanceEntity> findAllPerformances(String officerId);
	
	/**
     * 获取上级意见结果列表
     * @param officerId
     * @return
     */
    List<OfficerAuditingEntity> findAllAudits(String officerId);

}
