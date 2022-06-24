package com.simple.security.tutorial.security.controller;

import com.simple.security.tutorial.security.model.Student;
import com.simple.security.tutorial.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1-student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable(value = "studentId") Long studentId) {
        return studentService.getStudentByStudentId(studentId);
    }
}
