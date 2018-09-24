package com.inspection.service.evaluation;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.inspection.entity.evaluation.EvaluationResidualAuditingEntity;
import com.inspection.entity.evaluation.EvaluationResidualPerformanceEntity;
import com.inspection.entity.evaluation.EvaluationResidualProveEntity;

public interface EvaluationResidualServiceI extends CommonService{

	List<EvaluationResidualAuditingEntity> findAllAudits(String residualId);

	List<EvaluationResidualPerformanceEntity> findAllPerformances(String residualId);

	List<EvaluationResidualProveEntity> findAllProves(String residualId);

}
