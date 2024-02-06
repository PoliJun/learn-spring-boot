package com.example.demo;

import javax.persistence.*;

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
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "id", updatable = false)
    Long id;
    
    @Column(name = "first_name", nullable = false, columnDefinition = "Text")
    private String firstName;
    
    @Column(name = "last_name", nullable = false, columnDefinition = "Text")
    private String lastName;
    
    @Column(name = "email", nullable = false, columnDefinition = "Text", unique = true)
    private String email;
    
    @Column(name = "age")
    private Integer age;

}
