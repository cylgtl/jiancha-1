<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

  <script type="text/javascript">
 	function jubaoOnclickResults(){   
		createwindow('实时举报',
        		"reportController.do?addorupdate",
                700, 500);
		}
		
	$(document).ready(function(){
		$(".datagrid-toolbar").parent().css("width","auto");
		//将表格的表头固定
	    $("#results_table").createhftable({
	    	height:'200px',
			width:'auto',
			fixFooter:false
			});
});

</script>
<div style="padding: 3px; height: 25px; width: width:1024px;" class="datagrid-toolbar">
<a onclick="jubaoOnclickResults()" id="jubao" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">举报</span></span></a>
</div>

<table border="0" cellpadding="2" cellspacing="0" id="results_table" style="width: 650px">
	<tr bgcolor="#E6E6E6">

		<td align="left" bgcolor="#EEEEEE">开始时间</td>
		<td align="left" bgcolor="#EEEEEE">结束时间</td>
		<td align="left" bgcolor="#EEEEEE">单位</td>
		<td align="left" bgcolor="#EEEEEE">意见</td>
		<!-- <td align="left" bgcolor="#EEEEEE">附件</td> -->
	</tr>
	<tbody id="add_results_table">
		
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="auditing" varStatus="stuts">
				<tr>
				
				
				<td align="left">${auditing.beginTime}</td>
				<td align="left">${auditing.endTime}</td>
				<td align="left">${auditing.unit}</td>
				<td align="left">${auditing.suggestion}</td>
					<%-- <td align="left">
				
   							  <a target="_blank" href="${auditing.fileId}">下载</a>		
  					
					</td> --%>
			
				
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>