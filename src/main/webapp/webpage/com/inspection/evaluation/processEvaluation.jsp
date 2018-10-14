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
        <form id="processEvaluation" method="post" enctype="multipart/form-data">
            <ol class="breadcrumb">
                <a class="breadcrumb-item active" href="${webRoot }/evaluationResidualController.do?evaluationResidual">官兵评残</a>
                <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('evaluationResidualController.do?viewMainDetial&id=${evaluationResidualPage.entity.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
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
                                    <td>${evaluationResidualPage.entity.name}</td>
                                    <td>性别：</td>
                                    <td>${evaluationResidualPage.entity.sex}</td>
                                </tr>
                                <tr>
                                    <td>出生时间：</td>
                                    <td>
                                        <fmt:formatDate value='${evaluationResidualPage.entity.birthDay}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>政治面貌：</td>
                                    <td>${evaluationResidualPage.entity.political}</td>
                                </tr>
                                <tr>
                                    <td>籍贯：</td>
                                    <td>${evaluationResidualPage.entity.nativePlace}</td>
                                    <td>民族：</td>
                                    <td>${evaluationResidualPage.entity.nationalName}</td>
                                </tr>
                                <tr>
                                    <td>部职别：</td>
                                    <td>${evaluationResidualPage.entity.jobTitle}</td>
                                    <td>现军衔：</td>
                                    <td>${evaluationResidualPage.entity.nowRank}</td>
                                </tr>
                                <tr>
                                    <td>现军衔时间：</td>
                                    <td>
                                        <fmt:formatDate value='${evaluationResidualPage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>学历：</td>
                                    <td>${evaluationResidualPage.entity.education}</td>
                                </tr>
                                <tr>
                                    <td>入伍时间：</td>
                                    <td>
                                        <fmt:formatDate value='${evaluationResidualPage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-pencil"></i> 证明人</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" cellspacing="0">
                                <tr>
                                    <th>证明人一</th>
                                    <th>证明人二</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="zhengMingRen1" value="${evaluationResidualPage.zhengMingRen1}">
                                    </td>
                                    <td>
                                        <input type="text" name="zhengMingRen2" value="${evaluationResidualPage.zhengMingRen2}">
                                    </td>
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
                            <i class="fa fa-hand-stop-o"></i> 评残审查</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" cellspacing="0">
                                <tr>
                                    <th rowspan="2" style="vertical-align: middle">个人自述</th>
                                    <th rowspan="2" style="vertical-align: middle">致残性质</th>
                                    <th colspan="3">旁证人</th>
                                </tr>
                                <tr>
                                    <td>旁证人一</td>
                                    <td>旁证人二</td>
                                    <td>旁证人三</td>
                                </tr>
                                <tr>
                                    <td class="file-space">
                                        <input name="geRenZiShu" type="file"
                                               accept="application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document"/>
                                        <div class='file-type-tip' style="color:#999999">注：请上传word格式文档</div>
                                    </td>
                                    <td>
                                        <input type="text" name="zhiCanXingZhi" value="${evaluationResidualPage.zhiCanXingZhi}">
                                    </td>
                                    <td>
                                        <input type="text" name="oanZhengRen1" value="${evaluationResidualPage.oanZhengRen1}">
                                    </td>
                                    <td>
                                        <input type="text" name="oanZhengRen2" value="${evaluationResidualPage.oanZhengRen2}">
                                    </td>
                                    <td>
                                        <input type="text" name="oanZhengRen3" value="${evaluationResidualPage.oanZhengRen3}">
                                    </td>
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
                            <i class="fa fa-hand-stop-o"></i> 残疾评定</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" cellspacing="0">
                                <tr>
                                    <th>病情与致残标准符合性</th>
                                    <th>党委会决议</th>
                                    <th colspan="2">身份信息</th>
                                </tr>
                                <tr>
                                    <td class="file-space" rowspan="2" style="vertical-align: middle">
                                        <input name="fuHeXing" type="file"
                                               accept="application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document"/>
                                        <div class='file-type-tip' style="color:#999999">注：请上传word格式文档</div>
                                    </td>
                                    <td rowspan="2">
                                        <input type="text" name="jueYi" value="${evaluationResidualPage.jueYi}">
                                    </td>
                                    <td class="file-space">
                                        <input name="shenFenZheng" type="file" accept="image/*"/>
                                        <div class='file-type-tip' style="color:#999999">注：请上传身份证(图片格式)</div>
                                    </td>
                                    <td class="file-space">
                                        <input name="junGuangZheng" type="file" accept="image/*"/>
                                        <div class='file-type-tip' style="color:#999999">注：请上传军官证(图片格式)</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="file-space">
                                        <input name="baoZhangKa" type="file" accept="image/*"/>
                                        <div class='file-type-tip' style="color:#999999">注：请上传保障卡(图片格式)</div>
                                    </td>
                                    <td class="file-space">
                                        <input name="bingLibingLi" type="file" accept="image/*"/>
                                        <div class='file-type-tip' style="color:#999999">注：请上传病历复印证(图片格式)</div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div>
                <a onclick="submitPerformances()" class="l-btn">
                    <span class="l-btn-left" style="background:-webkit-gradient(linear, 0% 0%, 0% 100%, from(#33bbee), to(#2288cc)); color: #fff;">提交</span>
                </a>
                <a href="${webRoot }/evaluationResidualController.do?evaluationResidual" class="l-btn">
                    <span class="l-btn-left">返回</span>
                </a>
            </div>
        </form>
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

        function submitPerformances() {
            var arry = $("#processEvaluation").serialize();
            var id = "${evaluationResidualPage.entity.id}";
            $.ajax({
                url : "evaluationResidualController.do?modifyProcess&id="+id,
                type : "POST",
                data : arry,
                async : false,
                cache : false,
                error : function() {
                    alert("修改失败!!!");
                },
                success : function() {
                    alert("保存成功");
                    location.href = "evaluationResidualController.do?viewMainDetial&id=" + id + "&isView=true";
                }
            });
        }
    </script>
</div>
</body>
</html>