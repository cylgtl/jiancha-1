package com.inspection.service.soldierstudent;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;
import com.inspection.entity.soldierstudent.SoldierStudentAssessmentEntity;
import com.inspection.entity.soldierstudent.SoldierStudentAuditingEntity;
import com.inspection.entity.soldierstudent.SoldierStudentMeritEntity;
import com.inspection.entity.soldierstudent.SoldierStudentPerformanceEntity;
import com.inspection.entity.soldierstudent.SoldierStudentRecommendEntity;

public interface SoldierStudentServiceI extends CommonService{

	List<SoldierStudentAssessmentEntity> findAlltAssessments(String id);

	List<SoldierStudentRecommendEntity> findAllRecommends(String id);

	List<SoldierStudentPerformanceEntity> findAllPerformances(String id);

	List<SoldierStudentAuditingEntity> findAllAudits(String id);

	List<SoldierStudentMeritEntity> findAllMerits(String id);




}
