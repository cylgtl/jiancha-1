<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
 
	
	 
     function jubaoOnclickProves(){   
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
	<a onclick="jubaoOnclickProves()" id="jubao" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">举报</span></span></a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="bx_table" style="width: 750px">
	<tr bgcolor="#E6E6E6">
		<td align="left" style="width:100px;text-align:center;" bgcolor="#EEEEEE">证明人</td>
		<td align="left"  style="width:100px;text-align:center;" bgcolor="#EEEEEE">部职别</td>
		<td align="left"  style="width:100px;text-align:center;" bgcolor="#EEEEEE">证明结果</td>
	</tr>
	<tbody id="add_bx_table">
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="prove" varStatus="stuts">
				<tr>
				<td align="left" style="width:100px;text-align:center;" >${prove.proveName}</td>
				<td align="left" style="width:100px;text-align:center;" >${prove.jobTitle}</td>
				 <td align="left" style="width:100px;text-align:center;" >${prove.result}</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
 