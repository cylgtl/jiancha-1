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
			
			<table style="width: 650px;margin: auto;text-align: center;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						${evaluationResidualPage.name}
					
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
					${evaluationResidualPage.sex}
				
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生年月:
						</label>
					</td>
					<td class="value">
					${evaluationResidualPage.birthDay}
				
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
						${evaluationResidualPage.jobTitle}
					
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						${evaluationResidualPage.nativePlace}
				
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						${evaluationResidualPage.nationalName}
					
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔:
						</label>
					</td>
					<td class="value">
						${evaluationResidualPage.nowRank}
				
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						${evaluationResidualPage.rankTime}
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						${evaluationResidualPage.education}
					
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">${evaluationResidualPage.militaryTime}
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>