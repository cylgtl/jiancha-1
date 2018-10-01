package com.inspection.pojo;

import java.util.ArrayList;
import java.util.List;

import com.inspection.entity.leave.SoldierAuditingEntity;
import com.inspection.entity.leave.SoldierPerformanceEntity;

/**
 * 
 * @ClassName: SoldierLeaveMainPage
 * @Description: 士兵请假流程
 * @author  kangjie1209@126.com
 * @date 2018年7月5日 下午10:30:57
 *
 */
@SuppressWarnings("serial")
public class SoldierLeaveMainPage implements java.io.Serializable {
	
	private List<SoldierAuditingEntity> results = new ArrayList<SoldierAuditingEntity>();

	private List<SoldierPerformanceEntity> performances = new ArrayList<SoldierPerformanceEntity>();

	/**
	 * @return the results
	 */
	public List<SoldierAuditingEntity> getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(List<SoldierAuditingEntity> results) {
		this.results = results;
	}

	/**
	 * @return the performances
	 */
	public List<SoldierPerformanceEntity> getPerformances() {
		return performances;
	}

	/**
	 * @param performances the performances to set
	 */
	public void setPerformances(List<SoldierPerformanceEntity> performances) {
		this.performances = performances;
	}

	
}
