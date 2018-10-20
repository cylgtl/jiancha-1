<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>骨干配备</title>
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
        #shoujiang td, #junShi td {
            vertical-align: middle;
        }
    </style>
</head>
<body id="page-top">
<!-- Navigation-->
<div class="content-wrapper">
    <div class="container-fluid">
        <form id="processBackbone" method="post" enctype="multipart/form-data">
            <ol class="breadcrumb">
                <a class="breadcrumb-item active" href="${webRoot }/backboneController.do?backbone">骨干配备</a>
                <a id="toReport" class="mr-3 d-inline-block" href="javascript:goToReport('backboneController.do?viewMainDetial&id=${backbonePage.entity.id}')" style="margin-left: 100px;"><i class="fa fa-fw fa-comment"></i>我要举报</a>
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
                                    <td>${backbonePage.entity.name}</td>
                                    <td>性别：</td>
                                    <td>${backbonePage.entity.sex}</td>
                                </tr>
                                <tr>
                                    <td>籍贯：</td>
                                    <td>${backbonePage.entity.nativePlace}</td>
                                    <td>部职别：</td>
                                    <td >${backbonePage.entity.jobTitle}</td>
                                </tr>
                                <tr>
                                    <td>出生日期:</td>
                                    <td>
                                        <fmt:formatDate value='${backbonePage.entity.birthDay}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>入伍时间:</td>
                                    <td>
                                        <fmt:formatDate value='${backbonePage.entity.militaryTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>现军衔:</td>
                                    <td>${backbonePage.entity.nowRank}</td>
                                    <td>军衔时间:</td>
                                    <td>
                                        <fmt:formatDate value='${backbonePage.entity.rankTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>学历:</td>
                                    <td>${backbonePage.entity.education}</td>
                                    <td>现专业:</td>
                                    <td>${backbonePage.entity.nowProfessional}</td>
                                </tr>
                                <tr>
                                    <td>毕业时间:</td>
                                    <td>
                                        <fmt:formatDate value='${backbonePage.entity.graduateTime}' type="date" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>民族：</td>
                                    <td>${backbonePage.entity.nationalName}</td>
                                </tr>
                                <tr>
                                    <td>职务:</td>
                                    <td>${backbonePage.entity.position}</td>
                                    <td>班级:</td>
                                    <td>${backbonePage.entity.banji}</td>
                                </tr>
                                <tr>
                                    <td>政治面貌:</td>
                                    <td colspan="3">${backbonePage.entity.politicalLandscape}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-street-view"></i> 班级推荐</div>
                        <div class="card-body">
                            <textarea style="width: 100%; height: 200px; overflow: auto" name="banPaiTuiJian">${backbonePage.banPaiTuiJian}</textarea>
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
                                        <input type="text" name="yingDao" value="${backbonePage.yingDao}" onkeyup="demoEvalChange()">
                                    </td>
                                    <td>
                                        <input type="text" name="shiDao" value="${backbonePage.shiDao}" onkeyup="demoEvalChange()">
                                    </td>
                                    <td>
                                        <input type="text" name="youXiao" value="${backbonePage.youXiao}">
                                    </td>
                                    <td>
                                        <input type="text" name="chuQin" value="${backbonePage.chuQin}" readonly="readonly">
                                    </td>
                                    <td>
                                        <input type="text" name="zanCheng" value="${backbonePage.zanCheng}" onkeyup="demoEvalChange()">
                                    </td>
                                    <td>
                                        <input type="text" name="testRate" value="${backbonePage.testRate}" readonly="readonly">
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
                                    <td>支部研究确定预选对象</td>
                                    <td>
                                        <input class="Wdate" onClick="WdatePicker()" name="zhiBuTime"
                                               value="<fmt:formatDate value='${backbonePage.zhiBuTime}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input type="text" name="zhiBuJueDing" value="${backbonePage.zhiBuJueDing}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>营党委研究确定对象</td>
                                    <td>
                                        <input class="Wdate" onClick="WdatePicker()" name="yingDangWeiTime"
                                               value="<fmt:formatDate value='${backbonePage.yingDangWeiTime}' type="date" pattern="yyyy-MM-dd"/>">
                                    </td>
                                    <td>
                                        <input type="text" name="yingDangWeiJueDing" value="${backbonePage.yingDangWeiJueDing}">
                                    </td>
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
                                <div style="margin-bottom: 10px;">
                                    <a class="l-btn" onclick="addJunShiItem()">
                                        <span class="l-btn-left">添加</span>
                                    </a>
                                </div>
                                <table id="junShi" class="table table-bordered" width="100%" cellspacing="0">
                                    <tr>
                                        <th>科目</th>
                                        <th>成绩</th>
                                        <th>删除</th>
                                    </tr>
                                    <c:if test="${fn:length(backbonePage.junShiXunLian)  > 0 }">
                                        <c:forEach items="${backbonePage.junShiXunLian}" var="junshi" varStatus="stuts">
                                            <tr id="${stuts.index}_junShi">
                                                <td><input type="text" name="${stuts.index}_names" value="${junshi.name}"></td>
                                                <td><input type="text" name="${stuts.index}_scores" value="${junshi.score}"></td>
                                                <td><a href="#" onclick="deleteItem('${stuts.index}_junShi')">删除</a></td>
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
                                <div style="margin-bottom: 10px;">
                                    <a class="l-btn" onclick="addItem()">
                                        <span class="l-btn-left">添加</span>
                                    </a>
                                </div>
                                <table id="shoujiang" class="table table-bordered" width="100%" cellspacing="0">
                                    <tr>
                                        <th>序号</th>
                                        <th>条目</th>
                                        <th>删除</th>
                                    </tr>
                                    <c:if test="${fn:length(backbonePage.biaoZhang) > 0 }">
                                        <c:forEach items="${backbonePage.biaoZhang}" var="shouJiang" varStatus="stuts">
                                            <tr id="${stuts.index}_shouJiangs">
                                                <td>${stuts.index}</td>
                                                <td><input type="text" name="${stuts.index}_shouJiangs" value="${shouJiang}"></td>
                                                <td><a href="#" onclick="deleteItem('${stuts.index}_shouJiangs')">删除</a></td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
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
                <a href="${webRoot }/backboneController.do?backbone" class="l-btn">
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
                var testRate = (zanCheng/shiDao).toFixed(2)*100+"%";
                $("input[name='testRate']").attr("value",testRate);
            }
        }

        function addItem() {
            var count = $("#shoujiang tr").length - 1;
            var values = "";
            var tr = "<tr id="+count+"_shouJiangs"+">\n" +
                "<td>"+count+"</td>\n" +
                " <td><input type=\"text\" name="+count+"_shouJiangs\" value="+values+"></td>\n" +
                " <td><a href=\"#\" onclick=\"deleteItem('"+count+"_shouJiangs')\">删除</a></td>\n" +
                " </tr>";
            $("#shoujiang").append(tr);
        }

        function addJunShiItem() {
            var count = $("#junShi tr").length - 1;
            var values = "";
            var tr = "<tr id="+count+"_junShi"+">\n" +
                " <td><input type=\"text\" name="+count+"_names\" value="+values+"></td>\n" +
                " <td><input type=\"text\" name="+count+"_scores\" value="+values+"></td>\n" +
                " <td><a href=\"#\" onclick=\"deleteItem('"+count+"_junShi')\">删除</a></td>\n" +
                " </tr>";
            $("#junShi").append(tr);
        }

        function deleteItem(index){
            $("tr[id='"+index+"']").remove();
        }

        function submitPerformances() {
            var temp = $("#processBackbone").serializeArray();
            var shouJiang = [], names = [], scores = [], data = {};
            $.each(temp,function(i,v){
                if(v.name.indexOf("_shouJiangs")>-1){
                    shouJiang.push(v.value);
                }else if(v.name.indexOf("_names")>-1){
                    names.push(v.value||"");
                }else if(v.name.indexOf("_scores")>-1){
                    scores.push(v.value||"");
                }else {
                    data[v.name] = v.value;
                }
            });
            data.biaoZhang = shouJiang;
            data.names = names;
            data.scores = scores;
            var id = "${backbonePage.entity.id}";
            $.ajax({
                url : "backboneController.do?modifyProcess&id="+id,
                type : "POST",
                data : data,
                async : false,
                cache : false,
                traditional : true,
                error : function() {
                    alert("修改失败!!!");
                },
                success : function() {
                    alert("保存成功");
                    location.href = "backboneController.do?viewMainDetial&id=" + id + "&isView=true";
                }
            });
        }
    </script>
</div>
</body>
</html>