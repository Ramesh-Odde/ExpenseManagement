package com.expense.service;

import com.expense.entity.User;


public interface UserService {
	public User register(User user);
	
	public Boolean login(String username, String password);
	
}
