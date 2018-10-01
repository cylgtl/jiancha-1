<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>战士请假基础信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="soldierLeaveController.do?save">
			<input id="id" name="id" type="hidden" value="${soldierLeavePage.id }">
			<table style="width: 900px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.name}
					</td>
					
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.sex}
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.jobTitle}
					</td>
			
					<td align="right">
						<label class="Validform_label">
							休假类型:
						</label>
					</td>
					<td class="value">
				
		                <c:forEach items="${leaveTypeList}" var="type">
		                   <c:if test="${type.id==soldierLeavePage.leaveType }">${type.typename}</c:if>
		                </c:forEach>
		         
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生日期:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.birthday}
					</td>
				
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.militaryTime}
					</td>
				</tr>
				
				<tr>
				
				<td align="right">
						<label class="Validform_label">
							现军衔:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.rank}
					</td>
					
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.rankTime}
					</td>
					
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.political}
					</td>
					
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.national}
					</td>
				</tr>
				
				<tr>
				<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value" colspan="3">
						${soldierLeavePage.nativePlace}
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							休假开始时间:
						</label>
					</td>
					<td class="value">
					${soldierLeavePage.beginTime}
						
					</td>
			
					<td align="right">
						<label class="Validform_label">
							休假结束时间:
						</label>
					</td>
					<td class="value">
					    ${soldierLeavePage.endTime}
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假天数:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.days}
					</td>
					
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						${soldierLeavePage.educational}
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>