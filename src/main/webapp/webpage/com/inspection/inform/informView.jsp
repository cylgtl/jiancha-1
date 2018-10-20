<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>通知</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="informController.do?save">
		<input id="id" name="id" type="hidden" value="${informPage.id }">
		<input id="url" name="url" type="hidden" value="${informPage.url }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">内容:</label>
				<textarea class="inputxt" name="content" ignore="ignore" style="width:500px; height:375px;overflow: auto"
                          disabled="disabled">
						${informPage.content} </textarea>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>