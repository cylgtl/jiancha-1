<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>廉情公示</title>
<t:base type="ckeditor,jquery,easyui,tools"></t:base>
 </head>
 <body style="overflow-y: hidden;width: 700px" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="messageController.do?save">
		<input id="id" name="id" type="hidden" value="${messagePage.id }">
		<input id="type" name="type"  value="${type}" type="hidden">
	<fieldset class="step" style="width:700px;">
		 <%--  <input class="inputxt" id="type" name="type"  value="${type}" type="hidden"> --%>
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" 
					   value="${messagePage.title}" style="width:350px" maxlength="200">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form" style="width:900px;">
		       <t:ckeditor name="content"  type="width:900,height:400" value="${messagePage.content}"></t:ckeditor>
		    </div>
	    </fieldset> 
	    
	  <%--   <fieldset class="step">
	    <table style="width: 900px; height: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr style="height:25px">
			<td align="right"><label class="Validform_label"> 标题: </label></td>
			<td class="value"><input class="inputxt" id="title" style="width:250px" name="title" maxlength="200"   value="${messagePage.title}">
		</tr>
	
		<tr>
			<td align="right"><label class="Validform_label"> 内容: </label></td>
			<td ><t:ckeditor name="content"  value="${messagePage.content}" type="width:900,height:450"></t:ckeditor></td>
		</tr>
	</table>
	    </fieldset> --%>
	    

  </t:formvalid>
 </body>