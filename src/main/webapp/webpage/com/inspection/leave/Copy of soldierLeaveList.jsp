<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div  style="padding: 3px; height: 40px">
    <div name="searchColums" style="float: left; padding-left: 15px;">
              <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;" title="营部">营部: </span>
              <select name="depart_parent" id="" onchange="findDepartByParentId(this.value)" style="width: 150px">
                  <option value="">全部</option>
                  <c:forEach var="depart" items="${departList}">
                      <option value="${depart.orgCode}">${depart.departname}</option>
                  </c:forEach>
               </select>
        
              <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;" title="连部">连科: </span>
               <select name="departId" id="departId"  style="width: 150px">
                  <option value="">全部</option>
               </select>
   
         <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="soldierLeaveListsearch();" style="text-align: center;width: 140px">查询</a>
    </div>
</div>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  
  <c:if test="${not empty vistor}"></c:if>
  <t:datagrid name="soldierLeaveList" onLoadSuccess="controllerButton" autoLoadData="true"  title="战士请假" actionUrl="soldierLeaveController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <%-- <t:dgCol title="流程类型" field="type" ></t:dgCol> --%>
  <%--  <t:dgCol title="营部" field="departId" query="true"></t:dgCol> --%>
   <t:dgCol title="姓名" field="name" width="150"></t:dgCol>
   <t:dgCol title="基本信息" field="jobTitle" width="350"></t:dgCol>
   <%-- t:dgCol title="部职别" field="jobTitle" ></t:dgCol>
   <t:dgCol title="休假类型" field="leaveType" ></t:dgCol>
   <t:dgCol title="出生日期" field="birthday" ></t:dgCol>
   <t:dgCol title="入伍时间" field="militaryTime" ></t:dgCol>
   <t:dgCol title="现军衔时间" field="rankTime" ></t:dgCol>
   <t:dgCol title="休假开始时间" field="beginTime" ></t:dgCol>
   <t:dgCol title="休假结束时间" field="endTime" ></t:dgCol>
   <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="更新时间" field="updateTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="创建人ID" field="createId" ></t:dgCol>
   <t:dgCol title="请假天数" field="days" ></t:dgCol> --%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
    <t:dgFunOpt operationCode="zsxj_operate" funname="operateDetail(id)" title="处理" />
	<t:dgFunOpt funname="lookDetail(id)" title="查看" />
   <t:dgDelOpt title="删除" url="soldierLeaveController.do?del&id={id}" /> 
   <t:dgToolBar  title="录入"   operationCode="zsxj_add" icon="icon-add" url="soldierLeaveController.do?addorupdate" height="500" width="950" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑"  operationCode="zsxj_edit" icon="icon-edit" url="soldierLeaveController.do?addorupdate" height="450" width="750" funname="update"></t:dgToolBar>
  </t:datagrid>
  
  
  
  </div>
 </div>
 
 
 
 <script type="text/javascript">
	function operateDetail(id) {
		createwindow('战士请假处理',
				"soldierLeaveController.do?viewMain&id=" + id,
				900, 450);
	}
	function lookDetail(id) {
		//$("#mainTitle").text("战士请假");
		location.href = "soldierLeaveController.do?viewDetailMain&id=" + id;
        /* createwindow('物流详情',
                "soldierLeaveController.do?viewDetailMain&id=" + id,
               900, 450); */
    }
	
	
	$(function(){
		 var vistor = "${vistor}";
		 var user = "${user}";
		 
		 $("a").each(function(index, element) {
	         var href = $(this).attr('href');
	         var onClick = $(this).attr('onclick');
	         var icon = $(this).attr('icon');
	         if("icon-add" == icon){
	        	 if(vistor){
	        		 $(this).hide();
	        	 }
	         }
	         
        	if("icon-edit" == icon){
        		if(vistor || user){
	        		 $(this).hide();
	        	 }
        	}
	    });
	});
	
	
	function controllerButton(){
		 var vistor = "${vistor}";
		 var user = "${user}";
		 $("a").each(function(index, element) {
	         var href = $(this).attr('href');
	         var onClick = $(this).attr('onclick');
	         var icon = $(this).attr('icon');
	        // $(this).parent("[").hide();
	        $('[').replaceWith('');
	        $(']').replaceWith('');
        	 if(onClick){
        		if(onClick.indexOf("operateDetail") > -1){
        			if(vistor || user){
        			 
   	        		 $(this).hide();
   	        	  }
        		} if(onClick.indexOf("delObj") > -1){
        			if(vistor || user){
        				 $(this).hide();
        			}
        		}
        	}
	    });
	}
	
	
	function findDepartByParentId(departId){
		if("" == departId){
			$("#departId").html("<option>全部</option>");
		}else{
			$.ajax({
				async : false,
				cache : false,
				type : 'POST',
				url : "departController.do?findDepartByParentId&parentId="+departId+"&random="+Math.random(),
				error : function() {// 请求失败处理函数
				},
				success : function(data) {
					var list = $.parseJSON(data);
					if(list){
						var html ="<option>全部</option>";
						$.each(list, function(i, depart){  
						    html = html +"<option value=\""+depart.orgCode+"\">"+depart.departname+"</option>";
						}); 
						$("#departId").html(html);
					}
				}
			});
		}
	}
	
</script>