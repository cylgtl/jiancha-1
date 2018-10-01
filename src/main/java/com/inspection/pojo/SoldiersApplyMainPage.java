package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.soldiersApply.SoldiersApplyAssessmentEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyAuditEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyPerformanceEntity;
import com.inspection.entity.soldiersApply.SoldiersApplyRecommendEntity;

public class SoldiersApplyMainPage {
	
	private SoldiersApplyEntity soldiersApply;
	
	private List<SoldiersApplyAuditEntity> results = new ArrayList<SoldiersApplyAuditEntity>();

	private List<SoldiersApplyPerformanceEntity> performances = new ArrayList<SoldiersApplyPerformanceEntity>();
	
	private List<SoldiersApplyRecommendEntity> recommends = new ArrayList<SoldiersApplyRecommendEntity>();
	
	private List<SoldiersApplyAssessmentEntity> assessments = new ArrayList<SoldiersApplyAssessmentEntity>();

	public List<SoldiersApplyAuditEntity> getResults() {
		return results;
	}

	public void setResults(List<SoldiersApplyAuditEntity> results) {
		this.results = results;
	}

	public List<SoldiersApplyPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<SoldiersApplyPerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<SoldiersApplyRecommendEntity> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<SoldiersApplyRecommendEntity> recommends) {
		this.recommends = recommends;
	}

	public SoldiersApplyEntity getSoldiersApply() {
		return soldiersApply;
	}

	public void setSoldiersApply(SoldiersApplyEntity soldiersApply) {
		this.soldiersApply = soldiersApply;
	}

	public List<SoldiersApplyAssessmentEntity> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<SoldiersApplyAssessmentEntity> assessments) {
		this.assessments = assessments;
	}

}
