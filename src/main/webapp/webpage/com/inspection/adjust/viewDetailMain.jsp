<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>干部配备调整</title>
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
		  <a class="breadcrumb-item active" href="${webRoot }/adjustController.do?adjust">干部配备调整</a>
		  <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('adjustController.do?viewDetailMain&id=${adjustPage.adjust.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>监督纠错</a>
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
					<td>${adjustPage.adjust.name}</td>
					<td>性别：</td>
					<td>${adjustPage.adjust.sex}</td>
				</tr>
				
				<tr>
					<td>身份证号：</td>
					<td>${adjustPage.adjust.idCard}</td>
					<td>政治面貌：</td>
					<td>${adjustPage.adjust.politicalLandscape}</td>
				</tr>
				
				<tr>
					<td>民族：</td>
					<td>${adjustPage.adjust.nationalName}</td>
					<td>籍贯：</td>
					<td>${adjustPage.adjust.nativePlace}</td>
				</tr>
				
				<tr>
					<td>出生日期：</td>
					<td>
						<fmt:formatDate value='${adjustPage.adjust.birthDay}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>部职别：</td>
					<td>${adjustPage.adjust.jobTitle}</td>
				</tr>

				<tr>
					<td>入伍时间：</td>
					<td>
						<fmt:formatDate value='${adjustPage.adjust.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>军衔时间：</td>
					<td>
						<fmt:formatDate value='${adjustPage.adjust.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>现军衔：</td>
					<td>${adjustPage.adjust.nowRank}</td>
					<td>学历：</td>
					<td>${adjustPage.adjust.education}</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-hourglass-start"></i> 三评三考总体成绩</div>
            <div class="card-body">
			<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
				<tr>
					<th>三评总体成绩</th>
					<th>三考总体成绩</th>
					<th>排名</th>
				</tr>
				<tr>
					<td>${adjustPage.sanPingScore}</td>
					<td>${adjustPage.sanKaoScore}</td>
					<td>${adjustPage.totalRank}</td>
				</tr>
			</table>
            </div>
          </div>
        </div>
      </div>

	  <div>
		  <span class="breadcrumb" style="text-align: center;font-size: 20px; width: 100%; display: block">三评</span>
		  <div class="row">
			  <div style="text-align: center;font-size: 16px; width: 100%;">评群众公论</div>
			  <div class="col-lg-9">
				  <div class="card mb-3">
					  <div class="card-header">
						  <i class="fa fa-heart"></i> 民主测评优秀率</div>
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
								  <td style="width:50px;">${adjustPage.yingDao}</td>
								  <td style="width:50px;">${adjustPage.shiDao}</td>
								  <td style="width:50px;">${adjustPage.youXiao}</td>
								  <td style="width:50px;">${adjustPage.chuQin}</td>
								  <td style="width:50px;">${adjustPage.zanCheng}</td>
								  <td style="width:50px;">${adjustPage.testRate}</td>
							  </tr>
						  </table>
					  </div>
				  </div>
			  </div>
			  <div class="col-lg-3">
				  <div class="card mb-3">
					  <div class="card-header">
						  <i class="fa fa-hand-stop-o"></i> 民主推荐情况</div>
					  <div class="card-body">
						  <table class="table table-bordered" width="100%" cellspacing="0">
						  <tr>
							  <th>总票数</th>
							  <th>推荐票数</th>
							  <th>得票率(%)</th>
						  </tr>
						  <tr>
							  <td style="width:50px;">${adjustPage.totalTicket}</td>
							  <td style="width:50px;">${adjustPage.recommandTicket}</td>
							  <td style="width:50px;">${adjustPage.ticketRate}</td>
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
						  <i class="fa fa-tasks"></i> 评岗位历练</div>
					  <div class="card-body">
						  <table class="table table-bordered" width="100%" cellspacing="0">
							  <tr>
								  <td rowspan="${fn:length(adjustPage.jiaJianXiang)+1}" style="width: 100px;font-size: 14px;font-weight: bold">现职级期间加减项目</td>
							  </tr>
                              <c:if test="${fn:length(adjustPage.jiaJianXiang)  > 0 }">
                                  <c:forEach items="${adjustPage.jiaJianXiang}" var="recommend" varStatus="stuts">
                                      <tr>
                                          <td>${recommend}</td>
                                      </tr>
                                  </c:forEach>
                              </c:if>
						  </table>
					  </div>
				  </div>
			  </div>
			  <div class="col-lg-6">
				  <div class="card mb-3">
					  <div class="card-header">
						  <i class="fa fa-check-square-o"></i> 评工作实绩</div>
					  <div class="card-body">
						  <table class="table table-bordered" width="100%" cellspacing="0">
							  <tr>
								  <th>组织评审结果</th>
								  <th>得分</th>
							  </tr>
							  <tr>
								  <td style="width:50px;">${adjustPage.pingShen}</td>
								  <td style="width:50px;">${adjustPage.pingShenScore}</td>
							  </tr>
						  </table>
					  </div>
				  </div>
			  </div>
		  </div>
	  </div>

	  <div>
		<span class="breadcrumb" style="text-align: center;font-size: 20px; width: 100%; display: block">三考</span>
		<div class="row">
			<div class="col-lg-12">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-file-text"></i> 军事科目考试</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>科目</th>
								<th>3000米</th>
								<th>引体向上</th>
								<th>体能总评</th>
								<th>军事理论</th>
								<th>图上作业</th>
								<th rowspan="2" style="vertical-align: middle">军事成绩评定</th>
							</tr>
							<tr>
								<td>成绩</td>
								<td>${adjustPage.sanQian}</td>
								<td>${adjustPage.yingTi}</td>
								<td>${adjustPage.tiNeng}</td>
								<td>${adjustPage.junShi}</td>
								<td>${adjustPage.tuShang}</td>
							</tr>
							<tr>
								<th>科目</th>
								<th>指挥信息系统使用</th>
								<th>作战指标</th>
								<th>作战计算</th>
								<th>射击</th>
								<th>军事科目得分</th>
								<td rowspan="2" style="vertical-align: middle">${adjustPage.junShiChengJi}</td>
							</tr>
							<tr>
								<td>成绩</td>
								<td>${adjustPage.zhiHuiXinXi}</td>
								<td>${adjustPage.zuoZhanBiaoTu}</td>
								<td>${adjustPage.zuoZhanJiSuan}</td>
								<td>${adjustPage.sheJi}</td>
								<td>${adjustPage.junSHiKeMu}</td>
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
						<i class="fa fa-file-text-o"></i> 综合理论考试</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>科目</th>
								<th>应知应会</th>
								<th>专业理论</th>
							</tr>
							<tr>
								<td style="width:50px;">得分</td>
								<td style="width:50px;">${adjustPage.yingZhiYingHui}</td>
								<td style="width:50px;">${adjustPage.zhuanYeLiLun}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-user"></i> 面试考察</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<tr>
								<th>工作思路方法</th>
							</tr>
							<tr>
								<td>${adjustPage.gongZuoSiLu}</td>
							</tr>
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