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
import java.io.PrintWriter;

@WebServlet("/manipulation_data")
public class ControllerReadUpdateDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = new ServiceImpl();
        long id = Long.parseLong(req.getParameter("id"));
        PrintWriter writer = resp.getWriter();
        User user = service.getUserById(id);

        if (req.getParameter("flag").equals("read")) {
            req.setAttribute("user", user);
            String path = "/read.jsp";
            getServletContext().getRequestDispatcher(path).forward(req, resp);

        } else if (req.getParameter("flag").equals("update")) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/second_page_update.jsp");

        } else if (req.getParameter("flag").equals("delete")) {
            if (service.delete(user)) {
                resp.getWriter().write("<h1>User was delete</h1>");
            } else {
                resp.getWriter().write("<h1>Something bad</h1>");
            }
            writer.print("<input value=\"Return\" type=\"button\" onclick=\"location.href='index.jsp'\"/>");
        }
    }
}
