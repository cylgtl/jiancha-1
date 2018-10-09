<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>士兵考学</title>
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
        <a class="breadcrumb-item active" href="${webRoot }/soldiersApplyController.do?soldiersApply">士兵考学</a>
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('soldiersApplyController.do?viewDetailMain&id=${id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
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
					<td>${soldiersApplyPage.entity.name}</td>
					<td>性别：</td>
					<td>${soldiersApplyPage.entity.sex}</td>
				</tr>
				<tr>
					<td>出生时间：</td>
					<td>
						<fmt:formatDate value='${soldiersApplyPage.entity.birthday}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>政治面貌：</td>
					<td>${soldiersApplyPage.entity.politicalStatus}</td>
				</tr>
				<tr>
					<td>籍贯：</td>
					<td>${soldiersApplyPage.entity.nativePlace}</td>
					<td>民族：</td>
					<td>${soldiersApplyPage.entity.nation}</td>
				</tr>
				<tr>
					<td>部职别：</td>
					<td>${soldiersApplyPage.entity.jobTitle}</td>
					<td>现军衔：</td>
					<td>${soldiersApplyPage.entity.nowRank}</td>
				</tr>
				<tr>
					<td>现军衔时间：</td>
					<td>${soldiersApplyPage.entity.rankTime}</td>
					<td>学历：</td>
					<td>${soldiersApplyPage.entity.educational}</td>
				</tr>
				<tr>
					<td>入伍时间：</td>
					<td>
						<fmt:formatDate value='${soldiersApplyPage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>身份证号：</td>
					<td>${soldiersApplyPage.entity.idcard}</td>
				</tr>
				<tr>
					<td>报考学校：</td>
					<td>${soldiersApplyPage.entity.targetSchool}</td>
					<td>报考专业：</td>
					<td>${soldiersApplyPage.entity.applyingMajor}</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
        <div class="col-lg-6">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-hourglass-start"></i> 总体成绩</div>
				<div class="card-body">
					<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
						<tr>
							<th>预选考核成绩</th>
							<th>直前考核成绩</th>
							<th>加分</th>
							<th>总成绩</th>
							<th>排名</th>
						</tr>
						<tr>
							<td>${soldiersApplyPage.yuXuanKaoHe}</td>
							<td>${soldiersApplyPage.zhiQianKaoHe}</td>
							<td>${soldiersApplyPage.jiaFen}</td>
							<td>${soldiersApplyPage.zongChengJi}</td>
							<td>${soldiersApplyPage.rank}</td>
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
								<td>${soldiersApplyPage.yingDao}</td>
								<td>${soldiersApplyPage.shiDao}</td>
								<td>${soldiersApplyPage.youXiao}</td>
								<td>${soldiersApplyPage.chuQin}</td>
								<td>${soldiersApplyPage.zanCheng}</td>
								<td>${soldiersApplyPage.recommandRate}</td>
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
						<i class="fa fa-file-text"></i> 文化考核</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
							<tr>
								<th>语文</th>
								<th>数学</th>
								<th>英语</th>
								<th>综合</th>
							</tr>
							<tr>
								<td>${soldiersApplyPage.yuWen}</td>
								<td>${soldiersApplyPage.shuXue}</td>
								<td>${soldiersApplyPage.yingYu}</td>
								<td>${soldiersApplyPage.zongHe}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-file-text"></i> 体检情况</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
							<tr>
								<th>体检结果</th>
								<th>情况说明</th>
							</tr>
							<tr>
								<td>${soldiersApplyPage.tiJianJieGuo}</td>
								<td>${soldiersApplyPage.shuoMing}</td>
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
						<i class="fa fa-file-text"></i> 军事共同考核</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>科目</th>
								<th>停止间转法</th>
								<th>前进</th>
								<th>仰卧起坐</th>
								<th>实弹射击</th>
								<th>30*2蛇形跑</th>
								<th>3000米</th>
							</tr>
							<tr>
								<td>成绩</td>
								<td>${soldiersApplyPage.tiZhi}</td>
								<td>${soldiersApplyPage.qianJing}</td>
								<td>${soldiersApplyPage.yangWo}</td>
								<td>${soldiersApplyPage.shiDan}</td>
								<td>${soldiersApplyPage.sheXing}</td>
								<td>${soldiersApplyPage.sanQian}</td>
							</tr>
						</table>
						<div style="font-size: 14px; text-align: center">加分明细</div>
						<table class="table table-bordered mt5" width="100%" cellspacing="0">
							<tr>
								<th>时间</th>
								<th>明细</th>
							</tr>
							<c:if test="${fn:length(soldiersApplyPage.junShiJiaFen) > 0 }">
								<c:forEach items="${soldiersApplyPage.junShiJiaFen}" var="junShiJiaFen" varStatus="stuts">
									<tr>
										<td>${junShiJiaFen.time}</td>
										<td>${junShiJiaFen.detail}</td>
									</tr>
								</c:forEach>
							</c:if>
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
									<fmt:formatDate value='${soldiersApplyPage.zhiBuTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldiersApplyPage.zhiBuJueDing}</td>
							</tr>
							<tr>
								<td>营党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${soldiersApplyPage.yingDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldiersApplyPage.yingDangWeiJueDing}</td>
							</tr>
							<tr>
								<td>旅党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${soldiersApplyPage.lvDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldiersApplyPage.lvDangWeiJueDing}</td>
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
		add('录入',"reportController.do?addorupdate&url=" + url,'reportList',null,400);
	  }
    </script>
  </div>
</body>
</html>