package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.math.BigDecimal;

/**
 * Repository interface for managing Product entities in MongoDB
 *
 * @author Maruf Bepary
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	/**
	 * Finds products containing the given name, ignoring case
	 * 
	 * @param name The product name to search for
	 * @return List of products matching the name
	 * @author Maruf Bepary
	 */
	List<Product> findByNameContainingIgnoreCase(String name);

	/**
	 * Finds products with price less than or equal to the specified amount
	 * 
	 * @param maxPrice The maximum price threshold
	 * @return List of products within the price range
	 * @author Maruf Bepary
	 */
	List<Product> findByPriceLessThanEqual(BigDecimal maxPrice);
}