package controllers;

import models.Student;
import models.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = StudentService.findStudentById(id);
        request.setAttribute("edit", student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formEdit.jsp");
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String classroom = request.getParameter("class");
        StudentService.edit(new Student(id,name,date,address,phone,email,classroom));

        response.sendRedirect("/home");

    }


}
