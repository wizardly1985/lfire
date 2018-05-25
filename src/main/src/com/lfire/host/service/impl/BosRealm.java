package com.lfire.host.service.impl;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfire.host.entity.demo.User;

@Service("bosRealm")
public class BosRealm extends AuthorizingRealm {
	@Autowired
	private UserServiceImpl userServiceImpl;

	/* 
	 * 调用SecurityUtils.getSubject().isPermitted（）这个方法时
	 *
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("---授权---");
		String username = (String)pc.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	    authorizationInfo.setRoles(userServiceImpl.getRoles(username));
	    authorizationInfo.setStringPermissions(userServiceImpl.getPermissions(username));
		return authorizationInfo;
	}

	/* 
	 * 执行SecurityUtils.getSubject().login（）的时候调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		System.out.println("---认证---");
		String username = (String) token.getPrincipal(); // 得到用户名
		String password = new String((char[]) token.getCredentials()); // 得到密码

		User user = userServiceImpl.findById(1);
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
