<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	 
	function jubaoOnclickRecommends(){   
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
<a onclick="jubaoOnclickRecommends()" id="jubao" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">举报</span></span></a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="recommends_table" style="width: 1024px;">
	<tr bgcolor="#E6E6E6">
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">评议方</td>
		<td align="left"  style="width:100px;text-align:center;" bgcolor="#EEEEEE">开始时间</td>
		<td align="left"  style="width:100px;text-align:center;" bgcolor="#EEEEEE">结束时间</td>
		<td align="left"  style="width:200px;text-align:center;" bgcolor="#EEEEEE">评议意见</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">应到人数</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">赞成票</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">有效票</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">实到人数</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">得票率</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">出勤率</td>
	</tr>
	<tbody id="add_recommends_table">
		
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="recommend" varStatus="stuts">
				<tr>
				<td align="left"  style="width:50px;text-align:center;"  class="value" >${recommend.recommendPerson}
				</td>
				<td align="left"  style="width:100px;text-align:center;" >${recommend.beginTime}
				</td>
				<td align="left"  style="width:100px;text-align:center;" >${recommend.endTime}
				</td>
				<td align="left"  style="width:200px;text-align:center;" >${recommend.suggestion}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >${recommend.shouldNumber}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >${recommend.favour}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >${recommend.effective}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >${recommend.hierarchyNumber}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >${recommend.vote}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >${recommend.attendance}
				</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>