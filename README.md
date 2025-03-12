This project is a RESTful API built with Spring Boot 3 and MongoDB. It provides a foundation for building document-oriented applications with full CRUD operations. The project includes a product management system with search capabilities.

# Requirements

To run this application, you need:

- Java 17 or higher
- MongoDB (running locally on port 27017)
- Gradle 8

# Stack

Our application uses these key technologies:

- [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - The core programming language with modern features like records and improved switch expressions.

- [Spring Boot](https://spring.io/projects/spring-boot) - A framework that simplifies Java application development with convention over configuration.

- [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb) - Provides integration with MongoDB database and implements repository pattern.

- [MongoDB](https://www.mongodb.com/) - A NoSQL document database that stores data in flexible, JSON-like documents.

- [Gradle](https://gradle.org/) - A build automation tool that manages dependencies and builds the application.

- [Lombok](https://projectlombok.org/) - A Java library that reduces boilerplate code with annotations.

# Configuration

The application is configured through the `application.yaml` file:

```yaml
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: mydatabase
      
server:
  port: 8080

logging:
  level:
    org:
      springframework:
        data:
          mongodb:
            core:
              MongoTemplate: DEBUG
```

Configuration fields:

- `spring.data.mongodb.host`: MongoDB server hostname
- `spring.data.mongodb.port`: MongoDB server port
- `spring.data.mongodb.database`: Database name
- `server.port`: Application server port
- `logging.level`: Logging configuration for MongoDB operations

# Usage

## Running the Application

1. Ensure MongoDB is running locally on port 27017
2. Start the application:

```bash
./gradlew bootRun
```

## Testing the API

Here are some curl commands to test the application:

### Create a product
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"MongoDB Book","description":"A guide to MongoDB","price":29.99}'
```

### Get all products
```bash
curl http://localhost:8080/api/products
```

### Get product by ID
```bash
curl http://localhost:8080/api/products/YOUR_PRODUCT_ID
```

### Update a product
```bash
curl -X PUT http://localhost:8080/api/products/YOUR_PRODUCT_ID \
  -H "Content-Type: application/json" \
  -d '{"name":"Updated Book","description":"Revised guide","price":34.99}'
```

### Search products by name
```bash
curl "http://localhost:8080/api/products/search?name=Book"
```

### Search products by price
```bash
curl "http://localhost:8080/api/products/search?maxPrice=30"
```

### Delete a product
```bash
curl -X DELETE http://localhost:8080/api/products/YOUR_PRODUCT_ID
```

For more detailed information, please visit the wiki.