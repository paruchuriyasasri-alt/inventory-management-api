# Inventory Management API

A Spring Boot REST + GraphQL API for managing product inventory, warehouse locations, and stock movements. Built with PostgreSQL, Swagger, and Docker.

## Tech Stack

- Java 17, Spring Boot 3.x, Spring Data JPA
- GraphQL (Spring for GraphQL)
- PostgreSQL
- Swagger/OpenAPI
- Docker, Docker Compose
- JUnit 5, Mockito

## Features

- CRUD operations for products, categories, and warehouses
- GraphQL queries for flexible data fetching
- Stock movement tracking (inbound/outbound)
- Low stock alerts
- Pagination and search

## Running

```bash
docker-compose up -d   # Start PostgreSQL
mvn clean install
mvn spring-boot:run
```

## Endpoints

### REST
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/products | List products (paginated) |
| GET | /api/products/{id} | Get product |
| POST | /api/products | Create product |
| PUT | /api/products/{id} | Update product |
| DELETE | /api/products/{id} | Delete product |
| GET | /api/products/low-stock | Low stock alerts |
| POST | /api/stock-movements | Record stock movement |

### GraphQL
```
POST /graphql
```
```graphql
query {
  products(category: "Electronics") {
    id
    name
    sku
    quantity
    warehouse { name, location }
  }
}
```

## Testing
```bash
mvn test
```
