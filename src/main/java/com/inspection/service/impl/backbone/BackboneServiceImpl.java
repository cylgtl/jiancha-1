package com.inspection.service.impl.backbone;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.backbone.BackboneAuditingEntity;
import com.inspection.entity.backbone.BackbonePerformanceEntity;
import com.inspection.entity.backbone.BackboneRecommendEntity;
import com.inspection.entity.cadresadjust.AdjustPerformanceEntity;
import com.inspection.service.backbone.BackboneServiceI;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("backboneService")
@Transactional
public class BackboneServiceImpl extends CommonServiceImpl implements BackboneServiceI {

	@Override
	public List<BackbonePerformanceEntity> findAllPerformances(String id) {
		String query = "from BackbonePerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<BackbonePerformanceEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<BackboneAuditingEntity> findAllAudits(String id) {
		String query = "from BackboneAuditingEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<BackboneAuditingEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<BackboneRecommendEntity> findAllRecommends(String id) {
		String query = "from BackboneRecommendEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<BackboneRecommendEntity> lists =queryObject.list();	
		return lists;
	}
	
}