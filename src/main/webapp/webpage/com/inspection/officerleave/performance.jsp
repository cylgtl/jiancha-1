<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
  <script type="text/javascript">
  var count =0;
  function addOnclickPerformances(){   
	  count = count +1;
      var tr = $("#persons_"+count ).html();
      if(tr.indexOf("<tr>") <=0){
      	tr = "<tr id=\"rows_"+count+"\">"+tr+"</tr>";
      }
  	$("#add_performances_table").append(tr);
 }
	function delOnclickPerformances(){   
		$.each( $("#add_performances_table").find("input:checked"), function( index, val ) {
     	var	id=$(this).val();
			$.ajax({
				//请求方式
				    type:'GET',
				    //发送请求的地址以及传输的数据
				    url:"officerLeaveController.do?deletePerformances&id="+id,
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
    $("#add_performances_table").find("input:checked").parent().parent().remove(); 
    count = count - 1;
    resetTrNum('add_performances_table');
 }
	$(document).ready(function(){
		$(".datagrid-toolbar").parent().css("width","auto");
		//将表格的表头固定
	    $("#performances_table").createhftable({
	    	height:'200px',
			width:'auto',
			fixFooter:false
			});
});
	
	function uploadSuccess(d,file,response){
		if(d){
			var sessionKey = d.attributes.sessionKey;
			$("#"+sessionKey+"_personFile").val(d.attributes.url);
			alert("文件上传成功");
		}
	} 
</script>
<div style="padding: 3px; height: 25px; width: width:1024px;" class="datagrid-toolbar">
<a onclick="addOnclickPerformances()" id="addBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">添加</span></span></a>
<a onclick="delOnclickPerformances()" id="delBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left">删除</span></span></a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="performances_table" style="width: 1024px">
	<tr bgcolor="#E6E6E6">
		<td align="center" style="width:100px;text-align:center;" bgcolor="#EEEEEE">序号</td>
		<td align="left" style="width:300px;text-align:center;" bgcolor="#EEEEEE">类型</td>
		<td align="left"  style="width:500px;text-align:center;" bgcolor="#EEEEEE">附件</td>
	</tr>
		<tbody id="add_performances_table">
		<c:if test="${fn:length(lists)  <= 0 }">
			<tr>
				<td align="center"><input style="width: 20px;" type="checkbox" /></td>
				<td align="left" >
			
				<select name ="performances[0].bxType">
				<c:forEach items="${typeList}" var="type">
                    <option value="${type.typecode}">${type.typename}</option>
                </c:forEach>
				</select>
				
				</td>
				<td align="left">
					<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="performances[0].personFiles" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=0" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="0_personFiles" formData="id"></t:upload>
					</td>
					<input name="performances[0].fileId" id="0_personFile" type="hidden"/>
			</tr>
		</c:if>
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="performance" varStatus="stuts">
				<tr>
				<td align="center">
				<input class="inputxt" type="hidden" value="${performance.id}"  name="performances[${stuts.index }].id" >
				<input style="width: 20px;" type="checkbox" value="${performance.id}"/></td>
				<td align="left">
				<select name="performances[${stuts.index }].bxType">
				 
				 <c:forEach items="${typeList}" var="type">
                    <option value="${type.typecode}" <c:if test="${type.typecode==performance.bxType }">selected="selected"</c:if>>${type.typename}</option>
                </c:forEach>
				</select></td>
				<td align="left">
					<input name="performances[${stuts.index}].fileId" id="${stuts.index }_personFile" type="hidden" value="${performance.fileId}"/>
		
					<c:choose>
   						<c:when test="${empty performance.fileId}">
   				
   							<div class="form"><t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="performances[${stuts.index}].personFiles" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=${stuts.index }" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="${stuts.index }_personFiles" formData="id"></t:upload></div>    
	
   						</c:when>
   
   						<c:otherwise>
   							  <a target="_blank" href="${performance.fileId}">下载</a>		
   							 
  						</c:otherwise>

					</c:choose>

					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table> 