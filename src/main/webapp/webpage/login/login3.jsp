<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<html>
<head>
<title><t:mutiLang langKey="system.title"/></title>
<link rel="shortcut icon" href="resources/fc/images/icon/favicon.ico">
<link rel="stylesheet" href="plug-in/newLogin/home-css/reset.css"  />
<link rel="stylesheet" href="plug-in/newLogin/home-css/supersized.css"  />
<link rel="stylesheet" href="plug-in/newLogin/home-css/style.css"  />

<link href="plug-in/login/css/icon.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="plug-in/login/css/tipsy.css" media="all" />
</head>
<body>
<div class="container">
	<!-- /container -->
	<div class="row">
		<div class="col-xs-12 hidden-xs" style="margin-top:70px;"> </div>
	</div>
	<div class="row">
		<div class="page-container" style="margin-top: 150px;">
			<h1 style="font-family: 微软雅黑,宋体;font-size: 96px;text-align: center;letter-spacing:15px">敏感事务电子监察系统</h1>
		<form name="formLogin" id="formLogin"
					action="loginController.do?login"
					check="loginController.do?checkuser" method="post">
					<input name="userKey" type="hidden" id="userKey"
						value="D1B5CC2FE46C4CC983C073BCA897935608D926CD32992B5900" />
			<table>
			   <tr>
			   <td style="font-weight: bold;font-size: 16px;">请输入账号:</td>
			   <td colspan="2"><input name="userName" value="manager" type="text" id="userName" class="username" placeholder="请输入账号"></td>
			   </tr>
			   
			    <tr>
			   <td style="font-weight: bold;font-size: 16px;">请输入密码:</td>
			   <td colspan="2"><input type="password" value="123456" id="password" name="password" class="password" placeholder="请输入密码"></td>
			   </tr>
			   
			    <tr>
			   <td style="font-weight: bold;font-size: 16px;">验证码:</td>
			   <td><input name="randCode" type="text" id="randCode" style="width:100px" placeholder="请输入验证码">	
				
				
				</td>
				<td><img id="randCodeImage" src="randCodeImage" style="margin-top: 5px;"/></td>
			   </tr>
			   
			   <tr style="text-align: center;">
			   <td><button style="width: 120px;display: inline-block;float: left;" type="button"  onclick="Login();">登录</button></td>
			   <td style="margin-left: 100px;"><button style="width: 120px;display: inline-block;float: right;" type="button" onclick="vistorLogin()">游客登录</button></td>
			   </tr>
			</table>
		</form>
		</div>
	</div>
	<div class="row">
		</div>
	</div>
</div>
<ul id="supersized" class="quality" style="visibility: visible;">
	<li class="slide-1 activeslide" style="visibility: visible; opacity: 1;">
		<a target="_blank">
			<img src="plug-in/newLogin/2.jpg" style="width: 1583px; left: 0px; top: -324.5px; height: 1108.1px;">
		</a>
	</li>
</ul>
	
	<!-- Link JScript-->
	<script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="plug-in/jquery/jquery.cookie.js"></script>
	<script type="text/javascript" src="plug-in/login/js/jquery-jrumble.js"></script>
	<script type="text/javascript" src="plug-in/login/js/jquery.tipsy.js"></script>
	<script type="text/javascript" src="plug-in/login/js/login.js"></script>
	<script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js"></script>
	<script type="text/javascript">
	   function vistorLogin(){
		   $("#userName").val("vistor");
		   $("#password").val("123456");
		   $("#randCode").val("**********");
		   Login();
	   }
	</script>
</body>
</html>