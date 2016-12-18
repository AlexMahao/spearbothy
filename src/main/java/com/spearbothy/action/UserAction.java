package com.spearbothy.action;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.spearbothy.model.User;
import com.spearbothy.receive.RUser;
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
	
	@Action(value="login",
			results={
					@Result(name="home",location="/home.jsp")
					})
	public String register(){
		
		User user = userService.register(mRuser);
		
		getRequest().put("user", user);
		getSession().put("user", user);
		getApplication().put("user", user);
		return "home";
	}

	

}
