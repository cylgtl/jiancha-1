<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>骨干配备</title>
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
        <a class="breadcrumb-item active" href="${webRoot }/backboneController.do?backbone">骨干配备</a>
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('backboneController.do?viewMainDetial&id=${backbonePage.entity.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
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
					<td>${backbonePage.entity.name}</td>
					<td>性别：</td>
					<td>${backbonePage.entity.sex}</td>
				</tr>
				<tr>
					<td>籍贯：</td>
					<td>${backbonePage.entity.nativePlace}</td>
					<td>部职别：</td>
					<td >${backbonePage.entity.jobTitle}</td>
				</tr>
				<tr>
					<td>出生日期:</td>
					<td>
						<fmt:formatDate value='${backbonePage.entity.birthDay}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>入伍时间:</td>
					<td>
						<fmt:formatDate value='${backbonePage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>现军衔:</td>
					<td>${backbonePage.entity.nowRank}</td>
					<td>军衔时间:</td>
					<td>
						<fmt:formatDate value='${backbonePage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>学历:</td>
					<td>${backbonePage.entity.education}</td>
					<td>现专业:</td>
					<td>${backbonePage.entity.nowProfessional}</td>
				</tr>
				<tr>
					<td>毕业时间:</td>
					<td>
						<fmt:formatDate value='${backbonePage.entity.graduateTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>民族：</td>
					<td>${backbonePage.entity.nationalName}</td>
				</tr>
				<tr>
					<td>职务:</td>
					<td>${backbonePage.entity.position}</td>
					<td>班级:</td>
					<td>${backbonePage.entity.banji}</td>
				</tr>
				<tr>
					<td>政治面貌:</td>
					<td colspan="3">${backbonePage.entity.politicalLandscape}</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
	    <div class="col-lg-6">
			  <div class="card mb-3">
				  <div class="card-header">
					  <i class="fa fa-street-view"></i> 班排推荐</div>
				  <div class="card-body">
					  <textarea style="width: 100%; height: 200px; overflow: auto" readonly>${backbonePage.banPaiTuiJian}</textarea>
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
								<td>${backbonePage.yingDao}</td>
								<td>${backbonePage.shiDao}</td>
								<td>${backbonePage.youXiao}</td>
								<td>${backbonePage.chuQin}</td>
								<td>${backbonePage.zanCheng}</td>
								<td>${backbonePage.testRate}</td>
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
								<td>支部研究确定预选对象</td>
								<td>
									<fmt:formatDate value='${backbonePage.zhiBuTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${backbonePage.zhiBuJueDing}</td>
							</tr>
							<tr>
								<td>营党委研究确定对象</td>
								<td>
									<fmt:formatDate value='${backbonePage.yingDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${backbonePage.yingDangWeiJueDing}</td>
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
								<c:if test="${fn:length(backbonePage.junShiXunLian)  > 0 }">
									<c:forEach items="${backbonePage.junShiXunLian}" var="junshi" varStatus="stuts">
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
							<i class="fa fa-tasks"></i> 表彰及获奖情况</div>
						<div class="card-body">
							<table class="table table-bordered" width="100%" cellspacing="0">
								<tr>
									<th>序号</th>
									<th>条目</th>
								</tr>
								<c:if test="${fn:length(backbonePage.biaoZhang) > 0 }">
									<c:forEach items="${backbonePage.biaoZhang}" var="shouJiang" varStatus="stuts">
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
   <script src="plug-in/lhgDialog/lhgdialog.min.js"></script>
    
    <script type="text/javascript">
	 function goToReport(url) {
		add('录入',"reportController.do?addorupdate&url=" + url,'reportList',null,400);
	  }
    </script>
  </div>
</body>
</html>