package com.inspection.service.impl.soldierstudent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.soldierselect.SoldierSelectAssessmentEntity;
import com.inspection.entity.soldierstudent.SoldierStudentAssessmentEntity;
import com.inspection.entity.soldierstudent.SoldierStudentAuditingEntity;
import com.inspection.entity.soldierstudent.SoldierStudentMeritEntity;
import com.inspection.entity.soldierstudent.SoldierStudentPerformanceEntity;
import com.inspection.entity.soldierstudent.SoldierStudentRecommendEntity;
import com.inspection.service.soldierstudent.SoldierStudentServiceI;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("soldierStudentService")
@Transactional
public class SoldierStudentServiceImpl extends CommonServiceImpl implements SoldierStudentServiceI {

	@Override
	public List<SoldierStudentAssessmentEntity> findAlltAssessments(String id) {
		String query = "from SoldierStudentAssessmentEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierStudentAssessmentEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<SoldierStudentRecommendEntity> findAllRecommends(String id) {
		String query = "from SoldierStudentRecommendEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierStudentRecommendEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<SoldierStudentPerformanceEntity> findAllPerformances(String id) {
		String query = "from SoldierStudentPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierStudentPerformanceEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<SoldierStudentAuditingEntity> findAllAudits(String id) {
		String query = "from SoldierStudentAuditingEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierStudentAuditingEntity> lists =queryObject.list();	
		return lists;
	}
	
	@Override
	public List<SoldierStudentMeritEntity> findAllMerits(String id) {
		String query = "from SoldierStudentMeritEntity t where t.studentId = :studentId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("studentId",id);
		List<SoldierStudentMeritEntity> lists =queryObject.list();	
		return lists;
	}
	
}