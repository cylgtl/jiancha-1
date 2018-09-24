package com.inspection.service.impl.soldierselect;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.soldierselect.SoldierSelectAssessmentEntity;
import com.inspection.entity.soldierselect.SoldierSelectAuditingEntity;
import com.inspection.entity.soldierselect.SoldierSelectPerformanceEntity;
import com.inspection.entity.soldierselect.SoldierSelectRecommendEntity;
import com.inspection.service.soldierselect.SoldierselectServiceI;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("soldierselectService")
@Transactional
public class SoldierselectServiceImpl extends CommonServiceImpl implements SoldierselectServiceI {

	@Override
	public List<SoldierSelectAssessmentEntity> findAlltAssessments(String id) {
		String query = "from SoldierSelectAssessmentEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierSelectAssessmentEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<SoldierSelectRecommendEntity> findAllRecommends(String id) {
		String query = "from SoldierSelectRecommendEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierSelectRecommendEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<SoldierSelectAuditingEntity> findAllAudits(String id) {
		String query = "from SoldierSelectAuditingEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierSelectAuditingEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<SoldierSelectPerformanceEntity> findAllPerformances(String id) {
		String query = "from SoldierSelectPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldierSelectPerformanceEntity> lists =queryObject.list();	
		return lists;
	}
	
}