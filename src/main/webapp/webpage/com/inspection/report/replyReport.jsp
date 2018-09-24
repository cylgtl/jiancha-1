<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>信访举报</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
	$(function() {
		loadAnonymous();
	});
	
	function loadAnonymous(){
		var anonymous = "${reportPage.anonymous}";
		if(1 == anonymous){
			$("input[type='checkbox']").attr("checked",false);
		}
		changeAnonymous();
	}
	
	function changeAnonymous(){
		var isChecked = $("input[type='checkbox']").is(':checked');
		if(!isChecked){
			$("#name").show();
			$("#phone").show();
		}else{
			$("#name").hide();
			$("#phone").hide();
		}
	}
</script>
<style type="text/css">
 .inputxt{
  height:20px;
 }
</style>
 </head>
 <body style="overflow-y:scroll;" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="reportController.do?save">
		<input id="id" name="id" type="hidden" value="${reportPage.id }">
		<fieldset class="step">
			<div class="form" style="height:20px;">
		      <label class="Validform_label">举报标题:</label>
		      <input class="inputxt" id="title" readonly="readonly" name="title" style="width: 300px" maxlength="150"  
					   value="${reportPage.title}">
		      <span class="Validform_checktip"></span>
		    </div>
			
			<div class="form" style="height:20px;">
		      <label class="Validform_label">受理对象:</label>
			   <select name="roleId" id="roleId" disabled="disabled">
                <c:forEach items="${roleList}" var="role">
                    <option  value="${role.id}" <c:if test="${role.id==reportPage.roleId }">selected="selected"</c:if>>${role.roleName}</option>
                </c:forEach>
              </select>
		    </div>
			
			
		   <div class="form" style="height:20px;">
		     <label class="Validform_label">匿名匿名:</label>
			 <input type="checkbox" class="inputxt" readonly="readonly" onclick="changeAnonymous()" id="anonymous" name="anonymous"  checked="checked">
		      <span class="Validform_checktip"></span>
		    </div>
			
			<div class="form" style="height:20px;" id="name" style="display: none;">
		      <label class="Validform_label">举报人姓名:</label>
		      <input class="inputxt" id="personName" readonly="readonly" name="personName" maxlength="150" ignore="ignore"
					   value="${reportPage.personName}">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form" style="height:20px;" id="phone" style="display: none;">
		      <label class="Validform_label">举报人手机号:</label>
		      <input class="inputxt" id="personPhone" readonly="readonly" name="personPhone" datatype="m" errormsg="手机号码不正确" ignore="ignore"
					   value="${reportPage.personPhone}">
		      <span class="Validform_checktip"></span>
		    </div>
	
		    
		    <div class="form">
		      <label class="Validform_label">内容:</label>  
			   <textarea cols="100"  rows="12"   disabled="disabled" name="content">${reportPage.content}</textarea>
		      <span class="Validform_checktip"></span>
		    </div>
		    
		    
		    <div class="form">
		      <label class="Validform_label">回复内容:</label>  
			   <textarea cols="100"  rows="12"  datatype="*" name="replyContent" id="replyContent">${reportPage.replyContent}</textarea>
		      <span class="Validform_checktip"></span>
		    </div>
		    
	    </fieldset>
  </t:formvalid>
 </body>