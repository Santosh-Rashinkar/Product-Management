package com.prowings.product_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prowings.product_management.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long > {

	public Optional<Product> findById(long id);
	
	public Product save(Product product);
	
	public Product deleteProductById(long id);
	
	//public List <Product> getAllProducts();
	
	
//	public Product update(Product product);
	
//	
//	public List<Product> searchProducts();
//	
//	public List<Product> getAllProductsSortBy();
	
}
