package com.example.demo.student;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;



    @GetMapping
    public List<Student> hello() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/{StudentId}")
    public void removeStudent(@PathVariable("StudentId") Long id ){
        studentService.deleteStudent(id);
    }
}
