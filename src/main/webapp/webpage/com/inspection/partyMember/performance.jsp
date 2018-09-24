<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
  <script type="text/javascript">
	
	function addOnclickPerformance(){   
 		 var tr =  $("#add_performance_one_table_template tr").clone();
	 	 $("#add_performance_table").append(tr);
	 	 resetTrNum('add_performance_table');
    }
	function delOnclickPerformance(){   
		
		$.each( $("#add_performance_table").find("input:checked"), function( index, val ) {
        	var	id=$(this).val();
			$.ajax({
				//请求方式
				    type:'GET',
				    //发送请求的地址以及传输的数据
				    url:"partyMemberController.do?deletePerformance&id="+id,
				    //服务器返回的数据类型
				    dataType:'json',
				    success:function(data){
				        //请求成功函数内容
				    },
				    error:function(jqXHR){
				        //请求失败函数内容
				    }
			});
			
		});
		
       $("#add_performance_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_performance_table');
    }
	$(document).ready(function(){
		$(".datagrid-toolbar").parent().css("width","auto");
		//将表格的表头固定
	    $("#performance_table").createhftable({
	    	height:'200px',
			width:'auto',
			fixFooter:false
			});
});
</script>
<div style="padding: 3px; height: 25px; width:900px;" class="datagrid-toolbar">
<a onclick="addOnclickPerformance()" id="addBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">添加</span></span></a>
<a onclick="delOnclickPerformance()" id="delBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left">删除</span></span></a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="bx_table" style="width: 900px">
	<tr bgcolor="#E6E6E6">
		<td align="center" style="width:100px;text-align:center;" bgcolor="#EEEEEE">序号</td>
		<td align="left" style="width:300px;text-align:center;" bgcolor="#EEEEEE">党小组意见</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">联系人1</td>
		<td align="left" style="width:300px;text-align:center;" bgcolor="#EEEEEE">意见</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">联系人2</td>
		<td align="left" style="width:300px;text-align:center;" bgcolor="#EEEEEE">意见</td>
		<td align="left" style="width:100px;text-align:center;" bgcolor="#EEEEEE">录入时间</td>
	</tr>
	<tbody id="add_performance_table">
		<c:if test="${fn:length(lists)  <= 0 }">
			<tr>
				<td align="center"><input style="width: 20px;" type="checkbox" /></td>
				<td align="left" >
					<input  name="performances[0].partySuggestion"  type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[0].contact1"  type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[0].contactSuggestion1"  type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[0].contact2"  type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[0].contactSuggestion2"  type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[0].inputTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 120px;height:30px"
							   value="">
				</td>
			</tr>
		</c:if>
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="performance" varStatus="stuts">
				<tr>
				<td align="center">
				<input class="inputxt" type="hidden" value="${performance.id}"  name="performances[${stuts.index }].id" >
				<input style="width: 20px;" type="checkbox" value="${performance.id}"/></td>
				<td align="left" >
					<input  name="performances[${stuts.index }].partySuggestion" value="${performance.partySuggestion}" type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[${stuts.index }].contact1" value="${performance.contact1}" type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[${stuts.index }].contactSuggestion1" value="${performance.contactSuggestion1}" type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[${stuts.index }].contact2" value="${performance.contact2}" type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[${stuts.index }].contactSuggestion2" value="${performance.contactSuggestion2}" type="text" maxlength="240">
				</td>
				<td align="left" >
					<input  name="performances[${stuts.index }].inputTime" value="${performance.inputTime}" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 120px;height:30px"
							   value="">
				</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
 