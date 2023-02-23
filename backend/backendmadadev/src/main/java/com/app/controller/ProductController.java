//backend mada dev
package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service; 
	
	@GetMapping("/welcome")
	 public String welcome() {
		 return "voici un texte magnifique 22";
	 }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping
	public List<Product>getProducts(){
		return service.findAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable String id) {
		return service.getProductById(id);
	}
	
	@PutMapping
	public Product modifyProduct (@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable String id) {
		return service.deleteProduct(id);
	}
}
