<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>战士请假</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="soldierLeaveController.do?save">
			<input id="id" name="id" type="hidden" value="${soldierLeavePage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							流程类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="type" name="type" ignore="ignore"
							   value="${soldierLeavePage.type}">
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
							   value="${soldierLeavePage.name}">
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
							   value="${soldierLeavePage.jobTitle}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							休假类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="leaveType" name="leaveType" ignore="ignore"
							   value="${soldierLeavePage.leaveType}">
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
						<input class="inputxt" id="birthday" name="birthday" ignore="ignore"
							   value="${soldierLeavePage.birthday}">
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
						<input class="inputxt" id="militaryTime" name="militaryTime" ignore="ignore"
							   value="${soldierLeavePage.militaryTime}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="rankTime" name="rankTime" ignore="ignore"
							   value="${soldierLeavePage.rankTime}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							休假开始时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="beginTime" name="beginTime" ignore="ignore"
							   value="${soldierLeavePage.beginTime}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							休假结束时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="endTime" name="endTime" ignore="ignore"
							   value="${soldierLeavePage.endTime}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createTime" name="createTime" ignore="ignore"
							     value="<fmt:formatDate value='${soldierLeavePage.createTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
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
							     value="<fmt:formatDate value='${soldierLeavePage.updateTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
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
							   value="${soldierLeavePage.createId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假天数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="days" name="days" ignore="ignore"
							   value="${soldierLeavePage.days}">
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
							   value="${soldierLeavePage.nativePlace}">
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
							   value="${soldierLeavePage.national}">
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
						<input class="inputxt" id="political" name="political" ignore="ignore"
							   value="${soldierLeavePage.political}">
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
						<input class="inputxt" id="educational" name="educational" ignore="ignore"
							   value="${soldierLeavePage.educational}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>