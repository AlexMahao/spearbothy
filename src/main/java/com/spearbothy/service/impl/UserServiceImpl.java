package com.spearbothy.service.impl;

import java.util.UUID;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spearbothy.dao.BaseDao;
import com.spearbothy.model.User;
import com.spearbothy.receive.RUser;
import com.spearbothy.service.UserService;


@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private BaseDao<User> baseDao;

	@Override
	public User register(RUser rUser) {
		User user = new User();
		/*user.setUserId(UUID.randomUUID().toString());
		
		user.setPassword(rUser.getPassword());
		user.setUsername(rUser.getUsername());
		baseDao.save(user);*/
		
		return user;
	}

	
	
	
	
}
