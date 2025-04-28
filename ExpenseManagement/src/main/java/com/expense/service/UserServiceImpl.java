package com.expense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.entity.User;
import com.expense.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public User register(User user) {
		return repo.save(user);
	}

	@Override
	public Boolean login(String username, String password) {
		return repo.findByUsername(username).map(u -> u.getPassword().equals(password)).orElse(false); 
	}

}
