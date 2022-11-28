package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.dao.ProductDao;
import com.dao.UserDao;

//private
@RestController
public class ProductController {

	@Autowired
	ProductDao productDao;

	@Autowired
	UserDao userDao;

	// new
	@PostMapping("/product")
	public ResponseEntity saveProduct(@RequestHeader("token") String token, @RequestBody ProductBean product) {
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQty());
		System.out.println("token => " + token);
		if (token == null || userDao.isValidToken(token) == false) {
			// reject
			ResponseEntity r = new ResponseEntity("Please Provide Valid Token", HttpStatus.FORBIDDEN);
			return r;

		} else {

			productDao.saveProduct(product);

			System.out.println("Product Added....");
			ResponseEntity r = new ResponseEntity(product, HttpStatus.OK);
			return r;
		}
	}

	@GetMapping("/products")
	public List<ProductBean> getAllProducts() {
		List<ProductBean> products = productDao.getAllProudcts();
		;
		return products;
	}

	// /product/12
	@DeleteMapping("/product/{productId}")
	public List<ProductBean> deleteProduct(@PathVariable("productId") int productId) {
		ProductBean deletedBean = productDao.getProductById(productId);

		productDao.deleteProduct(productId);
		List<ProductBean> products = new ArrayList<ProductBean>();
		return products;
	}

	@GetMapping("/product/{productId}")
	public ProductBean getProductByProductId(@PathVariable("productId") int productId) {
		ProductBean productBean = productDao.getProductById(productId);
		return productBean;
	}

	@PutMapping("/product")
	public ProductBean updateProduct(@RequestBody ProductBean product) {
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQty());

		productDao.updateProduct(product);

		System.out.println("Product updated....");
		return product;// object -> json
	}

}
