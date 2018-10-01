<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>士兵考学基础信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="partyMembernPage.do?save">
			<input id="id" name="id" type="hidden" value="${partyMemberPage.id }">
			<table style="width: 600px;margin: auto;text-align: center;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						${partyMemberPage.name}
					</td>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						${partyMemberPage.sex}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生年月:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="birthDay" readonly="readonly" name="birthDay" 
							   value="${partyMemberPage.birthDay}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
					${partyMemberPage.jobTitle}
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
							   value="${partyMemberPage.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" readonly="readonly"    id="national" name="national" 
							   value="${partyMemberPage.national}">
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
					${partyMemberPage.nowRank}
					</td>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						${partyMemberPage.rankTime}
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" readonly="readonly"  id="education" name="education" 
							   value="${partyMemberPage.education}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" readonly="readonly"  id="militaryTime" name="militaryTime" 
							   value="${partyMemberPage.militaryTime}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>