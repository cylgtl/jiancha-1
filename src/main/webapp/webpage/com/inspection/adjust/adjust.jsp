<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>干部调整信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="adjustController.do?save">
			<input id="id" name="id" type="hidden" value="${adjustPage.id }">
			<table style="width: 650px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							事务类型:
						</label>
					</td>
					<td class="value" colspan="3">
						<select name="adjustType" id="adjustType">
						    <option value="干部调整配备">干部调整配备</option>
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
						<input class="inputxt" id="name" name="name" ignore="ignore"
							   value="${adjustPage.name}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sex" name="sex" ignore="ignore"
							   value="${adjustPage.sex}">
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
						<input class="inputxt" id="idCard" name="idCard" ignore="ignore"
							   value="${adjustPage.idCard}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="politicalLandscape" name="politicalLandscape" ignore="ignore"
							   value="${adjustPage.politicalLandscape}">
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
						<input class="inputxt" id="nationalName" name="nationalName" ignore="ignore"
							   value="${adjustPage.nationalName}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nativePlace" name="nativePlace" ignore="ignore"
							   value="${adjustPage.nativePlace}">
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
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="birthDay" name="birthDay" ignore="ignore"
							   value="<fmt:formatDate value='${adjustPage.birthDay}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jobTitle" name="jobTitle" ignore="ignore"
							   value="${adjustPage.jobTitle}">
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
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="militaryTime" name="militaryTime" ignore="ignore"
							   value="<fmt:formatDate value='${adjustPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							军衔时间:
						</label>
					</td>
					<td class="value">
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="rankTime" name="rankTime" ignore="ignore"
							   value="<fmt:formatDate value='${adjustPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>">
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
							   value="${adjustPage.nowRank}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="education" name="education" ignore="ignore"
							   value="${adjustPage.education}">
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<%-- <tr>
				<td align="right">
						<label class="Validform_label">
							现专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nowProfessional" name="nowProfessional" ignore="ignore"
							   value="${adjustPage.nowProfessional}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							毕业时间:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="graduateTime" name="graduateTime" ignore="ignore"
							   value="<fmt:formatDate value='${adjustPage.graduateTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
				
			</table>
		</t:formvalid>
 </body>