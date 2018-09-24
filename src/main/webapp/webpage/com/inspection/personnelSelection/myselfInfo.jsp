<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>基础信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="personnelSelectionPage.do?save">
			<input id="id" name="id" type="hidden" value="${personnelSelectionPage.id }">
			<table style="width: 600px;margin: auto;text-align: center;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						${personnelSelectionPage.name}
					</td>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						${personnelSelectionPage.sex}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生年月:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" style="width: 200px;height:30px" id="birthday" name="birthday"
							   value="<fmt:formatDate value='${personnelSelectionPage.birthday}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
					${personnelSelectionPage.jobTitle}
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
							   value="${personnelSelectionPage.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						${personnelSelectionPage.nation}
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
							   value="${personnelSelectionPage.politicalStatus}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							现军衔:
						</label>
					</td>
					<td class="value">
						<input  id="nowRank" readonly="readonly" name="nowRank" class="inputxt" 
							   value="${personnelSelectionPage.nowRank}">
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						<fmt:formatDate value='${personnelSelectionPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						${personnelSelectionPage.educational}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value" colspan="3">
						${personnelSelectionPage.militaryTime}
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>