# Spring MLT (Multi-Level Training) Examples

This module contains practical examples of common Spring Boot development scenarios.

## 1. Multiple Environments Configuration
- **Location:** `src/main/resources/application.properties` and `application-development.properties`.
- **Approach:** Use a common properties file for shared configuration and profile-specific files (e.g., `-development`, `-production`) for environment-dependent settings. Active profiles are set via `spring.profiles.active`.

## 2. RESTful API Versioning
- **Location:** `com.froyo.mlt.controller.InvoiceV1Controller`.
- **Approach:** Leverage URL versioning (e.g., `/api/v1/invoices`) to ensure backward compatibility as the API evolves.

## 3. Write-Through Caching Strategy
- **Location:** `com.froyo.mlt.service.ProductService`.
- **Approach:** Use `@CachePut` to update the cache synchronously whenever the database is modified, ensuring the cache always reflects the latest state.

## 4. Reactive Error Handling
- **Location:** `com.froyo.mlt.controller.GlobalReactiveExceptionHandler`.
- **Approach:** Use `@ControllerAdvice` in a Spring WebFlux application with `@ExceptionHandler` to catch and process asynchronous errors gracefully.

## 5. Spring Data JPA Custom Queries
- **Location:** `com.froyo.mlt.repository.OrderRepository`.
- **Approach:** Use the `@Query` annotation with JPQL or native SQL to implement complex data retrieval needs that involve multiple criteria, sorting, and pagination.

## 6. Asynchronous Messaging (Microservices)
- **Location:** `com.froyo.mlt.service.OrderMessagePublisher`.
- **Approach:** Integrate **Spring Cloud Stream** (with Kafka or RabbitMQ) to enable efficient asynchronous communication and coordination between microservices, enhancing scalability and responsiveness.

## 7. Pessimistic Locking
- **Location:** `com.froyo.mlt.repository.InventoryRepository`.
- **Approach:** Use `@Lock(LockModeType.PESSIMISTIC_WRITE)` to manage concurrent access to database entities, ensuring that update operations are serialized to prevent data inconsistencies.

## 8. Security Configuration (JWT)
- **Location:** `com.froyo.mlt.config.SecurityConfig`.
- **Approach:** Extend `WebSecurityConfigurerAdapter` and override the `configure(HttpSecurity http)` method to define authorized/unauthorized access paths and security filters.

## 9. Optimistic Locking
- **Location:** `com.froyo.mlt.model.FinancialAccount`.
- **Approach:** Implement optimistic locking by adding a `@Version` field to the entity. This prevents the "lost update" problem in concurrent environments without the overhead of heavy database locks.

## 10. Asynchronous Data Processing
- **Location:** `com.froyo.mlt.service.StockMarketService`.
- **Approach:** Use the `@Async` annotation to offload time-consuming tasks to separate threads, preventing performance bottlenecks in the main application flow and ensuring a responsive user experience.
