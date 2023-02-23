package com.app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Product;
import com.app.repository.ProductRepository;

@Service
public class ProductService {
 
	@Autowired
	private ProductRepository repository;
	
	public Product addProduct(Product product) {
		product.setId(UUID.randomUUID().toString().split("-")[0]) ;
		return repository.save(product);
	}
	
	public List<Product> findAllProducts(){
		return repository.findAll(); 
	}
	
	public Product getProductById(String id) {
		return repository.findById(id).get();
	}
	public Product updateProduct (Product productRequest) {
		Product existingProduct = repository.findById(productRequest.getId()).get();
		existingProduct.setDescription(productRequest.getDescription());
		existingProduct.setName(productRequest.getName());
		existingProduct.setPrice(productRequest.getPrice());
		return repository.save(existingProduct);
	}
	
	public String deleteProduct (String id) {
		repository.deleteById(id);
		return id+" product deleted from dashboard";
	}
}
