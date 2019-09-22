package com.demoproject.Service;

import com.demoproject.dao.StudentDAO;
import com.demoproject.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;
//    private SchoolClassDAO schoolClassDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> getStudents(String className){

        return studentDAO.getStudents(className);
    }

    @Override
    @Transactional
    public void saveStudent(Student theStudent) {
        // SchoolClass schoolClass = schoolClassDAO.getSchoolClass(theStudent.getClassName());
        // if (schoolClass==null) {
        //      schoolClassDAO.addSchoolClass(theStudent.getClassName());
        // }

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
