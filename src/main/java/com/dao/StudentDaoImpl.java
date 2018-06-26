package com.dao;

import com.DomObj.Student;
import com.utils.ConnectionToPostgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao  {
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> selectAllStudent() {
        Connection connection = ConnectionToPostgres.createConnection();
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM student2");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                students.add(student);
            }
            rs.close();
            pr.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


@Override
    public void addStudent(Student student, Connection connection) {
        try {
            connection = ConnectionToPostgres.checkCreateConnectionToDB();
            String query = "INSERT INTO student2 (name, sername, gender, phone) VALUES (?,?,?,?);";
            PreparedStatement pr = connection.prepareStatement(query);
            System.out.println(student.getName());
            pr.setString(1, student.getName());
            pr.setString(2, student.getSurname());
            pr.setString(3, student.getGender());
            pr.setString(4, student.getPhone());
            pr.executeUpdate();
            pr.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

@Override
    public void deleteStudent(Student student, Connection connection) {
        try {
        connection = ConnectionToPostgres.checkCreateConnectionToDB();
        PreparedStatement pr = connection.prepareStatement("DELETE FROM student2 WHERE student2.name=? AND student2.sername=? AND student2.gender=? AND student2.phone=?");
            pr.setString(1, student.getName());
            pr.setString(2, student.getSurname());
            pr.setString(3, student.getGender());
            pr.setString(4, student.getPhone());
            pr.executeUpdate();
            pr.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
