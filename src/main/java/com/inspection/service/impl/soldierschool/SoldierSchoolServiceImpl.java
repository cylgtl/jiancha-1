package com.inspection.service.impl.soldierschool;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.soldierschool.SoldierSchoolAssessmentEntity;
import com.inspection.entity.soldierschool.SoldierSchoolAuditingEntity;
import com.inspection.entity.soldierschool.SoldierSchoolMeritEntity;
import com.inspection.entity.soldierschool.SoldierSchoolPerformanceEntity;
import com.inspection.entity.soldierschool.SoldierSchoolRecommendEntity;
import com.inspection.entity.soldierselect.SoldierSelectAssessmentEntity;
import com.inspection.service.soldierschool.SoldierSchoolServiceI;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("soldierSchoolService")
@Transactional
public class SoldierSchoolServiceImpl extends CommonServiceImpl implements SoldierSchoolServiceI {

	@Override
	public List<SoldierSchoolAssessmentEntity> findAlltAssessments(String id) {
		String query = "from SoldierSchoolAssessmentEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierSchoolAssessmentEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<SoldierSchoolRecommendEntity> findAllRecommends(String id) {
		String query = "from SoldierSchoolRecommendEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierSchoolRecommendEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<SoldierSchoolPerformanceEntity> findAllPerformances(String id) {
		String query = "from SoldierSchoolPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierSchoolPerformanceEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<SoldierSchoolAuditingEntity> findAllAudits(String id) {
		String query = "from SoldierSchoolAuditingEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierSchoolAuditingEntity> lists =queryObject.list();	
		return lists;
	}
	
	@Override
	public List<SoldierSchoolMeritEntity> findAllMerits(String id) {
		String query = "from SoldierSchoolMeritEntity t where t.SchoolId = :SchoolId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("SchoolId",id);
		List<SoldierSchoolMeritEntity> lists =queryObject.list();	
		return lists;
	}
	
}