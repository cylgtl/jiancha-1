<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>军官请假</title>
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
<div class="content-wrapper">
    <div class="container-fluid">
        <form id="processOfficerLeave" method="post">
            <ol class="breadcrumb">
                <a class="breadcrumb-item active" href="${webRoot }/officerLeaveController.do?officerLeave">军官请假</a>
                <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('officerLeaveController.do?viewMainDetial&id=${officerLeaveId}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
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
                                    <td>${officerLeavePage.entity.name}</td>
                                    <td>性别：</td>
                                    <td>${officerLeavePage.entity.sex}</td>
                                </tr>
                                <tr>
                                    <td>政治面貌:</td>
                                    <td >${officerLeavePage.entity.political}</td>
                                </tr>
                                <tr>
                                    <td>民族：</td>
                                    <td>${officerLeavePage.entity.national}</td>
                                    <td>籍贯：</td>
                                    <td>${officerLeavePage.entity.nativePlace}</td>
                                </tr>
                                <tr>
                                    <td>出生日期:</td>
                                    <td>
                                        <fmt:formatDate value='${officerLeavePage.entity.birthday}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>部职别：</td>
                                    <td>${officerLeavePage.entity.jobTitle}</td>
                                </tr>
                                <tr>
                                    <td>入伍时间:</td>
                                    <td>
                                        <fmt:formatDate value='${officerLeavePage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>军衔时间:</td>
                                    <td>
                                        <fmt:formatDate value='${officerLeavePage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>现军衔:</td>
                                    <td>${officerLeavePage.entity.nowRank}</td>
                                    <td>学历:</td>
                                    <td>${officerLeavePage.entity.educational}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-street-view"></i> 个人休假计划</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
                                <tr>
                                    <th>次数</th>
                                    <th>计划休假时间</th>
                                </tr>
                                <tr>
                                    <td>${officerLeavePage.ciShi1}</td>
                                    <td>
                                        <select name="jiHuaXiuJia1">
                                            <option value="1" <c:if test="${1==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>1</option>
                                            <option value="2" <c:if test="${2==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>2</option>
                                            <option value="3" <c:if test="${3==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>3</option>
                                            <option value="4" <c:if test="${4==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>4</option>
                                            <option value="5" <c:if test="${5==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>5</option>
                                            <option value="6" <c:if test="${6==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>6</option>
                                            <option value="7" <c:if test="${7==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>7</option>
                                            <option value="8" <c:if test="${8==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>8</option>
                                            <option value="9" <c:if test="${9==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>9</option>
                                            <option value="10" <c:if test="${10==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>10</option>
                                            <option value="11" <c:if test="${11==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>11</option>
                                            <option value="12" <c:if test="${12==officerLeavePage.jiHuaXiuJia1 }">selected="selected"</c:if>>12</option>
                                        </select>
                                    (月份)</td>
                                </tr>
                                <tr>
                                    <td>${officerLeavePage.ciShi2}</td>
                                    <td>
                                        <select name="jiHuaXiuJia2">
                                            <option value="1" <c:if test="${1==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>1</option>
                                            <option value="2" <c:if test="${2==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>2</option>
                                            <option value="3" <c:if test="${3==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>3</option>
                                            <option value="4" <c:if test="${4==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>4</option>
                                            <option value="5" <c:if test="${5==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>5</option>
                                            <option value="6" <c:if test="${6==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>6</option>
                                            <option value="7" <c:if test="${7==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>7</option>
                                            <option value="8" <c:if test="${8==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>8</option>
                                            <option value="9" <c:if test="${9==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>9</option>
                                            <option value="10" <c:if test="${10==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>10</option>
                                            <option value="11" <c:if test="${11==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>11</option>
                                            <option value="12" <c:if test="${12==officerLeavePage.jiHuaXiuJia2 }">selected="selected"</c:if>>12</option>
                                        </select>
                                        (月份)</td>
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
                            <i class="fa fa-hand-stop-o"></i> 休假情况</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" cellspacing="0">
                                <tr>
                                    <th>总天数</th>
                                    <th>已休天数</th>
                                    <th>未休天数</th>
                                    <th>休假类型</th>
                                    <th>本次休假天数</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="zongTianShu" value="${officerLeavePage.zongTianShu}">
                                    </td>
                                    <td>
                                        <input type="text" name="yiXiuTianShu" value="${officerLeavePage.yiXiuTianShu}">
                                    </td>
                                    <td>
                                        <input type="text" name="weiXiuTianShu" value="${officerLeavePage.weiXiuTianShu}">
                                    </td>
                                    <td>
                                        <input type="text" name="xiuJiaLeiXing" value="${officerLeavePage.xiuJiaLeiXing}">
                                    </td>
                                    <td>
                                        <input type="text" name="benCiXiuJia" value="${officerLeavePage.benCiXiuJia}">
                                    </td>
                                </tr>
                                <tr>
                                    <th>剩余天数</th>
                                    <th>起止时间</th>
                                    <th>离队时间</th>
                                    <th>销假时间</th>
                                    <th>在位率</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="shengYuTianShu" value="${officerLeavePage.shengYuTianShu}">
                                    </td>
                                    <td>
                                        <input class="Wdate" onClick="WdatePicker()" name="startTime"
                                               value="<fmt:formatDate value='${officerLeavePage.startTime}' type="date" pattern="yyyy-MM-dd"/>">
                                        -
                                        <input class="Wdate" onClick="WdatePicker()" name="endTime"
                                               value="<fmt:formatDate value='${officerLeavePage.endTime}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input class="Wdate" onClick="WdatePicker()" name="liDuiShiJian"
                                               value="<fmt:formatDate value='${officerLeavePage.liDuiShiJian}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input class="Wdate" onClick="WdatePicker()" name="xiaoJiaShiJian"
                                               value="<fmt:formatDate value='${officerLeavePage.xiaoJiaShiJian}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input type="text" name="zaiWeiLv" value="${officerLeavePage.zaiWeiLv}">
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
                <a href="${webRoot }/officerLeaveController.do?officerLeave" class="l-btn">
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
            var arry = $("#processOfficerLeave").serialize();
            var id = "${officerLeavePage.entity.id}";
            $.ajax({
                url : "soldierLeaveController.do?modifyProcess&id="+id,
                type : "POST",
                data : arry,
                async : false,
                cache : false,
                error : function() {
                    alert("修改失败!!!");
                },
                success : function() {
                    alert("保存成功");
                    location.href = "officerLeaveController.do?viewMainDetial&id=" + id + "&isView=true";
                }
            });
        }
    </script>
</div>
</body>
</html>