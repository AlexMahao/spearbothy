package com.spearbothy.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spearbothy.dao.impl.UserDao;
import com.spearbothy.model.User;
import com.spearbothy.receive.RUser;
import com.spearbothy.service.UserService;

@Transactional
@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User register(RUser rUser) {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName(rUser.getUsername());
		user.setPassword(rUser.getPassword());
		user.setEmail(rUser.getEmail());
		userDao.save(user);
		return user;
	}

	
	
	
	
}
