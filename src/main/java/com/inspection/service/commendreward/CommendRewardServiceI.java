package com.inspection.service.commendreward;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;
import com.inspection.entity.commendreward.CommendRewardAuditEntity;
import com.inspection.entity.commendreward.CommendRewardPerformanceEntity;
import com.inspection.entity.commendreward.CommendRewardRecommendEntity;

public interface CommendRewardServiceI extends CommonService{

	List<CommendRewardPerformanceEntity> findAllPerformances(String id);

	List<CommendRewardAuditEntity> findAllAudits(String id);

	List<CommendRewardRecommendEntity> findAllRecommends(String id);

}
