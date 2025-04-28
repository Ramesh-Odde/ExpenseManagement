package com.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.entity.User;
import com.expense.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	public UserController(UserService userService) {
        this.service = userService;
    }
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user){
		return ResponseEntity.ok(service.register(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user){
		Boolean success = service.login(user.getUsername(), user.getPassword());
		return ResponseEntity.ok(success ? "Login Successful": "Invalid Credentials");
	}	
}
