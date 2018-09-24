<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>士兵考学基础信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="soldiersApplyPage.do?save">
			<input id="id" name="id" type="hidden" value="${soldiersApplyPage.id }">
			<table style="width: 600px;margin: auto;text-align: center;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.name}
					</td>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.sex}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生年月:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" style="width: 200px;height:30px" id="birthday" name="birthday" datatype="*"
							   value="<fmt:formatDate value='${soldiersApplyPage.birthday}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
					${soldiersApplyPage.jobTitle}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						<input  id="nativePlace" readonly="readonly" name="nativePlace" class="inputxt" 
							   value="${soldiersApplyPage.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.nation}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" readonly="readonly" id="politicalStatus" name="politicalStatus"
							   value="${soldiersApplyPage.politicalStatus}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							现军衔:
						</label>
					</td>
					<td class="value">
						<input  id="nowRank" readonly="readonly" name="nowRank" class="inputxt" 
							   value="${soldiersApplyPage.nowRank}">
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.rankTime}
						
					</td>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.educational}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.militaryTime}
					</td>
					<td align="right">
						<label class="Validform_label">
							身份证号:
						</label>
					</td>
					<td class="value">
						<input  id="idcard" readonly="readonly" name="idcard" class="inputxt" 
							   value="${soldiersApplyPage.idcard}">
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							报考学校:
						</label>
					</td>
					<td class="value">
						<input  id="targetSchool" readonly="readonly" name="targetSchool" class="inputxt" 
							   value="${soldiersApplyPage.targetSchool}">
					</td>
					<td align="right">
						<label class="Validform_label">
							报考专业:
						</label>
					</td>
					<td class="value">
						<input  id="applyingMajor" readonly="readonly" name="applyingMajor" class="inputxt" 
							   value="${soldiersApplyPage.applyingMajor}">
					</td>
				</tr> 
			</table>
		</t:formvalid>
 </body>