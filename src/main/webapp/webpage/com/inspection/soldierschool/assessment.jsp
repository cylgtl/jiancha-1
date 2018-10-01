<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
 <script type="text/javascript">

	 function addOnclickResults(){   
		 var count=$("#add_assessments_table tr").length;
		 
	      var tr = $("#assessments_"+count ).html();
	      if(tr.indexOf("<tr>") <=0){
	      	tr = "<tr id=\"assessments_"+count+"\">"+tr+"</tr>";
	      }
		 	$("#add_assessments_table").append(tr);
	    }
	function delOnclickassessments(){   
		$.each( $("#add_assessments_table").find("input:checked"), function( index, val ) {
        	var	id=$(this).val();
			$.ajax({
				//请求方式
				    type:'GET',
				    //发送请求的地址以及传输的数据
				    url:"soldierSchoolController.do?deleteAssessment&id="+id,
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
       $("#add_assessments_table").find("input:checked").parent().parent().remove();   
    
        resetTrNum('add_assessments_table');
    }
	$(document).ready(function(){
		$(".datagrid-toolbar").parent().css("width","auto");
		//将表格的表头固定
	    $("#assessments_table").createhftable({
	    	height:'200px',
			width:'auto',
			fixFooter:false
			});
});
	
	function uploadSuccess(d,file,response){
		if(d){
			var sessionKey = d.attributes.sessionKey;
			$("#"+sessionKey+"_assessmentFile").val(d.attributes.url);
			alert("文件上传成功");
		}
	}
</script>
 <div style="padding: 3px; height: 25px; width: width:1024px;" class="datagrid-toolbar">
<a onclick="addOnclickResults()" id="addBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">添加</span></span></a>
<a onclick="delOnclickassessments()" id="delBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left">删除</span></span></a>
</div> 
<table border="0" cellpadding="2" cellspacing="0" id="assessments_table" style="width: 900px">
	<tr bgcolor="#E6E6E6">
		<td align="left" style="width:100px;" bgcolor="#EEEEEE">序号</td>
		<td align="left" style="width:100px;" bgcolor="#EEEEEE">类型</td>
		<td align="left"  style="width:500px;" bgcolor="#EEEEEE">附件</td>
	</tr>
	<tbody id="add_assessments_table">
		<c:if test="${fn:length(lists)  <= 0 }">
			<tr>
				<td align="left"><input style="width: 20px;" type="checkbox" /></td>
				<td align="left" >
			
				<select name ="assessments[0].pxType">
				<c:forEach items="${pxList}" var="type">
                    <option value="${type.typecode}">${type.typename}</option>
                </c:forEach>
				</select>
				
				</td>
				<td align="left">
					<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess" id="0_assessmentFiles"
				 name="assessments[0].assessmentFiles" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=0" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" formData="id"></t:upload>
					</td>
					<input name="assessments[0].fileId" id="0_assessmentFile" type="hidden"/>
			</tr>
		</c:if>
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="assessment" varStatus="stuts">
				<tr>
				<td align="left">
				<input class="inputxt" type="hidden" value="${assessment.id}"  name="assessments[${stuts.index }].id" >
				<input style="width: 20px;" type="checkbox" value="${assessment.id}"/></td>
				<td align="left">
				<select name="assessments[${stuts.index }].pxType">
				 
				 <c:forEach items="${pxList}" var="type">
                    <option value="${type.typecode}" <c:if test="${type.typecode==assessment.pxType }">selected="selected"</c:if>>${type.typename}</option>
                </c:forEach>
				</select></td>
					<td align="left">
				<c:choose>
   						<c:when test="${empty assessment.fileId}">
   				
			
				<input name="assessments[${stuts.index}].fileId" id="${stuts.index }_assessmentFile" type="hidden" value="${assessment.fileId}"/>
		
					<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess" id="${stuts.index }_assessmentFiles"
				 name="assessments[${stuts.index }].assessmentFiles" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=${stuts.index }" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip"  formData="id"></t:upload>
				
					</c:when>
   
   						<c:otherwise>
   					
   							  <a target="_blank" href="${assessment.fileId}">下载</a>		
   							 
  						</c:otherwise>

					</c:choose>
						</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
 