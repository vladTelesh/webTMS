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

@WebServlet("/delete")
public class ControllerDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = new ServiceImpl();
        if(service.delete(Long.parseLong(req.getParameter("id")))){
            resp.getWriter().write("User was delete");
        }else {
            resp.getWriter().write("Something bad");
        }
    }
}
