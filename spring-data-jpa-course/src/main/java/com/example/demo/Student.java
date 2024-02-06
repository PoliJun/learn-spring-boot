package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
