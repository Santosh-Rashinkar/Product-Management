package com.prowings.product_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prowings.product_management.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long > {

	public Optional<Product> findById(long id);
	
	public Product save(Product product);
	
	public Product deleteProductById(long id);
	
	
	
	
	
	public List<Product>findByCatagory(String catagory);
	
	public List<Product>findByCatagoryAndPrice(String catagory,double price);
	
	public List<Product>findByCatagoryOrPrice(String catagory,double price);

	public List<Product> findByNameStartingWith(String startingWith);

	public Integer countByCatagory(String catagory);
	
	public Boolean existsByCatagory(String catagory);

	public List<Product> findByPriceBetween(double minPrice, double maxPrice);
	
	Page<Product> findAll(Pageable pageable);
	
	
	
	
	
	
	
	
		
//	public Product updateProduct(Product product);
	
	
//	public List<Product> searchProducts();
//	
//	public List<Product> getAllProductsSortBy();
	
}
