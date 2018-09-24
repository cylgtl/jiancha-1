<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>副食品定价信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
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
			 <div class="form">
		      <label class="Validform_label">附件地址:</label>
		      <a target="_blank" href="${stapleFoodPage.fileId}">下载</a>

		    </div>
	    </fieldset>
  </t:formvalid>
 </body>