package com.project.tms;

import domain.Role;
import domain.UserInfo;
import service.Service;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/work-with-data")
public class ControllerCreatUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInfo user = new UserInfo();
        Role role = new Role();
        Service service = new ServiceImpl();
        PrintWriter writer = resp.getWriter();

        user.setName(req.getParameter("name"));
        user.getLogin().setLogin(req.getParameter("email"));
        user.setGender(req.getParameter("gender"));
        user.getLogin().setPassword(req.getParameter("password"));
        role.setNameRole(req.getParameter("role"));
        user.getRoles().add(role);

        if (req.getParameter("flag").equals("creat")) {
            if (service.creat(user)) {
                resp.getWriter().write("<h1>Welcome to the our site</h1>");
            } else {
                resp.getWriter().write("<h1>Something bad</h1>");
            }
        } else if (req.getParameter("flag").equals("update")) {
            user.setId(Integer.parseInt(req.getParameter("id")));
            if (service.update(user)) {
                resp.getWriter().write("<h1>User was update</h1>");
            } else {
                resp.getWriter().write("<h1>Something bad</h1>");
            }
        }
        writer.print("<input value=\"Return\" type=\"button\" onclick=\"location.href='index.jsp'\"/>");
    }
}
