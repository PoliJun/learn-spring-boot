# Project Notes

## Directory Structure

### pom.xml

Maven file

### `@SpringBootApplication`

```java
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### resources/application.properties

config environments

### resources/static/

web: html, css, js, etc.

## Create a simple API

This returns json: `["Hello","World"]`

```java
@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping
    public List<String> hello() {
        return List.of("Hello", "World");
    }

}
```

## Student Class

- RESTful api response json to browser automate.
- toString method in Student class
    > lombok: `@toString`

## API Layer

This is Controller

## Service Layer

### Constructor dependency injection

Controller communicate with Service through this way

### Dependency Injection

- `@Component`
- `@Service`

## Data Access Layer

### application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

## Entity

- `@Entity`
- `@Table`
- Primary key:

    ```java
    @Id
        @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
        private Long id;
    ```
