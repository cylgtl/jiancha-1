<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>技术学兵选调</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="personnelSelectionController.do?save">
			<input id="id" name="id" type="hidden" value="${personnelSelectionPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							事务类型:
						</label>
					</td>
					<td class="value" colspan="3">
						<select id="type" name="type" style="width:200px;" >
					   		<option value="1">技术学兵选调</option>
					    </select>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="name" name="name"
							   value="${personnelSelectionPage.name}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jobTitle" name="jobTitle"
							   value="${personnelSelectionPage.jobTitle}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sex" name="sex"
							   value="${personnelSelectionPage.sex}">
						<%-- <select name ="sex"  style="width:200px;">
							<c:forEach items="${sexList}" var="sex">
			                    <option value="${sex.typename}"<c:if test="${sex.typename==personnelSelectionPage.sex}">selected="selected"</c:if>>${sex.typename}</option>
			                </c:forEach>
						</select> --%>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nation" name="nation"
							   value="${personnelSelectionPage.nation}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nativePlace" name="nativePlace"
							   value="${personnelSelectionPage.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="politicalStatus" name="politicalStatus"
							   value="${personnelSelectionPage.politicalStatus}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 200px;height:30px" id="birthday" name="birthday"
							   value="<fmt:formatDate value='${personnelSelectionPage.birthday}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 200px;height:30px" id="militaryTime" name="militaryTime"
							   value="<fmt:formatDate value='${personnelSelectionPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>">
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
						<input class="inputxt" id="nowRank" name="nowRank"
							   value="${personnelSelectionPage.nowRank}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						<%-- <input class="inputxt" id="rankTime" name="rankTime"
							   value="${personnelSelectionPage.rankTime}"> --%>
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 200px;height:30px" id="rankTime" name="rankTime" ignore="ignore"
							   value="<fmt:formatDate value='${partyMemberPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							选调类型:
						</label>
					</td>
					<td class="value">
						<select name ="selectionType" style="width:200px;">
							<c:forEach items="${selectionList}" var="selection">
			                    <option value="${selection.typename}"<c:if test="${selection.typename==personnelSelectionPage.selectionType}">selected="selected"</c:if>>${selection.typename}</option>
			                </c:forEach>
						</select>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="specialty" name="specialty"
							   value="${personnelSelectionPage.specialty}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							从事本专业时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 200px;height:30px" id="specialtyTime" name="specialtyTime"
							   value="<fmt:formatDate value='${personnelSelectionPage.specialtyTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							培训单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="trainingUnit" name="trainingUnit"
							   value="${personnelSelectionPage.trainingUnit}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							培训专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="trainingSpecialty" name="trainingSpecialty"
							   value="${personnelSelectionPage.trainingSpecialty}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							当前专业分配名额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="places" name="places"
							   value="${personnelSelectionPage.places}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<%-- <tr>
					<td align="right">
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createTime" name="createTime" ignore="ignore"
							     value="<fmt:formatDate value='${personnelSelectionPage.createTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							更新时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="updateTime" name="updateTime" ignore="ignore"
							     value="<fmt:formatDate value='${personnelSelectionPage.updateTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							修改人ID:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="updateId" name="updateId" ignore="ignore"
							   value="${personnelSelectionPage.updateId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建人ID:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="createId" name="createId" ignore="ignore"
							   value="${personnelSelectionPage.createId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部门ID:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="departId" name="departId" ignore="ignore"
							   value="${personnelSelectionPage.departId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
			</table>
		</t:formvalid>
 </body>