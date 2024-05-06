package com.prowings.product_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/products/cat")
	public List<Product> getAllProductsWithCatagryAndPrice(@RequestParam String catagory, @RequestParam double price) {
		
		System.out.println("catagory :"+catagory);
		System.out.println("price :"+price);
		
		return productService.getAllProductsWithCatagryAndPrice(catagory,price);
	}
	
	@GetMapping("/products/cata")
	public List<Product> getAllProductsWithCatagryOrPrice(@RequestParam String catagory, @RequestParam double price) {
		
		System.out.println("catagory :"+catagory);
		System.out.println("price :"+price);
		
		return productService.getAllProductsWithCatagryOrPrice(catagory,price);
	}
	
	@GetMapping("/products/startingwith/{startingwith}")
	public List<Product> getAllProductsWithCatagryAndPrice(@PathVariable String startingwith) {
				
		return productService.getAllProductsNameStartingWith(startingwith);
	}
	
	@GetMapping("/products/catagory/count/{catagory}")
	public Integer getProductCountByCatagory(@PathVariable String catagory)
	{
		return productService.getProductCountByCatagory(catagory);
	}
	
	
	@GetMapping("/products/catagory/exist/{catagory}")
	public Boolean getProductExistCatagory(@PathVariable String catagory)
	{
		return productService.existCatagory(catagory);
	}
	
	
	@GetMapping("/products/withinPriceRange")
	public List<Product> getAllProductsWithinPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice)
	{
		return productService.getAllProductsWithinPriceRange(minPrice, maxPrice);
	}
	
    @GetMapping("/products/page")
    public Page<Product> getProductsPagination(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "3") int size) {

		//        PageRequest pageable = PageRequest.of(page, size);
        PageRequest pageable = PageRequest.of(page, size , Sort.by("name").descending().and(Sort.by("price")));
        return productService.getAllProductsPagination(pageable);
    }
			
}


