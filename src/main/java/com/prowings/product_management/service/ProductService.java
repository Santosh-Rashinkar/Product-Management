package com.prowings.product_management.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.prowings.product_management.entity.Product;

public interface ProductService {

	public Product getProductById(long id);
	
	public Product saveProduct(Product product);

	public void deleteProductById(long id);

	public List<Product> getAllProducts();

	public List<Product> getAllProductsWithCatagryAndPrice(String catagory, double price);
	
	public List<Product> getAllProductsWithCatagryOrPrice(String catagory, double price);
	
	public List<Product> getAllProductsNameStartingWith(String startingWith);

	public Integer getProductCountByCatagory(String catagory);

	public Boolean existCatagory(String catagory);

	public List<Product> getAllProductsWithinPriceRange(double minPrice, double maxPrice);

	public Page<Product> getAllProductsPagination(Pageable pageable);
	

		
//	public Product updateProduct(Product product);
	
//	public List<Product> searchProducts();

//	public List<Product> getAllProductsSortBy();

}