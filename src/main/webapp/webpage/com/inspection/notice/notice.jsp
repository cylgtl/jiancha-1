<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>各种类型通知</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="noticeController.do?save">
		<input id="id" name="id" type="hidden" value="${noticePage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">类型ID,关联数据字典:</label>
		      <input class="inputxt" id="type" name="type" ignore="ignore"
					   value="${noticePage.type}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"
					   value="${noticePage.title}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">发布人:</label>
		      <input class="inputxt" id="release" name="release" ignore="ignore"
					   value="${noticePage.release}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">内容:</label>
		      <input class="inputxt" id="content" name="content" ignore="ignore"
					   value="${noticePage.content}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">发布日期:</label>
		      <input class="inputxt" id="releaseTime" name="releaseTime" ignore="ignore"
					   value="${noticePage.releaseTime}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">截止:</label>
		      <input class="inputxt" id="end" name="end" ignore="ignore"
					   value="${noticePage.end}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createTime" name="createTime" ignore="ignore"
					     value="<fmt:formatDate value='${noticePage.createTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">更新时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="updateTime" name="updateTime" ignore="ignore"
					     value="<fmt:formatDate value='${noticePage.updateTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建人:</label>
		      <input class="inputxt" id="createId" name="createId" ignore="ignore"
					   value="${noticePage.createId}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">部门ID:</label>
		      <input class="inputxt" id="departId" name="departId" ignore="ignore"
					   value="${noticePage.departId}">
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>