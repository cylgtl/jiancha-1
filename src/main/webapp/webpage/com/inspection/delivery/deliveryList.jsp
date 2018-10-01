<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  
  
  
  
    <c:if test="${isOtherRole eq 1 || not empty vistor}">
  <t:datagrid name="deliveryList" title="被装发放信息" actionUrl="deliveryController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标题" field="title" width="60" align="center"></t:dgCol>
   <t:dgCol title="开始时间" field="startDate" formatter="yyyy-MM-dd" width="20" align="center"></t:dgCol>
   <t:dgCol title="结束时间" field="endDate" formatter="yyyy-MM-dd" width="20" align="center"></t:dgCol>
   <t:dgCol title="发放人" field="givePerson" width="20" align="center"></t:dgCol>
   <t:dgCol title="联系方式" field="contactWay"  width="30" align="center" ></t:dgCol>
   <t:dgCol title="附件地址" field="fileId"   width="30" align="center" downloadName="下载" url="fileId" funname="test(fileId)"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="70" align="center"></t:dgCol>
   <t:dgFunOpt funname="lookDetail(id)" title="查看" />
   <%-- <t:dgToolBar title="查看" icon="icon-search" url="deliveryController.do?search" funname="detail"></t:dgToolBar> --%>
  </t:datagrid>
  </c:if>
  

   <c:if test="${not empty manager || not empty admin}">
  <t:datagrid name="deliveryList" title="被装发放信息" actionUrl="deliveryController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标题" field="title" width="60" align="center"></t:dgCol>
   <t:dgCol title="开始时间" field="startDate" formatter="yyyy-MM-dd" width="20" align="center"></t:dgCol>
   <t:dgCol title="结束时间" field="endDate" formatter="yyyy-MM-dd" width="20" align="center"></t:dgCol>
   <t:dgCol title="发放人" field="givePerson" width="20" align="center"></t:dgCol>
   <t:dgCol title="联系方式" field="contactWay"  width="30" align="center" ></t:dgCol>
   <t:dgCol title="附件地址" field="fileId"   width="30" align="center" downloadName="下载" url="fileId" funname="test(fileId)"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="70" align="center"></t:dgCol>
   <t:dgDelOpt title="删除" url="deliveryController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="deliveryController.do?addoredit" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="deliveryController.do?addoredit" funname="update"></t:dgToolBar>
   <t:dgFunOpt funname="lookDetail(id)" title="查看" />
  </t:datagrid>
  </c:if>
  
  
  </div>
 </div>
<script type="text/javascript">
	function lookDetail(id) {
		location.href = "deliveryController.do?addoredit&id=" + id;
    }
</script>