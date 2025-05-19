package com.example.studentmanagement.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
@Transactional
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        logger.info("Getting student with id: {}", id);
        return studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        logger.info("Creating new student: {}", student);
        Student savedStudent = studentRepository.save(student);
        logger.info("Student created successfully with id: {}", savedStudent.getId());
        return savedStudent;
    }

    public void updateStudent(Long id, String email, String studentClass, Double attendance) {
        logger.info("Updating student with id: {}", id);
        var student = studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        if (email != null) student.setEmail(email);
        if (studentClass != null) student.setStudentClass(studentClass);
        if (attendance != null) student.setAttendance(attendance);
        studentRepository.save(student);
        logger.info("Student updated successfully");
    }

    public void deleteStudent(Long id) {
        logger.info("Deleting student with id: {}", id);
        studentRepository.deleteById(id);
        logger.info("Student deleted successfully");
    }
}