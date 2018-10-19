<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="militrainingList" title="军事训练等级评定" actionUrl="militrainingController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标题" field="title" width="150" align="center"></t:dgCol>
   <t:dgCol title="分类" field="type" width="120" align="center"></t:dgCol>
   <t:dgCol title="开始时间" field="beginTime" width="120" align="center"></t:dgCol>
   <t:dgCol title="结束时间" field="endTime" width="120" align="center"></t:dgCol>
   <t:dgCol title="负责人" field="head" width="90" align="center"></t:dgCol>
   <t:dgCol title="上传单位" field="departId" width="200" align="center"></t:dgCol>
   <t:dgCol title="联系方式" field="phone" width="110" align="center"></t:dgCol>
   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="130"></t:dgCol>
   <t:dgCol title="附件" width="50" field="fileId" downloadName="下载" url="fileId" funname="test(fileId)"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="militrainingController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="militrainingController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="militrainingController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="militrainingController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>