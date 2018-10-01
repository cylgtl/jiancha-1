package com.inspection.service.soldierschool;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.inspection.entity.soldierschool.SoldierSchoolAssessmentEntity;
import com.inspection.entity.soldierschool.SoldierSchoolAuditingEntity;
import com.inspection.entity.soldierschool.SoldierSchoolMeritEntity;
import com.inspection.entity.soldierschool.SoldierSchoolPerformanceEntity;
import com.inspection.entity.soldierschool.SoldierSchoolRecommendEntity;


public interface SoldierSchoolServiceI extends CommonService{

	List<SoldierSchoolAssessmentEntity> findAlltAssessments(String id);

	List<SoldierSchoolRecommendEntity> findAllRecommends(String id);

	List<SoldierSchoolPerformanceEntity> findAllPerformances(String id);

	List<SoldierSchoolAuditingEntity> findAllAudits(String id);

	List<SoldierSchoolMeritEntity> findAllMerits(String id);







}
