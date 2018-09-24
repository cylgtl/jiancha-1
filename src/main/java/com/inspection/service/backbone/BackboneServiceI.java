package com.inspection.service.backbone;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.inspection.entity.backbone.BackboneAuditingEntity;
import com.inspection.entity.backbone.BackbonePerformanceEntity;
import com.inspection.entity.backbone.BackboneRecommendEntity;

public interface BackboneServiceI extends CommonService{

	List<BackbonePerformanceEntity> findAllPerformances(String id);

	List<BackboneAuditingEntity> findAllAudits(String id);

	List<BackboneRecommendEntity> findAllRecommends(String id);

}
