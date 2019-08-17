package com.demoproject.dao;

import com.demoproject.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create query
        Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);

        // execute the query and get the result list
        List<Student> students = theQuery.getResultList();

        // return result list
        return students;
    }

    @Override
    public void saveStudent(Student theStudent) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save student
        currentSession.saveOrUpdate(theStudent);

    }

    @Override
    public Student getStudent(int studentId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Student theStudent = currentSession.get(Student.class, studentId);

        return theStudent;
    }

    @Override
    public void deleteStudent(int studentId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Student where id=:studentId");
        theQuery.setParameter("studentId", studentId);

        theQuery.executeUpdate();
    }
}
