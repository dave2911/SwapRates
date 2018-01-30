package com.jwt.service;

import com.jwt.model.User;

public interface UserService {

	public void addUser(User user);
	public void removeUser(User user);
	public User getUser(String userName);
	
}
