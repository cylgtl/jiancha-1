<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>大学生士兵提干</title>
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
        <a class="breadcrumb-item active" href="${webRoot }/soldierStudentController.do?soldierStudent">大学毕业生士兵提干</a>
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('soldierStudentController.do?viewMainDetial&id=${id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
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
					<td>${soldierStudentPage.entity.name}</td>
					<td>性别：</td>
					<td>${soldierStudentPage.entity.sex}</td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td>${soldierStudentPage.entity.idCard}</td>
					<td>政治面貌:</td>
					<td>${soldierStudentPage.entity.politicalLandscape}</td>
				</tr>
				<tr>
					<td>民族：</td>
					<td>${soldierStudentPage.entity.nationalName}</td>
					<td>籍贯：</td>
					<td>${soldierStudentPage.entity.nativePlace}</td>
				</tr>
				<tr>
					<td>出生日期:</td>
					<td>
						<fmt:formatDate value='${soldierStudentPage.entity.birthDay}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>部职别：</td>
					<td>${soldierStudentPage.entity.jobTitle}</td>
				</tr>
				<tr>
					<td>入伍时间:</td>
					<td>
						<fmt:formatDate value='${soldierStudentPage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>军衔时间:</td>
					<td>
						<fmt:formatDate value='${soldierStudentPage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>现军衔:</td>
					<td>${soldierStudentPage.entity.nowRank}</td>
					<td>学历:</td>
					<td>${soldierStudentPage.entity.education}</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
	    <div class="col-lg-6">
			  <div class="card mb-3">
				  <div class="card-header">
					  <i class="fa fa-map-o"></i> 任骨干情况</div>
				  <div class="card-body">
					  <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
						  <tr>
							  <th>起止时间</th>
							  <th>担任职务</th>
						  </tr>
						  <tr>
							  <td>
                                  <fmt:formatDate value='${soldierStudentPage.startTime}' type="date" pattern="yyyy-MM-dd"/>
                                  —
                                  <fmt:formatDate value='${soldierStudentPage.endTime}' type="date" pattern="yyyy-MM-dd"/>
                              </td>
							  <td>${soldierStudentPage.zhiWu}</td>
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
						<i class="fa fa-tasks"></i> 立功受奖情况</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>条目</th>
							</tr>
							<c:if test="${fn:length(soldierStudentPage.shouJiangQingKuang) > 0 }">
								<c:forEach items="${soldierStudentPage.shouJiangQingKuang}" var="shouJiang" varStatus="stuts">
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
								<td>${soldierStudentPage.yingDao}</td>
								<td>${soldierStudentPage.shiDao}</td>
								<td>${soldierStudentPage.youXiao}</td>
								<td>${soldierStudentPage.chuQin}</td>
								<td>${soldierStudentPage.zanCheng}</td>
								<td>${soldierStudentPage.recommandRate}</td>
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
							<th>军事科目成绩</th>
							<th>文化科目成绩</th>
							<th>面试成绩</th>
							<th>总成绩</th>
							<th>排名</th>
						</tr>
						<tr>
							<td>${soldierStudentPage.junShiKeMu}</td>
							<td>${soldierStudentPage.wenHuaKeMu}</td>
							<td>${soldierStudentPage.mainShi}</td>
							<td>${soldierStudentPage.totalScore}</td>
							<td>${soldierStudentPage.totalRank}</td>
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
							<td>${soldierStudentPage.tiJianJieGuo}</td>
							<td>${soldierStudentPage.shuoMing}</td>
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
						<i class="fa fa-file-text"></i> 军事考核成绩</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>科目</th>
								<th>停止间转法</th>
								<th>实弹射击</th>
								<th>前进</th>
								<th>仰卧起坐</th>
								<th>蛇形跑</th>
								<th>3000米</th>
								<th>军事成绩</th>
								<th>军事加分</th>
							</tr>
							<tr>
								<td>成绩</td>
								<td>${soldierStudentPage.tiZhi}</td>
								<td>${soldierStudentPage.shiDan}</td>
								<td>${soldierStudentPage.qianJing}</td>
								<td>${soldierStudentPage.yangWo}</td>
								<td>${soldierStudentPage.sheXing}</td>
								<td>${soldierStudentPage.sanQian}</td>
								<td>${soldierStudentPage.junShiChengJi}</td>
								<td>${soldierStudentPage.junShiJiaFeng}</td>
							</tr>
						</table>
						<div style="font-size: 14px; text-align: center">军事加分明细</div>
						<table class="table table-bordered mt5" width="100%" cellspacing="0">
							<tr>
								<th>时间</th>
								<th>明细</th>
							</tr>
							<c:if test="${fn:length(soldierStudentPage.junShiJiaFen) > 0 }">
								<c:forEach items="${soldierStudentPage.junShiJiaFen}" var="junShiJiaFen" varStatus="stuts">
									<tr>
										<td>
											<fmt:formatDate value='${junShiJiaFen.time}' type="date" pattern="yyyy-MM-dd"/>
										</td>
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
									<fmt:formatDate value='${soldierStudentPage.zhiBuTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierStudentPage.zhiBuJueDing}</td>
							</tr>
							<tr>
								<td>营党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${soldierStudentPage.yingDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierStudentPage.yingDangWeiJueDing}</td>
							</tr>
							<tr>
								<td>旅党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${soldierStudentPage.lvDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierStudentPage.lvDangWeiJueDing}</td>
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