package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;

@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate stmt;

	public void saveProduct(ProductBean product) {
		stmt.update("insert into products (name,price,qty) values (?,?,?)", product.getName(), product.getPrice(),
				product.getQty());
	}

	public void deleteProduct(int productId) {
		stmt.update("delete from products where productid = ? ", productId);

	}

	public ProductBean getProductById(int productId) {
		// TODO Auto-generated method stub
		return stmt.queryForObject("select * from products where productid = ? ",
				new BeanPropertyRowMapper<ProductBean>(ProductBean.class), new Object[] { productId });
	}

	public void updateProduct(ProductBean product) {
		// update query
	}

	public List<ProductBean> getAllProudcts() {
		return stmt.query("select * from products ", new BeanPropertyRowMapper<ProductBean>(ProductBean.class));
	}
}
