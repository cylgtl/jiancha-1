package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.soldierselect.SoldierSelectAssessmentEntity;
import com.inspection.entity.soldierselect.SoldierSelectAuditingEntity;
import com.inspection.entity.soldierselect.SoldierSelectPerformanceEntity;
import com.inspection.entity.soldierselect.SoldierSelectRecommendEntity;



public class SoldierSelectMainPage {
	
	private List<SoldierSelectAuditingEntity> results = new ArrayList<SoldierSelectAuditingEntity>();

	private List<SoldierSelectPerformanceEntity> performances = new ArrayList<SoldierSelectPerformanceEntity>();
	
	private List<SoldierSelectRecommendEntity> recommends = new ArrayList<SoldierSelectRecommendEntity>();

	private List<SoldierSelectAssessmentEntity> assessments = new ArrayList<SoldierSelectAssessmentEntity>();

	public List<SoldierSelectAuditingEntity> getResults() {
		return results;
	}

	public void setResults(List<SoldierSelectAuditingEntity> results) {
		this.results = results;
	}

	public List<SoldierSelectPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<SoldierSelectPerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<SoldierSelectRecommendEntity> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<SoldierSelectRecommendEntity> recommends) {
		this.recommends = recommends;
	}

	public List<SoldierSelectAssessmentEntity> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<SoldierSelectAssessmentEntity> assessments) {
		this.assessments = assessments;
	}


	
}
