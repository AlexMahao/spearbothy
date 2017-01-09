package com.spearbothy.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import com.spearbothy.exception.BaseException;
import com.spearbothy.model.User;
import com.spearbothy.response.ResultResponse;
import com.spearbothy.service.UserService;

public class QQOauthAction extends BaseAction {
	
	private String name;
	
	private String openid;
	
	private String token;
	
	private int otype; // 1代表是qq
	
	private String avater;

	
	@Resource
	private UserService userService;
	
	@Action("qqOauth")
	public void qqOauth(){
		ResultResponse<User> result = new ResultResponse<>();

		User user = new User();
		user.setAvater(avater);
		user.setName(name);
		user.setOpenid(openid);
		user.setOtype(otype);
		user.setToken(token);
		try {
			
			user = userService.register(user);
			result.setSuccessDate(user);
		} catch (BaseException e) {
			result.setToastMsg(e);
			e.printStackTrace();
		}
		
		writeJson(result);
		
	}
	
	@Override
	public String toString() {
		return "QQOauthAction [name=" + name + ", openid=" + openid + ", token=" + token + ", otype=" + otype
				+ ", avater=" + avater + "]";
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getOtype() {
		return otype;
	}

	public void setOtype(int otype) {
		this.otype = otype;
	}

	public String getAvater() {
		return avater;
	}

	public void setAvater(String avater) {
		this.avater = avater;
	}
	
	
	
	
	
	
	

}
