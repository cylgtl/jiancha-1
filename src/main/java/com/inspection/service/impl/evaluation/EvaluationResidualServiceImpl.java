package com.inspection.service.impl.evaluation;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.evaluation.EvaluationResidualAuditingEntity;
import com.inspection.entity.evaluation.EvaluationResidualPerformanceEntity;
import com.inspection.entity.evaluation.EvaluationResidualProveEntity;
import com.inspection.entity.officerleave.OfficerAuditingEntity;
import com.inspection.entity.officerleave.OfficerPerformanceEntity;
import com.inspection.service.evaluation.EvaluationResidualServiceI;

@Service("evaluationResidualService")
@Transactional
public class EvaluationResidualServiceImpl extends CommonServiceImpl implements EvaluationResidualServiceI{

	@Override
	public List<EvaluationResidualAuditingEntity> findAllAudits(String residualId) {
		String query = "from EvaluationResidualAuditingEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",residualId);
		List<EvaluationResidualAuditingEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<EvaluationResidualPerformanceEntity> findAllPerformances(String residualId) {
		String query = "from EvaluationResidualPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",residualId);
		List<EvaluationResidualPerformanceEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<EvaluationResidualProveEntity> findAllProves(String residualId) {
		String query = "from EvaluationResidualProveEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",residualId);
		List<EvaluationResidualProveEntity> lists =queryObject.list();	
		return lists;
	}

	
}
