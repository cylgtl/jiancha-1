<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

  <script type="text/javascript">
	
  
	 function addOnclickResults(){   
		 var count=$("#add_results_table tr").length;
	      var tr = $("#rows_"+count ).html();
	      if(tr.indexOf("<tr>") <=0){
	      	tr = "<tr id=\"rows_"+count+"\">"+tr+"</tr>";
	      }
		 	$("#add_results_table").append(tr);
	    }
	function delOnclickResults(){   
		
		$.each( $("#add_results_table").find("input:checked"), function( index, val ) {
        	var	id=$(this).val();
			$.ajax({
				//请求方式
				    type:'GET',
				    //发送请求的地址以及传输的数据
				    url:"backboneController.do?deleteAuditing&id="+id,
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
		
       $("#add_results_table").find("input:checked").parent().parent().remove();   
   
        resetTrNum('add_results_table');
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
	
	function uploadSuccess(d,file,response){
		if(d){
			var sessionKey = d.attributes.sessionKey;
			$("#"+sessionKey+"_uplodeFile").val(d.attributes.url);
			alert("文件上传成功");
		}
	} 
</script>
<div style="padding: 3px; height: 25px; width: width:1024px;" class="datagrid-toolbar">
<a onclick="addOnclickResults()" id="addBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">添加</span></span></a>
<a onclick="delOnclickResults()" id="delBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left">删除</span></span></a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="results_table" style="width: 900px">
	<tr bgcolor="#E6E6E6">
		<td align="left" bgcolor="#EEEEEE">序号</td>
		<td align="left" bgcolor="#EEEEEE">开始时间</td>
		<td align="left" bgcolor="#EEEEEE">结束时间</td>
		<td align="left" bgcolor="#EEEEEE">单位</td>
		<td align="left" bgcolor="#EEEEEE">意见</td>
		<td align="left" bgcolor="#EEEEEE">附件</td>
	</tr>
<tbody id="add_results_table">
		<c:if test="${fn:length(lists)  <= 0 }">
			<tr>
				<td align="left"><input style="width: 50px;" type="checkbox" name="ck" /></td>
				<td align="left"><input   name="results[0].beginTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 120px;height:30px"
							   value=""></td>
				<td align="left"><input   name="results[0].endTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 120px;height:30px"
							   value=""></td>
				<td align="left"><input  name="results[0].unit"  type="text" maxlength="240" style="width: 150px;"></td>
				<td align="left"><input  name="results[0].suggestion"  maxlength="500" type="text" value=""
					style="width: 250px;"></td>
				<td align="left">
				<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess" id="0_files"
				 	name="results[0].files" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=0" 
				 	extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip"  formData="id">
				</t:upload>
					
				</td>
				
				<input name="results[0].fileId" id="0_uplodeFile" type="hidden"/>
			</tr>
		</c:if>
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="auditing" varStatus="stuts">
				<tr>
					<%-- <td align="center"><input style="width: 50px;" type="checkbox" name="ck" /></td>
					<td align="left"><t:dictSelect
					field="results
[${stuts.index }].deliveryMode" typeGroupCode="fhWay" hasLabel="false" defaultVal="${delivery.deliveryMode}"></t:dictSelect></td>
					<td align="left"><input name="results
[${stuts.index }].priceKg" datatype="/^[\+\-]?\d*?\.?\d*?$/" type="text"
						value="${delivery.priceKg }" style="width: 120px;"></td>
					<td align="left"><input name="results
[${stuts.index }].priceVolume" datatype="/^[\+\-]?\d*?\.?\d*?$/" type="text"
						value="${delivery.priceVolume }" style="width: 120px;"></td>
					<td align="left"><input   name="results
[${stuts.index }].transportationDays" maxlength="50" type="text"
						value="${delivery.transportationDays }" style="width: 120px;"></td>
					<td align="left"><input  name="results
[${stuts.index }].compensateMinDays" maxlength="50" type="text"
						value="${delivery.compensateMinDays }" style="width: 120px;"></td> --%>
						
						<td align="left">
						<input class="inputxt" type="hidden" value="${auditing.id}"  name="results[${stuts.index }].id" >
						<input value="${auditing.id}" style="width: 50px;" type="checkbox"  /></td>
				<td align="left"><input   name="results[${stuts.index }].beginTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 120px;height:30px"
							   value="${auditing.beginTime}"></td>
				<td align="left"><input   name="results[${stuts.index }].endTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 120px;height:30px"
							   value="${auditing.beginTime}"></td>
				<td align="left"><input value="${auditing.unit}"  name="results[${stuts.index }].unit"  type="text" maxlength="240" style="width: 150px;"></td>
				<td align="left"><input value="${auditing.suggestion}"  name="results[${stuts.index }].suggestion"  maxlength="500" type="text" value=""
					style="width: 250px;"></td>
					<td align="left">
					<input name="results[${stuts.index}].fileId" id="${stuts.index }_uplodeFile" type="hidden" value="${auditing.fileId}"/>
		
					<c:choose>
   						<c:when test="${empty auditing.fileId}">
   				
   							<div class="form"><t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="results[${stuts.index}].files" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=${stuts.index }" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="${stuts.index }_files" formData="id"></t:upload></div>    
	
   						</c:when>
   
   						<c:otherwise>
   							  <a target="_blank" href="${auditing.fileId}">下载</a>		
   							 
  						</c:otherwise>

					</c:choose>

					</td>
						<%--  <a target="_blank" href="${auditing.fileId}">查看</a>	 --%>
					
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>