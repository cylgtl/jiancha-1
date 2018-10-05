<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>军官请假基础信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="soldierSelectPage.do?save">
			<table style="width: 900px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						${soldierSchoolPage.name}
					</td>
					
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						${soldierSchoolPage.sex}
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
						${soldierSchoolPage.jobTitle}
					</td>
			
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						${soldierSchoolPage.education}
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生日期:
						</label>
					</td>
					<td class="value">
					<fmt:formatDate value='${soldierSchoolPage.birthDay}' type="date" pattern="yyyy-MM-dd"/>
					
						
					</td>
				
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
						
					<fmt:formatDate value='${soldierSchoolPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					
					
					</td>
				</tr>
				
				<tr>
				
				<td align="right">
						<label class="Validform_label">
							现军衔:
						</label>
					</td>
					<td class="value">
						${soldierSchoolPage.nowRank}
					</td>
					
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
					<fmt:formatDate value='${soldierSchoolPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>
						
					</td>
					
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						${soldierSchoolPage.politicalLandscape}
					</td>
					
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						${soldierSchoolPage.nationalName}
					</td>
				</tr>
				
				<tr>
				<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value" colspan="3">
						${soldierSchoolPage.nativePlace}
					</td>
				</tr>
				
			
			</table>
		</t:formvalid>
 </body>