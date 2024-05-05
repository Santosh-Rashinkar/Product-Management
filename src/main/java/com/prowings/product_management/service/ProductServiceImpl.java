package com.prowings.product_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.prowings.product_management.dao.ProductRepository;
import com.prowings.product_management.entity.Product;
import com.prowings.product_management.exception.InvalidProductException;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductById(long id) {
		
		Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
        	return null;
	}

	@Override
	public Product saveProduct(Product product) {
		
		Product fetchedProduct = null;
		if(validProduct(product))
			fetchedProduct = productRepository.save(product);
		return fetchedProduct;

	}

	private boolean validProduct(Product product) {
		
		if(product.getName().length() < 5)
			throw new InvalidProductException("Product Name is not valid!!");
		else if(product.getPrice()<100)
			throw new InvalidProductException("Product price must be greater than 100");
		else 
			return true;
	}

	@Override
	public void deleteProductById(long id) {
		productRepository.deleteById(id);
	}

	 @Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	@Override
	public List<Product> getAllProductsWithCatagryAndPrice(String catagory, double price) {
		return productRepository.findByCatagoryAndPrice(catagory, price);
	}
	
	public List<Product> getAllProductsWithCatagryOrPrice(String catagory, double price) {
		return productRepository.findByCatagoryOrPrice(catagory, price);
	}
	
	public List<Product> getAllProductsNameStartingWith(String startingWith) {
		return productRepository.findByNameStartingWith(startingWith);
	}

	@Override
	public Integer getProductCountByCatagory(String catagory) {

		return productRepository.countByCatagory(catagory);
	}

	@Override
	public Boolean existCatagory(String catagory) {

		return productRepository.existsByCatagory(catagory);
		
//		int res = productRepository.existsByCatagory(catagory);
//		
//		if(res>0)
//			return true;
//		else
//			return false;
	}

	@Override
	public List<Product> getAllProductsWithinPriceRange(double minPrice, double maxPrice) {

		
		return productRepository.findByPriceBetween(minPrice, maxPrice);
	}

	@Override
	public Page<Product> getAllProductsPagination(Pageable pageable) {
		return productRepository.findAll(pageable);
	}


		
//	@Override
//	public Product updateProduct(Product product) {
//		return productRepository.save(product);
//	}

//
//	@Override
//	public List<Product> searchProducts() {
//		
//		return null;
//	}
//
//	@Override
//	public List<Product> getAllProductsSortBy() {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
