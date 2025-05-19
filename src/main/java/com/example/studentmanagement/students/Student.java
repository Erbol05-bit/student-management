package com.example.studentmanagement.students;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Transient
    private Integer age;

    @Column(name = "student_class", nullable = false)
    private String studentClass;

    @Column(nullable = false)
    private Double attendance;

    @Column(nullable = false)
    private String grades;

    @Column(nullable = false)
    private String password;

    public Student() {}

    public Student(Long id, String name, String email, LocalDate birthDate, String studentClass, Double attendance, String grades, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.studentClass = studentClass;
        this.attendance = attendance;
        this.grades = grades;
        this.password = password;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public Integer getAge() {
        if (age == null) {
            age = Period.between(birthDate, LocalDate.now()).getYears();
        }
        return age;
    }
    public String getStudentClass() { return studentClass; }
    public void setStudentClass(String studentClass) { this.studentClass = studentClass; }
    public Double getAttendance() { return attendance; }
    public void setAttendance(Double attendance) { this.attendance = attendance; }
    public String getGrades() { return grades; }
    public void setGrades(String grades) { this.grades = grades; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}