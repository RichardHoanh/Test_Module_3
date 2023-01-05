package controllers;

import models.Student;
import models.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String classroom = request.getParameter("class");
        StudentService.create(new Student(name,date,address,phone,email,classroom));

        //        Điều hướng xuống Servlet "customer"
        response.sendRedirect("/home");

    }
}
