package com.example.studentmanagement.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        logger.info("Getting all students");
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        logger.info("Getting student with id: {}", id);
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        logger.info("Creating new student: {}", student);
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestParam(required = false) String email, @RequestParam(required = false) String studentClass, @RequestParam(required = false) Double attendance) {
        logger.info("Updating student with id: {}", id);
        studentService.updateStudent(id, email, studentClass, attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        logger.info("Deleting student with id: {}", id);
        studentService.deleteStudent(id);
    }
}