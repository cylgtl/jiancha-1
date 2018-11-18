<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
			<a class="breadcrumb-item active" href="${webRoot }/soldierSchoolController.do?soldierSchool">优秀士兵保送入学</a>
			<a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('soldierSchoolController.do?viewMainDetial&id=${id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>监督纠错</a>
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
								<td>${soldierSchoolPage.schoolEntity.name}</td>
								<td>性别：</td>
								<td>${soldierSchoolPage.schoolEntity.sex}</td>
							</tr>
							<tr>
								<td>身份证号：</td>
								<td>${soldierSchoolPage.schoolEntity.idCard}</td>
								<td>政治面貌:</td>
								<td>${soldierSchoolPage.schoolEntity.politicalLandscape}</td>
							</tr>
							<tr>
								<td>民族：</td>
								<td>${soldierSchoolPage.schoolEntity.nationalName}</td>
								<td>籍贯：</td>
								<td>${soldierSchoolPage.schoolEntity.nativePlace}</td>
							</tr>
							<tr>
								<td>出生日期:</td>
								<td>
									<fmt:formatDate value='${soldierSchoolPage.schoolEntity.birthDay}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>部职别：</td>
								<td>${soldierSchoolPage.schoolEntity.jobTitle}</td>
							</tr>
							<tr>
								<td>入伍时间:</td>
								<td>
									<fmt:formatDate value='${soldierSchoolPage.schoolEntity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>军衔时间:</td>
								<td>
									<fmt:formatDate value='${soldierSchoolPage.schoolEntity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
							</tr>
							<tr>
								<td>现军衔:</td>
								<td>${soldierSchoolPage.schoolEntity.nowRank}</td>
								<td>学历:</td>
								<td>${soldierSchoolPage.schoolEntity.education}</td>
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
									<fmt:formatDate value='${soldierSchoolPage.startTime}' type="date" pattern="yyyy-MM-dd"/>
									—
									<fmt:formatDate value='${soldierSchoolPage.endTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierSchoolPage.zhiWu}</td>
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
							<c:if test="${fn:length(soldierSchoolPage.shouJiangQingKuang) > 0 }">
								<c:forEach items="${soldierSchoolPage.shouJiangQingKuang}" var="shouJiang" varStatus="stuts">
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
								<td>${soldierSchoolPage.yingDao}</td>
								<td>${soldierSchoolPage.shiDao}</td>
								<td>${soldierSchoolPage.youXiao}</td>
								<td>${soldierSchoolPage.chuQin}</td>
								<td>${soldierSchoolPage.zanCheng}</td>
								<td>${soldierSchoolPage.recommandRate}</td>
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
								<td>${soldierSchoolPage.junShiKeMu}</td>
								<td>${soldierSchoolPage.wenHuaKeMu}</td>
								<td>${soldierSchoolPage.mainShi}</td>
								<td>${soldierSchoolPage.totalScore}</td>
								<td>${soldierSchoolPage.totalRank}</td>
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
								<td>${soldierSchoolPage.tiJianJieGuo}</td>
								<td>${soldierSchoolPage.shuoMing}</td>
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
								<td>${soldierSchoolPage.tiZhi}</td>
								<td>${soldierSchoolPage.shiDan}</td>
								<td>${soldierSchoolPage.qianJing}</td>
								<td>${soldierSchoolPage.yangWo}</td>
								<td>${soldierSchoolPage.sheXing}</td>
								<td>${soldierSchoolPage.sanQian}</td>
								<td>${soldierSchoolPage.junShiChengJi}</td>
								<td>${soldierSchoolPage.junShiJiaFeng}</td>
							</tr>
						</table>
						<div style="font-size: 14px; text-align: center">军事加分明细</div>
						<table class="table table-bordered mt5" width="100%" cellspacing="0">
							<tr>
								<th>时间</th>
								<th>明细</th>
							</tr>
							<c:if test="${fn:length(soldierSchoolPage.junShiJiaFen) > 0 }">
								<c:forEach items="${soldierSchoolPage.junShiJiaFen}" var="junShiJiaFen" varStatus="stuts">
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
									<fmt:formatDate value='${soldierSchoolPage.zhiBuTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierSchoolPage.zhiBuJueDing}</td>
							</tr>
							<tr>
								<td>营党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${soldierSchoolPage.yingDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierSchoolPage.yingDangWeiJueDing}</td>
							</tr>
							<tr>
								<td>旅党委研究确定选取对象</td>
								<td>
									<fmt:formatDate value='${soldierSchoolPage.lvDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${soldierSchoolPage.lvDangWeiJueDing}</td>
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