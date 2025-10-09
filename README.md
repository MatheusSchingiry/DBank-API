# DBank API

## Project Overview

DBank API is a backend application for a digital bank that allows for the creation and management of client and enterprise accounts, as well as financial transactions between them. The application is built with Java and the Spring Boot framework, providing a robust and scalable solution for banking operations.

## Features

  * **Client Management:**
      * Create new client accounts.
      * Retrieve client information by email.
      * Update client details.
      * Delete client accounts.
  * **Enterprise Management:**
      * Create new enterprise accounts.
      * Retrieve enterprise information by email.
      * Update enterprise details.
      * Delete enterprise accounts.
  * **Transactions:**
      * Perform financial transactions between clients and enterprises.
      * Authorize transactions through an external service.
      * Validate sender's balance before processing a transaction.

## Technologies Used

  * **Java 17**
  * **Spring Boot 3.5.0**
  * **Spring Data JPA:** For data persistence and repository management.
  * **Spring Web:** For creating RESTful APIs.
  * **Spring Cloud OpenFeign:** For declarative REST API client communication.
  * **PostgreSQL:** As the primary database.
  * **Flyway:** For database migration management.
  * **Maven:** For project build and dependency management.
  * **Lombok:** To reduce boilerplate code.
  * **MapStruct:** For bean mapping.

## Database Schema

The database schema is managed by Flyway migrations and consists of the following tables:

  * `tb_client`: Stores information about individual clients.
  * `tb_enterprise`: Stores information about enterprise clients.
  * `tb_transaction`: Stores a record of all transactions.

### Relationships

  * A `Client` can be a sender or a recipient of multiple `Transactions`.
  * An `Enterprise` can be a recipient of multiple `Transactions`.
  * A `Transaction` has one `Client` as a sender and can have either a `Client` or an `Enterprise` as a recipient.

## API Endpoints

### Client Controller (`/client`)

| Method | Endpoint        | Description                  |
| :----- | :-------------- | :--------------------------- |
| `POST` | `/add`          | Adds a new client.           |
| `GET`  | `/list/{email}` | Retrieves a client by email. |
| `PUT`  | `/edit/{id}`    | Edits a client by their ID.  |
| `DELETE`| `/delete/{id}`| Deletes a client by their ID.|

### Enterprise Controller (`/enterprise`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/add` | Adds a new enterprise. |
| `GET` | `/list/{email}` | Retrieves an enterprise by email. |
| `PUT` | `/edit/{id}` | Edits an enterprise by its ID. |
| `DELETE` | `/delete/{id}`| Deletes an enterprise by its ID. |

### Transaction Controller (`/transaction`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/add` | Adds a new transaction. |

## Configuration

The application is configured through the `application.properties` file located in the `src/main/resources` directory. The following properties need to be set as environment variables:

  * `API_URL`: The URL for the authorization service.
  * `DATABASE_DRIVE`: The database driver class name.
  * `DATABASE_URL`: The database connection URL.
  * `DATABASE_USERNAME`: The database username.
  * `DATABASE_PASSWORD`: The database password.

## How to Run

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/matheusschingiry/dbank-api.git
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd dbank-api
    ```
3.  **Set the environment variables** in the `application.properties` file or your operating system.
4.  **Build and run the project using Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```

The application will start on the default port `8080`.

## Project Structure

```
.
├── .mvn
│   └── wrapper
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── DBank
│   │   │           └── DBank
│   │   │               ├── Client
│   │   │               ├── controller
│   │   │               ├── dto
│   │   │               ├── mapper
│   │   │               ├── model
│   │   │               ├── repository
│   │   │               └── service
│   │   └── resources
│   │       ├── db
│   │       │   └── migration
│   │       └── application.properties
│   └── test
└── pom.xml
```
