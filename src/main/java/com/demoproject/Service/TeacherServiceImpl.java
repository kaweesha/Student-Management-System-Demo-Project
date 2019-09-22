package com.demoproject.Service;

import com.demoproject.dao.TeacherDAO;
import com.demoproject.entity.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    private TeacherDAO teacherDAO;

    public TeacherServiceImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    @Transactional
    public List<Teacher> getTeachers() {
        return teacherDAO.getTeachers();
    }

    @Override
    @Transactional
    public void saveTeacher(Teacher theTeacher) {
        teacherDAO.saveTeacher(theTeacher);

    }

//    @Override
//    @Transactional
//    public Teacher getTeacher(int teacherId) {
//        return teacherDAO.getTeacher(teacherId);
//    }

    @Override
    @Transactional
    public Teacher getTeacher(String className) {
        return teacherDAO.getTeacher(className);
    }

    @Override
    @Transactional
    public void deleteTeacher(int teacherId) {
        teacherDAO.deleteTeacher(teacherId);

    }
}
