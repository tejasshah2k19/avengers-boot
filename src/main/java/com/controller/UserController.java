package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;
import com.dto.LoginDto;
import com.service.TokenGenerator;


///public
@RestController
@RequestMapping("/public")
public class UserController {
	@Autowired
	UserDao userDao;
	@Autowired
	TokenGenerator tokenGenerator;

	// login rest api
	@PostMapping("/authenticateuser")
	public ResponseEntity authenticateUser(@RequestBody LoginDto login) {
		UserBean user = userDao.getByEmail(login.getEmail());
		ResponseEntity r = null;
		if (user == null || !user.getPassword().equals(login.getPassword())) {
			// email or password is wrong
			r = new ResponseEntity(login, HttpStatus.FORBIDDEN);

		} else {

			String token = tokenGenerator.generateToken();
			user.setToken(token);
			
			userDao.updateToken(user.getUserId(), user.getToken());
			
			r = new ResponseEntity(user, HttpStatus.OK);
		}
		return r;

	}


	
}
