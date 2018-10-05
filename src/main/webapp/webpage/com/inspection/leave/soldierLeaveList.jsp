<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  
  <c:if test="${isOtherRole eq 1 || not empty vistor}">
  <t:datagrid name="soldierLeaveList" autoLoadData="true"  title="战士请假" actionUrl="soldierLeaveController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="姓名" field="name" width="150"></t:dgCol>
   <t:dgCol title="基本信息" field="jobTitle" width="350"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="70"></t:dgCol>
	<t:dgFunOpt funname="lookDetail(id)" title="查看" />
  </t:datagrid>
  </c:if>

  <c:if test="${not empty manager || not empty admin}">
  <t:datagrid name="soldierLeaveList" autoLoadData="true"  title="战士请假" actionUrl="soldierLeaveController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="部门" field="departId" hidden="true"></t:dgCol>
   <t:dgCol title="姓名" field="name" width="150"></t:dgCol>
   <t:dgCol title="基本信息" field="jobTitle" width="350"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>

   	<t:dgToolBar  title="录入"   operationCode="zsxj_add" icon="icon-add" url="soldierLeaveController.do?addorupdate" height="500" width="950" funname="add"></t:dgToolBar>
	<t:dgFunOpt operationCode="zsxj_operate" funname="operateDetail(id,departId)" title="处理" />

	<t:dgFunOpt funname="lookDetail(id)" title="查看" />
    <t:dgFunOpt title="删除" funname="deleteConfirm(id,departId)"/> 
    <t:dgToolBar title="编辑"   icon="icon-edit" url="soldierLeaveController.do?addorupdate" height="450" width="750" funname="update"></t:dgToolBar>
  </t:datagrid>
  </c:if>
  
  <div   style="padding: 3px; height: 40px">
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
  
  </div>
 </div>
 
 
 
 
 <script type="text/javascript">
 var sessionDepartsCode = "${sessionDepartsCode}";
 var admin = "${admin}";
	/**
	 * 重写更新事件打开窗口
	 * @param title 编辑框标题
	 * @param url//目标页面地址
	 * @param id//主键字段
	 */

	function update(title,url, id,width,height,isRestful) {
	    gridname=id;
	    var rowsData = $('#'+id).datagrid('getSelections');
	   
	    if (!rowsData || rowsData.length==0) {
	        alert('请选择编辑项目0');
	        return;
	    }
	    if (rowsData.length>1) {
	        alert('请选择一条记录再编辑');
	        return;
	    }
	    
	    var departId = rowsData[0].departId;
	    if(admin || sessionDepartsCode.indexOf(departId) > -1){
	    	 if(isRestful!='undefined'&&isRestful){
	 	        url += '/'+rowsData[0].id;
	 	    }else{
	 	        url += '&id='+rowsData[0].id;
	 	    }
	 	    createwindow(title,url,width,height);
	    }else{
	    	alert("您没有权限处理其他连部的数据");
	    }
	   
	}
	
	
	
	function operateDetail(id,departId) {
		 //alert("处理："+sessionDepartsCode+","+departId +","+admin);
		if(admin || sessionDepartsCode.indexOf(departId) > -1){
			createwindow('战士请假处理',
					"soldierLeaveController.do?viewMain&id=" + id,
					900, 450);
		}else{
			alert("您没有权限处理其他连部的数据");
		}
	}
	
	function deleteConfirm(id,departId){
		if(admin || sessionDepartsCode.indexOf(departId) > -1){
			delObj('soldierLeaveController.do?del&id='+id,'soldierLeaveList');
		}else{
			alert("您没有权限处理其他连部的数据");
		}
		
	}
	function lookDetail(id) {
		location.href = "soldierLeaveController.do?viewDetailMain&id=" + id;
    }
	
	
	function findDepartByParentId(departId){
		if("" == departId){
			$("#departId").html("<option value=\"\">全部</option>");
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
						var html ="<option value=\"\">全部</option>";
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