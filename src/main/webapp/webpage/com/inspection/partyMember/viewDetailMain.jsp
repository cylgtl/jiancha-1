<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>党员发展</title>
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
	.shen-qing-shu {
		text-align: center;
	}
	.shen-qing-shu:hover{
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
        <a class="breadcrumb-item active" href="${webRoot }/partyMemberController.do?partyMember">党员发展</a>
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('partyMemberController.do?viewDetailMain&id=${partyMemberPage.entity.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
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
					<td>${partyMemberPage.entity.name}</td>
					<td>性别：</td>
					<td>${partyMemberPage.entity.sex}</td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td>${partyMemberPage.entity.idcard}</td>
					<td>政治面貌：</td>
					<td>${partyMemberPage.entity.politicalLandscape}</td>
				</tr>
				<tr>
					<td>民族：</td>
					<td>${partyMemberPage.entity.national}</td>
					<td>籍贯：</td>
					<td>${partyMemberPage.entity.nativePlace}</td>
				</tr>
				<tr>
					<td>出生日期：</td>
					<td>
						<fmt:formatDate value='${partyMemberPage.entity.birthDay}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>部职别：</td>
					<td>${partyMemberPage.entity.jobTitle}</td>
				</tr>
				<tr>
					<td>入伍时间：</td>
					<td>
						<fmt:formatDate value='${partyMemberPage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>军衔时间：</td>
					<td>
						<fmt:formatDate value='${partyMemberPage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>现军衔：</td>
					<td>${partyMemberPage.entity.nowRank}</td>
					<td>学历：</td>
					<td>${partyMemberPage.entity.education}</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
	    <div class="col-lg-6">
			  <div class="card mb-3">
				  <div class="card-header">
					  <i class="fa fa-address-book-o"></i> 入党申请书</div>
				  <div class="card-body shen-qing-shu">
				    <c:if test="${not empty partyMemberPage.ruDangFilename}">
					  <a class="fa fa-file-word-o" style="font-size: 50px;" href="./downloadFiles/partyMember/${partyMemberPage.id}/${partyMemberPage.ruDangFilename}"></a>
					</c:if>
				  </div>
			  </div>
		  </div>
      </div>

	  <div class="row">
			<div class="col-lg-6">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-user-o"></i> 培训联系人</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
							<tr>
								<th>培训联系人1</th>
								<th>培训联系人2</th>
							</tr>
							<tr>
								<td>${partyMemberPage.lianXiRen1}</td>
								<td>${partyMemberPage.lianXiRen2}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fa fa-file-text"></i> 考核成绩</div>
					<div class="card-body">
						<table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
							<tr>
								<th>成绩</th>
								<th>等级</th>
							</tr>
							<tr>
								<td>${partyMemberPage.score}</td>
								<td>${partyMemberPage.level}</td>
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
								<td>${partyMemberPage.yingDao}</td>
								<td>${partyMemberPage.shiDao}</td>
								<td>${partyMemberPage.youXiao}</td>
								<td>${partyMemberPage.chuQin}</td>
								<td>${partyMemberPage.zanCheng}</td>
								<td>${partyMemberPage.testRate}</td>
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
								<td>确定入党积极分子研究决定</td>
								<td>
									<fmt:formatDate value='${partyMemberPage.ruDangJiJiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${partyMemberPage.ruDangJiJi}</td>
							</tr>
							<tr>
								<td>确定党员发展对象研究决定</td>
								<td>
									<fmt:formatDate value='${partyMemberPage.dangYuanFaZhanTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${partyMemberPage.dangYuanFaZhan}</td>
							</tr>
							<tr>
								<td>接受预备党员研究决定</td>
								<td>
									<fmt:formatDate value='${partyMemberPage.yuBeiDangYuanTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${partyMemberPage.yuBeiDangYuan}</td>
							</tr>
							<tr>
								<td>党委研究决定</td>
								<td>
									<fmt:formatDate value='${partyMemberPage.dangWeiTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${partyMemberPage.dangWei}</td>
							</tr>
							<tr>
								<td>预备党员转正</td>
								<td>
									<fmt:formatDate value='${partyMemberPage.yuBeiZhuanZhengTime}' type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${partyMemberPage.yuBeiZhuanZheng}</td>
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
								<c:if test="${fn:length(partyMemberPage.junShiXunLian)  > 0 }">
									<c:forEach items="${partyMemberPage.junShiXunLian}" var="junshi" varStatus="stuts">
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
							  <c:if test="${fn:length(partyMemberPage.biaoZhang) > 0 }">
								  <c:forEach items="${partyMemberPage.biaoZhang}" var="shouJiang" varStatus="stuts">
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

	  function viewShenqingShu() {
		  console.log("查看word文档");
      }
    </script>
  </div>
</body>
</html>