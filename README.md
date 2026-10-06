# TestingPractice-1

This repository contains a Spring Boot application focused on testing and validating a simple user management API.

## What this project contains

- A Spring Boot application named `IntegrationTesting`
- A `Users` entity mapped to a database table
- A `UserRepo` repository using Spring Data JPA
- A `UserService` service layer for business logic
- A `UserController` exposing REST endpoints for user operations
- Integration tests that verify the API behavior and database interactions

## Project structure

```text
TestingPractice-1/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/com/vaishu/IntegrationTesting/
│   │   │   ├── IntegrationTestingApplication.java
│   │   │   ├── UserController.java
│   │   │   ├── UserRepo.java
│   │   │   ├── UserService.java
│   │   │   └── Users.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       ├── java/com/vaishu/IntegrationTesting/
│       │   ├── IntegrationTestingApplicationTests.java
│       │   └── UserIntegrationTesting.java
│       └── resources/
│           └── application-test.properties
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Main functionality

The application exposes a REST API for managing users:

- `POST /users` - create a new user
- `GET /users` - get all users
- `GET /users/{id}` - get a user by ID
- `DELETE /users/{id}` - delete a user by ID

The `Users` model includes:

- `id`
- `name`
- `email`

The entity validates input with `@NotBlank` and `@Email` so invalid user data is rejected.

## Technologies used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate / JPA persistence
- PostgreSQL for runtime database
- H2 database for testing
- JUnit 5 and MockMvc for integration testing

## How to run

1. Clone the repository
2. Open the project in your IDE or terminal
3. Run:

```bash
./mvnw spring-boot:run
```

## How to run tests

```bash
./mvnw test
```

## Purpose of this repository

This repo is a practical example of building a small Spring Boot application and testing it using integration tests. It demonstrates:

- REST API development
- JPA entity modeling
- repository-based database access
- validation
- automated testing with MockMvc and Spring Boot test setup

