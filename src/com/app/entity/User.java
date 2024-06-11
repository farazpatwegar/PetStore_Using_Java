package com.app.entity;

import java.util.List;

import com.app.custom_exception.AuthenticationException;

public class User {

	private String loginId;
	private String password;
	private Role role;
	public User(String loginId, String password, Role role) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", password=" + password + ", role=" + role + "]";
	}
	
	public static User login(String id, String pass, List<User> userList) {
		for (User user : userList) {
			if(user.getLoginId().equals(id)) {
				if(user.getPassword().equals(pass)) {
					return user;
				}
			}
		}
		throw new AuthenticationException("Invalid id or password !!");
		
	}
	
	
}
