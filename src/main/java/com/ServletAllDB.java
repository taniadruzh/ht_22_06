package com;

import com.DomObj.Student;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/allDB")


public class ServletAllDB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao studentDao = new StudentDaoImpl();
        ArrayList<Student> students = studentDao.selectAllStudent();
        req.setAttribute("allstudents",students);
        req.getRequestDispatcher("allDB.jsp").forward(req,resp);
    }

}

