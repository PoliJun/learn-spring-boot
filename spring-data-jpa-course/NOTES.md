# Spring Data JPA

## Course Description

- What is Spring Data JPA
- Connect to a real database and not in memory DB
- how to map classes two tables
- Hibernate entity life cycle
- Queries
- paging in sorting
- 1 to 1 relationships
- to many relationships
- many to many relationships
- transactions

## JPA and Spring Data JPA

![description](image/decription.png)

## ERD

### Entity

- Table name
- Constraint
- item name
- data type
![Entity](image/entity.png)

## Map Entity to Table

**import jakarta/javax related packages, not hibernate**

### `@Entity`

```java
@Entity(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

}
```

`name`: Default is the class name.  
Sometimes you have a long class but entity name is different. It's good practice to explicitly give the name of the entity.
