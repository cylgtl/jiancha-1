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
     text-align: right;
     font-size: 12px;
    }
    
    th{
     text-align: center;
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
        <li class="breadcrumb-item active">党员发展</li>
        <c:if test="${empty isView}">
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('partyMemberController.do?viewDetailMain&id=${id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
        </c:if>
      </ol>
      <!-- Area Chart Example-->
     <!--  <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-area-chart"></i> Area Chart Example</div>
        <div class="card-body">
          <canvas id="myAreaChart" width="100%" height="30"></canvas>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div> -->
      <div class="row">
        <div class="col-lg-6">
          <!-- Example Bar Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> 基本资料</div>
            <div class="card-body">
            <table class="table table-bordered" id="dataTable" width="100%" style="font-size: 12px;" cellspacing="0">
				<tr>
					<td>
					姓名：
					</td>
					<td>
					${partyMemberPage.partyMember.name}
					</td>
					<td>
					性别：
					</td>
					<td>
					${partyMemberPage.partyMember.sex}
					</td>
				</tr>
				
				<tr>
					<td>
					出生时间：
					</td>
					<td>
					<fmt:formatDate value='${partyMemberPage.partyMember.birthDay}' type="date" pattern="yyyy-MM-dd"/>
					
					
					</td>
					<td>
					部职别：
					</td>
					<td>
					${partyMemberPage.partyMember.jobTitle}
					</td>
					<%-- <td>
					政治面貌：
					</td>
					<td>
					${partyMemberPage.partyMember.politicalLandscape}
					</td> --%>
	
				</tr>
				
				<tr>
					<td>
					籍贯：
					</td>
					<td>
					${partyMemberPage.partyMember.nativePlace}
					</td>
					<td>
					民族：
					</td>
					<td>
					${partyMemberPage.partyMember.national}
					</td>
				</tr>
				
				<tr>
					
					<td>
					现军衔：
					</td>
					<td>
					${partyMemberPage.partyMember.nowRank}
					</td>
					<td>
					现军衔时间：
					</td>
					<td>
					${partyMemberPage.partyMember.rankTime}
					
				
					</td>
				</tr>
				<tr>
					<td>
					学历：
					</td>
					<td>
					${partyMemberPage.partyMember.education}
					</td>
					<td>
					入伍时间：
					</td>
					<td>
					<fmt:formatDate value='${partyMemberPage.partyMember.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
                </table>
            </div>
          </div>
        </div>
        <div class="col-lg-6">
          <!-- Example Pie Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-pie-chart"></i>个人平时表现</div>
            <div class="card-body">
                <table class="table table-bordered" id="dataTable" width="100%" style="font-size: 12px;" cellspacing="0">
                <tr>
                  <th>党小组意见</th>
                  <th>联系人1</th>
                  <th>意见</th>
                  <th>联系人2</th>
                  <th>意见</th>
                  <th>录入时间</th>
                </tr>
                
				<tbody>
		<c:if test="${fn:length(partyMemberPage.performances)  > 0 }">
			<c:forEach items="${partyMemberPage.performances}" var="performance" varStatus="stuts">
				<tr>
				<td align="left"  style="width:50px;text-align:center;"  class="value" >
				${performance.partySuggestion}
				</td>
				<td align="left"  style="width:50px;text-align:center;"  class="value" >
				${performance.contact1}
				</td>
				<td align="left"  style="width:50px;text-align:center;"  class="value" >
				${performance.contactSuggestion1}
				</td>
				<td align="left"  style="width:50px;text-align:center;"  class="value" >
				${performance.contact2}
				</td>
				<td align="left"  style="width:50px;text-align:center;"  class="value" >
				${performance.contactSuggestion2}
				</td>
				<td align="left"  style="width:100px;text-align:center;" >
				<fmt:formatDate value='${performance.inputTime}' type="date" pattern="yyyy-MM-dd"/>
					
				</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
                </table>
            </div>
          </div>
        </div>
      </div>
      
      
      
      
      
      
      
      <div class="row">
        <div class="col-lg-12">
          <!-- Example Bar Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-pie-chart"></i> 民主评议/推荐</div>
            <div class="card-body">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            
                <tr>
                  <th>评议方</th>
                  <th>开始时间</th>
                  <th>结束时间</th>
                  <th>评议意见</th>
                  <th>应到人数</th>
                  <th>赞成票</th>
                  <th>有效票</th>
                  <th>实到人数</th>
                  <th>得票率</th>
                  <th>出勤率</th>
                </tr>
              
           
                <tbody>
		<c:if test="${fn:length(partyMemberPage.recommends)  > 0 }">
			<c:forEach items="${partyMemberPage.recommends}" var="recommend" varStatus="stuts">
				<tr>
				<td align="left"  style="width:50px;text-align:center;"  class="value" >
				${recommend.recommendPerson}
				</td>
				<td align="left"  style="width:100px;text-align:center;" >
				<fmt:formatDate value='${recommend.beginTime}' type="date" pattern="yyyy-MM-dd"/>
					
				</td>
				<td align="left"  style="width:100px;text-align:center;" >
				<fmt:formatDate value='${recommend.endTime}' type="date" pattern="yyyy-MM-dd"/>
				
				
				</td>
				<td align="left"  style="width:200px;text-align:center;" >
				${recommend.suggestion}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				${recommend.shouldNumber}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				${recommend.favour}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				${recommend.effective}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				${recommend.hierarchyNumber}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				${recommend.vote}
				</td>
				<td align="left"  style="width:50px;text-align:center;" >
				${recommend.attendance}
				</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
                </table>
            </div>
          </div>
        </div>
      </div>
      
           <div class="row">
        <div class="col-lg-12">
          <!-- Example Bar Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-pie-chart"></i> 各级研究意见和结果</div>
            <div class="card-body">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            
                <tr>
                  <th>开始时间</th>
                  <th>结束时间</th>
                  <th>单位</th>
                  <th>意见</th>
                </tr>
              
           
                <tbody>
		<c:if test="${fn:length(partyMemberPage.audit)  > 0 }">
			<c:forEach items="${partyMemberPage.audit}" var="auditing" varStatus="stuts">
				<tr>
				<td align="left"><fmt:formatDate value='${auditing.beginTime}' type="date" pattern="yyyy-MM-dd"/></td>
				<td align="left"><fmt:formatDate value='${auditing.endTime}' type="date" pattern="yyyy-MM-dd"/></td>
				<td align="left">${auditing.unit}</td>
				<td align="left">${auditing.suggestion}</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
                
                </table>
            </div>
          </div>
        </div>
      </div>
      
      <div class="row">
        <div class="col-lg-6">
          <!-- Example Bar Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> 考核结果</div>
            <div class="card-body">
            <table class="table table-bordered" id="dataTable" width="100%" style="font-size: 12px;" cellspacing="0">
				<c:if test="${fn:length(partyMemberPage.assessments)  > 0 }">
			<c:forEach items="${partyMemberPage.assessments}" var="assessment" varStatus="stuts">
				<tr>
					<td>
					附件：
					</td>
					<td>
					
					<a  target="_blank" href="${assessment.fileId}">下载附件</a>
					</td>
				</tr>
				</c:forEach>
				</c:if>
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
		//createwindow('信息举报',"reportController.do?addorupdate&url=" + url,900, 450);
		add('录入',"reportController.do?addorupdate&url=" + url,'reportList',null,400);
	  }
    </script>
  </div>
</body>
</html>