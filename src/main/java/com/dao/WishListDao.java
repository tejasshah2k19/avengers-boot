package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.WishListBean;
import com.dto.WishListDto;

@Repository
public class WishListDao {

	@Autowired
	JdbcTemplate stmt;

	public void insertWishList(WishListBean wish) {
		stmt.update("insert into wishlist (userid,productid) values (?,?)", wish.getUserId(), wish.getProductId());
	}

	public List<WishListDto> getAllWish() {
		List<WishListDto> wishItems = stmt.query(
				"select u.* , p.* from users u , products p , wishlist w where w.userid = u.userid and w.productid = p.productid",
				new BeanPropertyRowMapper<WishListDto>(WishListDto.class));
		return wishItems;
	}

	public List<WishListDto> getAllWishByUser(Integer userId) {
		// TODO Auto-generated method stub
		List<WishListDto> wishItems = stmt.query(
				"select u.* , p.* from users u , products p , wishlist w where w.userid = u.userid and w.productid = p.productid and w.userid = ?",
				new BeanPropertyRowMapper<WishListDto>(WishListDto.class), new Object[] { userId });
		return wishItems;
	}
}
