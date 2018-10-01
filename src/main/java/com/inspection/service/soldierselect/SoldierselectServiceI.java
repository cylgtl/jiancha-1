package com.inspection.service.soldierselect;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.inspection.entity.cadresadjust.AdjustRecommendEntity;
import com.inspection.entity.soldierselect.SoldierSelectAssessmentEntity;
import com.inspection.entity.soldierselect.SoldierSelectAuditingEntity;
import com.inspection.entity.soldierselect.SoldierSelectPerformanceEntity;
import com.inspection.entity.soldierselect.SoldierSelectRecommendEntity;

public interface SoldierselectServiceI extends CommonService{

	List<SoldierSelectAssessmentEntity> findAlltAssessments(String id);

	List<SoldierSelectRecommendEntity> findAllRecommends(String id);

	List<SoldierSelectAuditingEntity> findAllAudits(String id);

	List<SoldierSelectPerformanceEntity> findAllPerformances(String id);

	

}
