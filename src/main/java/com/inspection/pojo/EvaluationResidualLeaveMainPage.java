package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;
import com.inspection.entity.evaluation.EvaluationResidualAuditingEntity;
import com.inspection.entity.evaluation.EvaluationResidualPerformanceEntity;
import com.inspection.entity.evaluation.EvaluationResidualProveEntity;

public class EvaluationResidualLeaveMainPage {
	private List<EvaluationResidualAuditingEntity> results = new ArrayList<EvaluationResidualAuditingEntity>();

	private List<EvaluationResidualPerformanceEntity> performances = new ArrayList<EvaluationResidualPerformanceEntity>();
	
	private List<EvaluationResidualProveEntity> proves = new ArrayList<EvaluationResidualProveEntity>();

	public List<EvaluationResidualAuditingEntity> getResults() {
		return results;
	}

	public void setResults(List<EvaluationResidualAuditingEntity> results) {
		this.results = results;
	}

	public List<EvaluationResidualPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<EvaluationResidualPerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<EvaluationResidualProveEntity> getProves() {
		return proves;
	}

	public void setProves(List<EvaluationResidualProveEntity> proves) {
		this.proves = proves;
	}
	


	
}
