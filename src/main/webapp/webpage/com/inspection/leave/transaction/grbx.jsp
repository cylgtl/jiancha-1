<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
  <script type="text/javascript">
  
  $('#addBtn1').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBtn1').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	
	$(document).ready(function(){
		
		$(".datagrid-toolbar").parent().css("width","auto");
		//将表格的表头固定
	    $("#bx_table").createhftable({
	    	height:'200px',
			width:'auto',
			fixFooter:false
			});
});
	
	var countIndex =0;
	
	$('#addBtn1').bind('click', function(){   
 		 //var tr =  $("#add_bx_one_table_template tr").clone();
	 	 //$("#add_bx_table").append(tr);
	 	// resetTrNum('add_bx_table');
 		    countIndex = countIndex +1;
 	        var tr = $("#persons_"+countIndex ).html();
 	        if(tr.indexOf("<tr>") <=0){
 	        	tr = "<tr id=\"rows_"+countIndex+"\">"+tr+"</tr>";
 	        }
 		 	$("#add_bx_table").append(tr);
    });  
	
	$('#delBtn1').bind('click', function(){   
       $("#add_bx_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bx_table');
    });

	function onuploadsuccess(d,file,response) {
		if(d){
			var sessionKey = d.attributes.sessionKey;
			$("#"+sessionKey+"_personFile").val(d.attributes.url);
			alert("文件上传成功");
			
		}
	}
</script>
<div style="padding: 3px; height: 25px; width: width: 900px;" class="datagrid-toolbar"><a id="addBtn1" href="#">添加</a> <!-- <a id="delBtn1" href="#">删除</a> --></div>
<table border="0" cellpadding="2" cellspacing="0" id="bx_table" style="width: 900px">
	<tr bgcolor="#E6E6E6">
		<td align="center" style="width:100px;text-align:center;" bgcolor="#EEEEEE">序号</td>
		<td align="left" style="width:300px;text-align:center;" bgcolor="#EEEEEE">类型</td>
		<td align="left"  style="width:500px;text-align:center;" bgcolor="#EEEEEE">附件</td>
	</tr>
	<tbody id="add_bx_table">
		<c:if test="${fn:length(list)  <= 0 }">
			<tr>
				<td align="center" style="width:100px;"><input style="width: 20px;" type="checkbox" name="ck" /></td>
				<td align="left" style="width:300px"> 
				<select name="performances[0].type" >
                <c:forEach items="${typeList}" var="type">
                    <option  value="${type.id}">${type.typename}</option>
                </c:forEach>
              </select>
              </td>
				<td align="left" style="width:500px;">
					<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="onuploadsuccess"
				 name="performances[0].personFiles" id="0_personFiles" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=0" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip"  formData="id"></t:upload>
					</td>
					<input type="hidden" name="performances[0].file" id="0_personFile"/>
					<input type="hidden" name="performances[0].leaveId" value="${leaveId}"/>
			</tr>
		</c:if>
		<c:if test="${fn:length(list)  > 0 }">
			<c:forEach items="${list}" var="delivery" varStatus="stuts">
				<tr>
				<td align="center"><input style="width: 20px;" type="checkbox" name="ck" /></td>
				<td align="left">
				<select name="performances[${stuts.index }].type" id="type" >
                <c:forEach items="${typeList}" var="type">
                    <option  value="${type.id}">${type.typename}</option>
                </c:forEach>
              </select>
				</td>
				<td align="left">
					<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="onuploadsuccess"
				 name="performances[${stuts.index }].personFiles" id="${stuts.index }_personFiles" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=${stuts.index }" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" formData="id"></t:upload>
					</td>
					<input type="hidden" name="performances[${stuts.index }].file" id="${stuts.index }_personFile" />
					<input type="hidden" name="performances[${stuts.index }].leaveId" value="${leaveId}"/>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>