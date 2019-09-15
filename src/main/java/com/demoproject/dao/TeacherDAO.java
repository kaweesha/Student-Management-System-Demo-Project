package com.demoproject.dao;

import com.demoproject.entity.Teacher;

import java.util.List;

public interface TeacherDAO {

    List<Teacher> getTeachers();

//    Teacher getTeacher(int teacherId);

    Teacher getTeacher(String className);

    void saveTeacher(Teacher theTeacher);

    void deleteTeacher(int teacherId);

}
