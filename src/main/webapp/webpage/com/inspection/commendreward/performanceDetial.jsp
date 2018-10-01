<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">

	
	 
	function jubaoOnclickPerformance(){   
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
<div style="padding: 3px; height: 25px; width:900px;" class="datagrid-toolbar">
<a onclick="jubaoOnclickPerformance()" id="jubao" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">举报</span></span></a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="bx_table" style="width: 900px">
	<tr bgcolor="#E6E6E6">
		<td align="left" style="width:300px;text-align:center;" bgcolor="#EEEEEE">类型</td>
		<td align="left"  style="width:500px;text-align:center;" bgcolor="#EEEEEE">附件</td>
	</tr>
	<tbody id="add_bx_table">
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="performance" varStatus="stuts">
				<tr>
				<td align="left">
				
				 <c:forEach items="${typeList}" var="type">
                     <c:if test="${type.typecode==performance.bxType }">${type.typename}</c:if>
                </c:forEach>
				</td>
				<td align="left">
						  <a target="_blank" href="${performance.fileId}">下载</a>		
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
 