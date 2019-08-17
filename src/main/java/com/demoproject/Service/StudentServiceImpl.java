package com.demoproject.Service;

import com.demoproject.dao.StudentDAO;
import com.demoproject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getStudents(){

        return studentDAO.getStudents();
    }

    @Override
    @Transactional
    public void saveStudent(Student theStudent) {

        studentDAO.saveStudent(theStudent);
    }

    @Override
    @Transactional
    public Student getStudent(int studentId) {

        return studentDAO.getStudent(studentId);
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {

        studentDAO.deleteStudent(studentId);
    }


}
