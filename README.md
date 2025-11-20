# Hexagonal Architecture Order Taking App

This is a minimal Spring Boot 3 application demonstrating **Hexagonal Architecture** (also known as Ports and Adapters) with Java 21.

## 🏗 Architecture

The application follows the Hexagonal Architecture principles to isolate the domain logic from external concerns.

### Layers

1.  **Domain Layer (Core)**
    *   Contains the business logic and domain entities.
    *   **No dependencies** on frameworks or external libraries.
    *   Located in: `com.example.ordertaking.domain.model`

2.  **Application Layer (Ports & Services)**
    *   **Ports**: Interfaces that define how the core interacts with the outside world.
        *   *Input Ports (Use Cases)*: API for the driving side (e.g., `CreateOrderUseCase`).
        *   *Output Ports*: SPI for the driven side (e.g., `OrderRepositoryPort`).
    *   **Services**: Implement input ports and orchestrate domain logic.
    *   Located in: `com.example.ordertaking.application`

3.  **Infrastructure Layer (Adapters)**
    *   Implementations of the ports.
    *   **Primary Adapters (Driving)**: REST Controllers, CLI, etc. (e.g., `OrderController`).
    *   **Secondary Adapters (Driven)**: Persistence, External APIs, etc. (e.g., `OrderPersistenceAdapter`).
    *   Located in: `com.example.ordertaking.infrastructure.adapter`

## 🛠 Technologies

*   **Java 21**
*   **Spring Boot 3.2.0**
*   **Spring Data JPA**
*   **H2 Database** (In-memory)
*   **Maven**

## 🚀 How to Run

### Prerequisites
*   JDK 21 installed.

### Build and Run
Using the Maven Wrapper (no need to install Maven manually):

```bash
./mvnw clean package
java -jar target/ordertaking-0.0.1-SNAPSHOT.jar
```

The application will start on port `8080`.

## 🧪 Testing

### Create an Order (cURL)

You can create a new order using the exposed REST API:

```bash
curl -X POST -H "Content-Type: application/json" \
-d '{"product":"Laptop","quantity":1,"price":1200.00}' \
http://localhost:8080/orders
```

### H2 Console

The H2 database console is enabled for inspection:
*   **URL**: `http://localhost:8080/h2-console`
*   **JDBC URL**: `jdbc:h2:mem:testdb`
*   **User**: `sa`
*   **Password**: `password`

## 📂 Project Structure

```
src/main/java/com/example/ordertaking
├── application
│   ├── port
│   │   ├── in          # Input Ports (Use Cases)
│   │   └── out         # Output Ports (Repository Interfaces)
│   └── service         # Application Services
├── domain
│   └── model           # Domain Entities
└── infrastructure
    └── adapter
        ├── in
        │   └── web     # REST Controllers
        └── out
            └── persistence # JPA Repositories & Entities
```
