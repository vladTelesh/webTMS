package com.project.tms;



import domain.User;
import service.Service;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info")
public class ControllerCreat extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        Service service = new ServiceImpl();
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setGender(req.getParameter("gender"));
        user.setPassword(req.getParameter("password"));
        if(service.creat(user)){
            resp.getWriter().write("Welcome to the our site");
        }else {
            resp.getWriter().write("Something bad");
        }
    }
}
