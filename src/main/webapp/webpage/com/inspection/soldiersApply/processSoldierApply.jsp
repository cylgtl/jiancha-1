<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>士兵考学</title>
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
        <form id="processSoldierApply" method="post">
            <ol class="breadcrumb">
                <a class="breadcrumb-item active" href="${webRoot }/soldiersApplyController.do?soldiersApply">士兵考学</a>
                <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('soldiersApplyController.do?viewDetailMain&id=${id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>监督纠错</a>
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
                                    <td>${soldiersApplyPage.entity.name}</td>
                                    <td>性别：</td>
                                    <td>${soldiersApplyPage.entity.sex}</td>
                                </tr>
                                <tr>
                                    <td>身份证号：</td>
                                    <td>${soldiersApplyPage.entity.idcard}</td>
                                    <td>政治面貌：</td>
                                    <td>${soldiersApplyPage.entity.politicalStatus}</td>
                                </tr>
                                <tr>
                                    <td>民族：</td>
                                    <td>${soldiersApplyPage.entity.nation}</td>
                                    <td>籍贯：</td>
                                    <td>${soldiersApplyPage.entity.nativePlace}</td>
                                </tr>
                                <tr>
                                    <td>出生日期：</td>
                                    <td>
                                        <fmt:formatDate value='${soldiersApplyPage.entity.birthday}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>部职别：</td>
                                    <td>${soldiersApplyPage.entity.jobTitle}</td>
                                </tr>
                                <tr>
                                    <td>入伍时间：</td>
                                    <td>
                                        <fmt:formatDate value='${soldiersApplyPage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>现军衔时间：</td>
                                    <td>
                                        <fmt:formatDate value='${soldiersApplyPage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>现军衔：</td>
                                    <td>${soldiersApplyPage.entity.nowRank}</td>
                                    <td>学历：</td>
                                    <td>${soldiersApplyPage.entity.educational}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-hourglass-start"></i> 总体成绩</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
                                <tr>
                                    <th>预选考核成绩</th>
                                    <th>直前考核成绩</th>
                                    <th>加分</th>
                                    <th>总成绩</th>
                                    <th>排名</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="yuXuanKaoHe" value="${soldiersApplyPage.yuXuanKaoHe}">
                                    </td>
                                    <td>
                                        <input type="text" name="zhiQianKaoHe" value="${soldiersApplyPage.zhiQianKaoHe}">
                                    </td>
                                    <td>
                                        <input type="text" name="jiaFen" value="${soldiersApplyPage.jiaFen}">
                                    </td>
                                    <td>
                                        <input type="text" name="zongChengJi" value="${soldiersApplyPage.zongChengJi}">
                                    </td>
                                    <td>
                                        <input type="text" name="rank" value="${soldiersApplyPage.rank}">
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
                                        <input type="text" name="yingDao" value="${soldiersApplyPage.yingDao}" onkeyup="demoEvalChange()">
                                    </td>
                                    <td>
                                        <input type="text" name="shiDao" value="${soldiersApplyPage.shiDao}" onkeyup="demoEvalChange()">
                                    </td>
                                    <td>
                                        <input type="text" name="youXiao" value="${soldiersApplyPage.youXiao}">
                                    </td>
                                    <td>
                                        <input type="text" name="chuQin" value="${soldiersApplyPage.chuQin}" readonly="readonly">
                                    </td>
                                    <td>
                                        <input type="text" name="zanCheng" value="${soldiersApplyPage.zanCheng}" onkeyup="demoEvalChange()">
                                    </td>
                                    <td>
                                        <input type="text" name="recommandRate" value="${soldiersApplyPage.recommandRate}" readonly="readonly">
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
                            <i class="fa fa-file-text"></i> 文化考核</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" style="font-size: 12px;" cellspacing="0">
                                <tr>
                                    <th>语文</th>
                                    <th>数学</th>
                                    <th>英语</th>
                                    <th>综合</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="yuWen" value="${soldiersApplyPage.yuWen}">
                                    </td>
                                    <td>
                                        <input type="text" name="shuXue" value="${soldiersApplyPage.shuXue}">
                                    </td>
                                    <td>
                                        <input type="text" name="yingYu" value="${soldiersApplyPage.yingYu}">
                                    </td>
                                    <td>
                                        <input type="text" name="zongHe" value="${soldiersApplyPage.zongHe}">
                                    </td>
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
                                    <td>
                                        <input type="text" name="tiJianJieGuo" value="${soldiersApplyPage.tiJianJieGuo}">
                                    </td>
                                    <td>
                                        <input type="text" name="shuoMing" value="${soldiersApplyPage.shuoMing}">
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
                            <i class="fa fa-file-text"></i> 军事共同考核</div>
                        <div class="card-body">
                            <table class="table table-bordered" width="100%" cellspacing="0">
                                <tr>
                                    <th>科目</th>
                                    <th>停止间转法</th>
                                    <th>前进</th>
                                    <th>仰卧起坐</th>
                                    <th>实弹射击</th>
                                    <th>30*2蛇形跑</th>
                                    <th>3000米</th>
                                </tr>
                                <tr>
                                    <td>成绩</td>
                                    <td>
                                        <input type="text" name="tiZhi" value="${soldiersApplyPage.tiZhi}">
                                    </td>
                                    <td>
                                        <input type="text" name="qianJing" value="${soldiersApplyPage.qianJing}">
                                    </td>
                                    <td>
                                        <input type="text" name="yangWo" value="${soldiersApplyPage.yangWo}">
                                    </td>
                                    <td>
                                        <input type="text" name="shiDan" value="${soldiersApplyPage.shiDan}">
                                    </td>
                                    <td>
                                        <input type="text" name="sheXing" value="${soldiersApplyPage.sheXing}">
                                    </td>
                                    <td>
                                        <input type="text" name="sanQian" value="${soldiersApplyPage.sanQian}">
                                    </td>
                                </tr>
                            </table>
                            <div style="margin-bottom: 10px;">
                                <span style="font-size: 14px;margin-right: 10px">加分明细</span>
                                <a class="l-btn" onclick="addJunItem()">
                                    <span class="l-btn-left">添加</span>
                                </a>
                            </div>
                            <table id="junShiJiaFen" class="table table-bordered" width="100%" cellspacing="0">
                                <tr>
                                    <th>时间</th>
                                    <th>明细</th>
                                    <th>操作</th>
                                </tr>
                                <c:if test="${fn:length(soldiersApplyPage.junShiJiaFen) > 0 }">
                                    <c:forEach items="${soldiersApplyPage.junShiJiaFen}" var="junShi" varStatus="stuts">
                                        <tr id="${stuts.index}_junShiJiaFens">
                                            <td>
                                                <input class="Wdate" onClick="WdatePicker()" name="${stuts.index}_time"
                                                       value="<fmt:formatDate value='${junShi.time}' type="date" pattern="yyyy-MM-dd"/>">
                                            </td>
                                            <td><input type="text" name="${stuts.index}_detail" value="${junShi.detail}"></td>
                                            <td><a href="#" onclick="deleteItem('${stuts.index}_junShiJiaFens')">删除</a></td>
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
                                        <input class="Wdate" onClick="WdatePicker()" name="zhiBuTime"
                                               value="<fmt:formatDate value='${soldiersApplyPage.zhiBuTime}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input type="text" name="zhiBuJueDing" value="${soldiersApplyPage.zhiBuJueDing}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>营党委研究确定选取对象</td>
                                    <td>
                                        <input class="Wdate" onClick="WdatePicker()" name="yingDangWeiTime"
                                               value="<fmt:formatDate value='${soldiersApplyPage.yingDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input type="text" name="yingDangWeiJueDing" value="${soldiersApplyPage.yingDangWeiJueDing}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>旅党委研究确定选取对象</td>
                                    <td>
                                        <input class="Wdate" onClick="WdatePicker()" name="lvDangWeiTime"
                                               value="<fmt:formatDate value='${soldiersApplyPage.lvDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input type="text" name="lvDangWeiJueDing" value="${soldiersApplyPage.lvDangWeiJueDing}">
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
                <a href="${webRoot }/soldiersApplyController.do?soldiersApply" class="l-btn">
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

        function addJunItem(){
            var count = $("#junShiJiaFen tr").length - 1;
            var values = "";
            var tr = "<tr id="+ count +"_junShiJiaFens"+">\n" +
                " <td>\n" +
                " <input class=\"Wdate\" onClick=\"WdatePicker()\" name="+ count +"_time\"\n" +
                " value=\"<fmt:formatDate value='${junShi.time}' type='date' pattern='yyyy-MM-dd'/>\">\n" +
                " </td>\n" +
                " <td><input type=\"text\" name="+ count +"_detail\" value="+values+"></td>\n" +
                " <td><a href=\"#\" onclick=\"deleteItem('"+ count +"_junShiJiaFens')\">删除</a></td>\n" +
                " </tr>";
            $("#junShiJiaFen").append(tr);
        }

        function deleteItem(index){
            $("tr[id='"+index+"']").remove();
        }

        function submitPerformances() {
            var temp = $("#processSoldierApply").serializeArray();
            var data = {}, times = [], details = [];
            $.each(temp,function(i,v){
                if(v.name.indexOf("_time")>-1){
                    times.push(v.value);
                }else if(v.name.indexOf("_detail")>-1){
                    details.push(v.value||"");
                } else {
                    data[v.name] = v.value;
                }
            });
            data.times = times;
            data.details = details;
            var id = "${soldiersApplyPage.entity.id}";
            $.ajax({
                url : "soldiersApplyController.do?modifyProcess&id="+id,
                type : "POST",
                data : data,
                async : false,
                cache : false,
                traditional:true,
                error : function() {
                    alert("修改失败!!!");
                },
                success : function() {
                    alert("保存成功");
                    location.href = "soldiersApplyController.do?viewDetailMain&id=" + id + "&isView=true";
                }
            });
        }
    </script>
</div>
</body>
</html>