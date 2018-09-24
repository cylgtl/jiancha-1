package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.soldierschool.SoldierSchoolAssessmentEntity;
import com.inspection.entity.soldierschool.SoldierSchoolAuditingEntity;
import com.inspection.entity.soldierschool.SoldierSchoolPerformanceEntity;
import com.inspection.entity.soldierschool.SoldierSchoolRecommendEntity;


public class SoldierSchoolMainPage {
	
	private List<SoldierSchoolAuditingEntity> results = new ArrayList<SoldierSchoolAuditingEntity>();

	private List<SoldierSchoolPerformanceEntity> performances = new ArrayList<SoldierSchoolPerformanceEntity>();
	
	private List<SoldierSchoolRecommendEntity> recommends = new ArrayList<SoldierSchoolRecommendEntity>();

	private List<SoldierSchoolAssessmentEntity> assessments = new ArrayList<SoldierSchoolAssessmentEntity>();
	
	

	

	public List<SoldierSchoolAuditingEntity> getResults() {
		return results;
	}

	public void setResults(List<SoldierSchoolAuditingEntity> results) {
		this.results = results;
	}

	public List<SoldierSchoolPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<SoldierSchoolPerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<SoldierSchoolRecommendEntity> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<SoldierSchoolRecommendEntity> recommends) {
		this.recommends = recommends;
	}

	public List<SoldierSchoolAssessmentEntity> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<SoldierSchoolAssessmentEntity> assessments) {
		this.assessments = assessments;
	}
	
	
	


}
