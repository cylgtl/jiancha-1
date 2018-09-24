<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
  <script type="text/javascript">


	function addOnclickRecommends(){   

		 var count=$("#add_recommends_table tr").length;
		var tr = $("#"+count+"_recommends").html();
	      if(tr.indexOf("<tr>") <=0){
	      	tr = "<tr id="+count+"_recommends>"+tr+"</tr>";
	      }
	      
	 	 $("#add_recommends_table").append(tr);
	 	 resetTrNum('add_recommends_table');
  }
    function delOnclickRecommends(){   
    	$.each( $("#add_recommends_table").find("input:checked"), function( index, val ) {
        	var	id=$(this).val();
			$.ajax({
				//请求方式
				    type:'GET',
				    //发送请求的地址以及传输的数据
				    url:"partyMemberController.do?deleteRecommend&id="+id,
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
    	
       $("#add_recommends_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_recommends_table');
    }
	$(document).ready(function(){
		$(".datagrid-toolbar").parent().css("width","auto");
		//将表格的表头固定
	    $("#recommends_table").createhftable({
	    	height:'200px',
			width:'auto',
			fixFooter:false
			});
});
</script>
<div style="padding: 3px; height: 25px; width: 1024px;" class="datagrid-toolbar">
<a onclick="addOnclickRecommends()" id="addBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">添加</span></span></a>
<a onclick="delOnclickRecommends()" id="delBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left">删除</span></span></a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="recommends_table" style="width: 1024px;">
	<tr bgcolor="#E6E6E6">
		<td align="left" style="width:20px;text-align:center;" bgcolor="#EEEEEE">序号</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">评议方</td>
		<td align="left"  style="width:100px;text-align:center;" bgcolor="#EEEEEE">开始时间</td>
		<td align="left"  style="width:100px;text-align:center;" bgcolor="#EEEEEE">结束时间</td>
		<!-- <td align="left"  style="width:200px;text-align:center;" bgcolor="#EEEEEE">评议意见</td> -->
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">应到人数</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">实到人数</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">有效票</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">出勤率</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">赞成票</td>
		<td align="left" style="width:50px;text-align:center;" bgcolor="#EEEEEE">得票率</td>
	</tr>
	<tbody id="add_recommends_table">
		<c:if test="${fn:length(lists)  <= 0 }">
			<tr id="0_recommends">
				<td align="left"  style="width:20px;text-align:center;">
				<input style="width: 20px;" type="checkbox" /></td>
				<td align="left"  style="width:50px;text-align:center;">
				<input style="width: 50px" type="text" id="recommendPerson" name="recommends[0].recommendPerson" ignore="ignore"/>
				</td>
				<td align="left"  style="width:100px;text-align:center;" >
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 100px;height:25px" id="beginTime" name="recommends[0].beginTime" ignore="ignore"/>
				</td>
				<td align="left"  style="width:100px;text-align:center;" >
				<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 100px;height:25px" id="endTime" name="recommends[0].endTime" ignore="ignore"/>
				</td>
				<!-- <td align="left"  style="width:200px;text-align:center;" >
				<input style="width: 200px" type="text" id="suggestion" name="recommends[0].suggestion" ignore="ignore"/>
				</td> -->
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="shouldNumber" onblur="getAttendance(this)" name="recommends[0].shouldNumber" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="hierarchyNumber" onblur="getAttendance(this)" name="recommends[0].hierarchyNumber" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="effective"   onblur="getVote(this)"  name="recommends[0].effective" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="attendance" name="recommends[0].attendance" ignore="ignore"/>
				</td>
				
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="favour" onblur="getVote(this)"  name="recommends[0].favour" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="vote" name="recommends[0].vote" ignore="ignore"/>
				</td>
			</tr>
		</c:if>
		<c:if test="${fn:length(lists)  > 0 }">
			<c:forEach items="${lists}" var="recommend" varStatus="stuts">
				<tr id="${stuts.index }_recommends">
				<td align="left"  style="width:20px;text-align:center;">
						<input class="inputxt" type="hidden" value="${recommend.id}"  name="recommends[${stuts.index }].id" >
						<input value="${recommend.id}" style="width: 20px;" type="checkbox"  /></td>
				<td align="left"  style="width:50px;text-align:center;"  class="value" >
				<input style="width: 50px" type="text" id="recommendPerson"  value="${recommend.recommendPerson}" name="recommends[${stuts.index }].recommendPerson" ignore="ignore"/>
				</td>
				<td align="left"  style="width:100px;text-align:center;" >
					<input class="Wdate" onClick="WdatePicker()" value="${recommend.beginTime}"  style="width: 100px" id="beginTime" name="recommends[${stuts.index }].beginTime" ignore="ignore"/>
				</td>
				<td align="left"  style="width:100px;text-align:center;" >
				<input class="Wdate" onClick="WdatePicker()"  value="${recommend.endTime}" style="width: 100px" id="endTime" name="recommends[${stuts.index }].endTime" ignore="ignore"/>
				</td>
				<%-- <td align="left"  style="width:200px;text-align:center;" >
				<input style="width: 200px" type="text" id="suggestion" value="${recommend.suggestion}" name="recommends[${stuts.index }].suggestion" ignore="ignore"/>
				</td> --%>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="shouldNumber" onblur="getAttendance(this)" value="${recommend.shouldNumber}" name="recommends[${stuts.index }].shouldNumber" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="hierarchyNumber"  onblur="getAttendance(this)" value="${recommend.hierarchyNumber}" name="recommends[${stuts.index }].hierarchyNumber" ignore="ignore"/>
				</td>
				
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="effective"  onblur="getVote(this)" value="${recommend.effective}" name="recommends[${stuts.index }].effective" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="attendance" value="${recommend.attendance}" name="recommends[${stuts.index }].attendance" ignore="ignore"/>
				</td>
			
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="favour" onblur="getVote(this)" value="${recommend.favour}" name="recommends[${stuts.index }].favour" ignore="ignore"/>
				</td>
					<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="vote" value="${recommend.vote}" name="recommends[${stuts.index }].vote" ignore="ignore"/>
				</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<script>

function getAttendance(a){
    var hierarchyNumber =$(a).parent().parent().find("input[id='hierarchyNumber']").val();
    var shouldNumber =$(a).parent().parent().find("input[id='shouldNumber']").val();
    if(hierarchyNumber&&shouldNumber){
   	 var result = (hierarchyNumber/shouldNumber).toFixed(2)*100+"%";
   		$(a).parent().parent().find("input[id='attendance']").val(result);
	
    }
  }
  
function getVote(a){
    var favour = $(a).parent().parent().find("input[id='favour']").val();
    var effective = $(a).parent().parent().find("input[id='effective']").val();
    if(favour&&effective){
   	 var result = (favour/effective).toFixed(2)*100+"%";
   		$(a).parent().parent().find("input[id='vote']").val(result);
	
    }
  }
</script>