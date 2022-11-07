package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.dao.ProductDao;

@RestController
public class ProductController {

	@Autowired
	ProductDao productDao;

	// new
	@PostMapping("/product")
	public ProductBean saveProduct(@RequestBody ProductBean product) {
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQty());

		productDao.saveProduct(product);

		System.out.println("Product Added....");
		return product;// object -> json
	}

	@GetMapping("/product")
	public List<ProductBean> getAllProducts() {
		List<ProductBean> products = new ArrayList<ProductBean>();
		return products;
	}

}
