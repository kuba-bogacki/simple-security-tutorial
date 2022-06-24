package com.simple.security.tutorial.security.controller;

import com.simple.security.tutorial.security.model.Student;
import com.simple.security.tutorial.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/api/v1-student")
public class ManagementController {

    private final StudentService studentService;

    @Autowired
    public ManagementController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.createNewStudent(student);
    }

    @DeleteMapping(value = "{studentId}")
    public void deleteStudent(@PathVariable(name = "studentId") Long studentId) {
        studentService.deleteExistingStudent(studentId);
    }

    @PutMapping(value = "{studentId}")
    public void editStudent(@PathVariable(name = "studentId") Long studentId, @RequestBody String studentName) {
        studentService.editExistingStudent(studentId, studentName);
    }
}
