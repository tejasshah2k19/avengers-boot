package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;
import com.dto.LoginDto;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;

	// login rest api
	@PostMapping("/authenticateuser")
	public ResponseEntity authenticateUser(@RequestBody LoginDto login) {
		UserBean user = userDao.getByEmail(login.getEmail());
		ResponseEntity r = null;
		if (user == null || !user.getPassword().equals(login.getPassword())) {
			// email or password is wrong
			r = new ResponseEntity(login, HttpStatus.FORBIDDEN);

		} else {
			r = new ResponseEntity(user, HttpStatus.OK);
		}
		return r;

	}
}
