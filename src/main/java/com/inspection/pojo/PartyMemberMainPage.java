package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.partyMember.PartyMemberAssessmentEntity;
import com.inspection.entity.partyMember.PartyMemberAuditEntity;
import com.inspection.entity.partyMember.PartyMemberEntity;
import com.inspection.entity.partyMember.PartyMemberPerformanceEntity;
import com.inspection.entity.partyMember.PartyMemberRecommendEntity;
import com.inspection.entity.partyMember.PartyMemberReportEntity;

public class PartyMemberMainPage {
	
	private PartyMemberEntity partyMember;
	
	private List<PartyMemberAuditEntity> audit = new ArrayList<PartyMemberAuditEntity>();
	
	private List<PartyMemberAssessmentEntity> assessments = new ArrayList<PartyMemberAssessmentEntity>();

	private List<PartyMemberPerformanceEntity> performances = new ArrayList<PartyMemberPerformanceEntity>();
	
	private List<PartyMemberRecommendEntity> recommends = new ArrayList<PartyMemberRecommendEntity>();
	
	private List<PartyMemberReportEntity> report = new ArrayList<PartyMemberReportEntity>();

	public PartyMemberEntity getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(PartyMemberEntity partyMember) {
		this.partyMember = partyMember;
	}

	public List<PartyMemberAuditEntity> getAudit() {
		return audit;
	}

	public void setAudit(List<PartyMemberAuditEntity> audit) {
		this.audit = audit;
	}

	public List<PartyMemberAssessmentEntity> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<PartyMemberAssessmentEntity> assessments) {
		this.assessments = assessments;
	}

	public List<PartyMemberPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<PartyMemberPerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<PartyMemberRecommendEntity> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<PartyMemberRecommendEntity> recommends) {
		this.recommends = recommends;
	}

	public List<PartyMemberReportEntity> getReport() {
		return report;
	}

	public void setReport(List<PartyMemberReportEntity> report) {
		this.report = report;
	}
	
}
