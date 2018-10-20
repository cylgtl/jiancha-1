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
		      <select name="type" id="type" disabled="disabled">
                <c:forEach items="${typeList}" var="type">
                    <option value="${type.typename}" <c:if test="${type.typename==militrainingPage.type }">selected="selected"</c:if>>${type.typename}</option>
                </c:forEach>
              </select>
		    </div>
			<div class="form">
		      <label class="Validform_label">序号:</label>
		      <input class="inputxt" id="no" name="no" ignore="ignore"
					   value="${informPage.no}" datatype="n" disabled="disabled">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore" style="width:500px;"
					   value="${informPage.title}" disabled="disabled">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">内容:</label>
				<textarea class="inputxt" name="content" ignore="ignore" style="width:500px; height:75px;" disabled="disabled">
						${informPage.content} </textarea>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">发布人:</label>
		      <input class="inputxt" id="head" name="head" ignore="ignore"
					   value="${informPage.head}" disabled="disabled">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">发布时间:</label>
		      <input class="Wdate" onClick="WdatePicker()"  style="width: 200px" id="beginTime" name="beginTime" ignore="ignore"
							   value="<fmt:formatDate value='${informPage.beginTime}' type="date" pattern="yyyy-MM-dd"/>" disabled="disabled">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">截止时间:</label>
		      <input class="Wdate" onClick="WdatePicker()"  style="width: 200px" id="endTime" name="endTime" ignore="ignore"
							   value="<fmt:formatDate value='${informPage.endTime}' type="date" pattern="yyyy-MM-dd"/>" disabled="disabled">
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>