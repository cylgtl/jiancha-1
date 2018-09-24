<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
 <script type="text/javascript">
	
	function addOnclickProves(){   
 		 var tr =  $("#add_proves_one_table_template tr").clone();
	 	 $("#add_proves_table").append(tr);
	 	 resetTrNum('add_proves_table');
    } 
	function delOnclickProves(){  
		$.each( $("#add_proves_table").find("input:checked"), function( index, val ) {
        	var	id=$(this).val();
			$.ajax({
				//请求方式
				    type:'GET',
				    //发送请求的地址以及传输的数据
				    url:"evaluationResidualController.do?deleteProves&id="+id,
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
       $("#add_proves_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_proves_table');
    }
	$(document).ready(function(){
		$(".datagrid-toolbar").parent().css("width","auto");
		//将表格的表头固定
	    $("#proves_table").createhftable({
	    	height:'200px',
			width:'auto',
			fixFooter:false
			});
});
</script>
<div style="padding: 3px; height: 25px; width: width:1024px;" class="datagrid-toolbar">
<a onclick="addOnclickProves()" id="addBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">添加</span></span></a>
<a onclick="delOnclickProves()" id="delBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left">删除</span></span></a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="proves_table" style="width: 900px">
	<tr bgcolor="#E6E6E6">
		<td align="center" style="width:100px;text-align:center;" bgcolor="#EEEEEE">序号</td>
		<td align="left" style="width:150px;text-align:center;" bgcolor="#EEEEEE">证明人</td>
		<td align="left"  style="width:150px;text-align:center;" bgcolor="#EEEEEE">部职别</td>
		<td align="left"  style="width:200px;text-align:center;" bgcolor="#EEEEEE">证明结果</td>
	</tr>
	<tbody id="add_proves_table">
		<c:if test="${fn:length(lists)  <= 0 }">
			<tr>
				<td align="center"><input style="width: 20px;" type="checkbox" /></td>
				<td align="left"><input   name="proves[0].proveName" type="text" style="width: 120px;height:30px"
							   value=""></td>
				<td align="left"><input   name="proves[0].jobTitle" type="text"  style="width: 120px;height:30px"
							   value=""></td>
				 <td align="left"><input   name="proves[0].result" type="text"  style="width: 120px;height:30px"
							   value=""></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="prove" varStatus="stuts">
				<tr>
				<td align="center">
				<input class="inputxt" type="hidden" value="${prove.id}"  name="proves[${stuts.index }].id" >
				<input style="width: 20px;" type="checkbox" value="${prove.id}"/></td>
				<td align="left"><input   name="proves[${stuts.index }].proveName" type="text" style="width: 120px;height:30px"
							   value="${prove.proveName}"></td>
				<td align="left"><input   name="proves[${stuts.index }].jobTitle"  type="text" style="width: 120px;height:30px"
							   value="${prove.jobTitle}"></td>
				 <td align="left"><input   name="proves[${stuts.index }].result"  type="text" style="width: 120px;height:30px"
							   value="${prove.result}"></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
 