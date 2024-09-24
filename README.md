# JavaSpringBoot Project

## Description
This project is a Spring Boot backend application that demonstrates how to connect a Spring Boot project to 
Microsoft SQL Server (MSSQL) and use Spring Data JPA for database operations. The project is built with Java 21 
and Maven, and it includes a RESTful API for managing staff data.

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

### 1. Clone the Repository

```bash
git clone https://github.com/your-repository/JavaSpringBoot.git
cd JavaSpringBoot
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




