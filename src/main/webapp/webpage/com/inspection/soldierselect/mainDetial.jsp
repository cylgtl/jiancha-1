<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>士官选取</title>
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
      <!-- Breadcrumbs-->
	  <ol class="breadcrumb">
		<li class="breadcrumb-item active">士官选取</li>
		<a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('soldierSelectController.do?viewMainDetial&id=${id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
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
					<td>${soldierSelectPage.entity.name}</td>
					<td>性别：</td>
					<td>${soldierSelectPage.entity.sex}</td>
				</tr>
				
				<tr>
					<td>出生时间：</td>
					<td>
						<fmt:formatDate value='${soldierSelectPage.entity.birthDay}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>政治面貌：</td>
					<td>${soldierSelectPage.entity.politicalLandscape}</td>
				</tr>
				
				<tr>
					<td>籍贯：</td>
					<td>${soldierSelectPage.entity.nativePlace}</td>
					<td>民族：</td>
					<td>${soldierSelectPage.entity.nationalName}</td>
				</tr>
				<tr>
					<td>部职别：</td>
					<td>${soldierSelectPage.entity.jobTitle}</td>
					<td>现军衔：</td>
					<td>${soldierSelectPage.entity.nowRank}</td>
				</tr>
				<tr>
					<td>现军衔时间：</td>
					<td>
						<fmt:formatDate value='${soldierSelectPage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>学历：</td>
					<td>${soldierSelectPage.entity.education}</td>
				</tr>
				<tr>
					<td>入伍时间：</td>
					<td>
						<fmt:formatDate value='${soldierSelectPage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-map-o"></i> 选取条件</div>
            <div class="card-body">
				<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
					<tr>
						<th>选取类型</th>
						<th>选取专业</th>
					</tr>
					<tr>
						<td>${soldierSelectPage.selectType}</td>
						<td>${soldierSelectPage.selectMajor}</td>
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
					   <td style="width:50px;">${soldierSelectPage.yingDao}</td>
					   <td style="width:50px;">${soldierSelectPage.shiDao}</td>
					   <td style="width:50px;">${soldierSelectPage.youXiao}</td>
					   <td style="width:50px;">${soldierSelectPage.chuQin}</td>
					   <td style="width:50px;">${soldierSelectPage.zanCheng}</td>
					   <td style="width:50px;">${soldierSelectPage.recommandRate}</td>
				   </tr>
                </table>
            </div>
          </div>
        </div>
      </div>

	  <div class="row">
			<div class="col-lg-6">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-hourglass-start"></i> 总体成绩</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
							<tr>
								<th>身体和心理素质</th>
								<th>基本理论</th>
								<th>军事技能</th>
							</tr>
							<tr>
								<td>${soldierSelectPage.shenTi}</td>
								<td>${soldierSelectPage.jiBenLiLun}</td>
								<td>${soldierSelectPage.junShiJiNeng}</td>
							</tr>
							<tr>
								<th>总成绩</th>
								<th>排名</th>
								<th rowspan="2"></th>
							</tr>
							<tr>
								<td>${soldierSelectPage.zongChengJi}</td>
								<td>${soldierSelectPage.totalRank}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-file-text"></i> 军事技能考核</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
							<tr>
								<th colspan="3">基础技能</th>
								<th rowspan="2">专业技能</th>
							</tr>
							<tr>
								<td>3000米跑</td>
								<td>俯卧撑</td>
								<td>仰卧起坐</td>
							</tr>
							<tr>
								<td>${soldierSelectPage.sanQian}</td>
								<td>${soldierSelectPage.fuWoCheng}</td>
								<td>${soldierSelectPage.yangWoQiZuo}</td>
								<td>${soldierSelectPage.zhuanYeJiNeng}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>

	  <div class="row">
			<div class="col-lg-6">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-file-text-o"></i> 基本理论考核</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
							<tr>
								<th>政治理论</th>
								<th>法令条规</th>
								<th>军事理论基础</th>
								<th>专业理论</th>
							</tr>
							<tr>
								<td>${soldierSelectPage.zhengZhiLiLun}</td>
								<td>${soldierSelectPage.faLingTiaoGui}</td>
								<td>${soldierSelectPage.junShiLilun}</td>
								<td>${soldierSelectPage.zhuanYeLiLun}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-universal-access"></i> 身体和心理素质考核</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
							<tr>
								<th>体检</th>
								<th>心理素质</th>
							</tr>
							<tr>
								<td>${soldierSelectPage.tiJian}</td>
								<td>${soldierSelectPage.xinLiSuZhi}</td>
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
									<fmt:formatDate value='${soldierSelectPage.zhiBu.time}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierSelectPage.zhiBu.yanJiuJueDing}</td>
							</tr>
							<tr>
								<td>营党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${soldierSelectPage.yingDangWei.time}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierSelectPage.yingDangWei.yanJiuJueDing}</td>
							</tr>
							<tr>
								<td>旅党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${soldierSelectPage.lvDangWei.time}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierSelectPage.lvDangWei.yanJiuJueDing}</td>
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
	 function goToReport(url) {
		//iframe层-父子操作
		add('录入',"reportController.do?addorupdate&url=" + url,'reportList',null,400);
	  }
    </script>
  </div>
</body>
</html>