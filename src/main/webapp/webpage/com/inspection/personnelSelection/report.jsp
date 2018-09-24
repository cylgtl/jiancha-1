<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">

	function addOnclickReports(){   
 		 var tr =  $("#add_reports_one_table_template tr").clone();
	 	 $("#add_reports_table").append(tr);
	 	 resetTrNum('add_reports_table');
    } 
	function delOnclickReports(){  
		
		$.each( $("#add_reports_table").find("input:checked"), function( index, val ) {
        	var	id=$(this).val();
			$.ajax({
				//请求方式
				    type:'GET',
				    //发送请求的地址以及传输的数据
				    url:"personnelSelectionController.do?deleteReport&id="+id,
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
		
       $("#add_reports_table").find("input:checked").parent().parent().remove();   
       
        resetTrNum('add_reports_table');
    }
	$(document).ready(function(){
		$(".datagrid-toolbar").parent().css("width","auto");
		//将表格的表头固定
	    $("#reports_table").createhftable({
	    	height:'200px',
			width:'auto',
			fixFooter:false
			});
});
	
	function uploadSuccess(d,file,response){
		console.log(d);
        //$(this).val(d.attributes.url);
 		}
    function uploadCallback(callback,inputId){
            var url = $("#fileUrl").val();
            var name= $("#fileName").val();
            callback(url,name,inputId);
    }
</script>

<div style="padding: 3px; height: 25px; width: width:1024px;" class="datagrid-toolbar">
<a onclick="addOnclickReports()" id="addBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">添加</span></span></a>
<a onclick="delOnclickReports()" id="delBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left">删除</span></span></a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="reports_table" style="width: 900px">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="left" bgcolor="#EEEEEE">举报标题</td>
		<td align="left" bgcolor="#EEEEEE">举报附件</td>
		<td align="left" bgcolor="#EEEEEE">匿名</td>
		<td align="left" bgcolor="#EEEEEE">描述</td>
	</tr>
	<tbody id="add_reports_table">
		<c:if test="${fn:length(lists)  <= 0 }">
			<tr>
				<td align="center"><input style="width: 50px;" type="checkbox" name="ck" /></td>
				<td align="left"><input  name="reports[0].title"  type="text" maxlength="240" style="width: 150px;"></td>
				<td align="left">
					<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="reports[0].fileId" view="false" auto="true" uploader="militrainingController.do?saveFiles" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="file_Id" formData="id"></t:upload>
					</td>
				<td align="left"><input  name="reports[0].isAnonymity"  type="text" maxlength="240" style="width: 150px;"></td>
				<td align="left"><input  name="reports[0].describe"  maxlength="500" type="text" value=""
					style="width: 250px;"></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="reports" varStatus="stuts">
				<tr>
						<td align="center">
						<input class="inputxt" type="hidden" value="${auditing.id}"  name="reports[${stuts.index }].id" >
						<input value="${reports.id}" style="width: 50px;" type="checkbox"  /></td>
				<td align="left"><input value="${reports.title}"  name="reports[${stuts.index }].title"  type="text" maxlength="240" style="width: 150px;"></td>
				<td align="left">
					<c:choose>
   						<c:when test="${reports.fileId==null}">
   						  <input class="inputxt" type="hidden" id="fileId" name="reports[${stuts.index }].fileId" ignore="ignore">
   							<div class="form"><t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="file_Id" view="false" auto="true" uploader="militrainingController.do?saveFiles" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="file_Id" formData="id"></t:upload></div>    
	
   						</c:when>
   
   						<c:otherwise>
   							  <a target="_blank" href="${reports.fileId}">下载</a>		
  						</c:otherwise>

					</c:choose>

					</td>
				<td align="left"><input value="${reports.isAnonymity}"  name="reports[${stuts.index }].isAnonymity"  type="text" maxlength="240" style="width: 150px;"></td>
				<td align="left"><input value="${reports.describe}"  name="reports[${stuts.index }].describe"  maxlength="500" type="text" value=""
					style="width: 250px;"></td>
				
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>