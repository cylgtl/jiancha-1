<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="commendrewardPage.do?save">
	
			<table style="width: 600px;margin: auto;text-align: center;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						${commendrewardPage.nameUnit}
					</td>
				</tr>
			<%-- 	<tr>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sex" readonly="readonly" name="sex" datatype="*"
							   value="${commendrewardPage.sex}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生年月:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="birthDay" readonly="readonly" name="birthDay" datatype="*"
							   value="${commendrewardPage.birthDay}">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
					${commendrewardPage.jobTitle}
					</td>
				</tr>
		<%-- 		<tr>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						<input  id="nativePlace" readonly="readonly" name="nativePlace" class="inputxt" 
							   value="${commendrewardPage.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" readonly="readonly"    id="nationalName" name="nationalName" datatype="*"
							   value="${commendrewardPage.nationalName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔:
						</label>
					</td>
					<td class="value">
					${commendrewardPage.nowRank}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
					<fmt:formatDate value='${commendrewardPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>
						
						
					</td>
				</tr>
			<%-- 	<tr>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" readonly="readonly"  id="education" name="education" datatype="*"
							   value="${commendrewardPage.education}">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
				<%-- <tr>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" readonly="readonly"  id="militaryTime" name="militaryTime" datatype="*"
							   value="${commendrewardPage.militaryTime}">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							提名类型:
						</label>
					</td>
					<td class="value">
					 <c:forEach items="${typeList}" var="type">
                     		<c:if test="${type.typecode==commendrewardPage.nominateType}">${type.typename}</c:if>
                	</c:forEach>
						
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							奖励类型:
						</label>
					</td>
					<td class="value">${commendrewardPage.nominateRewardType}
					
					</td>
				</tr> 
				<tr>
					<td align="right">
						<label class="Validform_label">
							事迹材料:
						</label>
					</td>
					<td class="value">
						<a target="_blank" href="${commendrewardPage.fileId}">下载</a>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>