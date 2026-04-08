# ToDo List API

This project is a RESTful API for a To-Do List application built with Java and Spring Boot. It is a solution to the backend project from roadmap.sh.

## Project Page URL
[https://roadmap.sh/projects/todo-list-api](https://roadmap.sh/projects/todo-list-api)

## Prerequisites

- Java 17 or higher
- Maven
- MySQL

## Setup Database

1. Create a MySQL database named `to_do_list_db`.
2. Update the database credentials in `src/main/resources/application.yml` if necessary:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/to_do_list_db
       username: <your_username> # Default in project: root
       password: <your_password> # Default in project: 227985
   ```

## Running the Application

You can run the application using the Maven Wrapper included in the project:

### On Windows
```cmd
mvnw.cmd spring-boot:run
```

### On Linux/macOS
```bash
./mvnw spring-boot:run
```

The application will start and listen on port `8080` by default. You can then access the API endpoints (e.g., at `http://localhost:8080`).

## Database Migrations

The project uses Flyway for database migrations. When you start the application, Flyway will automatically execute any available migration scripts located in the project resources.
