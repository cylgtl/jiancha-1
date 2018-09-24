<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>表彰奖励详情信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
    <script type="text/javascript">
    function uploadSuccess(d,file,response){
        $("#fileId").val(d.attributes.url);
        alert("上传成功");
 		}
       
</script>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="commendRewardController.do?save">
			<input id="id" name="id" type="hidden" value="${commendRewardPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							事物类型:
						</label>
					</td>
					<td class="value" colspan="3">
					<select id="recognitType" name="recognitType" >
					   		<option value="1">表彰奖励</option>
					   </select>
						
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名/单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nameUnit" name="nameUnit" ignore="ignore"
							   value="${commendRewardPage.nameUnit}">
						<span class="Validform_checktip"></span>
					</td>
				 <td align="right">
						<label class="Validform_label">
							部职别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jobTitle" name="jobTitle" ignore="ignore"
							   value="${commendRewardPage.jobTitle}">
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
							   value="${commendRewardPage.nowRank}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							军衔时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="rankTime" name="rankTime" ignore="ignore"
							   value="<fmt:formatDate value='${commendRewardPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							提名类型:
						</label>
					</td>
					<td class="value">
					<!-- 1-首长提名 2-群众提名 -->
					<select name ="nominateType">
				<c:forEach items="${typeList}" var="type">
                    <option value="${type.typecode}">${type.typename}</option>
                </c:forEach>
				</select>
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							提名奖励类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nominateRewardType" name="nominateRewardType" ignore="ignore"
							   value="${commendRewardPage.nominateRewardType}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							名额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="places" name="places" ignore="ignore"
							   value="${commendRewardPage.places}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							事迹材料:
						</label>
					</td>
					<td class="value">
					 <input class="inputxt" type="hidden" id="fileId" name="fileId" ignore="ignore"
					   value="${commendRewardPage.fileId}">
				<div class="form"><t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="file_Id" view="false" auto="true" uploader="militrainingController.do?saveFiles" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="file_Id" formData="id"></t:upload></div>    
	
					
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							录用时间:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="employTime" name="employTime" ignore="ignore"
							   value="<fmt:formatDate value='${commendRewardPage.employTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>