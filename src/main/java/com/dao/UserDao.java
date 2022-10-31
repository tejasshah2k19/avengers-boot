package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void insertUser(UserBean user) {
		stmt.update("insert into users (firstname,email,password) values (?,?,?)", user.getFirstName(), user.getEmail(),
				user.getPassword());// insert update delete
	}

	public List<UserBean> getAllUsers() {
		return stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

	public void deleteUser(int userId) {
		stmt.update("delete from users where userid = ?", userId);
	}

	public UserBean getUserByUserId(int userId) {
		return stmt.queryForObject("select * from users where userid = ? ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { userId });
	}

	public void updateUser(UserBean user) {
			stmt.update("update users set firstname = ? where userid = ? ",user.getFirstName(),user.getUserId());
	}

}
