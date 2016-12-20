package com.spearbothy.service;

import com.spearbothy.model.User;
import com.spearbothy.receive.RUser;


public interface UserService {
	
	User register(RUser rUser);
}
