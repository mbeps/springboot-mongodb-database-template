package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * Product entity representing a product in the MongoDB database.
 * 
 * @author Maruf Bepary
 */
@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	/** Unique identifier for the product */
	@Id
	private String id;

	/** Name of the product */
	private String name;

	/** Description of the product */
	private String description;

	/** Price of the product */
	private BigDecimal price;
}