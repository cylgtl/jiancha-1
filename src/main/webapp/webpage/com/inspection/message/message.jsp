<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>廉情公示</title>
<t:base type="ckeditor,jquery,easyui,tools"></t:base>
 </head>
 <body style="overflow-y: auto;width: 100%" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="messageController.do?save">
		<input id="id" name="id" type="hidden" value="${messagePage.id }">
		<input id="type" name="type"  value="${type}" type="hidden">
	<fieldset class="step" style="width:100%;">
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" 
					   value="${messagePage.title}" style="width:350px" maxlength="200">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form" style="width:95%">
		       <t:ckeditor name="content" value="${messagePage.content}"></t:ckeditor>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>