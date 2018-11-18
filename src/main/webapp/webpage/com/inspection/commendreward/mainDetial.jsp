<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>表彰奖励</title>
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
	.shijicailiao {
		text-align: center;
	}
	.shijicailiao:hover{
		color: #007bff !important;
		cursor: pointer;
	}
  </style>
</head>
<body id="page-top">
  <!-- Navigation-->
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <a class="breadcrumb-item active" href="${webRoot }/commendRewardController.do?commendReward">表彰奖励</a>
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('commendRewardController.do?viewMainDetial&id=${commendrewardPage.entity.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>监督纠错</a>
      </ol>
      <div class="row">
		  <div class="col-lg-6">
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-user-circle"></i> 基本资料</div>
            <div class="card-body">
            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
				<tr>
					<td>姓名/单位：</td>
					<td>${commendrewardPage.entity.nameUnit}</td>
					<td>部职别:</td>
					<td>${commendrewardPage.entity.jobTitle}</td>
				</tr>
				<tr>
					<td>现军衔:</td>
					<td>${commendrewardPage.entity.nowRank}</td>
					<td>现军衔时间:</td>
					<td>
						<fmt:formatDate value='${commendrewardPage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>名额:</td>
					<td>${commendrewardPage.entity.places}</td>
					<td>录用时间:</td>
					<td>
						<fmt:formatDate value='${commendrewardPage.entity.employTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
			</table>
            </div>
          </div>
        </div>
		  <div class="col-lg-6">
			  <div class="card mb-3">
				  <div class="card-header">
					  <i class="fa fa-user-o"></i> 表彰奖励</div>
				  <div class="card-body">
					  <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
						  <tr>
							  <th>奖励类型</th>
							  <th>提名类型</th>
						  </tr>
						  <tr>
							  <td>${commendrewardPage.jiangLiLeiXing}</td>
							  <td>${commendrewardPage.tiMingLeiXing}</td>
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
					  <i class="fa fa-address-book-o"></i> 事迹材料</div>
				  <div class="card-body shijicailiao">
                    <c:if test="${not empty commendrewardPage.shiJiFilename}">
					  <a class="fa fa-file-word-o" style="font-size: 50px;" href="./downloadFiles/commendReward/${commendrewardPage.id}/${commendrewardPage.shiJiFilename}"></a>
					</c:if>
				  </div>
			  </div>
		  </div>
		  <div class="col-lg-6">
			  <div class="card mb-3">
				  <div class="card-header">
					  <i class="fa fa-thumb-tack"></i> 材料认证</div>
				  <div class="card-body" style="text-align: center;">
					  <div style="font-size: 20px;">事迹材料真实性认定（立功需要）</div>
					  <div style="font-size: 16px;">事迹材料真实</div>
					  <div style="float: right;">合成第二三五旅政治工作部</div>
				  </div>
			  </div>
		  </div>
	  </div>

	  <div class="row">
			<div class="col-lg-12">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-hand-stop-o"></i> 群众评议</div>
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
								<td>${commendrewardPage.yingDao}</td>
								<td>${commendrewardPage.shiDao}</td>
								<td>${commendrewardPage.youXiao}</td>
								<td>${commendrewardPage.chuQin}</td>
								<td>${commendrewardPage.zanCheng}</td>
								<td>${commendrewardPage.testRate}</td>
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
								<td>支部研究上报</td>
								<td>
									<fmt:formatDate value='${commendrewardPage.zhiBuTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${commendrewardPage.zhiBuJueDing}</td>
							</tr>
							<tr>
								<td>党委研究批准</td>
								<td>
									<fmt:formatDate value='${commendrewardPage.dangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${commendrewardPage.dangWeiJueDing}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>

	  <div>
			<span class="breadcrumb" style="text-align: center;font-size: 20px; width: 100%; display: block">个人平时表现</span>
			<div class="row">
				<div class="col-lg-12">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-tasks"></i> 军事训练成绩</div>
						<div class="card-body">
							<table class="table table-bordered" width="100%" cellspacing="0">
								<tr>
									<th>科目</th>
									<th>成绩</th>
								</tr>
								<c:if test="${fn:length(commendrewardPage.junShiXunLian)  > 0 }">
									<c:forEach items="${commendrewardPage.junShiXunLian}" var="junshi" varStatus="stuts">
										<tr>
											<td>${junshi.name}</td>
											<td>${junshi.score}</td>
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
							<i class="fa fa-tasks"></i> 今年取得成绩</div>
						<div class="card-body">
							<table class="table table-bordered" width="100%" cellspacing="0">
								<tr>
									<th>序号</th>
									<th>条目</th>
								</tr>
								<c:if test="${fn:length(commendrewardPage.biaoZhang) > 0 }">
									<c:forEach items="${commendrewardPage.biaoZhang}" var="shouJiang" varStatus="stuts">
										<tr>
											<td>${stuts.index}</td>
											<td>${shouJiang}</td>
										</tr>
									</c:forEach>
								</c:if>
							</table>
						</div>
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

	  function viewShiJiCaiLiao() {
	     console.log("事迹材料...");
	  }
    </script>
  </div>
</body>
</html>