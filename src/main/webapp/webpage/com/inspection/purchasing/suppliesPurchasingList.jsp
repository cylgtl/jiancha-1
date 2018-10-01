<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  
  
  
  <c:if test="${isOtherRole eq 1 || not empty vistor}">
  <t:datagrid name="suppliesPurchasingList" title="通用物资集中采购" actionUrl="suppliesPurchasingController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="projectName" width="60" align="center" ></t:dgCol>
   <t:dgCol title="供应商" field="suppliers" width="60" align="center" ></t:dgCol>
   <t:dgCol title="承办人" field="undertaker" width="60" align="center" ></t:dgCol>
   <t:dgCol title="联系方式" field="phone"  width="60" align="center"></t:dgCol>
<%--    <t:dgCol title="附件ID" field="fileId" width="60" align="center" ></t:dgCol>
 --%>   <%-- <t:dgCol title="创建人" field="createUserId" ></t:dgCol>
   <t:dgCol title="更新人" field="updateUserId" ></t:dgCol>
   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="更新时间" field="updateTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="部分ID" field="departId" ></t:dgCol> --%>
   <t:dgCol title="操作" field="opt" width="100" align="center"></t:dgCol>
   <t:dgFunOpt funname="lookDetail(id)" title="查看" />
<%--    <t:dgToolBar title="查看" icon="icon-search" url="suppliesPurchasingController.do?addorupdate" funname="detail"></t:dgToolBar>
 --%>  </t:datagrid>
  </c:if>
  

   <c:if test="${not empty manager || not empty admin}">
  <t:datagrid name="suppliesPurchasingList" title="通用物资集中采购" actionUrl="suppliesPurchasingController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="projectName" width="60" align="center" ></t:dgCol>
   <t:dgCol title="供应商" field="suppliers" width="60" align="center" ></t:dgCol>
   <t:dgCol title="承办人" field="undertaker" width="60" align="center" ></t:dgCol>
   <t:dgCol title="联系方式" field="phone"  width="60" align="center"></t:dgCol>
<%--    <t:dgCol title="附件ID" field="fileId" width="60" align="center" ></t:dgCol>
 --%>   <%-- <t:dgCol title="创建人" field="createUserId" ></t:dgCol>
   <t:dgCol title="更新人" field="updateUserId" ></t:dgCol>
   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="更新时间" field="updateTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="部分ID" field="departId" ></t:dgCol> --%>
   <t:dgCol title="操作" field="opt" width="100" align="center"></t:dgCol>
   <t:dgDelOpt title="删除" url="suppliesPurchasingController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="suppliesPurchasingController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="suppliesPurchasingController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgFunOpt funname="lookDetail(id)" title="查看" />
  </t:datagrid>
  
  </c:if>
  </div>
 </div>
 <script type="text/javascript">
	function lookDetail(id) {
		location.href = "suppliesPurchasingController.do?addorupdate&id=" + id;
    }
</script>