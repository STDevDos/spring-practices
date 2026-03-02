package com.froyo.practice.controller;

import com.froyo.practice.model.Student;
import com.froyo.practice.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

}
