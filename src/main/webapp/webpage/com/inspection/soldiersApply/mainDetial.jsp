<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>士兵考学事务处理</title>
</head>
 <script type="text/javascript">
	function jubaoOnclickMyselfInfo(){   
		createwindow('实时举报',
        		"reportController.do?addorupdate",
                700, 500);
	}
		
	$(document).ready(function(){
		$(".datagrid-toolbar").parent().css("width","auto");
	
});

</script>
<body style="overflow-y: hidden" scroll="no">
		<input id="id" name="id" type="hidden" value="${residualId}">
		<div  style="width: 1024px; height: 400px;"><%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
	   	<div style="width:auto; height: 1px;"></div>
		<!--关联信息-->
		<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
			<t:tab href="soldiersApplyController.do?viewMyselfInfo&id=${residualId}&funname=detial" icon="icon-search" title="基本资料" id="1"></t:tab>
			<t:tab href="soldiersApplyController.do?viewResidualRecommend&id=${residualId}&funname=detial" icon="icon-search" title="民族评议/推荐" id="2"></t:tab>
			<t:tab href="soldiersApplyController.do?viewAuditing&id=${residualId}&funname=detial" icon="icon-search" title="各级研究意见和结果" id="3"></t:tab>
			<t:tab href="soldiersApplyController.do?viewPerformance&id=${residualId}&funname=detial" icon="icon-search" title="个人平时表现" id="4"></t:tab>
			<t:tab href="soldiersApplyController.do?viewAssessment&id=${residuald}&funname=detial" icon="icon-search" title="考核结果" id="5"></t:tab>
		</t:tabs>
		</div>
</body>
</html>