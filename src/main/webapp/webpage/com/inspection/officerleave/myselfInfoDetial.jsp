<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>军官请假基础信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 
 <body style="overflow-y: hidden" scroll="no">
  <div style="padding: 3px; height: 25px; width: width:1024px;" class="datagrid-toolbar">
	<a onclick="jubaoOnclickMyselfInfo()" id="jubao" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">举报</span></span></a>
</div>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" >
			
			<table style="width: 600px;margin: auto;text-align: center;" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							事务类型:
						</label>
					</td>
					<td class="value">
						<%-- <input class="inputxt" id="type" name="type" ignore="ignore"
							   value="${soldierLeavePage.type}">
						<span class="Validform_checktip"></span> --%>
						<select name="type" id="type">
						    <option value="0">军官请假</option>
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
						${officerLeavePage.name}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
					${officerLeavePage.jobTitle}
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生日期:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.birthday}
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.militaryTime}
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.rankTime}
					
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							休假开始时间:
						</label>
					</td>
					<td class="value">
					${officerLeavePage.beginTime}
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							休假结束时间:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.endTime}
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假天数:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.days}
						
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>