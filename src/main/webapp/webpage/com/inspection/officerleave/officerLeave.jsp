<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>军官请假信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="officerLeaveController.do?save">
			<input id="id" name="id" type="hidden" value="${officerLeavePage.id }">
			<table style="width: 650px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							事物类型:
						</label>
					</td>
					<td class="value" colspan="3">
						<%-- <input class="inputxt" id="type" name="type" ignore="ignore"
							   value="${officerLeavePage.type}">
						<span class="Validform_checktip"></span> --%>
						<select name="type" id="type">
						    <option value="军官请假">军官请假</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							标题:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="title" name="title"  ignore="ignore"
							   value="${officerLeavePage.title}">
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
							   value="${officerLeavePage.name}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sex" name="sex" ignore="ignore"
							   value="${officerLeavePage.sex}">
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
						<input class="inputxt" id="educational" name="educational"  ignore="ignore"
							   value="${officerLeavePage.educational}">
						<span class="Validform_checktip"></span>
					</td>
						<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="political" name="political" ignore="ignore"
							   value="${officerLeavePage.political}">
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
						<input class="inputxt" id="nativePlace" name="nativePlace"  ignore="ignore"
							   value="${officerLeavePage.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>
						<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="national" name="national" ignore="ignore"
							   value="${officerLeavePage.national}">
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
							   value="${officerLeavePage.nowRank}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							军衔时间:
						</label>
					</td>
					<td class="value">
					
							   <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="rankTime" name="rankTime" datatype="*"
							     value="<fmt:formatDate value='${officerLeavePage.rankTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生日期:
						</label>
					</td>
					<td class="value" >
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="birthday" name="birthday" datatype="*"
							     value="<fmt:formatDate value='${officerLeavePage.birthday}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value" >
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="militaryTime" name="militaryTime" datatype="*"
							     value="<fmt:formatDate value='${officerLeavePage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value" >
						<input class="inputxt" id="jobTitle" name="jobTitle" ignore="ignore"
							   value="${officerLeavePage.jobTitle}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							休假开始时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onchange="getDays()" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="beginTime" name="beginTime" datatype="*"
							     value="<fmt:formatDate value='${officerLeavePage.beginTime}' type="date" pattern="yyyy-MM-dd"/>">
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
						<input class="Wdate" onchange="getDays()" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="endTime" name="endTime" datatype="*"
							     value="<fmt:formatDate value='${officerLeavePage.endTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							请假天数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="days" name="days"  readonly="readonly"
							   value="${officerLeavePage.days}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
			</table>
		</t:formvalid>
 </body>
 <script type="text/javascript">
 function getDays(){
     var beginTime = $("#beginTime").val();
     var endTime = $("#endTime").val();
     if(beginTime&&endTime){
    	 var result = (new Date(beginTime).getTime() - new Date(endTime))/(24*3600*1000);
      		$("#days").val(Math.abs(result));
     }
   }
 
 
 </script>