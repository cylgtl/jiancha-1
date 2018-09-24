<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="messageList" title="廉情公示" actionUrl="messageController.do?datagrid&type=0" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
  <t:dgCol title="标题" field="title" width="150"></t:dgCol>
   <%-- <t:dgCol title="具体内容" field="content" width="250"></t:dgCol> --%>
   <t:dgCol title="创建时间" field="createTime" width="120" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="更新时间" field="updateTime" width="120" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <%-- <t:dgCol title="状态" field="status" replace="无效_D,正常_E"></t:dgCol> --%>
   <%-- <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="messageController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>