package com;

import com.DomObj.Student;
import com.dao.StudentDaoImpl;
import com.utils.ConnectionToPostgres;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;


@WebServlet("/")
public class EditStudentServlet extends HttpServlet {
    private static StudentDaoImpl studentDao = new StudentDaoImpl();
    private static ArrayList<Student> students;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("buttonEditOFStudent") != null && req.getParameter("buttonEditOFStudent").equals("add")) {
            add(req, resp);
        } else if (req.getParameter("buttonEditOFStudent") != null && req.getParameter("buttonEditOFStudent").equals("delete")) {
            delete(req, resp);
        } else {
            req.getRequestDispatcher("editStudent.jsp").forward(req, resp);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        Student student = new Student(name, surname, gender, phone);
        Connection connection = ConnectionToPostgres.createConnection();
        studentDao.addStudent(student, connection);
        req.getRequestDispatcher("/editStudent.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        Student student = new Student(name, surname, gender, phone);
        Connection connection = ConnectionToPostgres.createConnection();
        studentDao.deleteStudent(student, connection);
        req.getRequestDispatcher("editStudent.jsp").forward(req, resp);
    }
}

