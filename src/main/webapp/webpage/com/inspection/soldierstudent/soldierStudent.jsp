<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>大学生毕业生提干</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <!--<script type="text/javascript">
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

	function addOnclick(){   
 		 var tr =  $("#add_merits_one_table_template tr").clone();
	 	 $("#add_merits_table").append(tr);
	 	 resetTrNum('add_merits_table');
    } 
 </script>-->
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="soldierStudentController.do?save">
			<input id="id" name="id" type="hidden" value="${soldierStudentPage.id }">
			
			<table style="width: 680px;" cellpadding="0" cellspacing="1" class="formtable">
			<tbody id="add_merits_table">
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
						<input class="inputxt" id="name" name="name" ignore="ignore"
							   value="${soldierStudentPage.name}">
						<span class="Validform_checktip"></span>
					</td>
				<td align="right">
						<label class="Validform_label">
							性别:
						</label>
				
						<input class="inputxt" id="sex" name="sex" ignore="ignore"
							   value="${soldierStudentPage.sex}">
						<span class="Validform_checktip"></span>
					</td>
				
				</tr>
				<tr>
					<td align="right" >
						<label class="Validform_label">
							部职别:
						</label>
				
						<input class="inputxt" id="jobTitle" name="jobTitle" ignore="ignore"
							   value="${soldierStudentPage.jobTitle}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
				
						<input class="inputxt" id="politicalLandscape" name="politicalLandscape" ignore="ignore"
							   value="${soldierStudentPage.politicalLandscape}">
						<span class="Validform_checktip"></span>
					</td>
	            </tr>
	            <tr>
				
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
						<input class="inputxt" id="nativePlace" name="nativePlace" ignore="ignore"
							   value="${soldierStudentPage.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
		
						<input class="inputxt" id="nationalName" name="nationalName" ignore="ignore"
							   value="${soldierStudentPage.nationalName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生日期:
						</label>
			
						<input class="Wdate" onClick="WdatePicker()" id="birthDay" name="birthDay" ignore="ignore"
							   value="<fmt:formatDate value='${soldierStudentPage.birthDay}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							入伍时间:
						</label>
					
						<input class="Wdate" onClick="WdatePicker()"  id="militaryTime" name="militaryTime" ignore="ignore"
							   value="<fmt:formatDate value='${soldierStudentPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				
				</tr>
				<tr>
					
					<td align="right">
						<label class="Validform_label">
							现军衔:
						</label>
					
						<input class="inputxt" id="nowRank" name="nowRank" ignore="ignore"
							   value="${soldierStudentPage.nowRank}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							军衔时间:
						</label>
				
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="rankTime" name="rankTime" ignore="ignore"
							   value="<fmt:formatDate value='${soldierStudentPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
			
				</tr>
				<tr>
					
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
				
						<input class="inputxt" id="education" name="education" ignore="ignore"
							   value="${soldierStudentPage.education}">
						<span class="Validform_checktip"></span>
					</td>
						<td align="right">
						<label class="Validform_label">
							现专业:
						</label>
					
						<input class="inputxt" id="nowProfessional" name="nowProfessional" ignore="ignore"
							   value="${soldierStudentPage.nowProfessional}">
						<span class="Validform_checktip"></span>
					</td>
		
				</tr>
				<tr>
				
					<td align="right">
						<label class="Validform_label">
							毕业院校:
						</label>
			
						<input class="inputxt" id="graduateSchool" name="graduateSchool" ignore="ignore"
							   value="${soldierStudentPage.graduateSchool}">
						<span class="Validform_checktip"></span>
						</td>
						<td align="right">
						<label class="Validform_label">
							毕业时间:
						</label>
					
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="graduateTime" name="graduateTime" ignore="ignore"
							   value="<fmt:formatDate value='${soldierStudentPage.graduateTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				
				</tr>
				
		
				<tr>
					<td align="right">
						<label class="Validform_label">
							专业:
						</label>
						<input class="inputxt" id="professional" name="professional" ignore="ignore"
							   value="${soldierStudentPage.professional}">
						<span class="Validform_checktip"></span>
					</td>
						<td align="right">
						<label class="Validform_label">
							录取批次:
						</label>

						<select name="essenceWork">
							<option value="一类本科">一类本科</option>
							<option value="二类本科">二类本科</option>
							<option value="三类本科">三类本科</option>
							<option value="研究生">研究生</option>
							<option value="博士">博士</option>
						</select>
						<span class="Validform_checktip"></span>
					</td>
				</tr>

				<tr>
					<td align="right">
						<label class="Validform_label">
							任骨干情况:
						</label>
						<select>
							<option value="班长">班长</option>
								<option value="副班长">副班长</option>
						</select>
						<span class="Validform_checktip"></span>
					</td>
					<td></td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开始时间:
						</label>
					
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="beginTime" name="beginTime" ignore="ignore"
							   value="<fmt:formatDate value='${soldierStudentPage.beginTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
			
					<td align="right">
						<label class="Validform_label">
							结束时间:
						</label>
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="endTime" name="endTime" ignore="ignore"
							   value="<fmt:formatDate value='${soldierStudentPage.endTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							立功情况:
						</label>
					</td>
					<td class="value">
						<label><input name="merit" type="checkbox" value="三等功" />三等功 </label>
						<label><input name="merit" type="checkbox" value="二等功" />二等功 </label>
						<label><input name="merit" type="checkbox" value="一等功" />一等功</label>
						<label><input name="merit" type="checkbox" value="荣誉称号" />荣誉称号</label>
						<label><input name="merit" type="checkbox" value="其他" />其他</label>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
	
				<tr>
					<td align="right">
						<label class="Validform_label">
							立功次数:
						</label>
						<input class="inputxt" id="meritNumber" name="meritNumber" ignore="ignore"
							   value="${soldierStudentPage.meritNumber}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
					<td></td>
				</tr>
   			<c:if test="${fn:length(lists)  > 0 }">
					<c:forEach items="${lists}" var="merit" varStatus="stuts">
					<tr>
					
					<td align="right">
				<!-- 	<a onclick="addOnclick()" id="addBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">添加</span></span></a> -->
						<label class="Validform_label">
							立功类型:<input class="inputxt"  id="meritType" name="meritType" ignore="ignore"
							   value='${merit.meritType}' datatype="n">
								<span class="Validform_checktip"></span>
						</label>
					</td>
					<td align="left">
						立功时间:<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="meritTime" name="meritTime" ignore="ignore"
							   value="<fmt:formatDate value='${merit.meritTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				</c:forEach>
				</c:if>
				<c:if test="${fn:length(lists)  <= 0 }">
					
					<tr>
					
					<td align="right">
				<!-- 	<a onclick="addOnclick()" id="addBtn" href="#" class="l-btn"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left">添加</span></span></a> -->
						<label class="Validform_label">
							立功类型:<input class="inputxt"  id="meritType" name="meritType" ignore="ignore"
							    datatype="n">
								<span class="Validform_checktip"></span>
						</label>
					</td>
					<td align="left">
						立功时间:<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="meritTime" name="meritTime" ignore="ignore"
							/>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				</c:if>
				</tbody>
			</table>
			
		</t:formvalid>
<!-- <table style="display: none">
	<tbody id="add_merits_one_table_template">
		<tr>
				<td align="right">
						<label class="Validform_label">
							立功类型:<input class="inputxt"  name="merits[0].meritType" ignore="ignore"
							   value="" datatype="n">
								<span class="Validform_checktip"></span>
						</label>
					</td>
					<td align="left">
				
						立功时间:<input   name="merits[0].meritTime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 120px;height:30px"
							   value="">
						<span class="Validform_checktip"></span>
					</td>
			</tr>
	</tbody>
</table> -->
 </body>