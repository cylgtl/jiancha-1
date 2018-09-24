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
		      <select name="type" id="type" >
                <c:forEach items="${typeList}" var="type">
                    <option value="${type.typename}" <c:if test="${type.typename==militrainingPage.type }">selected="selected"</c:if>>${type.typename}</option>
                </c:forEach>
              </select>
		    </div>
			<div class="form">
		      <label class="Validform_label">序号:</label>
		      <input class="inputxt" id="no" name="no" ignore="ignore"
					   value="${informPage.no}" datatype="n">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore" style="width:500px;"
					   value="${informPage.title}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">内容:</label>
		      <input class="inputxt" name="content" ignore="ignore" style="width:500px; height:75px;"
					   value="${informPage.content}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">发布人:</label>
		      <input class="inputxt" id="head" name="head" ignore="ignore"
					   value="${informPage.head}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">发布时间:</label>
		      <input class="Wdate" onClick="WdatePicker()"  style="width: 200px" id="beginTime" name="beginTime" ignore="ignore"
							   value="<fmt:formatDate value='${informPage.beginTime}' type="date" pattern="yyyy-MM-dd"/>">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">截止时间:</label>
		      <input class="Wdate" onClick="WdatePicker()"  style="width: 200px" id="endTime" name="endTime" ignore="ignore"
							   value="<fmt:formatDate value='${informPage.endTime}' type="date" pattern="yyyy-MM-dd"/>">
		      <span class="Validform_checktip"></span>
		    </div>
			<%-- <div class="form">
		      <label class="Validform_label">创建人:</label>
		      <input class="inputxt" id="createUserId" name="createUserId" ignore="ignore"
					   value="${informPage.createUserId}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">更新人:</label>
		      <input class="inputxt" id="updateUserId" name="updateUserId" ignore="ignore"
					   value="${informPage.updateUserId}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createTime" name="createTime" ignore="ignore"
					     value="<fmt:formatDate value='${informPage.createTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">更新时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="updateTime" name="updateTime" ignore="ignore"
					     value="<fmt:formatDate value='${informPage.updateTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">部分ID:</label>
		      <input class="inputxt" id="departId" name="departId" ignore="ignore"
					   value="${informPage.departId}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">跳转地址:</label>
		      <input class="inputxt" id="url" name="url" ignore="ignore"
					   value="${informPage.url}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">点击次数:</label>
		      <input class="inputxt" id="clickCount" name="clickCount" ignore="ignore"
					   value="${informPage.clickCount}" datatype="n">
		      <span class="Validform_checktip"></span>
		    </div> --%>
	    </fieldset>
  </t:formvalid>
 </body>