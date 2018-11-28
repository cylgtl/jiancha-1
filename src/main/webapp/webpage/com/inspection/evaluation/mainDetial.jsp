<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>官兵评残</title>
  <!-- Bootstrap core CSS-->
  <link href="plug-in/startbootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="plug-in/startbootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="plug-in/startbootstrap/css/sb-admin.css" rel="stylesheet">
  <style type="text/css">
	  td{
		  text-align: center;
		  font-size: 12px;
	  }
	  th{
		  text-align: center;
		  font-size: 14px;
	  }
	  .card-header {
		  font-size: 14px;
	  }
	  .file-space:hover{
		  cursor: pointer;
		  color: #007bff !important;
	  }
  </style>
</head>
<body id="page-top">
  <!-- Navigation-->
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <a class="breadcrumb-item active" href="${webRoot }/evaluationResidualController.do?evaluationResidual">官兵评残</a>
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('jiucuo','evaluationResidualController.do?viewMainDetial&id=${evaluationResidualPage.entity.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>监督纠错</a>
      <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('fankui','evaluationResidualController.do?viewMainDetial&id=${evaluationResidualPage.entity.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>情况反馈</a>
            </ol>
      <div class="row">
        <div class="col-lg-6">
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-user-circle"></i> 基本资料</div>
            <div class="card-body">
            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
				<tr>
					<td>姓名：</td>
					<td>${evaluationResidualPage.entity.name}</td>
					<td>性别：</td>
					<td>${evaluationResidualPage.entity.sex}</td>
				</tr>
				<tr>
					<td>身份证：</td>
					<td>${evaluationResidualPage.entity.idCard}</td>
					<td>政治面貌：</td>
					<td>${evaluationResidualPage.entity.political}</td>
				</tr>
				<tr>
					<td>民族：</td>
					<td>${evaluationResidualPage.entity.nationalName}</td>
					<td>籍贯：</td>
					<td>${evaluationResidualPage.entity.nativePlace}</td>
				</tr>
				<tr>
					<td>出生日期：</td>
					<td>
						<fmt:formatDate value='${evaluationResidualPage.entity.birthDay}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>部职别：</td>
					<td>${evaluationResidualPage.entity.jobTitle}</td>
				</tr>
				<tr>
					<td>入伍时间：</td>
					<td>
						<fmt:formatDate value='${evaluationResidualPage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>军衔时间：</td>
					<td>
						<fmt:formatDate value='${evaluationResidualPage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>现军衔：</td>
					<td>${evaluationResidualPage.entity.nowRank}</td>
					<td>学历：</td>
					<td>${evaluationResidualPage.entity.education}</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
	    <div class="col-lg-6">
			  <div class="card mb-3">
				  <div class="card-header">
					  <i class="fa fa-pencil"></i> 证明人</div>
				  <div class="card-body">
					  <table class="table table-bordered" width="100%" cellspacing="0">
						  <tr>
							  <th>证明人一</th>
							  <th>证明人二</th>
						  </tr>
						  <tr>
							  <td>${evaluationResidualPage.zhengMingRen1}</td>
							  <td>${evaluationResidualPage.zhengMingRen2}</td>
						  </tr>
					  </table>
				  </div>
			  </div>
		  </div>
      </div>

	  <div class="row">
			<div class="col-lg-12">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-hand-stop-o"></i> 评残审查</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th rowspan="2" style="vertical-align: middle">个人自述</th>
								<th rowspan="2" style="vertical-align: middle">致残性质</th>
								<th colspan="3">旁证人</th>
							</tr>
							<tr>
								<td>旁证人一</td>
								<td>旁证人二</td>
								<td>旁证人三</td>
							</tr>
							<tr>
								<td class="file-space">
								    <c:if test="${not empty evaluationResidualPage.ziShuFilename}">
								        <a class="fa fa-file-word-o" style="font-size: 50px;" href="./downloadFiles/evaluationResidual/${evaluationResidualPage.id}/${evaluationResidualPage.ziShuFilename}"></a>
								    </c:if>
								</td>
								<td>${evaluationResidualPage.zhiCanXingZhi}</td>
								<td>${evaluationResidualPage.oanZhengRen1}</td>
								<td>${evaluationResidualPage.oanZhengRen2}</td>
								<td>${evaluationResidualPage.oanZhengRen3}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>

	  <div class="row">
			<div class="col-lg-12">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-file-word-o"></i> 残疾评定</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>病情与致残标准符合性</th>
								<th>党委会决议</th>
								<th colspan="2">身份信息</th>
							</tr>
							<tr>
								<td class="file-space" rowspan="2" style="vertical-align: middle">
								    <c:if test="${not empty evaluationResidualPage.fuHeFilename}">
									    <a class="fa fa-file-word-o" style="font-size: 50px;" href="./downloadFiles/evaluationResidual/${evaluationResidualPage.id}/${evaluationResidualPage.fuHeFilename}"></a>
									</c:if>
								</td>
								<td rowspan="2">${evaluationResidualPage.jueYi}</td>
								<td class="file-space">
								    <c:if test="${not empty evaluationResidualPage.shenFenZhengFilename}">
									    <img  src="./downloadFiles/evaluationResidual/${evaluationResidualPage.id}/${evaluationResidualPage.shenFenZhengFilename}"/>
									</c:if>
									<div>身份证</div>
								</td>
								<td class="file-space">
								    <c:if test="${not empty evaluationResidualPage.junGuangZhengFilename}">
									    <img  src="./downloadFiles/evaluationResidual/${evaluationResidualPage.id}/${evaluationResidualPage.junGuangZhengFilename}"/>
									</c:if>
									<div>军官证</div>
								</td>
							</tr>
							<tr>
								<td class="file-space">
								    <c:if test="${not empty evaluationResidualPage.baoZhangKaFilename}">
									    <img  src="./downloadFiles/evaluationResidual/${evaluationResidualPage.id}/${evaluationResidualPage.baoZhangKaFilename}"/>
									</c:if>
									<div>保障卡</div>
								</td>
								<td class="file-space">
								    <c:if test="${not empty evaluationResidualPage.bingLiFilename}">
									    <img  src="./downloadFiles/evaluationResidual/${evaluationResidualPage.id}/${evaluationResidualPage.bingLiFilename}"/>
									</c:if>
									<div>病历复印证</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
    </div>
  
    <!-- Bootstrap core JavaScript-->
    <script src="plug-in/startbootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="plug-in/startbootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="plug-in/startbootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="plug-in/startbootstrap/vendor/chart.js/Chart.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="plug-in/startbootstrap/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="plug-in/startbootstrap/js/sb-admin-charts.min.js"></script>
   <script src="plug-in/lhgDialog/lhgdialog.min.js"></script>
    
    <script type="text/javascript">
	 function goToReport(type, url) {
		add('录入',"reportController.do?addorupdate&type="+type+"&url=" + url,'reportList',null,400);
	  }

	  function viewGeren(){
	     console.log("view gerenzishu...");
	  }
    </script>
  </div>
</body>
</html>