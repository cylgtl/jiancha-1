

	//渲染的模板
var tplRender = _.template($("#tpl").html());

/**
 * 获取物流信息
 */
function loadWuliu(){
	var id = localStorage.getItem("id");
	var orderNo =  localStorage.getItem("orderNo");
	$("#orderNumber").html(orderNo);
	axs(httpUrl + "mobile/orderLogistics.do?logisticsList", true, {
		"orderNo": orderNo
	}, function(data) {
		//console.info("物流查询结果集：" + JSON.stringify(data));
		var isSuccess = data.success;
		if(isSuccess) {
			var dataList = data.obj.resultList;
			var time = "";
			if(dataList){
				var length = dataList.length;
				for(var i =0;i< length;i++){
					var logistic = dataList[i];
					if(4 == logistic.type){
						var remarks = logistic.remarks;
						var resultTime = remarks.substring(8,18);
						var timeArray = resultTime.split('-');
						time = timeArray[2] + "-" + timeArray[1] + "-" + timeArray[0];
						break;
					}
				}
			}
			$("#list").html(tplRender({
				"list": dataList,
				"time":time
			}));
		}
	});
}

/**
 * 初始化加载事件
 * @param {Object} $
 * @param {Object} doc
 */
(function($, doc) {
    loadWuliu();
}(mui, document));

