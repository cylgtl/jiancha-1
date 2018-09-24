<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>士兵考学</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="soldiersApplyController.do?save">
			<input id="id" name="id" type="hidden" value="${soldiersApplyPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							事务类型:
						</label>
					</td>
					<td class="value" colspan="3">
						<select id="type" name="type" >
					   		<option value="1">士兵考学</option>
					    </select>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名/单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="name" name="name"
							   value="${soldiersApplyPage.name}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jobTitle" name="jobTitle"
							   value="${soldiersApplyPage.jobTitle}">
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
						<select name ="sex">
							<c:forEach items="${sexList}" var="sex">
			                    <option value="${sex.typename}"<c:if test="${sex.typename==soldiersApplyPage.sex}">selected="selected"</c:if>>${sex.typename}</option>
			                </c:forEach>
						</select>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nation" name="nation"
							   value="${soldiersApplyPage.nation}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="politicalStatus" name="politicalStatus"
							   value="${soldiersApplyPage.politicalStatus}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nativePlace" name="nativePlace"
							   value="${soldiersApplyPage.nativePlace}">
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
							   value="<fmt:formatDate value='${soldiersApplyPage.birthday}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 200px;height:30px" id="militaryTime" name="militaryTime"
							   value="<fmt:formatDate value='${soldiersApplyPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>">
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
							   value="${soldiersApplyPage.nowRank}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="rankTime" name="rankTime"
							   value="${soldiersApplyPage.rankTime}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="educational" name="educational"
							   value="${soldiersApplyPage.educational}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="specialty" name="specialty"
							   value="${soldiersApplyPage.specialty}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							毕业时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 200px;height:30px" id="graduateTime" name="graduateTime"
							   value="<fmt:formatDate value='${soldiersApplyPage.graduateTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							身份证号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="idcard" name="idcard"
							   value="${soldiersApplyPage.idcard}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							报考学校:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="targetSchool" name="targetSchool"
							   value="${soldiersApplyPage.targetSchool}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							报考专业:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="applyingMajor" name="applyingMajor"
							   value="${soldiersApplyPage.applyingMajor}">
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
							     value="<fmt:formatDate value='${soldiersApplyPage.createTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
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
							     value="<fmt:formatDate value='${soldiersApplyPage.updateTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
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
							   value="${soldiersApplyPage.updateId}">
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
							   value="${soldiersApplyPage.createId}">
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
							   value="${soldiersApplyPage.departId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
			</table>
		</t:formvalid>
 </body>