package com.inspection.service.soldiersApply;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.inspection.entity.soldiersApply.SoldiersApplyAssessmentEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyAuditEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyPerformanceEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyRecommendEntity;

public interface SoldiersApplyServiceI extends CommonService{
	
	List<SoldiersApplyAuditEntity> findAllAudits(String id);
	
	List<SoldiersApplyPerformanceEntity> findAllPerformances(String id);
	
	List<SoldiersApplyRecommendEntity> findAllRecommends(String id);

	List<SoldiersApplyAssessmentEntity> findAllAssessments(String id);

}
