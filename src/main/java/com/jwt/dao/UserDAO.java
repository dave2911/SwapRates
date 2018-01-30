package com.jwt.dao;

import com.jwt.model.User;

public interface UserDAO {

	public void addUser(User user);
	public void removeUser(User user);
	public User getUser(String userName);
}
