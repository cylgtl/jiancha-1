<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>被装发放信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
    function uploadSuccess(d,file,response){
        $("#fileId").val(d.attributes.url);
 		}
        function uploadCallback(callback,inputId){
            var url = $("#fileUrl").val();
            var name= $("#fileName").val();
            callback(url,name,inputId);
    }
</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="deliveryController.do?save">
		<input id="id" name="id" type="hidden" value="${deliveryPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"
					   value="${deliveryPage.title}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">开始时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="startDate" name="startDate" ignore="ignore"
					     value="<fmt:formatDate value='${deliveryPage.startDate}' type="date" pattern="yyyy-MM-dd"/>">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">结束时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="endDate" name="endDate" ignore="ignore"
					     value="<fmt:formatDate value='${deliveryPage.endDate}' type="date" pattern="yyyy-MM-dd"/>">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">发放人:</label>
		      <input class="inputxt" id="givePerson" name="givePerson" ignore="ignore"
					   value="${deliveryPage.givePerson}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系方式:</label>
		      <input class="inputxt" id="contactWay" name="contactWay" ignore="ignore"
					   value="${deliveryPage.contactWay}">
		      <span class="Validform_checktip"></span>
		    </div>
			 <input class="inputxt" type="hidden" id="fileId" name="fileId" ignore="ignore"
					   value="${deliveryPage.fileId}">
			
		     <!--  <label class="Validform_label">上传附件:</label> -->
	<%-- 	      <input class="inputxt" id="fileId" name="fileId" ignore="ignore"
					   value="${militrainingPage.fileId}">
					 --%>
			   <div class="form" id="filediv"></div> 
				<div class="form"><t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="file_Id" view="false" auto="true" uploader="militrainingController.do?saveFiles" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="file_Id" formData="id"></t:upload></div>    
	
	    </fieldset>
  </t:formvalid>
 </body>