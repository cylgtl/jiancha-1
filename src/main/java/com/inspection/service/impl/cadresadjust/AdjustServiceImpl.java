package com.inspection.service.impl.cadresadjust;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.cadresadjust.AdjustAssessmentEntity;
import com.inspection.entity.cadresadjust.AdjustAuditingEntity;
import com.inspection.entity.cadresadjust.AdjustPerformanceEntity;
import com.inspection.entity.cadresadjust.AdjustRecommendEntity;
import com.inspection.entity.commendreward.CommendRewardAuditEntity;
import com.inspection.entity.commendreward.CommendRewardPerformanceEntity;
import com.inspection.entity.commendreward.CommendRewardRecommendEntity;
import com.inspection.service.cadresadjust.AdjustServiceI;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("adjustService")
@Transactional
public class AdjustServiceImpl extends CommonServiceImpl implements AdjustServiceI {

	@Override
	public List<AdjustPerformanceEntity> findAllPerformances(String id) {
		String query = "from AdjustPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<AdjustPerformanceEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<AdjustAuditingEntity> findAllAudits(String id) {
		String query = "from AdjustAuditingEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<AdjustAuditingEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<AdjustRecommendEntity> findAllRecommends(String id) {
		String query = "from AdjustRecommendEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<AdjustRecommendEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<AdjustAssessmentEntity> findAlltAssessments(String id) {
		String query = "from AdjustAssessmentEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<AdjustAssessmentEntity> lists =queryObject.list();	
		return lists;
	}
	
}