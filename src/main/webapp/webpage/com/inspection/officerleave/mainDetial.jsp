<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>军官请假</title>
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
  </style>
</head>
<body id="page-top">
  <!-- Navigation-->
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <a class="breadcrumb-item active" href="${webRoot }/officerLeaveController.do?officerLeave">军官请假</a>
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('officerLeaveController.do?viewMainDetial&id=${officerLeaveId}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>监督纠错</a>
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
					<td>${officerLeavePage.entity.name}</td>
					<td>性别：</td>
					<td>${officerLeavePage.entity.sex}</td>
				</tr>
				<tr>
					<td>政治面貌:</td>
					<td >${officerLeavePage.entity.political}</td>
				</tr>
				<tr>
					<td>民族：</td>
					<td>${officerLeavePage.entity.national}</td>
					<td>籍贯：</td>
					<td>${officerLeavePage.entity.nativePlace}</td>
				</tr>
				<tr>
					<td>出生日期:</td>
					<td>
						<fmt:formatDate value='${officerLeavePage.entity.birthday}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>部职别：</td>
					<td>${officerLeavePage.entity.jobTitle}</td>
				</tr>
				<tr>
					<td>入伍时间:</td>
					<td>
						<fmt:formatDate value='${officerLeavePage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>军衔时间:</td>
					<td>
						<fmt:formatDate value='${officerLeavePage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>现军衔:</td>
					<td>${officerLeavePage.entity.nowRank}</td>
					<td>学历:</td>
					<td>${officerLeavePage.entity.educational}</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
	    <div class="col-lg-6">
		  <div class="card mb-3">
			  <div class="card-header">
				  <i class="fa fa-street-view"></i> 个人休假计划</div>
			  <div class="card-body">
				  <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
					  <tr>
						  <th>次数</th>
						  <th>计划休假时间</th>
					  </tr>
					  <tr>
						  <td>${officerLeavePage.ciShi1}</td>
						  <td>${officerLeavePage.jiHuaXiuJia1}(月份)</td>
					  </tr>
					  <tr>
						  <td>${officerLeavePage.ciShi2}</td>
						  <td>${officerLeavePage.jiHuaXiuJia2}(月份)</td>
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
						<i class="fa fa-hand-stop-o"></i> 休假情况</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>总天数</th>
								<th>已休天数</th>
								<th>未休天数</th>
								<th>休假类型</th>
								<th>本次休假天数</th>
							</tr>
							<tr>
								<td>${officerLeavePage.zongTianShu}</td>
								<td>${officerLeavePage.yiXiuTianShu}</td>
								<td>${officerLeavePage.weiXiuTianShu}</td>
								<td>${officerLeavePage.xiuJiaLeiXing}</td>
								<td>${officerLeavePage.benCiXiuJia}</td>
							</tr>
							<tr>
								<th>剩余天数</th>
								<th>起止时间</th>
								<th>离队时间</th>
								<th>销假时间</th>
								<th>在位率</th>
							</tr>
							<tr>
								<td>${officerLeavePage.shengYuTianShu}</td>
								<td>
									<fmt:formatDate value='${officerLeavePage.startTime}' type="date" pattern="yyyy-MM-dd"/>
									—
									<fmt:formatDate value='${officerLeavePage.endTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>
									<fmt:formatDate value='${officerLeavePage.liDuiShiJian}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>
									<fmt:formatDate value='${officerLeavePage.xiaoJiaShiJian}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${officerLeavePage.zaiWeiLv}</td>
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
    <script src="plug-in/layer/layer.js"></script>
    <script src="plug-in/lhgDialog/lhgdialog.min.js"></script>
    
    <script type="text/javascript">
	 function goToReport(url) {
		add('录入',"reportController.do?addorupdate&url=" + url,'reportList',null,400);
	  }
    </script>
  </div>
</body>
</html>