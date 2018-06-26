package com.dao;

import com.DomObj.Student;

import java.sql.Connection;
import java.util.ArrayList;

public interface StudentDao {

     ArrayList<Student> selectAllStudent();

     void addStudent(Student student, Connection connection);

     void deleteStudent(Student student, Connection connection);
}
