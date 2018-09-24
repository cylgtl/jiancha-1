package com.inspection.service.impl.soldiersApply;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.soldiersApply.SoldiersApplyAssessmentEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyAuditEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyPerformanceEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyRecommendEntity;
import com.inspection.service.soldiersApply.SoldiersApplyServiceI;

@Service("soldiersApplyService")
@Transactional
@SuppressWarnings("unchecked")
public class SoldiersApplyServiceImpl extends CommonServiceImpl implements SoldiersApplyServiceI {
	
	@Override
	public List<SoldiersApplyAuditEntity> findAllAudits(String id) {
		String query = "from SoldiersApplyAuditEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldiersApplyAuditEntity> lists =queryObject.list();	
		return lists;
	}
	
	@Override
	public List<SoldiersApplyPerformanceEntity> findAllPerformances(String id) {
		String query = "from SoldiersApplyPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldiersApplyPerformanceEntity> lists =queryObject.list();	
		return lists;
	}
	
	@Override
	public List<SoldiersApplyRecommendEntity> findAllRecommends(String id) {
		String query = "from SoldiersApplyRecommendEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldiersApplyRecommendEntity> lists =queryObject.list();	
		return lists;
	}
	
	@Override
	public List<SoldiersApplyAssessmentEntity> findAllAssessments(String id) {
		String query = "from SoldiersApplyAssessmentEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<SoldiersApplyAssessmentEntity> lists =queryObject.list();	
		return lists;
	}
	
}