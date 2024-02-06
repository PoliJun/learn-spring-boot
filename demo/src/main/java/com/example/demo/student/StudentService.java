package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student with id " + id + "does not exist");
        }

        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Student with id " + id + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);

        }

        if (email != null && email.length() > 0 && !Objects.equals(email, student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email Already Taken");
            }
            student.setEmail(email);
        }
    }
}
