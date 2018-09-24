<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>副食品定价信息</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="stapleFoodController.do?save">
		<input id="id" name="id" type="hidden" value="${stapleFoodPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">承办人:</label>
		      <input class="inputxt" id="undertakePerson" name="undertakePerson" ignore="ignore"
					   value="${stapleFoodPage.undertakePerson}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系方式:</label>
		      <input class="inputxt" id="contactWay" name="contactWay" ignore="ignore"
					   value="${stapleFoodPage.contactWay}">
		      <span class="Validform_checktip"></span>
		    </div>
			 <input class="inputxt" type="hidden" id="fileId" name="fileId" ignore="ignore"
					   value="${stapleFoodPage.fileId}">
			
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