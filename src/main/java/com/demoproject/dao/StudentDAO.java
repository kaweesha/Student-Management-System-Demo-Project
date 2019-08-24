package com.demoproject.dao;

import com.demoproject.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getStudents();

    Student getStudent(int studentId);

    void saveStudent(Student theStudent);

    void deleteStudent(int studentId);



}
