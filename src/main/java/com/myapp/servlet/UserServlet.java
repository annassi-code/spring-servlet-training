package com.myapp.servlet;

import com.myapp.dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user-details")
public class UserServlet extends HttpServlet {

    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(request.getParameter("firstname"), request.getParameter("lastname"), Integer.valueOf(request.getParameter("salary")));
        userDao.addUser(request.getParameter("firstname"), user);
        response.sendRedirect(request.getContextPath() + "/userdetail?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("detail".equals(action)) {
                User user = userDao.findUser(request.getParameter("id"));
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/pages/user-detail.jsp").forward(request, response);
            } else if ("list".equals(action)) {
                request.setAttribute("userList", userDao.findAllList());
                request.getRequestDispatcher("/WEB-INF/pages/user-list.jsp").forward(request, response);
            } else if ("create".equals(action)) {
                request.getRequestDispatcher("/WEB-INF/pages/user-add.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
