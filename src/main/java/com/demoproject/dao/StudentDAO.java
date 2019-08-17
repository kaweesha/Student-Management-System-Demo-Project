package com.demoproject.dao;

import com.demoproject.entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> getStudents();

    public Student getStudent(int studentId);

    public void saveStudent(Student theStudent);

    public void deleteStudent(int studentId);



}
