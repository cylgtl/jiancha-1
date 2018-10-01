<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
  <script type="text/javascript">
    $('#addBtn2').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBtn2').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	
	var count =0;
	
	$('#addBtn2').bind('click', function(){   
 		/*  var tr =  $("#add_results_one_table_template tr").clone(); */
 		 var tr ="";
 		/* $('[id^="row_"]').each(function(i){
	 		alert($(this).attr("id"));
        }); */
        count = count +1;
       // var length = $('[id^="row_"]').length;
        //alert(length);
        var tr = $("#rows_"+count ).html();
        if(tr.indexOf("<tr>") <=0){
        	tr = "<tr id=\"rows_"+count+"\">"+tr+"</tr>";
        }
	 	$("#add_results_table").append(tr);
	 	 //resetTrNum('add_results_table');
    });  
	$('#delBtn2').bind('click', function(){   
       $("#add_results_table").find("input:checked").parent().parent().remove();  
       count = count - 1;
        resetTrNum('add_results_table');
    });
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
			var fileKey = d.attributes.fileKey;
			alert(fileKey);
			alert(d.attributes.url);
			$("#"+fileKey+"_uplodfile").val(d.attributes.url);
		}
	} 
</script>
<div style="padding: 3px; height: 25px; width: width:900px;" class="datagrid-toolbar"><a id="addBtn2" href="#">添加</a> <a id="delBtn2" href="#">删除</a></div>
<table border="0" cellpadding="2" cellspacing="0" id="results_table" style="width: 1024px">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="text-align: center">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="text-align: center">开始时间</td>
		<td align="center" bgcolor="#EEEEEE" style="text-align: center">结束时间</td>
		<td align="center" bgcolor="#EEEEEE" style="text-align: center">单位</td>
		<td align="center" bgcolor="#EEEEEE" style="text-align: center">意见</td>
		 <td align="center" bgcolor="#EEEEEE" style="text-align: center">附件</td>
	</tr>
	<tbody id="add_results_table">
		<c:if test="${fn:length(list)  <= 0 }">
			<tr id="row_0">
				<td align="center"><input style="width: 50px;" type="checkbox" name="ck" /></td>
				<td align="center"><input   name="results[0].beginTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 100px;height:25px"
							   value=""></td>
				<td align="center"><input   name="results[0].endTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 100px;height:25px"
							   value=""></td>
				<td align="left"><input  name="results[0].unit"  type="text" maxlength="240" style="width: 150px;height:25px"></td>
				<td align="left"><input  name="results[0].opinion"  maxlength="500" type="text" value=""
					style="width: 250px;height:25px"></td>
				 <td align="left">
					 <t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="0_files" id="0_files" view="false" auto="true"  uploader="fileController.do?saveFiles" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" formData="id"></t:upload> 
					</td> 
				<input name="results[0].file" id="0_uplodeFile" type="hidden"/>
				<input type="hidden" name="results[0].leaveId" value="${leaveId}"/>
			</tr>
		</c:if>
		  <c:if test="${fn:length(list)  > 0 }">
			<c:forEach items="${list}" var="delivery" varStatus="stuts">
				<tr>
				<input type="hidden" name="results[${stuts.index }].leaveId" value="${leaveId}"/>
				<td align="center"><input style="width: 50px;" type="checkbox" name="ck" /></td>
				<td align="center"><input   name="results[${stuts.index }].beginTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 100px;height:25px"
							   value=""></td>
				<td align="center"><input   name="results[${stuts.index }].endTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 100px;height:25px"
							   value=""></td>
				<td align="left"><input  name="results[${stuts.index }].unit"  type="text" maxlength="240" style="width: 150px;;height:25px"></td>
				<td align="left"><input  name="results[${stuts.index }].opinion"  maxlength="500" type="text" value=""
					style="width: 250px;;height:25px"></td>
				<td align="left">
					<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="results[${stuts.index }].files" id="[${stuts.index }]_uplodfile" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=${stuts.index }_files" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip"  formData="id"></t:upload>
					</td>
					<input name="results[${stuts.index }].file" id="${stuts.index }_uplodeFile" type="hidden"/>
					<input type="hidden" name="results[${stuts.index }].leaveId" value="${leaveId}"/>
				</tr>
			</c:forEach>
		</c:if> 
	</tbody>
</table>