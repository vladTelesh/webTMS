package com.project.tms;

import domain.User;
import service.Service;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/second_update")
public class ControllerSecondPageUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = new ServiceImpl();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setGender(req.getParameter("gender"));
        user.setPassword(req.getParameter("password"));
        if(service.update(user,user.getId())){
            resp.getWriter().write("User was update");
        }else {
            resp.getWriter().write("Something bad");
        }
    }
}
