<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>官兵评残</title>
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
        <li class="breadcrumb-item active">官兵评残</li>
        <c:if test="${empty isView}">
        <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('evaluationResidualController.do?viewMainDetial&id=${id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
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
					${evaluationResidualPage.name}
					</td>
					<td>
					性别：
					</td>
					<td>
					${evaluationResidualPage.sex}
					</td>
				</tr>
				
				<tr>
					<td>
					出生时间：
					</td>
					<td>
					<fmt:formatDate value='${evaluationResidualPage.birthDay}' type="date" pattern="yyyy-MM-dd"/>
					
					
					</td>
					
					<td>
					政治面貌：
					</td>
					<td>
					${evaluationResidualPage.political}
					</td>
	
				</tr>
				
				<tr>
					<td>
					籍贯：
					</td>
					<td>
					${evaluationResidualPage.nativePlace}
					</td>
					<td>
					民族：
					</td>
					<td>
					${evaluationResidualPage.nationalName}
					</td>
				</tr>
				
				<tr>
				<td>
					部职别：
					</td>
					<td>
					${evaluationResidualPage.jobTitle}
					</td>
					<td>
					现军衔：
					</td>
					<td>
					${evaluationResidualPage.nowRank}
					</td>
					
				</tr>
				
				
				<tr>
					<td>
					现军衔时间：
					</td>
					<td>
					<fmt:formatDate value='${evaluationResidualPage.rankTime}' type="date" pattern="yyyy-MM-dd"/>
					
				
					</td>
					<td>
					学历：
					</td>
					<td>
					${evaluationResidualPage.education}
					</td>
					
				</tr>
				<tr>
				<td>
					入伍时间：
					</td>
					<td>
					<fmt:formatDate value='${evaluationResidualPage.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
					
					
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
				<tbody>
		<c:if test="${fn:length(performanceLists)  > 0 }">
			<c:forEach items="${performanceLists}" var="performance" varStatus="stuts">
				<tr>
				<td align="left">
				<select name="performances[${stuts.index }].bxType" disabled="disabled">
				 
				 <c:forEach items="${typeList}" var="type">
                    <option value="${type.typecode}" <c:if test="${type.typecode==performance.bxType }">selected="selected"</c:if>>${type.typename}</option>
                </c:forEach>
				</select></td>
				<td><a href="${performance.fileId} ">下载附件</a></td>
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
                  <th>附件</th>
                </tr>
              
           
                <tbody>
		<c:if test="${fn:length(auditingLists)  > 0 }">
			<c:forEach items="${auditingLists}" var="auditing" varStatus="stuts">
				<tr>
				<td align="left"><fmt:formatDate value='${auditing.beginTime}' type="date" pattern="yyyy-MM-dd"/></td>
				<td align="left"><fmt:formatDate value='${auditing.endTime}' type="date" pattern="yyyy-MM-dd"/></td>
				<td align="left">${auditing.unit}</td>
				<td align="left">${auditing.suggestion}</td>
				<td><a href="${auditing.fileId}">下载附件</a></td>
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
              <i class="fa fa-pie-chart"></i> 证明材料</div>
            <div class="card-body">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            
                <tr>
                  <th>证明人</th>
                  <th>部职别</th>
                  <th>证明结果</th>
                 
                </tr>
              
           
                <tbody>
		<c:if test="${fn:length(proveLists)  > 0 }">
			<c:forEach items="${proveLists}" var="prove" varStatus="stuts">
				<tr>
				<td align="left">${prove.proveName }</td>
				<td align="left">${prove.jobTitle }</td>
				<td align="left">${prove.result }</td>
				
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
                
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