<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--360浏览器优先以webkit内核解析-->
    <title>Jeecg 微云快速开发平台</title>
    <style type="text/css">
    a {
    color: #428bca;
    text-decoration: none;
    font-size: 14px;
    font-weight: bold;
}
    </style>
</head>
 <body style="overflow-y:hidden;">
        <div  style="background: rgba(0,0,0,.03);text-align: center;">
			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center"  >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/9.png">
				<a style="display: inline-block; text-align: center;width: 100% ; " href="${webRoot }/adjustController.do?adjust">干部调整配备</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center"  >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/12.png">
				<a style="display: inline-block; text-align: center;width: 100% ; "  href="${webRoot }/partyMemberController.do?partyMember">党员发展</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center"  >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/2.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/soldierSelectController.do?soldierselect">士官选取</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center" gid="72" >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/11.png">
				<a style="display: inline-block; text-align: center;width: 100% ; " href="${webRoot }/soldierStudentController.do?soldierStudent">大学毕业生士兵提干</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center" gid="71" >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/10.png">
				<a style="display: inline-block; text-align: center;width: 100% ; " href="${webRoot }/soldierSchoolController.do?soldierSchool">优秀士兵保送入学</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center" gid="89" >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/8.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/soldiersApplyController.do?soldiersApply">士兵考学</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center" gid="82" >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/4.png">
				<a style="display: inline-block; text-align: center;width: 100% ; " href="${webRoot }/personnelSelectionController.do?personnelSelection">技术学兵选调</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center"  >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/13.png">
				<a style="display: inline-block; text-align: center;width: 100% ; " href="${webRoot }/backboneController.do?backbone">骨干配备</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center" gid="81" >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/1.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/commendRewardController.do?commendReward">表彰奖励</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center" gid="87" >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/15.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/evaluationResidualController.do?evaluationResidual">官兵评残</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center" gid="86" >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/6.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/officerLeaveController.do?officerLeave">军官休假</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center"  >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/7.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/soldierLeaveController.do?soldierLeave">战士休假</a>
			</div>

            <div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center" >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/14.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/militrainingController.do?militrainingList">军事训练成绩等级评定</a>
			</div>

			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center"  >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/3.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/deliveryController.do?delivery">被装发放</a>
			</div>
			
			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center"  >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/16.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/suppliesPurchasingController.do?suppliesPurchasing">通用物资集中采购</a>
			</div>
				
			<div class="item" style="display: inline-block;width: 20%;margin-left: 12px; margin-top:12px ;text-align: center"  >
				<img style="display: inline-block;width: 120px; height: 120px;display: inline-block"  src="plug-in/image/5.png">
				<a style="display: inline-block; text-align: center;width: 100% ;" href="${webRoot }/stapleFoodController.do?stapleFood">副食品定价</a>
			</div>
			
			</div>
<!-- 全局js -->
<script src="plug-in/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="plug-in/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<!--统计代码，可删除-->
</body>
</html>