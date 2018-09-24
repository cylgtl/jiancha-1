package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.backbone.BackboneAuditingEntity;
import com.inspection.entity.backbone.BackbonePerformanceEntity;
import com.inspection.entity.backbone.BackboneRecommendEntity;


public class BackboneMainPage {
	
	private List<BackboneAuditingEntity> results = new ArrayList<BackboneAuditingEntity>();

	private List<BackbonePerformanceEntity> performances = new ArrayList<BackbonePerformanceEntity>();
	
	private List<BackboneRecommendEntity> recommends = new ArrayList<BackboneRecommendEntity>();

	public List<BackboneAuditingEntity> getResults() {
		return results;
	}

	public void setResults(List<BackboneAuditingEntity> results) {
		this.results = results;
	}

	public List<BackbonePerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<BackbonePerformanceEntity> performances) {
		this.performances = performances;
	}

	public List<BackboneRecommendEntity> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<BackboneRecommendEntity> recommends) {
		this.recommends = recommends;
	}



}
