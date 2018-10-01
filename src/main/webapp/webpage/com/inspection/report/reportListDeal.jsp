<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="reportList" title="廉情公示" fitColumns="false"  actionUrl="reportController.do?datagrid&isFilter=1" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标题" field="title" width="180"></t:dgCol><%-- 
   <t:dgCol title="内容" field="content" width="200"></t:dgCol> --%>
   <t:dgCol title="当前状态" field="status" replace="待回复_W,已回复_E"></t:dgCol>
   <t:dgCol title="提交时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss" width="150"></t:dgCol>
   <%-- <t:dgCol title="回复人姓名" field="replayUserId" ></t:dgCol> --%>
   <t:dgCol title="回复时间" field="replyTime" formatter="yyyy-MM-dd hh:mm:ss" width="150"></t:dgCol>
   <%-- <t:dgCol title="回复内容" field="replyContent" width="200"></t:dgCol> --%>
   <t:dgCol title="举报人姓名" field="personName" width="100"></t:dgCol>
   <t:dgCol title="举报人手机号" field="personPhone" width="150"></t:dgCol>
   <t:dgCol title="是否匿名" field="anonymous" replace="匿名_0,实名_1"></t:dgCol>
   <%-- <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
   <%-- <t:dgToolBar title="录入" icon="icon-add" url="reportController.do?addorupdate" funname="add" height="550"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="reportController.do?addorupdate" funname="detail" height="550"></t:dgToolBar>
  </t:datagrid>
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
					"reportController.do?addorupdate&id=" + id,
					650, 550);
		}
	}
</script>