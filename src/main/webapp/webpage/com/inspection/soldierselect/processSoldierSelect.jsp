<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>士官选取</title>
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
        input[type="text"] {
            width: 100%;
        }
    </style>
</head>
<body id="page-top">
<!-- Navigation-->
<div class="content-wrapper">
    <div class="container-fluid">
        <form id="processSoldierSelect" method="post">
            <ol class="breadcrumb">
                <a class="breadcrumb-item active" href="${webRoot }/soldierSelectController.do?soldierselect">士官选取</a>
                <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('soldierSelectController.do?viewMainDetial&id=${id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>监督纠错</a>
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
                                    <td>${soldierSelectPage.entity.name}</td>
                                    <td>性别：</td>
                                    <td>${soldierSelectPage.entity.sex}</td>
                                </tr>
                                <tr>
                                    <td>身份证号：</td>
                                    <td>${soldierSelectPage.entity.idCard}</td>
                                    <td>政治面貌：</td>
                                    <td>${soldierSelectPage.entity.politicalLandscape}</td>
                                </tr>
                                <tr>
                                    <td>民族：</td>
                                    <td>${soldierSelectPage.entity.nationalName}</td>
                                    <td>籍贯：</td>
                                    <td>${soldierSelectPage.entity.nativePlace}</td>
                                </tr>
                                <tr>
                                    <td>出生日期：</td>
                                    <td>
                                        <fmt:formatDate value='${soldierSelectPage.entity.birthDay}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>部职别：</td>
                                    <td>${soldierSelectPage.entity.jobTitle}</td>
                                </tr>
                                <tr>
                                    <td>入伍时间：</td>
                                    <td>
                                        <fmt:formatDate value='${soldierSelectPage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>军衔时间：</td>
                                    <td>
                                        <fmt:formatDate value='${soldierSelectPage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>现军衔：</td>
                                    <td>${soldierSelectPage.entity.nowRank}</td>
                                    <td>学历：</td>
                                    <td>${soldierSelectPage.entity.education}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-map-o"></i> 选取条件</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
                                <tr>
                                    <th>选取类型</th>
                                    <th>选取专业</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="selectType" value="${soldierSelectPage.selectType}">
                                    </td>
                                    <td>
                                        <input type="text" name="selectMajor" value="${soldierSelectPage.selectMajor}">
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
                                    <td>
                                        <input type="text" name="yingDao" value="${soldierSelectPage.yingDao}" onkeyup="demoEvalChange()">
                                    </td>
                                    <td>
                                        <input type="text" name="shiDao" value="${soldierSelectPage.shiDao}" onkeyup="demoEvalChange()">
                                    </td>
                                    <td>
                                        <input type="text" name="youXiao" value="${soldierSelectPage.youXiao}">
                                    </td>
                                    <td>
                                        <input type="text" name="chuQin" value="${soldierSelectPage.chuQin}" readonly="readonly">
                                    </td>
                                    <td>
                                        <input type="text" name="zanCheng" value="${soldierSelectPage.zanCheng}" onkeyup="demoEvalChange()">
                                    </td>
                                    <td>
                                        <input type="text" name="recommandRate" value="${soldierSelectPage.recommandRate}" readonly="readonly">
                                    </td>
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
                                    <th>身体和心理素质</th>
                                    <th>基本理论</th>
                                    <th>军事技能</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="shenTi" value="${soldierSelectPage.shenTi}">
                                    </td>
                                    <td>
                                        <input type="text" name="jiBenLiLun" value="${soldierSelectPage.jiBenLiLun}">
                                    </td>
                                    <td>
                                        <input type="text" name="junShiJiNeng" value="${soldierSelectPage.junShiJiNeng}">
                                    </td>
                                </tr>
                                <tr>
                                    <th>总成绩</th>
                                    <th>排名</th>
                                    <th rowspan="2"></th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="zongChengJi" value="${soldierSelectPage.zongChengJi}">
                                    </td>
                                    <td>
                                        <input type="text" name="totalRank" value="${soldierSelectPage.totalRank}">
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-file-text"></i> 军事技能考核</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
                                <tr>
                                    <th colspan="3">基础技能</th>
                                    <th rowspan="2">专业技能</th>
                                </tr>
                                <tr>
                                    <td>3000米跑</td>
                                    <td>俯卧撑</td>
                                    <td>仰卧起坐</td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="sanQian" value="${soldierSelectPage.sanQian}">
                                    </td>
                                    <td>
                                        <input type="text" name="fuWoCheng" value="${soldierSelectPage.fuWoCheng}">
                                    </td>
                                    <td>
                                        <input type="text" name="yangWoQiZuo" value="${soldierSelectPage.yangWoQiZuo}">
                                    </td>
                                    <td>
                                        <input type="text" name="zhuanYeJiNeng" value="${soldierSelectPage.zhuanYeJiNeng}">
                                    </td>
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
                            <i class="fa fa-file-text-o"></i> 基本理论考核</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
                                <tr>
                                    <th>政治理论</th>
                                    <th>法令条规</th>
                                    <th>军事理论基础</th>
                                    <th>专业理论</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="zhengZhiLiLun" value="${soldierSelectPage.zhengZhiLiLun}">
                                    </td>
                                    <td>
                                        <input type="text" name="faLingTiaoGui" value="${soldierSelectPage.faLingTiaoGui}">
                                    </td>
                                    <td>
                                        <input type="text" name="junShiLilun" value="${soldierSelectPage.junShiLilun}">
                                    </td>
                                    <td>
                                        <input type="text" name="zhuanYeLiLun" value="${soldierSelectPage.zhuanYeLiLun}">
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-universal-access"></i> 身体和心理素质考核</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
                                <tr>
                                    <th>体检</th>
                                    <th>心理素质</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="tiJian" value="${soldierSelectPage.tiJian}">
                                    </td>
                                    <td>
                                        <input type="text" name="xinLiSuZhi" value="${soldierSelectPage.xinLiSuZhi}">
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
                                        <input class="Wdate" onClick="WdatePicker()" name="zhiBuTime"
                                        value="<fmt:formatDate value='${soldierSelectPage.zhiBuTime}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input type="text" name="zhiBuJueDing" value="${soldierSelectPage.zhiBuJueDing}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>营党委研究确定选取对象</td>
                                    <td>
                                        <input class="Wdate" onClick="WdatePicker()" name="yingDangWeiTime"
                                               value="<fmt:formatDate value='${soldierSelectPage.yingDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input type="text" name="yingDangWeiJueDing" value="${soldierSelectPage.yingDangWeiJueDing}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>旅党委研究确定选取对象</td>
                                    <td>
                                        <input class="Wdate" onClick="WdatePicker()" name="lvDangWeiTime"
                                               value="<fmt:formatDate value='${soldierSelectPage.lvDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input type="text" name="lvDangWeiJueDing" value="${soldierSelectPage.lvDangWeiJueDing}">
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
                <a href="${webRoot }/soldierSelectController.do?soldierselect" class="l-btn">
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
            add('录入',"reportController.do?addorupdate&type=jiucuo&url=" + url,'reportList',null,400);
        }

        function demoEvalChange(){
            var yingDao = $("input[name='yingDao']").val();
            var shiDao = $("input[name='shiDao']").val();
            var zanCheng = $("input[name='zanCheng']").val();
            if(shiDao && yingDao){
                var chuQin = (shiDao/yingDao).toFixed(2)*100+"%";
                $("input[name='chuQin']").attr("value",chuQin);
            }
            if(shiDao && zanCheng){
                var recommandRate = (zanCheng/shiDao).toFixed(2)*100+"%";
                $("input[name='recommandRate']").attr("value",recommandRate);
            }
        }

        function submitPerformances() {
            var arry = $("#processSoldierSelect").serialize();
            var id = "${soldierSelectPage.entity.id}";
            $.ajax({
                url : "soldierSelectController.do?modifyProcess&id="+id,
                type : "POST",
                data : arry,
                async : false,
                cache : false,
                traditional : true,
                error : function() {
                    alert("修改失败!!!");
                },
                success : function() {
                    alert("保存成功");
                    location.href = "soldierSelectController.do?viewMainDetial&id=" + id + "&isView=true";
                }
            });
        }
    </script>
</div>
</body>
</html>