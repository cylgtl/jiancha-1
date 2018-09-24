<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px; text-align: center;">
	  <p>请选择要创建的事务类型</p>
	  <button style="width:150px;height:150px;" onclick="save('入党积极分子发展');">入党积极分子发展</button>
	  <button style="width:150px;height:150px;" onclick="save('党员发展');">党员发展</button>
  </div>
 </div>
 <script type="text/javascript">
	function save(swType){
		createwindow('录入',
				"partyMemberController.do?addorupdate&swType="+swType,
				600, 350);
	}
</script>
