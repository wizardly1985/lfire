package com.lfire.host.service;

import java.io.Serializable;
import java.util.Set;

import com.lfire.host.entity.demo.User;

public interface UserService {

	public User findById(Serializable id);
	public Set<String> getRoles(String user);
	public Set<String> getPermissions(String user);
}
