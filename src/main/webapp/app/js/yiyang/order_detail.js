/**
 * 加载国际化语言包
 */
function loadLang() {
	/***底部菜单**/
	$('#order_detail').html($.i18n.prop('orderDetail'));
}


//渲染的模板
var tplRender = _.template($("#tpl").html());

/**
 * 获取物流信息
 */
function orderDetail(){
	var orderNo =  localStorage.getItem("orderNo");
	axs(httpUrl + "mobile/order.do?orderDetail", true, {
		"orderNo": orderNo
	}, function(data) {
		//console.info("订单详情查询结果集：" + JSON.stringify(data));
		var isSuccess = data.success;
		if(isSuccess) {
			var order = data.obj;
			$("#table_detail").html(tplRender({
				"order": order
			}));
		}else{
			var msg = getLanguageByKey("postFail");
			mui.toast(msg);
			$("#table_detail").html(tplRender({
				"order": ""
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
	//loadLangFun(loadLang);
    orderDetail();
}(mui, document));



