package com.example.demo.student;

import java.util.List;
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
        //  studentRepository.save(student);
        System.out.println("New student"); 
    }
}
