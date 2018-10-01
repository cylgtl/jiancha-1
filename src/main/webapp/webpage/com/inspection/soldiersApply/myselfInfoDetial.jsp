<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <script type="text/javascript">
 	function jubaoOnclickResults(){   
		createwindow('实时举报',
        		"reportController.do?addorupdate",
                700, 500);
		}
		
	$(document).ready(function(){
		$(".datagrid-toolbar").parent().css("width","auto");
		//将表格的表头固定
	    $("#results_table").createhftable({
	    	height:'200px',
			width:'auto',
			fixFooter:false
			});
});

</script>
 <body style="overflow-y: hidden" scroll="no">
  <div style="padding: 3px; height: 25px; width: width:1024px;" class="datagrid-toolbar">
	<a onclick="jubaoOnclickMyselfInfo()" id="jubao" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">举报</span></span></a>
</div>
   <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="soldiersApplyPage.do?save">
			<input id="id" name="id" type="hidden" value="${soldiersApplyPage.id }">
			<table style="width: 600px;margin: auto;text-align: center;"  cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.name}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.sex}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生年月:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.birthday}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
					${soldiersApplyPage.jobTitle}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.nativePlace}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
					   ${soldiersApplyPage.nation}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔:
						</label>
					</td>
					<td class="value">
					${soldiersApplyPage.nowRank}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现军衔时间:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.rankTime}
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
					   ${soldiersApplyPage.educational}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					</td>
					<td class="value">
					   ${soldiersApplyPage.militaryTime}
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							身份证号:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.idcard}
					</td>
				</tr> 
				<tr>
					<td align="right">
						<label class="Validform_label">
							报考学校:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.targetSchool}
					</td>
				</tr> 
				<tr>
					<td align="right">
						<label class="Validform_label">
							报考专业:
						</label>
					</td>
					<td class="value">
						${soldiersApplyPage.applyingMajor}
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>