package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> findProductById(String id) {
		return productRepository.findById(id);
	}

	public List<Product> findProductsByName(String name) {
		return productRepository.findByNameContainingIgnoreCase(name);
	}

	public List<Product> findProductsByMaxPrice(BigDecimal maxPrice) {
		return productRepository.findByPriceLessThanEqual(maxPrice);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(String id) {
		productRepository.deleteById(id);
	}
}