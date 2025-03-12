package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.math.BigDecimal; // Add this import

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	// Custom query methods
	List<Product> findByNameContainingIgnoreCase(String name);

	List<Product> findByPriceLessThanEqual(BigDecimal maxPrice);
}