<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="noticeList" title="各种类型通知" actionUrl="noticeController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="类型ID,关联数据字典" field="type" ></t:dgCol>
   <t:dgCol title="标题" field="title" ></t:dgCol>
   <t:dgCol title="发布人" field="release" ></t:dgCol>
   <t:dgCol title="内容" field="content" ></t:dgCol>
   <t:dgCol title="发布日期" field="releaseTime" ></t:dgCol>
   <t:dgCol title="截止" field="end" ></t:dgCol>
   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="更新时间" field="updateTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="创建人" field="createId" ></t:dgCol>
   <t:dgCol title="部门ID" field="departId" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="noticeController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="noticeController.do?addorupdateMany" width="1024" height="600" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="noticeController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="noticeController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>