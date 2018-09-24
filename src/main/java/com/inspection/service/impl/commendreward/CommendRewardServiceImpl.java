package com.inspection.service.impl.commendreward;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.commendreward.CommendRewardAuditEntity;
import com.inspection.entity.commendreward.CommendRewardPerformanceEntity;
import com.inspection.entity.commendreward.CommendRewardRecommendEntity;
import com.inspection.service.commendreward.CommendRewardServiceI;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("commendRewardService")
@Transactional
public class CommendRewardServiceImpl extends CommonServiceImpl implements CommendRewardServiceI {

	@Override
	public List<CommendRewardPerformanceEntity> findAllPerformances(String id) {
		String query = "from CommendRewardPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<CommendRewardPerformanceEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<CommendRewardAuditEntity> findAllAudits(String id) {
		String query = "from CommendRewardAuditEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<CommendRewardAuditEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<CommendRewardRecommendEntity> findAllRecommends(String id) {
		String query = "from CommendRewardRecommendEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<CommendRewardRecommendEntity> lists =queryObject.list();	
		return lists;
	}
	
}