package com.spearbothy.action;

import java.io.UnsupportedEncodingException;
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

	@Action(value = "register", results = { @Result(name = "error", location = "/WEB-INF/pages/register.jsp"),
			@Result(name = "success", location = "ui_index", type = "redirect") })
	public String register() {
		if (StringUtils.isEmpty(mRuser.getUsername()) || StringUtils.isEmpty(mRuser.getEmail())
				|| StringUtils.isEmpty(mRuser.getPassword())) {
			getRequest().put("msg", "信息填写不完整");
			return "error";
		}
		try {
			User user = userService.register(mRuser);
			HashMap<String, String> map = new HashMap<>();
			map.put("id", user.getId());
			map.put("name", user.getName());
			Cookie cookie = new Cookie("user", URLEncoder.encode(JSON.toJSONString(map), "UTF-8"));
			cookie.setMaxAge(7 * 24 * 60 * 60);
			ServletActionContext.getResponse().addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (BaseException e) {
			getRequest().put("msg", e.getMessage());
			return "error";
		}
		return "success";
	}

}
