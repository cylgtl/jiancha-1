<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>士兵选取信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="soldierSelectController.do?save">
			<input id="id" name="id" type="hidden" value="${soldierselectPage.id }">
			<div style="width:700px;height:400px;overflow-y:scroll;">
			<table style="width: 680px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
				<td align="right">
						<label class="Validform_label">
							事务类型:
						</label>
					</td>
					<td align="left" colspan="3">
						
						<select name="selectType">
							<option value="士兵选取">士兵选取</option>
						</select>
				
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="name" name="name" ignore="ignore"
							   value="${soldierselectPage.name}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nationalName" name="nationalName" ignore="ignore"
							   value="${soldierselectPage.nationalName}">
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
						<input class="inputxt" id="sex" name="sex" ignore="ignore"
							   value="${soldierselectPage.sex}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nativePlace" name="nativePlace" ignore="ignore"
							   value="${soldierselectPage.nativePlace}">
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
						<input class="inputxt" id="politicalLandscape" name="politicalLandscape" ignore="ignore"
							   value="${soldierselectPage.politicalLandscape}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							出生日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="birthDay" name="birthDay" ignore="ignore"
							   value="<fmt:formatDate value='${soldierselectPage.birthDay}' type="date" pattern="yyyy-MM-dd"/>">
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
							   value="<fmt:formatDate value='${soldierselectPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
			
				<%-- <tr>
					<td align="right">
						<label class="Validform_label">
							身份证号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="idCard" name="idCard" ignore="ignore"
							   value="${soldierselectPage.idCard}">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
				
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jobTitle" name="jobTitle" ignore="ignore"
							   value="${soldierselectPage.jobTitle}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							名额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="places" name="places" ignore="ignore"
							   value="${soldierselectPage.places}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
		
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="education" name="education" ignore="ignore"
							   value="${soldierselectPage.education}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			
				<tr>
					<td align="right">
						<label class="Validform_label">
							现专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nowProfessional" name="nowProfessional" ignore="ignore"
							   value="${soldierselectPage.nowProfessional}">
						<span class="Validform_checktip"></span>
					</td>
			
					<td align="right">
						<label class="Validform_label">
							改后专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="endProfessional" name="endProfessional" ignore="ignore"
							   value="${soldierselectPage.endProfessional}">
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
							   value="${soldierselectPage.nowRank}">
						<span class="Validform_checktip"></span>
					</td>
			
					<td align="right">
						<label class="Validform_label">
							改后军衔:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="endRank" name="endRank" ignore="ignore"
							   value="${soldierselectPage.endRank}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
		
				 <tr>
					<td align="right">
						<label class="Validform_label">
							军衔时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="rankTime" name="rankTime" ignore="ignore"
							   value="<fmt:formatDate value='${soldierselectPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
			
					<td align="right">
						<label class="Validform_label">
							专业技术等级:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="professionalLevel" name="professionalLevel" ignore="ignore"
							   value="${soldierselectPage.professionalLevel}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			
				<tr>
					<td align="right">
						<label class="Validform_label">
							录入时间:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="entryTime" name="entryTime" ignore="ignore"
							   value="<fmt:formatDate value='${soldierselectPage.entryTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
			<%--		<td align="right">
						<label class="Validform_label">
							毕业时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="graduateTime" name="graduateTime" ignore="ignore"
							   value="<fmt:formatDate value='${soldierselectPage.graduateTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			
				 <tr>
					<td align="right">
						<label class="Validform_label">
							职务:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="position" name="position" ignore="ignore"
							   value="${soldierselectPage.position}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							班级:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="theClass" name="theClass" ignore="ignore"
							   value="${soldierselectPage.theClass}">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
			</table>
			</div>
		</t:formvalid>
 </body>