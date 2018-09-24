package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.personnelSelection.PersonnelSelectionAssessmentEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionAuditEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionPerformanceEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionRecommendEntity;
import com.inspection.entity.personnelSelection.PersonnelSelectionReportEntity;

public class PersonnelSelectionMainPage {
	
	private PersonnelSelectionEntity personnelSelection;
	
	private List<PersonnelSelectionAuditEntity> results = new ArrayList<PersonnelSelectionAuditEntity>();

	private List<PersonnelSelectionPerformanceEntity> performances = new ArrayList<PersonnelSelectionPerformanceEntity>();
	
	private List<PersonnelSelectionRecommendEntity> recommends = new ArrayList<PersonnelSelectionRecommendEntity>();
	
	private List<PersonnelSelectionAssessmentEntity> assessments = new ArrayList<PersonnelSelectionAssessmentEntity>();
	
	private List<PersonnelSelectionReportEntity> reports = new ArrayList<PersonnelSelectionReportEntity>();

	public List<PersonnelSelectionAuditEntity> getResults() {
		return results;
	}

	public void setResults(List<PersonnelSelectionAuditEntity> results) {
		this.results = results;
	}

	public List<PersonnelSelectionPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<PersonnelSelectionPerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<PersonnelSelectionRecommendEntity> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<PersonnelSelectionRecommendEntity> recommends) {
		this.recommends = recommends;
	}

	public PersonnelSelectionEntity getPersonnelSelection() {
		return personnelSelection;
	}

	public void setPersonnelSelection(PersonnelSelectionEntity personnelSelection) {
		this.personnelSelection = personnelSelection;
	}

	public List<PersonnelSelectionAssessmentEntity> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<PersonnelSelectionAssessmentEntity> assessments) {
		this.assessments = assessments;
	}

	public List<PersonnelSelectionReportEntity> getReports() {
		return reports;
	}

	public void setReports(List<PersonnelSelectionReportEntity> reports) {
		this.reports = reports;
	}


}
