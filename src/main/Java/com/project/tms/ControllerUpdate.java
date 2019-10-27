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

@WebServlet("/update")
public class ControllerUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = new ServiceImpl();
        User user = service.getUserById(Long.parseLong(req.getParameter("id")));
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect("/second_page_update.jsp");
    }
}
