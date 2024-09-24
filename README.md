# JavaSpringBoot Project

## Description
This project is a Spring Boot backend application that demonstrates how to connect a Spring Boot project to 
Microsoft SQL Server (MSSQL) and use Spring Data JPA for database operations. The project is built with Java 21 
and Maven, and it includes a RESTful API for managing staff data.

## Assignment Detail
**Java Backend Interview Assignment:**
1. Create a Java SpringBoot Application.
2. Project Structure is required for ease of maintainability and readability.
3. Explore api for Client (Example: to be test via Postman. Please provide the Postman Collection.)
4. Each api required to log REQUEST & RESPONSE info into logs file.
5. Your project able connect to database, preferred with MSSQL database (Using Local Machine DB, DB name: TESTDB).
- *@transactional* is required implement in the project. (For http Methos: INSERT, UPDATE, GET method)
6. Explore 1 GET method api with Pagination (Each Page 10 records)
7. Explore an api which will nested calling another api from 3rd party.
Example: Postman/Client > Your API Endpoint > calling another api
You are able to upload the assignment to a public git folder and share the URL for us to review.



## Prerequisites

To run this project, you need to have the following installed:

- **Java 21**: The project is built using Java 21, so ensure that you have this version installed.
- **Maven**: The project uses Maven for dependency management and building.
- **MSSQL Server**: Ensure that you have a running instance of Microsoft SQL Server.
- **Postman** (Optional): For testing API endpoints.

## Key Dependencies

This project includes the following key dependencies in the `pom.xml` file:

- `spring-boot-starter-data-jpa`: Provides support for Spring Data JPA and ORM with Hibernate.
- `spring-boot-starter-web`: Used to create RESTful web services with Spring MVC.
- `mssql-jdbc`: The Microsoft SQL Server JDBC driver for connecting to MSSQL databases.
- `spring-boot-devtools`: Helps with development by providing auto-restart capabilities.
- `spring-boot-starter-test`: Provides testing support with JUnit and Spring Boot test utilities.

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-repository/JavaSpringBoot.git
cd JavaSpringBoot
```
### SQL Query
Make sure user 'admin' has access to create table in 'dbo' schema.
Query below might help.

```
USE TESTDB;
GO

-- Grant SELECT, INSERT, UPDATE, DELETE permissions
GRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::dbo TO admin;
GO

-- Grant ALTER permission on all objects
GRANT ALTER ON SCHEMA::dbo TO admin;
GO
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.4/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/maven-plugin/build-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.




