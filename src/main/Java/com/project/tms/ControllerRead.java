package com.project.tms;

import domain.User;
import service.Service;
import service.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/information")
public class ControllerRead extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = new ServiceImpl();
        User user = service.getUserById(Long.parseLong(req.getParameter("id")));
        req.setAttribute("user",user);
        String path = "/read.jsp";
        getServletContext().getRequestDispatcher(path).forward(req, resp);

    }
}
