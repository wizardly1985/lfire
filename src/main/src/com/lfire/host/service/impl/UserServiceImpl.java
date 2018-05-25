package com.lfire.host.service.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfire.host.dao.impl.demo.UserDaoImpl;
import com.lfire.host.entity.demo.User;
import com.lfire.host.service.UserService;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDaoImpl userDaoImpl;
	public User findById(Serializable id) {
		return userDaoImpl.findById(id);
	}
	public Set<String> getRoles(String user) {
		Set<String> roles = new HashSet<String>();
		roles.add("role");
		return roles;
	}
	public Set<String> getPermissions(String user) {
		Set<String> permissions = new HashSet<String>();
		permissions.add("role");
		return permissions;
	}

}
