package com.prowings.product_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.product_management.entity.Product;
import com.prowings.product_management.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable int id) {
				
		return productService.getProductById(id);	
	}
	
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		
		return productService.saveProduct(product);	
	}
	
	@DeleteMapping("/products/{id}")
	public void DeleteProduct(@PathVariable int id) {
		
		productService.deleteProductById(id);	
	}
	
	@GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
	
	
		
}


