<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>战士请假事务处理</title>
<script type="text/javascript">
  //初始化下标
	function resetTrNum(tableId) {
		$tbody = $("#"+tableId+"");
		$tbody.find('>tr').each(function(i){
			$(':input, select', this).each(function(){
				var $this = $(this), name = $this.attr('name'), val = $this.val();
				if(name!=null){
					if (name.indexOf("#index#") >= 0){
						$this.attr("name",name.replace('#index#',i));
					}else{
						var s = name.indexOf("[");
						var e = name.indexOf("]");
						var new_name = name.substring(s+1,e);
						$this.attr("name",name.replace(new_name,i));
					}
				}
			});
		});
	}
  
    $(function(){
    	var customerId = "${customer.id }";
    	if("" == customerId || null == customerId){
    		$("#password").val(RndNum(8));
    	}
    });
    
    function RndNum(n) {
        var rnd = "";
        for (var i = 0; i < n; i++) {
            rnd += Math.floor(Math.random() * 10);
        }
        return rnd;
    }
 </script>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="soldierStudentController.do?addorupdateOperate&id=${residuald}">
		<div style="width: 1024px; height: 500px"><%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
	   	<div style="width:auto; height: 1px;"></div>
		<!--关联信息-->
		<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
			<t:tab href="soldierStudentController.do?viewMyselfInfo&id=${residuald}" icon="icon-search" title="基本资料" id="1"></t:tab>
			<t:tab href="soldierStudentController.do?viewResidualRecommend&id=${residuald}" icon="icon-search" title="民主评议/推荐" id="2"></t:tab>
			<t:tab href="soldierStudentController.do?viewAuditing&id=${residuald}" icon="icon-search" title="各级研究意见和结果" id="3"></t:tab>
			<t:tab href="soldierStudentController.do?viewPerformance&id=${residuald}" icon="icon-search" title="个人平时表现" id="4"></t:tab>
			<t:tab href="soldierStudentController.do?viewAssessment&id=${residuald}" icon="icon-search" title="培训与考核结果" id="5"></t:tab>
		</t:tabs>
		</div>
	</t:formvalid>
	
	<!-- 各级研究意见和结果 -->
  <table style="display: none">
	<tbody id="add_results_one_table_template">
		 	<!--先循环出10条信息-->
 	<c:forEach  begin="1" end="10" varStatus="status" var="index">
 	      <tr id="rows_${index}">
				<td align="left"><input style="width: 50px;" type="checkbox" name="ck" /></td>
				<td align="left"><input   name="results[${index}].beginTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 120px;height:30px"
							   value=""></td>
				<td align="left"><input   name="results[${index}].endTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 120px;height:30px"
							   value=""></td>
				<td align="left"><input  name="results[${index}].unit"  type="text" maxlength="240" style="width: 150px;"></td>
				<td align="left"><input  name="results[${index}].suggestion"  maxlength="500" type="text" value=""
					style="width: 250px;"></td>
				<td align="left">
				<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="results[${index }].files" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=${index}" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="${index }_files" formData="id"></t:upload>
					</td>
					<input name="results[${index}].fileId" id="${index}_uplodeFile" type="hidden"/>
					
			</tr>
			</c:forEach>
	</tbody>
	
	
	
	
	<tbody id="add_performances_one_table_template">
		 	<!--先循环出10条信息-->
 	<c:forEach  begin="1" end="10" varStatus="status" var="index">
 	      <tr id="persons_${index}">
		
				<td align="left"><input style="width: 50px;" type="checkbox" name="ck" /></td>
				<td align="left">
				<select name="performances[${index}].bxType">
				 
				 <c:forEach items="${typeList}" var="type">
                    <option value="${type.typecode}">${type.typename}</option>
                </c:forEach>
				</select></td>
				
				<td align="left">
				<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="performances[${index}].personFiles" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=${index}" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="${index}_personFiles" formData="id"></t:upload>
					</td>
					<input type="hidden" name="performances[${index}].fileId" id="${index}_personFile" />
			</tr>
			</c:forEach>
	</tbody>

	
	
	<tbody id="add_recommends_one_table_template">
		<c:forEach  begin="1" end="10" varStatus="status" var="index">
 		<tr  id="${index}_recommends">
				<td align="left"  style="width:20px;text-align:center;">
				<input style="width: 20px;" type="checkbox" /></td>
				<td align="left"  style="width:50px;text-align:center;">
				<input style="width: 50px" type="text" id="recommendPerson" name="recommends[${index}].recommendPerson" ignore="ignore"/>
				</td>
				<td align="left"  style="width:100px;text-align:center;" >
					<input class="Wdate" onClick="WdatePicker()"  style="width: 100px" id="beginTime" name="recommends[${index}].beginTime" ignore="ignore"/>
				</td>
				<td align="left"  style="width:100px;text-align:center;" >
				<input class="Wdate" onClick="WdatePicker()"  style="width: 100px" id="endTime" name="recommends[${index}].endTime" ignore="ignore"/>
				</td>
				<!-- <td align="left"  style="width:200px;text-align:center;" >
				<input style="width: 200px" type="text" id="suggestion" name="recommends[${index}].suggestion" ignore="ignore"/>
				</td> -->
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="shouldNumber" onblur="getAttendance(this)" name="recommends[${index}].shouldNumber" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="hierarchyNumber"  onblur="getAttendance(this)" name="recommends[${index}].hierarchyNumber" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="effective"  onblur="getVote(this)"  name="recommends[${index}].effective" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="attendance" name="recommends[${index}].attendance" ignore="ignore"/>
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="favour"  onblur="getVote(this)"  name="recommends[${index}].favour" ignore="ignore"/>
				</td>
				
				
				<td align="left"  style="width:50px;text-align:center;" >
				<input style="width: 50px" type="text" id="vote" name="recommends[${index}].vote" ignore="ignore"/>
				</td>
				
			</tr>
			</c:forEach>
			</tbody>
			

<tbody id="add_assessments_table_template">
		<c:forEach  begin="1" end="10" varStatus="status" var="index">
		<tr id="assessments_${index}">
				<td align="left"><input style="width: 50px;" type="checkbox" name="ck" /></td>
				<td align="left">
				<select name="assessments[${index}].pxType">
				 
				 <c:forEach items="${pxList}" var="type">
                    <option value="${type.typecode}">${type.typename}</option>
                </c:forEach>
				</select>
				</td>
				<td align="left">
					<t:upload dialog="false"   buttonText="上传附件" onUploadSuccess="uploadSuccess"
				 name="assessments[${index}].assessmentFiles" view="false" auto="true" uploader="fileController.do?saveFiles&sessionKey=${index}" 
				 extend=".jpg;*,jpeg;*.png;*.gif;*.bmp;*.ico;*.tif;*.xls;*.doc;*.rar;*.txt;*.zip" id="${index}_assessmentFiles" formData="id"></t:upload>
					</td>
					<input type="hidden" name="assessments[${index}].fileId" id="${index}_assessmentFile" />
			</tr>
			</c:forEach>
	</tbody>
	
</table>

<!--个人平时表现-->

</body>
</html>