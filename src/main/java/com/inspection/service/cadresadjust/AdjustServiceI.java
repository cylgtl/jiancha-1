package com.inspection.service.cadresadjust;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.inspection.entity.cadresadjust.AdjustAssessmentEntity;
import com.inspection.entity.cadresadjust.AdjustAuditingEntity;
import com.inspection.entity.cadresadjust.AdjustPerformanceEntity;
import com.inspection.entity.cadresadjust.AdjustRecommendEntity;



public interface AdjustServiceI extends CommonService{
	List<AdjustPerformanceEntity> findAllPerformances(String id);

	List<AdjustAuditingEntity> findAllAudits(String id);

	List<AdjustRecommendEntity> findAllRecommends(String id);
	
	List<AdjustAssessmentEntity> findAlltAssessments(String id);
}
