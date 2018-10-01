<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>军官请假基础信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="adjustPage.do?save">
  <div>
			<table cellpadding="0" cellspacing="1" class="formtable" style="width: 60%;margin: auto;">
				<tr>
					<td  align="center">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td align="center" class="value">${adjustPage.name}
					</td>
					<td  align="center">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td align="center" class="value">${adjustPage.sex}
					</td>
				</tr>
				<tr>
					<td  align="center">
						<label class="Validform_label">
							出生年月:
						</label>
					</td>
					<td align="center" class="value"><fmt:formatDate value='${adjustPage.birthDay}' type="date" pattern="yyyy-MM-dd"/>
						
					</td>
					<td  align="center">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td align="center" class="value">${adjustPage.jobTitle}
						
					</td>
				</tr>
				<tr>
					<td  align="center">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td align="center" class="value">${adjustPage.nativePlace}
					</td>
					<td  align="center">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td align="center" class="value">${adjustPage.nationalName}
					</td>
				</tr>
				<tr>
					<td  align="center">
						<label class="Validform_label">
							现军衔:
						</label>
					</td>
					<td align="center" class="value">${adjustPage.nowRank}
					</td>
					<td  align="center">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td align="center" class="value">${adjustPage.politicalLandscape}
					</td>
					
				</tr>
				<tr>
				<td  align="center">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td align="center" class="value">
					<fmt:formatDate value='${adjustPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					
					</td>
					<td  align="center">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td align="center" class="value">${adjustPage.education}
					</td>
					
				</tr>
				<tr>
				<td  align="center">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td align="center" class="value" colspan="3">
					<fmt:formatDate value='${adjustPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					
					</td>
				</tr>
			</table>
	</div>		
		</t:formvalid>
 </body>