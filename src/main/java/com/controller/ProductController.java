package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;

@RestController
public class ProductController {
	// new
	@PostMapping("/product")
	public ProductBean saveProduct(@RequestBody  ProductBean product) {
		System.out.println("Product Added....");
		return product;//object -> json
	}
}
