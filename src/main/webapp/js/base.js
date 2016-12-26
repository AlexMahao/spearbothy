// ===============jquery 状态回调code
var code_success ="0000";
var code_toast = "1001";

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


