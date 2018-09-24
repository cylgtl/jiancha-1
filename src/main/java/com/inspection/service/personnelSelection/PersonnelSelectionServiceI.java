package com.inspection.service.personnelSelection;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.inspection.entity.personnelSelection.PersonnelSelectionAssessmentEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionAuditEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionPerformanceEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionRecommendEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionReportEntity;

public interface PersonnelSelectionServiceI extends CommonService{
	
	List<PersonnelSelectionAuditEntity> findAllAudits(String id);
	
	List<PersonnelSelectionPerformanceEntity> findAllPerformances(String id);
	
	List<PersonnelSelectionRecommendEntity> findAllRecommends(String id);
	
	List<PersonnelSelectionAssessmentEntity> findAllAssessments(String id);
	
	List<PersonnelSelectionReportEntity> findAllReports(String id);

}
