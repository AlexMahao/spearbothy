package com.spearbothy.action;

import java.beans.Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;
import com.spearbothy.exception.BaseException;
import com.spearbothy.model.User;
import com.spearbothy.receive.RUser;
import com.spearbothy.response.Code;
import com.spearbothy.response.ResultResponse;
import com.spearbothy.service.UserService;

public class UserAction extends BaseAction implements ModelDriven<RUser> {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserAction.class);

	private RUser mRuser = new RUser();

	@Override
	public RUser getModel() {
		return mRuser;
	}

	@Resource
	private UserService userService;

	@Action(value = "register")
	public void register() {

		ResultResponse<User> result = new ResultResponse<>();

		if (StringUtils.isEmpty(mRuser.getUsername()) || StringUtils.isEmpty(mRuser.getEmail())
				|| StringUtils.isEmpty(mRuser.getPassword())) {
			getRequest().put("msg", "信息填写不完整");
			result.setCode(Code.TOAST_MESSAGE);
			result.setMsg("信息填写不完整");

		} else {
			try {
				User user = userService.register(mRuser);
				result.setCode(Code.SUCCESS);
				result.setData(user);
				result.setMsg("成功");
				
			} catch (BaseException e) {
				result.setCode(Code.TOAST_MESSAGE);
				result.setMsg(e.getMessage());
			}
		}
		// 回写数据
		writeJson(result);
	}

	
	@Action("login")
	public void login(){
		ResultResponse<User> result = new ResultResponse<>();
		if (StringUtils.isEmpty(mRuser.getUsername())|| StringUtils.isEmpty(mRuser.getPassword())) {
			getRequest().put("msg", "信息填写不完整");
			result.setCode(Code.TOAST_MESSAGE);
			result.setMsg("信息填写不完整");

		} else{
			try {
				User user = userService.login(mRuser);
				result.setCode(Code.SUCCESS);
				result.setData(user);
				result.setMsg("成功");
			} catch (BaseException e) {
				result.setCode(Code.TOAST_MESSAGE);
				result.setMsg(e.getMessage());
			}
		}
		
		writeJson(result);
	}
	
	/**
	 * 支持单点登录
	 */
	@Action("/getLoginInfo")
	public void getLoginInfo(){
		/*HashMap<String, String> result = new HashMap<>();
		// 获取用户信息的cookie
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("user")){
				User user = JSON.parseObject(URLDecoder.decode(cookie.getValue()),User.class);
				result.put("isLogin", "1");
				result.put("nickName", )
			}
		}
		
		result.put("isLogin", "0");*/
		
	}
}
