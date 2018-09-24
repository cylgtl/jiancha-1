var lang = localStorage.getItem('lang');
if(null == lang || "null" == lang || "" == lang) {
	lang = "zh";
	localStorage.setItem('lang', lang);
	//lang = (jQuery.i18n.browserLang().substring(0, 2)); //默认从浏览器语言读取
}

/**
 * 动态加载语言包,通过方法
 * @param {Object} setLang
 */
function loadLangFun(langFun) {
	jQuery.i18n.properties({
		name: 'strings',
		path: 'i18n/', //资源文件路径
		mode: 'map', //用Map的方式使用资源文件中的值
		language: lang,
		callback: langFun
	});
}

/**
 * 通过key获取value值
 * @param {Object} key
 */
function getLanguageByKey(key) {
	var languageValue = "";
	var lang = localStorage.getItem('lang');

	if(null == lang || "null" == lang || "" == lang) {
		lang = "zh";
		localStorage.setItem('lang', lang);
		//lang = (jQuery.i18n.browserLang().substring(0, 2)); //默认从浏览器语言读取
	}
	jQuery.i18n.properties({
		name: 'strings',
		path: 'i18n/', //资源文件路径
		mode: 'map', //用Map的方式使用资源文件中的值
		language: lang,
		callback: function() { //加载成功后设置显示内容
			languageValue = $.i18n.prop(key);
		}
	});
	return languageValue;
}