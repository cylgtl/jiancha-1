<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style>
    button{
        width: 150px;
        height: 150px;
        display: inline-block;
        padding: .3em .5em;
        background-image: linear-gradient(#7c9abf, #9bc5ec);
        border: 1px solid rgba(0,0,0,.2);
        border-radius: .3em;
        box-shadow: 0 1px white inset;
        text-align: center;
        text-shadow: 0 1px 1px black;
        color:white;
        font-weight: bold;
        font-size: 14px;
    }
    button:active{
        box-shadow: .05em .1em .2em rgba(0,0,0,.6) inset;
        border-color: rgba(0,0,0,.3);
        background: #9bc5ec;
    }
</style>
<div class="easyui-layout">
  <div style="text-align: center; width: 100%;">
	  <p style="margin-top: 80px; font-size: 20px">请选择要创建的事务类型</p>
	  <button onclick="save('1');">入党积极分子发展</button>
	  <button onclick="save('2');">党员发展</button>
  </div>
 </div>
 <script type="text/javascript">
	function save(swType){
		//frameElement.api.cancel(); 
		createwindow('录入',
				"partyMemberController.do?addorupdate&swType="+swType,
				600, 350);
		
	}
</script>
