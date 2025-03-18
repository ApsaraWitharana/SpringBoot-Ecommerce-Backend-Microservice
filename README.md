# E-Commerce Microservices Application

## Overview
This project is a microservices-based e-commerce application built using **Spring Boot**, **MySQL**, and **Eureka Server**. The architecture includes multiple microservices such as **Eureka Server, Order Service, Item Service, Customer Service, and API Gateway**.

## Microservices Architecture
- **Eureka Server** - Service registry for managing microservices discovery.
- **API Gateway** - Manages API requests and routes them to respective services.
- **Order Service** - Handles order creation, retrieval, and management.
- **Item Service** - Manages product details and inventory.
- **Customer Service** - Manages customer-related operations.

## Technologies Used
- **Spring Boot** - Backend framework
- **Spring Cloud Netflix Eureka** - Service discovery
- **Spring Cloud Gateway** - API Gateway
- **Spring Data JPA** - ORM for database operations
- **MySQL** - Database for data persistence
- **Spring Boot Security (Optional)** - Authentication & Authorization

## Getting Started
### Prerequisites
Ensure you have the following installed:
- Java 17 or later
- Maven
- MySQL Server

### Clone the Repository
```sh
https://github.com/ApsaraWitharana/SpringBoot-Ecommerce-Backend-Microservice.git
```

### Configuration
1. Update `application.properties` or `application.yml` for each service with MySQL database configurations.
2. Configure **Eureka Server** settings.
3. Configure **API Gateway** routing.

### Build and Run Microservices
#### Start Eureka Server
```sh
cd eureka-server
mvn spring-boot:run
```
#### Start API Gateway
```sh
cd api-gateway
mvn spring-boot:run
```
#### Start Microservices (Order, Item, Customer)
```sh
cd order-service
mvn spring-boot:run

cd item-service
mvn spring-boot:run

cd customer-service
mvn spring-boot:run
```

## API Endpoints
### Order Service
- `POST /orders` - Create a new order
- `GET /orders/{id}` - Retrieve order details

### Item Service
- `GET /items` - List all items
- `POST /items` - Add a new item

### Customer Service
- `POST /customers` - Register a new customer
- `GET /customers/{id}` - Get customer details

### API Document
```
https://documenter.getpostman.com/view/35385905/2sAYdbPtSH
```  

## Contributing
Contributions are welcome! Feel free to submit a pull request.

## License
This project is licensed under the MIT License.

## Contact

For inquiries or collaboration:
- **Author:** [Sachini Apsara](https://github.com/ApsaraWitharana)
  
<div align="center">
    © 2025 All Rights Reserved, Designed By Sachini Apsara
</div>


⭐ **Feel free to contribute, star the repo, and explore more!**
