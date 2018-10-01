

/**
 * 后台调用通用地址
 */
//var  httpUrl = "http://localhost:2222/yiyang/";
var httpUrl = "http://ssoonmall.com/yiyang/";
/**
 * 判断是否有保存账号信息
 */
function goToPage(page) {
	window.location = page + ".html";
}

/**
 * 返回上一级
 */
function back() {
	mui.back();
}


/**
 * ajax封装 url 发送请求的地址 data 发送到服务器的数据，数组存储，如：{"date": new Date().getTime(),
 * "state": 1} successfn 成功回调函数
 */
axs = function(url, async, data, successfn) {
	//var w = Common.showWaiting();
	data = (data == null || data == "" || typeof(data) == "undefined") ? {
		"date": new Date().getTime()
	} : data;
	mui.ajax({
		type: "post",
		data: data,
		timeout: 20000,
		crossDomain: true,
		async: async,
		url: url,
		//jsonp:"callback",
		dataType: "json",
		success: function(d) {
			//Common.closeWaiting(w);
			successfn(d);
		},
		error: function(xhr, type, errorThrown) {
			//Common.closeWaiting(w);
			var postFail = "请求数据失败";
			mui.toast(postFail);
		}
	});
};

