<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>军事训练等级评定</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="militrainingController.do?save">
		<input id="id" name="id" type="hidden" value="${militrainingPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" datatype="*" maxlength="245"
					   value="${militrainingPage.title}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">分类:</label>
		       <select name="type" id="type">
                <c:forEach items="${typeList}" var="type">
                    <option value="${type.typecode}" <c:if test="${type.typecode==militrainingPage.type }">selected="selected"</c:if>>${type.typename}</option>
                </c:forEach>
            </select>
		      
		    </div>
			<div class="form">
		      <label class="Validform_label">开始时间:</label>
		      <input class="inputxt" id="beginTime" name="beginTime" datatype="*"
					   value="${militrainingPage.beginTime}" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">结束时间:</label>
		      <input class="inputxt" id="endTime" name="endTime" datatype="*"
					   value="${militrainingPage.endTime}" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">负责人:</label>
		      <input class="inputxt" id="head" name="head" ignore="ignore" maxlength="50"
					   value="${militrainingPage.head}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系方式:</label>
		      <input class="inputxt" id="phone" name="phone" ignore="ignore" maxlength="15"
					   value="${militrainingPage.phone}">
		      <span class="Validform_checktip"></span>
		    </div>
		    <input class="inputxt" type="hidden" id="fileId" name="fileId" ignore="ignore"
					   value="${militrainingPage.fileId}">
			
		     <!--  <label class="Validform_label">上传附件:</label> -->
	<%-- 	      <input class="inputxt" id="fileId" name="fileId" ignore="ignore"
					   value="${militrainingPage.fileId}">
					 --%>
			   <div class="form" id="filediv"></div> 
				<div class="form"><t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="file_Id" view="false" auto="true" uploader="fileController.do?saveFiles" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="file_Id" formData="id"></t:upload></div>    
	    </fieldset>
  </t:formvalid>
 </body>