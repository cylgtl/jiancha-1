/**
 * 空值判断校验
 * @param {Object} value
 */
function isNotNull(value){
	//console.info("value:"+value);
	//value = value.replace(/\s+/g,""); 
	if(null != value && "" != value && typeof(value) != "undefined"){
		return true;
	}
	return false;
}