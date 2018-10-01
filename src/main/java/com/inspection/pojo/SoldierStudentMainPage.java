package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.soldierstudent.SoldierStudentAssessmentEntity;
import com.inspection.entity.soldierstudent.SoldierStudentAuditingEntity;
import com.inspection.entity.soldierstudent.SoldierStudentPerformanceEntity;
import com.inspection.entity.soldierstudent.SoldierStudentRecommendEntity;


public class SoldierStudentMainPage {
	
	private List<SoldierStudentAuditingEntity> results = new ArrayList<SoldierStudentAuditingEntity>();

	private List<SoldierStudentPerformanceEntity> performances = new ArrayList<SoldierStudentPerformanceEntity>();
	
	private List<SoldierStudentRecommendEntity> recommends = new ArrayList<SoldierStudentRecommendEntity>();

	private List<SoldierStudentAssessmentEntity> assessments = new ArrayList<SoldierStudentAssessmentEntity>();
	
	

	

	public List<SoldierStudentAuditingEntity> getResults() {
		return results;
	}

	public void setResults(List<SoldierStudentAuditingEntity> results) {
		this.results = results;
	}

	public List<SoldierStudentPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<SoldierStudentPerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<SoldierStudentRecommendEntity> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<SoldierStudentRecommendEntity> recommends) {
		this.recommends = recommends;
	}

	public List<SoldierStudentAssessmentEntity> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<SoldierStudentAssessmentEntity> assessments) {
		this.assessments = assessments;
	}
	
	
	


}
