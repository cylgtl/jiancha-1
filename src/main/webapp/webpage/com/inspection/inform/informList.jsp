<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  
  <c:choose>
  	<c:when test="${not empty admin}">
  		<t:datagrid name="informList" title="通知" actionUrl="informController.do?datagrid" idField="id" fit="true">
		   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
		   <t:dgCol title="跳转地址" field="url" hidden="true"></t:dgCol>
		   <t:dgCol title="序号" field="no" width="70" align="center" ></t:dgCol>
		   <t:dgCol title="分类" field="type" width="150" align="center"></t:dgCol>
		   <t:dgCol title="标题" field="title" width="150" align="center" ></t:dgCol>
		   <t:dgCol title="创建单位" field="departId" width="250" align="center" ></t:dgCol>
		  <%--  <t:dgCol title="内容" field="content" width="300" align="center" ></t:dgCol> --%>
		   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
		   <t:dgCol title="操作" field="opt" width="150" align="center"></t:dgCol>
		   <t:dgFunOpt title="查看" funname="viewDetail(id)" />
		    <t:dgFunOpt title="创建事务" funname="createDetail(url,type)" />
		    <t:dgDelOpt title="删除" url="informController.do?del&id={id}" />
			<t:dgToolBar title="录入" icon="icon-add" url="informController.do?addorupdate" funname="add"></t:dgToolBar>
		    <t:dgToolBar title="编辑" icon="icon-edit" url="informController.do?addorupdate" funname="update"></t:dgToolBar>
		  </t:datagrid>
  	</c:when>
  	<c:when test="${not empty manager}">
  		<t:datagrid name="informList" title="通知" actionUrl="informController.do?datagrid" idField="id" fit="true">
		   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
		   <t:dgCol title="跳转地址" field="url" hidden="true"></t:dgCol>
		   <t:dgCol title="序号" field="no" width="70" align="center" ></t:dgCol>
		   <t:dgCol title="分类" field="type" width="150" align="center"></t:dgCol>
		   <t:dgCol title="标题" field="title" width="150" align="center" ></t:dgCol>
		   <t:dgCol title="创建单位" field="departId" width="250" align="center" ></t:dgCol>
		   <%-- <t:dgCol title="内容" field="content" width="300" align="center" ></t:dgCol> --%>
		   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
		   <t:dgCol title="操作" field="opt" width="120" align="center"></t:dgCol>
		   <t:dgFunOpt title="查看" funname="viewDetail(id)" />
		    <t:dgFunOpt title="创建事务" funname="createDetail(url,type)" />
  		</t:datagrid>
  	</c:when>
  	<c:when test="${not empty rlzy}">
  		<t:datagrid name="informList" title="通知" actionUrl="informController.do?datagrid" idField="id" fit="true">
		   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
		   <t:dgCol title="跳转地址" field="url" hidden="true"></t:dgCol>
		   <t:dgCol title="序号" field="no" width="70" align="center" ></t:dgCol>
		   <t:dgCol title="分类" field="type" width="150" align="center"></t:dgCol>
		   <t:dgCol title="标题" field="title" width="150" align="center" ></t:dgCol>
		   <t:dgCol title="创建单位" field="departId" width="250" align="center" ></t:dgCol>
		 <%--   <t:dgCol title="内容" field="content" width="300" align="center" ></t:dgCol> --%>
		   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
		   <t:dgCol title="操作" field="opt" width="150" align="center"></t:dgCol>
		   <t:dgFunOpt title="查看" funname="viewDetail(id)" />
		    <t:dgFunOpt title="编辑" funname="editDetailRlzy(id,type)"></t:dgFunOpt>
		    <t:dgDelOpt title="删除" url="informController.do?del&id={id}" />
			<t:dgToolBar title="录入" icon="icon-add" url="informController.do?addorupdate" funname="add"></t:dgToolBar>
		  </t:datagrid>
  	</c:when>
  	<c:when test="${not empty zzk}">
  		<t:datagrid name="informList" title="通知" actionUrl="informController.do?datagrid" idField="id" fit="true">
		   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
		   <t:dgCol title="跳转地址" field="url" hidden="true"></t:dgCol>
		   <t:dgCol title="序号" field="no" width="70" align="center" ></t:dgCol>
		   <t:dgCol title="分类" field="type" width="150" align="center"></t:dgCol>
		   <t:dgCol title="标题" field="title" width="150" align="center" ></t:dgCol>
		   <t:dgCol title="创建单位" field="departId" width="250" align="center" ></t:dgCol>
		 <%--   <t:dgCol title="内容" field="content" width="300" align="center" ></t:dgCol> --%>
		   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
		   <t:dgCol title="操作" field="opt" width="150" align="center"></t:dgCol>
		   <t:dgFunOpt title="查看" funname="viewDetail(id)" />
		    <t:dgFunOpt title="编辑" funname="editDetailZzk(id,type)"></t:dgFunOpt>
		    <t:dgDelOpt title="删除" url="informController.do?del&id={id}" />
			<t:dgToolBar title="录入" icon="icon-add" url="informController.do?addorupdate" funname="add"></t:dgToolBar>
		  </t:datagrid>
  	</c:when>
  	<c:when test="${not empty wsk}">
  		<t:datagrid name="informList" title="通知" actionUrl="informController.do?datagrid" idField="id" fit="true">
		   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
		   <t:dgCol title="跳转地址" field="url" hidden="true"></t:dgCol>
		   <t:dgCol title="序号" field="no" width="70" align="center" ></t:dgCol>
		   <t:dgCol title="分类" field="type" width="150" align="center"></t:dgCol>
		   <t:dgCol title="标题" field="title" width="150" align="center" ></t:dgCol>
		   <t:dgCol title="创建单位" field="departId" width="250" align="center" ></t:dgCol>
		 <%--   <t:dgCol title="内容" field="content" width="300" align="center" ></t:dgCol> --%>
		   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
		   <t:dgCol title="操作" field="opt" width="150" align="center"></t:dgCol>
		   <t:dgFunOpt title="查看" funname="viewDetail(id)" />
		    <t:dgFunOpt title="编辑" funname="editDetailWsk(id,type)"></t:dgFunOpt>
		    <t:dgDelOpt title="删除" url="informController.do?del&id={id}" />
			<t:dgToolBar title="录入" icon="icon-add" url="informController.do?addorupdate" funname="add"></t:dgToolBar>
		  </t:datagrid>
  	</c:when>
  	<c:otherwise>
  		<t:datagrid name="informList" title="通知" actionUrl="informController.do?datagrid" idField="id" fit="true">
		   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
		   <t:dgCol title="跳转地址" field="url" hidden="true"></t:dgCol>
		   <t:dgCol title="序号" field="no" width="70" align="center" ></t:dgCol>
		   <t:dgCol title="分类" field="type" width="150" align="center"></t:dgCol>
		   <t:dgCol title="标题" field="title" width="150" align="center" ></t:dgCol>
		   <t:dgCol title="创建单位" field="departId" width="250" align="center" ></t:dgCol>
		  <%--  <t:dgCol title="内容" field="content" width="300" align="center" ></t:dgCol> --%>
		   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
		   <t:dgCol title="操作" field="opt" width="100" align="center"></t:dgCol>
		   <t:dgFunOpt title="查看" funname="viewDetail(id)" />
  		</t:datagrid>
  	</c:otherwise>
  </c:choose>
  
  
  </div>
 </div>
 <script>
 function createDetail(url,type) {
		createwindow(type,
				url,
				600, 400);
	}
 function viewDetail(id) {
		createwindow("通知详情",
				"informController.do?addorupdateView&id="+id,
				654, 400);
	}
 function editDetailRlzy(id,type) {
	 if(type == '党员发展' || type == '表彰奖励' || type == '官兵评残'){
		 alert("权限不足，无法编辑此分类");
		 return;
	 }else{
		createwindow("通知编辑",
				"informController.do?addorupdateEdit&id="+id,
				654, 400);
	 }
	}
 function editDetailZzk(id,type) {
	 if(type != '党员发展' && type != '表彰奖励'){
		 alert("权限不足，无法编辑此分类");
		 return;
	 }else{
		createwindow("通知编辑",
				"informController.do?addorupdateEdit&id="+id,
				654, 400);
	 }
	}
 function editDetailWsk(id,type) {
	 if(role == 'wsk' && type != '官兵评残'){
		 alert("权限不足，无法编辑此分类");
		 return;
	 }else{
		createwindow("通知编辑",
				"informController.do?addorupdateEdit&id="+id,
				654, 400);
	 }
	}
 </script>