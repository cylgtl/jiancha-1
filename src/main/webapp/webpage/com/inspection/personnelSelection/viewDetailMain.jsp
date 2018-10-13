<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>技术学兵选调</title>
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
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <a class="breadcrumb-item active" href="${webRoot }/personnelSelectionController.do?personnelSelection">技术学兵选调</a>
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('personnelSelectionController.do?viewDetailMain&id=${id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
      </ol>
      <div class="row">
        <div class="col-lg-6">
          <div class="card mb-3">
            <div class="card-header">
				<i class="fa fa-user-circle"></i> 个人基本信息</div>
            <div class="card-body">
            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
				<tr>
					<td>姓名：</td>
					<td>${personnelSelectionPage.entity.name}</td>
					<td>性别：</td>
					<td>${personnelSelectionPage.entity.sex}</td>
				</tr>
				<tr>
					<td>出生时间：</td>
					<td>
						<fmt:formatDate value='${personnelSelectionPage.entity.birthday}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>政治面貌：</td>
					<td>${personnelSelectionPage.entity.politicalStatus}</td>
				</tr>
				<tr>
					<td>籍贯：</td>
					<td>${personnelSelectionPage.entity.nativePlace}</td>
					<td>民族：</td>
					<td>${personnelSelectionPage.entity.nation}</td>
				</tr>
				<tr>
					<td>部职别：</td>
					<td>${personnelSelectionPage.entity.jobTitle}</td>
					<td>现军衔：</td>
					<td>${personnelSelectionPage.entity.nowRank}</td>
				</tr>
				<tr>
					<td>现军衔时间：</td>
					<td>
						<fmt:formatDate value='${personnelSelectionPage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>学历：</td>
					<td>${personnelSelectionPage.entity.educational}</td>
				</tr>
				<tr>
					<td>入伍时间：</td>
					<td>
						<fmt:formatDate value='${personnelSelectionPage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
        <div class="col-lg-6">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-hourglass-start"></i> 学兵培训</div>
				<div class="card-body">
					<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
						<tr>
							<th>培训类型</th>
							<th>培训专业</th>
						</tr>
						<tr>
							<td>${personnelSelectionPage.peiXunLeiXing}</td>
							<td>${personnelSelectionPage.peiXunZhuanYe}</td>
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
						<i class="fa fa-hand-stop-o"></i> 民主推荐</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>应到人数</th>
								<th>实到人数</th>
								<th>有效票数</th>
								<th>出勤率</th>
								<th>赞成票</th>
								<th>得票率</th>
							</tr>
							<tr>
								<td>${personnelSelectionPage.yingDao}</td>
								<td>${personnelSelectionPage.shiDao}</td>
								<td>${personnelSelectionPage.youXiao}</td>
								<td>${personnelSelectionPage.chuQin}</td>
								<td>${personnelSelectionPage.zanCheng}</td>
								<td>${personnelSelectionPage.recommandRate}</td>
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
						<i class="fa fa-file-text"></i> 考核成绩</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th rowspan="2">科目</th>
								<th rowspan="2">军事考察</th>
								<th colspan="4">文化考核</th>
								<th rowspan="2">专业摸底</th>
								<th rowspan="2">体检</th>
								<th rowspan="2">总成绩</th>
								<th rowspan="2">同专业排名</th>
							</tr>
							<tr>
								<td>语文</td>
								<td>数学</td>
								<td>政治</td>
								<td>物理</td>
							</tr>
							<tr>
								<td>成绩</td>
								<td>${personnelSelectionPage.junShiKaoHe}</td>
								<td>${personnelSelectionPage.yuWen}</td>
								<td>${personnelSelectionPage.shuXue}</td>
								<td>${personnelSelectionPage.zhengZhi}</td>
								<td>${personnelSelectionPage.wuLi}</td>
								<td>${personnelSelectionPage.zhuanYeMoDi}</td>
								<td>${personnelSelectionPage.tiJian}</td>
								<td>${personnelSelectionPage.zongChengJi}</td>
								<td>${personnelSelectionPage.rank}</td>
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
						<i class="fa fa-pencil"></i> 组织审批</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>条目</th>
								<th>时间</th>
								<th>研究决定</th>
							</tr>
							<tr>
								<td>支部研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${personnelSelectionPage.zhiBuTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${personnelSelectionPage.zhiBuJueDing}</td>
							</tr>
							<tr>
								<td>营党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${personnelSelectionPage.yingDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${personnelSelectionPage.yingDangWeiJueDing}</td>
							</tr>
							<tr>
								<td>旅党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${personnelSelectionPage.lvDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${personnelSelectionPage.lvDangWeiJueDing}</td>
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