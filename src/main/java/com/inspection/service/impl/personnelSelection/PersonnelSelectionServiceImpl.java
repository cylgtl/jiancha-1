package com.inspection.service.impl.personnelSelection;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.personnelSelection.PersonnelSelectionAssessmentEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionAuditEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionPerformanceEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionRecommendEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionReportEntity;
import com.inspection.service.personnelSelection.PersonnelSelectionServiceI;

@Service("personnelSelectionService")
@Transactional
public class PersonnelSelectionServiceImpl extends CommonServiceImpl implements PersonnelSelectionServiceI {
	
	@Override
	public List<PersonnelSelectionAuditEntity> findAllAudits(String id) {
		String query = "from PersonnelSelectionAuditEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PersonnelSelectionAuditEntity> lists =queryObject.list();	
		return lists;
	}
	
	@Override
	public List<PersonnelSelectionPerformanceEntity> findAllPerformances(String id) {
		String query = "from PersonnelSelectionPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PersonnelSelectionPerformanceEntity> lists =queryObject.list();	
		return lists;
	}
	
	@Override
	public List<PersonnelSelectionRecommendEntity> findAllRecommends(String id) {
		String query = "from PersonnelSelectionRecommendEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PersonnelSelectionRecommendEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<PersonnelSelectionAssessmentEntity> findAllAssessments(String id) {
		String query = "from PersonnelSelectionAssessmentEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PersonnelSelectionAssessmentEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<PersonnelSelectionReportEntity> findAllReports(String id) {
		String query = "from PersonnelSelectionReportEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PersonnelSelectionReportEntity> lists =queryObject.list();	
		return lists;
	}
	
}