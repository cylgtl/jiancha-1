package com.inspection.service.impl.partyMember;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.entity.partyMember.PartyMemberAssessmentEntity;
import com.inspection.entity.partyMember.PartyMemberAuditEntity;
import com.inspection.entity.partyMember.PartyMemberPerformanceEntity;
import com.inspection.entity.partyMember.PartyMemberRecommendEntity;
import com.inspection.entity.partyMember.PartyMemberReportEntity;
import com.inspection.service.partyMember.PartyMemberServiceI;

@Service("partyMemberService")
@Transactional
public class PartyMemberServiceImpl extends CommonServiceImpl implements PartyMemberServiceI {
	
	@Override
	public List<PartyMemberAuditEntity> findAllAudits(String id) {
		String query = "from PartyMemberAuditEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PartyMemberAuditEntity> lists =queryObject.list();	
		return lists;
	}
	
	@Override
	public List<PartyMemberPerformanceEntity> findAllPerformances(String id) {
		String query = "from PartyMemberPerformanceEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PartyMemberPerformanceEntity> lists =queryObject.list();	
		return lists;
	}
	
	@Override
	public List<PartyMemberRecommendEntity> findAllRecommends(String id) {
		String query = "from PartyMemberRecommendEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PartyMemberRecommendEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<PartyMemberAssessmentEntity> findAllAssessments(String id) {
		String query = "from PartyMemberAssessmentEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PartyMemberAssessmentEntity> lists =queryObject.list();	
		return lists;
	}

	@Override
	public List<PartyMemberReportEntity> findAllReports(String id) {
		String query = "from PartyMemberReportEntity t where t.officerId = :officerId";
		org.hibernate.Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("officerId",id);
		List<PartyMemberReportEntity> lists =queryObject.list();	
		return lists;
	}
	
}