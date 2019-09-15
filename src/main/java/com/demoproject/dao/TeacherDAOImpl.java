package com.demoproject.dao;

import com.demoproject.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Teacher> getTeachers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Teacher> theQuery = currentSession.createQuery("from Teacher", Teacher.class);

        // execute the query and get the result list
        List<Teacher> teachers = theQuery.getResultList();

        // return result list
        return teachers;
    }

//    @Override
//    public Teacher getTeacher(int teacherId) {
//
//        // get the current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        // now retrieve/read from database using the primary key
//        Teacher theTeacher = currentSession.get(Teacher.class, teacherId);
//
//        return theTeacher;
//    }

    @Override
    public Teacher getTeacher(String className) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
//        Teacher theTeacher = currentSession.get(Teacher.class, className);

        Query<Teacher> theQuery = currentSession.createQuery("FROM Teacher T WHERE T.className = :className", Teacher.class);
        theQuery.setParameter("className",className);

        return theQuery.getSingleResult();
    }

    @Override
    public void saveTeacher(Teacher theTeacher) {

    }

    @Override
    public void deleteTeacher(int teacherId) {

    }
}
