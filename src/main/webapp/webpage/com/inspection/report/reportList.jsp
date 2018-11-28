<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  
  <c:if test="${not empty manager || not empty vistor}">
   <t:datagrid name="reportList" title="信访举报" fitColumns="false"  actionUrl="reportController.do?datagrid&notFiter=1&type=${type}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标题" field="title" width="180" align="center"></t:dgCol>
   <t:dgCol title="url" field="url" hidden="true"></t:dgCol>
   <t:dgCol title="当前状态" field="status" replace="待回复_W,已回复_E" align="center"></t:dgCol>
  <%--  <t:dgCol title="点击查看原始信息" field="url" downloadName="查看详细" url="goToDetail(id,url)"  width="180" funname="goToDetail(id,url)"  ></t:dgCol> --%>
   <t:dgCol title="提交时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
   <t:dgCol title="回复时间" field="replyTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
   <t:dgCol title="反馈人姓名" field="personName" width="100" align="center"></t:dgCol>
   <t:dgCol title="反馈人手机号" field="personPhone" width="150" align="center"></t:dgCol>
   <t:dgCol title="是否匿名" field="anonymous" width="80" replace="匿名_0,实名_1" align="center"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="200" align="center"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="reportController.do?addorupdate&type=${type}" funname="add" height="550"></t:dgToolBar>
   <t:dgFunOpt funname="goToDetail(id,url)" title="查看原始举报信息" />
 </t:datagrid>
  </c:if>
  
  <c:if test="${isOtherRole eq 1  || not empty admin}">
  <t:datagrid name="reportList" title="信访举报" fitColumns="false"  actionUrl="reportController.do?datagrid&isFilter=1&type=${type}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标题" field="title" width="180" align="center"></t:dgCol>
    <t:dgCol title="标题" field="title" width="180" align="center"></t:dgCol>
   <t:dgCol title="url" field="url" hidden="true"></t:dgCol>
 <%--  <t:dgCol title="点击查看原始信息" field="url" downloadName="查看详细"  width="180" funname="goToDetail(id,url)"  ></t:dgCol> --%>
   <t:dgCol title="提交时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
   <t:dgCol title="回复时间" field="replyTime" formatter="yyyy-MM-dd hh:mm:ss" width="150" align="center"></t:dgCol>
   <t:dgCol title="反馈人姓名" field="personName" width="100" align="center"></t:dgCol>
   <t:dgCol title="反馈人手机号" field="personPhone" width="150" align="center"></t:dgCol>
   <t:dgCol title="是否匿名" field="anonymous" width="80" replace="匿名_0,实名_1" align="center"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="350" align="center"></t:dgCol>
   <t:dgFunOpt funname="updateInfo(id,status)" title="编辑" />
   <t:dgFunOpt funname="goToDetail(id,url)" title="查看原始举报信息" />
   <t:dgToolBar title="回复" icon="icon-edit"   url="reportController.do?replyReport&type=${type}" funname="update" height="550"></t:dgToolBar>
   <t:dgDelOpt title="删除" url="reportController.do?del&id={id}" />
<%--    <t:dgToolBar title="录入" icon="icon-add" url="reportController.do?addorupdate&type=${type}" funname="add" height="550"></t:dgToolBar>
 --%>  </t:datagrid>
  </c:if>
  </div>
 </div>
 <script>
	function updateInfo(id,status) {
		if("E" == status){
			  $.messager.show({
                  title : '编辑提示',
                  msg : "举报已经回复无法编辑"
              });
		}else{
			createwindow('举报详情',
					"reportController.do?addorupdate&type=${type}&id=" + id,
					650, 550);
		}
	}
	
	
	function goToDetail(id,url) {
		if(url){
			location.href = url + "&isView=true";
		}else{
			createwindow('原始举报信息',"reportController.do?addorupdate&type=${type}&reportId="+id,650, 600);
		}
	}
</script>