package com.inspection.service.impl.officerleave;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.inspection.entity.officerleave.OfficerAuditingEntity;
import com.inspection.entity.officerleave.OfficerPerformanceEntity;
import com.inspection.service.officerleave.OfficerLeaveServiceI;
import java.util.List;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("officerLeaveService")
@Transactional
public class OfficerLeaveServiceImpl extends CommonServiceImpl implements OfficerLeaveServiceI {

	@Override
	public List<OfficerPerformanceEntity> findAllPerformances(String officerId) {
		String query = "from OfficerPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",officerId);
		List<OfficerPerformanceEntity> lists =queryObject.list();	
		return lists;
	}
	
	
	@Override
	public List<OfficerAuditingEntity> findAllAudits(String officerId) {
		String query = "from OfficerAuditingEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",officerId);
		List<OfficerAuditingEntity> lists =queryObject.list();	
		return lists;
	}
	
	
}