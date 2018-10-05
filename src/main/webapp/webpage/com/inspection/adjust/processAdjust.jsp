<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>干部调整</title>
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
            <li class="breadcrumb-item active">干部配备调整</li>
            <c:if test="${empty isView}">
                <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('adjustController.do?viewDetailMain&id=${adjustPage.adjust.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
            </c:if>
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
                                <td>出生时间：</td>
                                <td>
                                    <fmt:formatDate value='${adjustPage.adjust.birthDay}' type="date" pattern="yyyy-MM-dd"/>
                                </td>
                                <td>政治面貌：</td>
                                <td>${adjustPage.adjust.politicalLandscape}</td>
                            </tr>

                            <tr>
                                <td>籍贯：</td>
                                <td>${adjustPage.adjust.nativePlace}</td>
                                <td>民族：</td>
                                <td>${adjustPage.adjust.nationalName}</td>
                            </tr>

                            <tr>
                                <td>部职别：</td>
                                <td>${adjustPage.adjust.jobTitle}</td>
                                <td>现军衔：</td>
                                <td>${adjustPage.adjust.nowRank}</td>
                            </tr>

                            <tr>
                                <td>现军衔时间：</td>
                                <td>
                                    <fmt:formatDate value='${adjustPage.adjust.rankTime}' type="date" pattern="yyyy-MM-dd"/>
                                </td>
                                <td>学历：</td>
                                <td>${adjustPage.adjust.education}</td>
                            </tr>
                            <tr>
                                <td>入伍时间：</td>
                                <td>
                                    <fmt:formatDate value='${adjustPage.adjust.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-file-text"></i> 三评三考总体成绩</div>
                    <div class="card-body">
                        <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
                            <tr>
                                <th>三评总体成绩</th>
                                <th>三考总体成绩</th>
                                <th>排名</th>
                            </tr>
                            <tr>
                                <td>${commentExam.commentScore}</td>
                                <td>${commentExam.examScore}</td>
                                <td>${commentExam.rank}</td>
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