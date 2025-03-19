package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing product operations.
 *
 * @author Maruf Bepary
 */
@Service
public class ProductService {
	/** Repository for product data access operations */
	private final ProductRepository productRepository;

	/**
	 * Constructs ProductService with required repository.
	 *
	 * @param productRepository the product repository
	 * @author Maruf Bepary
	 */
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/**
	 * Retrieves all products from the database.
	 *
	 * @return list of all products
	 */
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	/**
	 * Finds a product by its ID.
	 *
	 * @param id the product ID
	 * @return optional containing product if found
	 */
	public Optional<Product> findProductById(String id) {
		return productRepository.findById(id);
	}

	/**
	 * Searches products by name (case-insensitive).
	 *
	 * @param name the product name to search
	 * @return list of matching products
	 */
	public List<Product> findProductsByName(String name) {
		return productRepository.findByNameContainingIgnoreCase(name);
	}

	/**
	 * Finds products with price less than or equal to maximum price.
	 *
	 * @param maxPrice the maximum price
	 * @return list of products within price range
	 */
	public List<Product> findProductsByMaxPrice(BigDecimal maxPrice) {
		return productRepository.findByPriceLessThanEqual(maxPrice);
	}

	/**
	 * Saves or updates a product.
	 *
	 * @param product the product to save
	 * @return the saved product
	 */
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param id the product ID to delete
	 */
	public void deleteProduct(String id) {
		productRepository.deleteById(id);
	}
}