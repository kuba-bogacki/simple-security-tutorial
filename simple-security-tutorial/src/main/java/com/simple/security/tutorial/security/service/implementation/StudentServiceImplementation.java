package com.simple.security.tutorial.security.service.implementation;

import com.simple.security.tutorial.security.model.Student;
import com.simple.security.tutorial.security.repository.StudentRepository;
import com.simple.security.tutorial.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentByStudentId(Long studentId) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student does not exist!"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void createNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Modifying
    public void deleteExistingStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    @Modifying
    public void editExistingStudent(Long studentId, String studentName) {
        Optional<Student> studentToEdit = studentRepository.findById(studentId);
        studentToEdit.get().setStudentName(studentName);
        studentRepository.save(studentToEdit.get());
    }
}
