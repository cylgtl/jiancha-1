package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.cadresadjust.AdjustAssessmentEntity;
import com.inspection.entity.cadresadjust.AdjustAuditingEntity;
import com.inspection.entity.cadresadjust.AdjustEntity;
import com.inspection.entity.cadresadjust.AdjustPerformanceEntity;
import com.inspection.entity.cadresadjust.AdjustRecommendEntity;

public class AdjustMainPage {
	
	private AdjustEntity adjust;
	
	private List<AdjustAuditingEntity> results = new ArrayList<AdjustAuditingEntity>();

	private List<AdjustPerformanceEntity> performances = new ArrayList<AdjustPerformanceEntity>();
	
	private List<AdjustRecommendEntity> recommends = new ArrayList<AdjustRecommendEntity>();

	private List<AdjustAssessmentEntity> assessments = new ArrayList<AdjustAssessmentEntity>();

	public List<AdjustAuditingEntity> getResults() {
		return results;
	}

	public void setResults(List<AdjustAuditingEntity> results) {
		this.results = results;
	}

	public List<AdjustPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<AdjustPerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<AdjustRecommendEntity> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<AdjustRecommendEntity> recommends) {
		this.recommends = recommends;
	}

	public List<AdjustAssessmentEntity> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<AdjustAssessmentEntity> assessments) {
		this.assessments = assessments;
	}

	public AdjustEntity getAdjust() {
		return adjust;
	}

	public void setAdjust(AdjustEntity adjust) {
		this.adjust = adjust;
	}

	

	


}
