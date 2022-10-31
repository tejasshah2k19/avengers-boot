package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	@GetMapping("/listuser")
	public String listUser(Model model) {
		List<UserBean> userList = userDao.getAllUsers();
		model.addAttribute("userList", userList);
		return "UserList";
	}

	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") int userId) {
		userDao.deleteUser(userId);
		return "redirect:/listuser";
	}

	@GetMapping("/edituser")
	public String editUser(@RequestParam("userId") int userId,Model model) {
		UserBean user = userDao.getUserByUserId(userId);
		model.addAttribute("user",user);
		return "EditUser";
	}

	@PostMapping("/updateuser")
	public String updateUser(UserBean user) {
		userDao.updateUser(user);
		return "redirect:/listuser";
	}
	
	
















}
