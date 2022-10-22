package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@GetMapping("/signup")
	public String signup() {
		System.out.println("Signup()");
		return "Signup";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserBean user) {
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());
		userDao.insertUser(user);
		return "Home";
	}
}
