package com.demoproject.Service;

import com.demoproject.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getTeachers();

    public void saveTeacher(Teacher theTeacher);

//    public Teacher getTeacher(int teacherId);

    public Teacher getTeacher(String className);

    public void deleteTeacher(int teacherId);



}
