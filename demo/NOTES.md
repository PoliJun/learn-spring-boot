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

- Get
- Post
- Put
- Delete

### From Bard

<div style="padding: 20px; margin: 5px; border: 1px solid purple">
In Spring Boot, the API layer forms the core for interacting with your application through various HTTP methods like GET, POST, PUT, and DELETE. Understanding these methods and how to implement them effectively is crucial for building functional and user-friendly applications.

**Understanding the HTTP Methods:**

- **GET:** This method retrieves data from a specific resource identified by the URL. It's typically used to fetch information or list available resources.
- **POST:** This method creates a new resource on the server based on the data provided in the request body. It's commonly used for submitting forms, adding new entries, or triggering actions.
- **PUT:** This method updates an existing resource on the server with the data provided in the request body. It's used to modify or replace existing data entirely.
- **DELETE:** This method removes a specific resource from the server based on the provided URL. Use it with caution as deleted data is generally unrecoverable.

**Implementing API Endpoints in Spring Boot:**

Spring Boot provides several annotations and libraries to simplify building RESTful APIs. Here's a basic overview:

1. **Define your data model:** Create domain classes representing your resources (e.g., User, Product).
2. **Create controllers:** Use Spring MVC controllers annotated with `@RestController` to define your API endpoints.
3. **Map methods to HTTP verbs:** Annotate controller methods with `@GetMapping`, `@PostMapping`, `@PutMapping`, or `@DeleteMapping` to specify the supported HTTP method.
4. **Handle data input and output:** Use request and response objects to access data sent and received by the API. Utilize libraries like Jackson for automatic JSON serialization and deserialization.
5. **Connect to data store:** Integrate with databases or other persistence mechanisms to store and retrieve your data. Spring Data and JPA offer simplified access to various data sources.

**Examples:**

```java
// GET all users
@GetMapping("/users")
public List<User> getAllUsers() {
    return userService.findAll();
}

// POST a new user
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    return userService.save(user);
}

// PUT an existing user
@PutMapping("/users/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    user.setId(id);
    return userService.save(user);
}

// DELETE a user
@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable Long id) {
    userService.deleteById(id);
}
```

**Remember:**

- Implement proper error handling and security measures for your API endpoints.
- Use clear and descriptive URLs for your resources.
- Document your API with tools like Swagger for better collaboration and usability.

By effectively utilizing Spring Boot's API layer functionalities, you can create robust and scalable web applications that interact seamlessly with your users and other systems. As you progress in your Spring Boot journey, delve deeper into advanced topics like security, exception handling, and performance optimization for a well-rounded understanding of building efficient and secure APIs.
</div>
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

### Entity

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

### JPA Repositories

`@Repository`

```java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    
}

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
```

### Saving Student

#### CommandLineRunner

```java
package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(null, "Mariam", "mariam@example.com",
                    LocalDate.of(2000, Month.JANUARY, 5), 21);
            Student alex = new Student(null, "Alex", "alex@example.com",
                    LocalDate.of(2004, Month.JANUARY, 5), 21);
            Student delores = new Student(null, "Delores", "delores@example.com",
                    LocalDate.of(2002, Month.JANUARY, 5), 21);

            repository.saveAll(List.of(mariam, alex, delores));

        };

    }
}
```

## `@Transient`

`jakarta.persistence.Transient`
Specifies that the property or field is not persistent. It is used to annotate a property or field of an entity class, mapped superclass, or embeddable class.

```java
package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

}
```

`age` is no longer in database, but returned from api.

```terminal
student=# \d student
                      Table "public.student"
 Column |          Type          | Collation | Nullable | Default 
--------+------------------------+-----------+----------+---------
 dob    | date                   |           |          | 
 id     | bigint                 |           | not null | 
 email  | character varying(255) |           |          | 
 name   | character varying(255) |           |          | 
Indexes:
    "student_pkey" PRIMARY KEY, btree (id)
```

```json
[
  {
    "id": 1,
    "name": "Mariam",
    "email": "mariam@example.com",
    "dob": "2000-01-05",
    "age": 24
  },
  {
    "id": 2,
    "name": "Alex",
    "email": "alex@example.com",
    "dob": "2004-01-05",
    "age": 20
  },
  {
    "id": 3,
    "name": "Delores",
    "email": "delores@example.com",
    "dob": "2002-01-05",
    "age": 22
  }
]
```

## PostMapping

- `@PostMapping`
- `@RequestBody`

```java
@PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }
```

## Business Logic

### FindStudentByEmail(String email)

`Optional<Student> findStudentByEmail(String email);`

### `Optional<Student>`

`isPresent()`

```java
package com.example.demo.student;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional =
                studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        studentRepository.save(student);
    }
}
```

### Testing Post

#### error message

`application.properties`

```properties
server.error.include-message=always
```

returns:

```json
{
    "timestamp": "2024-02-06T15:19:12.872+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Email already taken",
    "path": "/api/v1/student"
}
```

## Delete Method

`existsById(id)`

```java
public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student with id " + id + "does not exist");
        }

        studentRepository.deleteById(id);
    }
```

### `@Query`

```java
@Query("SELECT u FROM User u WHERE u.status = 1")
Collection<User> findAllActiveUsers();
```

[baeldung bolg](https://www.baeldung.com/spring-data-jpa-query)

## Put api

update database

### `@Transactional`

**Using this annotation means that you don't have to write any JPQL query.**

#### Entity Managed State

[Hibernate Entity Life Cycle](https://nikhilsukhani.medium.com/hibernate-lifecycle-states-in-hibernate-transient-persistent-detached-removed-40ba2f689b07)

## Packaging and Running Applications

- `mvn install`
- `java -jar demo-0.0.1-SNAPSHOT.jar`  
- `java -jar demo-0.0.1-SNAPSHOT.jar --server.port 8081`

### `mvn package` vs. `mvn install`

----
**Bard:**

<div style="margin: 5px; padding: 20px; border: 1px solid purple">
**Tailoring Project Outputs: Understanding `mvn package` vs. `mvn install`**

In the realm of Maven builds, both `mvn package` and `mvn install` play crucial roles, each catering to distinct deployment scenarios. Choosing the right command depends on your specific project objectives and desired outcomes.

**mvn package:**

- **Focus:** Packaged Artifact
- **Action:** Compiles and packages your project into a distributable format (JAR/WAR), placing it within the dedicated `target` directory.
- **Outcome:** Standalone distributable ready for manual deployment or testing.
- **Suitability:** Ideal when you solely require a distributable package for immediate use without impacting your local Maven repository.

**mvn install:**

- **Focus:** Packaging and Installation
- **Action:** Executes the entire build lifecycle up to the `install` phase, encompassing compilation, packaging (similar to `mvn package`), and verification.
- **Outcome:** Packaged artifact placed in the `target` directory **and** installed in your local Maven repository, readily accessible for project dependencies.
- **Suitability:** Perfect for developing libraries or modules intended for integration with other projects within your codebase, ensuring efficient dependency management.

**Key Considerations:**

- **`mvn clean install`:** Combines cleaning the `target` directory (`mvn clean`) with packaging and installation (`mvn install`) for a streamlined workflow.
- **Custom Goals:** Configure custom goals for fine-grained control over specific build functionalities beyond default behaviors.

By understanding the nuances of `mvn package` and `mvn install`, you can make informed decisions regarding project outputs, streamlining your development process and effectively managing dependencies. Feel free to ask any further questions you may have!
</div>
