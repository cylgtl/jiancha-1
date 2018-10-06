<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--360浏览器优先以webkit内核解析-->
    <title>Jeecg 微云快速开发平台</title>
    <style type="text/css">
    </style>
</head>
 <body >
        <div  style="background: #ffffff;text-align: center;">
           <div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center" >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/1.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="${webRoot }/militrainingController.do?militrainingList">军事训练成绩等级评定</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center"  >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/2.png">
				<a style="display: inline-block; text-align: center;width: 100% ; font-size: 16px;" href="#">干部调整配备</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center"  >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/3.png">
				<a style="display: inline-block; text-align: center;width: 100% ; font-size: 16px;" href="#">骨干配备</a>
			</div> 
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center"  >
			<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/4.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="#">士官选取</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center"  >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/5.png">
				<a style="display: inline-block; text-align: center;width: 100% ; font-size: 16px;"  href="#">党员发展</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center" gid="82" >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/6.png">
				<a style="display: inline-block; text-align: center;width: 100% ; font-size: 16px;" href="#">技术学兵选调</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center" gid="71" >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/7.png">
				<a style="display: inline-block; text-align: center;width: 100% ; font-size: 16px;" href="#">优秀士兵保送入学</a>
			</div>
			
			
		     <div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center" gid="72" >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/8.png">
				<a style="display: inline-block; text-align: center;width: 100% ; font-size: 16px;" href="#">大学毕业生士兵提干</a>
			</div>
			
			
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center" gid="89" >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/9.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="#">士兵考学</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center" gid="81" >
			<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/10.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="#">表彰奖励</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center" gid="87" >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/11.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="#">官兵评残</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center" gid="86" >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/12.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="#">军官休假</a>
			</div>
					
					
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center"  >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/13.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="#">战士休假</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center"  >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/14.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="#">被装发放</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center"  >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/15.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="#">通用物资集中采购</a>
			</div>
				
			<div class="item" style="display: inline-block;width: 20%;margin-left: 10px; margin-top:15px ;border:solid 1px green ;text-align: center"  >
				<img style="display: inline-block;width: 200px; height: 200px;display: inline-block"  src="plug-in/image/16.png">
				<a style="display: inline-block; text-align: center;width: 100% ;font-size: 16px;" href="#">副食品定价</a>
			</div>
			
			</div>
<!-- 全局js -->
<script src="plug-in/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="plug-in/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<!--统计代码，可删除-->
</body>
</html>