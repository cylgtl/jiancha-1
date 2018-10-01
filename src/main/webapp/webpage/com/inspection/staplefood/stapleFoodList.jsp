<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">


  <c:if test="${isOtherRole eq 1 || not empty vistor}">
  <t:datagrid name="stapleFoodList" title="副食品定价信息" actionUrl="stapleFoodController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="承办人" field="undertakePerson" width="60"></t:dgCol>
   <t:dgCol title="联系方式" field="contactWay" width="60"></t:dgCol>
      <t:dgCol title="附件地址" field="fileId"   width="80" align="center" downloadName="下载" url="fileId" funname="test(fileId)"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   
   <t:dgFunOpt funname="lookDetail(id)" title="查看" />
  </t:datagrid>
  </c:if>
  

   <c:if test="${not empty manager || not empty admin}">
   <t:datagrid name="stapleFoodList" title="副食品定价信息" actionUrl="stapleFoodController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="承办人" field="undertakePerson" width="60"></t:dgCol>
   <t:dgCol title="联系方式" field="contactWay" width="60"></t:dgCol>
      <t:dgCol title="附件地址" field="fileId"   width="80" align="center" downloadName="下载" url="fileId" funname="test(fileId)"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="stapleFoodController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="stapleFoodController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="stapleFoodController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgFunOpt funname="lookDetail(id)" title="查看" />
  </t:datagrid>
 
  
  </c:if>
  </div>
 </div>
 <script type="text/javascript">
	function lookDetail(id) {
		location.href = "stapleFoodController.do?viewFood&id=" + id;
    }
</script>