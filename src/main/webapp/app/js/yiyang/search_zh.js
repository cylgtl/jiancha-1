

//渲染的模板
var tplRender = _.template($("#tpl").html());


/**
 * 查询订单信息
 */
function queryOrderList(pageNo) {

	var keyWords = $("#keyWords").val();
	if(!keyWords){
		return;
	}
	
	axs(httpUrl + "mobile/order.do?orderList", true, {
		"page": pageNo,
		"currentPage": pageNo,
		"pageSize": 10,
		"searchKey": keyWords
	}, function(data) {
		//console.info("在途订单查询结果集：" + JSON.stringify(data));
		var isSuccess = data.success;
		if(isSuccess) {
			var count = data.obj.count;
			if(count > 0 ) {
				var totalPages = Math.ceil(count / 10);
				var dataList = data.obj.resultList;
			
				$("#list").html(tplRender({
					"list": dataList
				}));
			}else{
				var msg = "没有找到相应订单号";
				$("#list").html(msg);
			} 
		} else {
			var msg = "请求数据失败";
			$("#list").html(msg);
		}
	})
}





/**
 * 初始化加载事件
 * @param {Object} $
 * @param {Object} doc
 */
(function($, doc) {
	//queryOrderList(1);
	
	//绑定点击事件
	$("#list").on('tap', 'ul', function(event) {
		this.click();
	});
}(mui, document));

/**
 * 页面跳转
 * @param {Object} page
 * @param {Object} id
 * @param {Object} orderNo
 */
function goToPageParm(page, id, orderNo) {
	localStorage.setItem("orderNo", orderNo);
	window.location = page + ".html";
}