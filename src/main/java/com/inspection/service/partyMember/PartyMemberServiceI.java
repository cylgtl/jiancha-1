package com.inspection.service.partyMember;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.inspection.entity.partyMember.PartyMemberAssessmentEntity;
import com.inspection.entity.partyMember.PartyMemberAuditEntity;
import com.inspection.entity.partyMember.PartyMemberPerformanceEntity;
import com.inspection.entity.partyMember.PartyMemberRecommendEntity;
import com.inspection.entity.partyMember.PartyMemberReportEntity;

public interface PartyMemberServiceI extends CommonService{

	List<PartyMemberAuditEntity> findAllAudits(String id);

	List<PartyMemberPerformanceEntity> findAllPerformances(String id);

	List<PartyMemberRecommendEntity> findAllRecommends(String id);

	List<PartyMemberAssessmentEntity> findAllAssessments(String id);

	List<PartyMemberReportEntity> findAllReports(String id);

}
