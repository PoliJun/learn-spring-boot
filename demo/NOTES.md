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

-   RESTful api response json to browser automate.
-   toString method in Student class
    > lombok: `@toString`

## API Layer

This is Controller
