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
        .min-zhu input{
            width: 60px;
        }
        .min-zhu td,.min-zhu th{
            padding: 0.45rem;
        }
        #jiaJian input{
            width: 100%;
        }
    </style>
</head>
<body id="page-top">
<!-- Navigation-->
<div class="content-wrapper">
    <div class="container-fluid">
        <form id="processAdjust" method="post">
            <ol class="breadcrumb">
                <a class="breadcrumb-item active" href="${webRoot }/adjustController.do?adjust">干部配备调整</a>
                <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('jiucuo','adjustController.do?viewDetailMain&id=${adjustPage.adjust.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>监督纠错</a>
            <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('fankui','adjustController.do?viewDetailMain&id=${adjustPage.adjust.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>情况反馈</a>
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
                                    <td>
                                        <input type="text" name="sanPingScore" value="${adjustPage.sanPingScore}">
                                    </td>
                                    <td>
                                        <input type="text" name="sanKaoScore" value="${adjustPage.sanKaoScore}">
                                    </td>
                                    <td>
                                        <input type="text" name="totalRank" value="${adjustPage.totalRank}">
                                    </td>
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
                                <table class="table table-bordered min-zhu" width="100%" cellspacing="0">
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
                                            <input type="text" name="yingDao" value="${adjustPage.yingDao}" onkeyup="demoEvalChange()">
                                        </td>
                                        <td>
                                            <input type="text" name="shiDao" value="${adjustPage.shiDao}" onkeyup="demoEvalChange()">
                                        </td>
                                        <td>
                                            <input type="text" name="youXiao" value="${adjustPage.youXiao}">
                                        </td>
                                        <td>
                                            <input type="text" name="chuQin" value="${adjustPage.chuQin}" readonly="readonly">
                                        </td>
                                        <td>
                                            <input type="text" name="zanCheng" value="${adjustPage.zanCheng}" onkeyup="demoEvalChange()">
                                        </td>
                                        <td>
                                            <input type="text" name="testRate" value="${adjustPage.testRate}" readonly="readonly">
                                        </td>
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
                                <table class="table table-bordered min-zhu" width="100%" cellspacing="0">
                                    <tr>
                                        <th>总票数</th>
                                        <th>推荐票数</th>
                                        <th>得票率</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="text" name="totalTicket" value="${adjustPage.totalTicket}" onkeyup="voteRateChange()">
                                        </td>
                                        <td>
                                            <input type="text" name="recommandTicket" value="${adjustPage.recommandTicket}" onkeyup="voteRateChange()">
                                        </td>
                                        <td>
                                            <input type="text" name="ticketRate" value="${adjustPage.ticketRate}" readonly="readonly">
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
                                <i class="fa fa-tasks"></i> 评岗位历练</div>
                            <div class="card-body">
                                <div style="margin-bottom: 10px;">
                                    <a class="l-btn" onclick="addItem()">
                                        <span class="l-btn-left">添加</span>
                                    </a>
                                </div>
                                <table id="jiaJian" class="table table-bordered" width="100%" cellspacing="0">
                                    <tr>
                                        <th>现职级期间加减项目</th>
                                        <th>操作</th>
                                    </tr>
                                    <c:if test="${fn:length(adjustPage.jiaJianXiang)  > 0 }">
                                        <c:forEach items="${adjustPage.jiaJianXiang}" var="recommend" varStatus="stuts">
                                            <tr id="${stuts.index}_recommends">
                                                <td><input type="text" name="${stuts.index}_recommends" value="${recommend}"></td>
                                                <td><a href="#" onclick="deleteItem('${stuts.index}_recommends')">删除</a></td>
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
                                        <td>
                                            <input type="text" name="pingShen" value="${adjustPage.pingShen}">
                                        </td>
                                        <td>
                                            <input type="text" name="pingShenScore" value="${adjustPage.pingShenScore}">
                                        </td>
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
                                        <td><input type="text" name="sanQian" value="${adjustPage.sanQian}"></td>
                                        <td><input type="text" name="yingTi" value="${adjustPage.yingTi}"></td>
                                        <td><input type="text" name="tiNeng" value="${adjustPage.tiNeng}"></td>
                                        <td><input type="text" name="junShi" value="${adjustPage.junShi}"></td>
                                        <td><input type="text" name="tuShang" value="${adjustPage.tuShang}"></td>
                                    </tr>
                                    <tr>
                                        <th>科目</th>
                                        <th>指挥信息系统使用</th>
                                        <th>作战指标</th>
                                        <th>作战计算</th>
                                        <th>射击</th>
                                        <th>军事科目得分</th>
                                        <td rowspan="2" style="vertical-align: middle">
                                            <input type="text" name="junShiChengJi" value="${adjustPage.junShiChengJi}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>成绩</td>
                                        <td><input type="text" name="zhiHuiXinXi" value="${adjustPage.zhiHuiXinXi}"></td>
                                        <td><input type="text" name="zuoZhanBiaoTu" value="${adjustPage.zuoZhanBiaoTu}"></td>
                                        <td><input type="text" name="zuoZhanJiSuan" value="${adjustPage.zuoZhanJiSuan}"></td>
                                        <td><input type="text" name="sheJi" value="${adjustPage.sheJi}"></td>
                                        <td><input type="text" name="junSHiKeMu" value="${adjustPage.junSHiKeMu}"></td>
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
                                        <td>得分</td>
                                        <td><input type="text" name="yingZhiYingHui" value="${adjustPage.yingZhiYingHui}"></td>
                                        <td><input type="text" name="zhuanYeLiLun" value="${adjustPage.zhuanYeLiLun}"></td>
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
                                        <td><input style="width:100%" type="text" name="gongZuoSiLu" value="${adjustPage.gongZuoSiLu}"></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div>
                <a onclick="submitPerformances()" class="l-btn">
                    <span class="l-btn-left" style="background:-webkit-gradient(linear, 0% 0%, 0% 100%, from(#33bbee), to(#2288cc)); color: #fff;">提交</span>
                </a>
                <a href="${webRoot }/adjustController.do?adjust" class="l-btn">
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
        function goToReport(type, url) {
            add('录入',"reportController.do?addorupdate&type="+type+"&url=" + url,'reportList',null,400);
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
                var testRate = (zanCheng/shiDao).toFixed(2)*100+"%";
                $("input[name='testRate']").attr("value",testRate);
            }
        }

        function voteRateChange(){
            var totalTicket = $("input[name='totalTicket']").val();
            var recommandTicket = $("input[name='recommandTicket']").val();
            if(recommandTicket && totalTicket){
                var ticketRate = (recommandTicket/totalTicket).toFixed(2)*100+"%";
                $("input[name='ticketRate']").attr("value",ticketRate);
            }
        }

        function addItem(){
            var count = $("#jiaJian tr").length - 1;
            var value = "";
            var tr = "<tr id="+ count +"_recommends"+">\n" +
                " <td><input type=\"text\" name="+ count +"_recommends\" value="+ value +"></td>\n" +
                " <td><a href=\"#\" onclick=\"deleteItem('"+count+"_recommends')\">删除</a></td>\n" +
                " </tr>";

            $("#jiaJian").append(tr);
        }

        function deleteItem(index){
            $("tr[id='"+index+"']").remove();
        }

        function submitPerformances() {
            var temp = $("#processAdjust").serializeArray();
            var data = {}, jia = [];
            $.each(temp,function(i,v){
                if(v.name.indexOf("_recommends")>-1){
                    jia.push(v.value);
                }else {
                    data[v.name] = v.value;
                }
            });
            data.jiaJianXiang = jia;
            var id = "${adjustPage.adjust.id}";
            $.ajax({
                url : "adjustController.do?modifyProcess&id="+id,
                type : "POST",
                data : data,
                traditional:true,
                async : false,
                cache : false,
                error : function() {
                    alert("修改失败!!!");
                },
                success : function() {
                    alert("保存成功");
                    location.href = "adjustController.do?viewDetailMain&id=" + id+ "&isView=true";
                }
            });
        }
    </script>
</div>
</body>
</html>