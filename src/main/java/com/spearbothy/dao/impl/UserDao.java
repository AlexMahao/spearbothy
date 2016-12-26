package com.spearbothy.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.spearbothy.model.User;

@Repository
public class UserDao extends BaseDaoImpl<User> {

	/**
	 * 根据用户名和密码查找用户
	 * @param hql
	 * @param username
	 * @param password
	 * @return
	 */
	public User getUserByNameAndPassword(String username,String password) {
		Query q = this.getCurrentSession().createQuery("from User where name=:name and password=:password");
		
		q.setParameter("name",username);
		q.setParameter("password", password);
		List<User> l = q.list();
		if (l != null && l.size() > 0) {
			System.out.println("==========="+l.get(0).toString());
			return l.get(0);
		}
		return null;
	}
	
}
