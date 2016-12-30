// ===============jquery 状态回调code
var code_success ="0000";
var code_toast = "1001";
var code_sever_error = "1002";

/**
 * 从cookie 中获取到user 对象
 */
function getUserFromCookie(){
	$cookie = $.cookie("user");
	if($cookie==""||$cookie==null){
		return null;
	}else{
		return JSON.parse(decodeURI($cookie));
	}
}

/**
 * 获取参数的值
 * @param name
 * @returns
 */
function getQueryString(name) {  
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");  
    var r = window.location.search.substr(1).match(reg);  
    if (r != null) return unescape(r[2]);  
    return null;  
}  


