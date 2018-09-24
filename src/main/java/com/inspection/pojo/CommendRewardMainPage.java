package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.commendreward.CommendRewardAuditEntity;
import com.inspection.entity.commendreward.CommendRewardPerformanceEntity;
import com.inspection.entity.commendreward.CommendRewardRecommendEntity;

public class CommendRewardMainPage {
	
	private List<CommendRewardAuditEntity> results = new ArrayList<CommendRewardAuditEntity>();

	private List<CommendRewardPerformanceEntity> performances = new ArrayList<CommendRewardPerformanceEntity>();
	
	private List<CommendRewardRecommendEntity> recommends = new ArrayList<CommendRewardRecommendEntity>();

	public List<CommendRewardAuditEntity> getResults() {
		return results;
	}

	public void setResults(List<CommendRewardAuditEntity> results) {
		this.results = results;
	}

	public List<CommendRewardPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<CommendRewardPerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<CommendRewardRecommendEntity> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<CommendRewardRecommendEntity> recommends) {
		this.recommends = recommends;
	}
	
	

	


}
