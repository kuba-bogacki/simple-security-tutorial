package com.simple.security.tutorial.security.service;

import com.simple.security.tutorial.security.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudentByStudentId(Long studentId);
    List<Student> getAllStudents();
    void createNewStudent(Student student);
    void deleteExistingStudent(Long studentId);
    void editExistingStudent(Long studentId, String studentName);
}
