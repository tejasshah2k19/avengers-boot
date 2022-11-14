package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
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
		return null;
	}

	public void updateProduct(ProductBean product) {
		// update query
	}
}