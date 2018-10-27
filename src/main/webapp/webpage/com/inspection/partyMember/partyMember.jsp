<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>党员发展</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="partyMemberController.do?save">
			<input id="id" name="id" type="hidden" value="${partyMemberPage.id }">
			<input id="swType" name="swType" type="hidden" value="${swType}">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value" colspan="3">
						<select id="type" name="type" >
					   		<option value="1" <c:if test="${partyMemberPage.type=='入党积极分子'}">selected="selected"</c:if>>入党积极分子</option>
					   		<option value="2" <c:if test="${partyMemberPage.type=='党员发展'}">selected="selected"</c:if>>党员发展</option>
					    </select>
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="name" name="name" ignore="ignore"
							   value="${partyMemberPage.name}">
						<span class="Validform_checktip"></span>
					</td>
                    <td align="right">
                        <label class="Validform_label">
                            性别:
                        </label>
                    </td>
                    <td class="value">
                        <select name ="sex">
                            <c:forEach items="${sexList}" var="sex">
                                <option value="${sex.typename}"<c:if test="${sex.typename==partyMemberPage.sex}">selected="selected"</c:if>>${sex.typename}</option>
                            </c:forEach>
                        </select>
                        <span class="Validform_checktip"></span>
                    </td>
				</tr>
				<tr>
                    <td align="right">
                        <label class="Validform_label">
                            身份证号:
                        </label>
                    </td>
                    <td class="value">
                        <input class="inputxt" id="idcard" name="idcard" ignore="ignore"
                               value="${partyMemberPage.idcard}">
                        <span class="Validform_checktip"></span>
                    </td>
                    <td align="right">
                        <label class="Validform_label">
                            政治面貌:
                        </label>
                    </td>
                    <td class="value">
                        <input class="inputxt" id="politicalLandscape" name="politicalLandscape" ignore="ignore"
                               value="${partyMemberPage.politicalLandscape}">
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
                        <input class="inputxt" id="national" name="national" ignore="ignore"
                               value="${partyMemberPage.national}">
                        <span class="Validform_checktip"></span>
                    </td>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nativePlace" name="nativePlace" ignore="ignore"
							   value="${partyMemberPage.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>

				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="birthDay" name="birthDay" ignore="ignore"
							   value="<fmt:formatDate value='${partyMemberPage.birthDay}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
                    <td align="right">
                        <label class="Validform_label">
                            部职别:
                        </label>
                    </td>
                    <td class="value">
                        <input class="inputxt" id="jobTitle" name="jobTitle" ignore="ignore"
                               value="${partyMemberPage.jobTitle}">
                        <span class="Validform_checktip"></span>
                    </td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="militaryTime" name="militaryTime" ignore="ignore"
							   value="<fmt:formatDate value='${partyMemberPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
                    <td align="right">
                        <label class="Validform_label">
                            军衔时间:
                        </label>
                    </td>
                    <td class="value">

                        <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="rankTime" name="rankTime" ignore="ignore"
                               value="<fmt:formatDate value='${partyMemberPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>">
                        <span class="Validform_checktip"></span>
                    </td>
				</tr>
				<tr>
                    <td align="right">
                        <label class="Validform_label">
                            现军衔:
                        </label>
                    </td>
                    <td class="value">
                        <input class="inputxt" id="nowRank" name="nowRank" ignore="ignore"
                               value="${partyMemberPage.nowRank}">
                        <span class="Validform_checktip"></span>
                    </td>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="education" name="education" ignore="ignore"
							   value="${partyMemberPage.education}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>