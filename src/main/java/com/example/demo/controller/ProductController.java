package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.findAllProducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id) {
		return productService.findProductById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/search")
	public List<Product> searchProducts(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) BigDecimal maxPrice) {

		if (name != null && maxPrice != null) {
			// If both parameters are provided, you might want to implement a custom method
			return productService.findProductsByName(name);
		} else if (name != null) {
			return productService.findProductsByName(name);
		} else if (maxPrice != null) {
			return productService.findProductsByMaxPrice(maxPrice);
		} else {
			return productService.findAllProducts();
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
		return productService.findProductById(id)
				.map(existingProduct -> {
					product.setId(id);
					return ResponseEntity.ok(productService.saveProduct(product));
				})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
		return productService.findProductById(id)
				.map(product -> {
					productService.deleteProduct(id);
					return ResponseEntity.noContent().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}