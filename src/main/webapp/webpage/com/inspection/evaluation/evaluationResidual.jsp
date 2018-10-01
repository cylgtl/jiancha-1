<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>官兵评残信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="evaluationResidualController.do?save">
			<input id="id" name="id" type="hidden" value="${evaluationResidualPage.id }">
			<table style="width: 650px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							事物类型:
						</label>
					</td>
					<td class="value" colspan="3">
					   <select id="residualType" name="residualType" >
					   		<option value="1">官兵评残</option>
					   </select>
					   
						<%-- <input class="inputxt" ignore="ignore"
							   value="${evaluationResidualPage.residualType}"> --%>
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
							   value="${evaluationResidualPage.name}">
						<span class="Validform_checktip"></span>
					</td>
			
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sex" name="sex" ignore="ignore"
							   value="${evaluationResidualPage.sex}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jobTitle" name="jobTitle" ignore="ignore"
							   value="${evaluationResidualPage.jobTitle}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nationalName" name="nationalName" ignore="ignore"
							   value="${evaluationResidualPage.nationalName}">
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
						<input class="inputxt" id="nativePlace" name="nativePlace" ignore="ignore"
							   value="${evaluationResidualPage.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>
			
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="political" name="political" ignore="ignore"
							   value="${evaluationResidualPage.political}">
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
							   value="<fmt:formatDate value='${evaluationResidualPage.birthDay}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="militaryTime" name="militaryTime" ignore="ignore"
							   value="<fmt:formatDate value='${evaluationResidualPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>">
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
							   value="${evaluationResidualPage.nowRank}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							军衔时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="rankTime" name="rankTime" ignore="ignore"
							   value="<fmt:formatDate value='${evaluationResidualPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>">
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
						<input class="inputxt" id="education" name="education" ignore="ignore"
							   value="${evaluationResidualPage.education}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							现专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nowProfessional" name="nowProfessional" ignore="ignore"
							   value="${evaluationResidualPage.nowProfessional}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							毕业时间:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="graduateTime" name="graduateTime" ignore="ignore"
							   value="<fmt:formatDate value='${evaluationResidualPage.graduateTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
			</table>
		</t:formvalid>
 </body>