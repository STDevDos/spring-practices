package com.froyo.practice.service.impl;

import com.froyo.practice.model.Student;
import com.froyo.practice.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Student getStudentById(int studentId) {
        if (1 == studentId) {
            return new Student(1, "Froyo", "Muguruza");
        } else {
            return new Student(2, "Dann", "Muguruza");
        }

    }

}
