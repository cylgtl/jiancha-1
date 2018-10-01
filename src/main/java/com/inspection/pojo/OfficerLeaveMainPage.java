package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.officerleave.OfficerAuditingEntity;
import com.inspection.entity.officerleave.OfficerPerformanceEntity;

/**
 * @ClassName: SoldierLeaveMainPage
 * @Description: 军官请假请假流程
 * @author yxd
 * @date 2018年7月6日 上午9:30:57
 */
@SuppressWarnings("serial")
public class OfficerLeaveMainPage implements java.io.Serializable {
	
	private List<OfficerAuditingEntity> results = new ArrayList<OfficerAuditingEntity>();

	private List<OfficerPerformanceEntity> performances = new ArrayList<OfficerPerformanceEntity>();

	public List<OfficerAuditingEntity> getResults() {
		return results;
	}

	public void setResults(List<OfficerAuditingEntity> results) {
		this.results = results;
	}

	public List<OfficerPerformanceEntity> getPerformances() {
		return performances;
	}

	public void setPerformances(List<OfficerPerformanceEntity> performances) {
		this.performances = performances;
	}

	
}
