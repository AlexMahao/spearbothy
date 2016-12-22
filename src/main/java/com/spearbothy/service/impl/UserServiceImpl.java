package com.spearbothy.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spearbothy.dao.impl.UserDao;
import com.spearbothy.exception.BaseException;
import com.spearbothy.model.User;
import com.spearbothy.receive.RUser;
import com.spearbothy.service.UserService;
import com.spearbothy.util.MD5Util;

@Transactional
@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User register(RUser rUser) throws BaseException {
		// 验证用户名唯一，验证邮箱唯一
		
		Long count = userDao.count("select count(*)  from User where name = '"+rUser.getUsername()+"'");
		
		if(count>0){
			throw new BaseException("用户名已存在");
		}
		
		count = userDao.count("select count(*) from User where email= '"+rUser.getEmail()+"'");
		
		if(count>0){
			throw new BaseException("邮箱已经存在");
		}
		
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName(rUser.getUsername());
		user.setPassword(MD5Util.toMD5(rUser.getPassword()));
		user.setEmail(rUser.getEmail());
		userDao.save(user);
		return user;
	}

	

	
	
}
