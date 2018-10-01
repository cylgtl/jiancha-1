<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>军官请假基础信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="officerLeavePage.do?save">
			<table  cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.name}
					</td>
					
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.sex}
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
			
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.educational}
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生日期:
						</label>
					</td>
					<td class="value">
					<fmt:formatDate value='${officerLeavePage.birthday}' type="date" pattern="yyyy-MM-dd"/>
						
					</td>
				
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
					<fmt:formatDate value='${officerLeavePage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					
						
					</td>
				</tr>
				
				<tr>
				
				<td align="right">
						<label class="Validform_label">
							现军衔:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.nowRank}
					</td>
					
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
					<fmt:formatDate value='${officerLeavePage.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					
						
					</td>
					
				</tr>
				
				<tr>
					 <td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.political}
					</td> 
					
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.national}
					</td>
				</tr>
				
				<tr>
				<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.nativePlace}
					</td>
					<td align="right">
					<label class="Validform_label">
							请假开始时间:
						</label>
					</td>
					<td class="value">
					<fmt:formatDate value='${officerLeavePage.beginTime}' type="date" pattern="yyyy-MM-dd"/>
					
					</td>
				</tr>
				<tr>
			
					<td align="right">
					<label class="Validform_label">
							请假结束时间:
						</label>
					</td>
					<td class="value">
					<fmt:formatDate value='${officerLeavePage.endTime}' type="date" pattern="yyyy-MM-dd"/>
					
					</td>
					<td align="right">
						<label class="Validform_label">
							请假时长:
						</label>
					</td>
					<td class="value">
						${officerLeavePage.days}(天)
					</td>
				</tr>
			
			</table>
		</t:formvalid>
 </body>