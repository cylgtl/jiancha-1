<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  
  <c:if test="${isOtherRole eq 1 || not empty vistor}">
  <t:datagrid name="partyMemberList" title="党员发展" actionUrl="partyMemberController.do?datagrid&currentDepartId=${currentDepart.orgCode}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="姓名" field="name"  width="150" align="center"></t:dgCol>
   <t:dgCol title="基本信息" field="jobTitle" width="350" align="center"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100" align="center"></t:dgCol>
	<t:dgFunOpt funname="lookDetail(id)" title="查看" />
  </t:datagrid>
  </c:if>
  
  <c:if test="${not empty manager || not empty admin}">
  <t:datagrid name="partyMemberList" title="党员发展" actionUrl="partyMemberController.do?datagrid&currentDepartId=${currentDepart.orgCode}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
    <t:dgCol title="部门" field="departId" hidden="true"></t:dgCol>
   <t:dgCol title="姓名" field="name"  width="150" align="center"></t:dgCol>
   <t:dgCol title="基本信息" field="jobTitle" width="350" align="center"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100" align="center"></t:dgCol>
      <t:dgFunOpt funname="lookDetail(id)" title="查看" />
	<t:dgFunOpt funname="operateDetail(id,departId)" title="处理" />
    <t:dgFunOpt title="删除" funname="deleteConfirm(id,departId)"/> 
	<t:dgToolBar title="录入" icon="icon-add" url="partyMemberController.do?selectType" funname="add" height="400" width="600"></t:dgToolBar>
    <t:dgToolBar title="编辑" icon="icon-edit" url="partyMemberController.do?addorupdate" height="400" width="600" funname="update"></t:dgToolBar>
  </t:datagrid>
  </c:if>
  <div   style="padding: 3px; height: 40px">
    <div name="searchColums" style="float: left; padding-left: 15px;">
    			<select name="type" id="type" style="width:150px">
   					<option value="">全部</option>
   					<option value="入党积极分子">入党积极分子</option>
   					<option value="党员发展">党员发展</option>
   				</select>
              <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;" title="营/部">营/部: </span>
              <select name="depart_parent" id="" onchange="findDepartByParentId(this.value)" style="width: 150px">
                  <option value="">全部</option>
                  <c:forEach var="depart" items="${departList}">
                      <c:choose>
                          <c:when test="${not empty currentDepart && not empty currentDepart.TSPDepart && currentDepart.TSPDepart.orgCode == depart.orgCode }">
                             <option value="${depart.orgCode}"  selected="selected" >${depart.departname}</option>
                         </c:when>
                          <c:otherwise>
                            <option value="${depart.orgCode}">${depart.departname}</option>
                         </c:otherwise>
                       </c:choose>
                  </c:forEach>
               </select>
        
              <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;" title="连/科">连科: </span>
               <select name="departId" id="departId"  style="width: 150px">
                  <option value=${currentDepart.orgCode}>${currentDepart.departname}</option>
               </select>

	              <select name="search" id="search"  style="width: 150px" hidden="true">
                <option value="search">search</option>
             </select>
         <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="partyMemberListsearch();" style="text-align: center;width: 140px">查询</a>
    </div>
</div>
  </div>
 </div>
  <script>
  
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
 	    	alert("您没有权限处理其他连/科的数据");
 	    }
 	   
 	}
 	
	function operateDetail(id,departId) {
		if(admin || sessionDepartsCode.indexOf(departId) > -1){
            location.href = "partyMemberController.do?viewDetailMain&id=" + id+ "&isView=false";
		}else{
			alert("您没有权限处理其他连/科的数据");
		}
	}
	
	function deleteConfirm(id,departId){
		if(admin || sessionDepartsCode.indexOf(departId) > -1){
			delObj('partyMemberController.do?del&id='+id,'partyMemberList');
		}else{
			alert("您没有权限处理其他连/科的数据");
		}
		
	}

	function lookDetail(id) {
		location.href = "partyMemberController.do?viewDetailMain&id=" + id+ "&isView=true";
    }
	
	function findDepartByParentId(departId, currentDepartId = "", currentDepart = ""){
         if("" != departId){
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
                             if (depart.orgCode == currentDepartId){
                                 html = html +"<option selected=\"selected\" value=\""+depart.orgCode+"\">"+depart.departname+"</option>";
                             } else {
                                 html = html +"<option value=\""+depart.orgCode+"\">"+depart.departname+"</option>";
                             }

                         });
                         $("#departId").html(html);
                     }
                 }
             });
         }
     }


     window.onload = function(){
         findDepartByParentId("${currentDepart.TSPDepart.orgCode}","${currentDepart.orgCode}","${currentDepart.departname}")
     }
	
</script>