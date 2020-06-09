package com.myapp.servlet;

import com.myapp.dao.LoginDao;
import com.myapp.dao.UserDao;
import model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao = new LoginDao();


    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");

            if ("create".equals(action)) {
                request.setAttribute("create", true);
                request.getRequestDispatcher("/WEB-INF/pages/login-add.jsp").forward(request, response);
            } else if ("login".equals(action)) {
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            } else if ("remove".equals(action)) {
                loginDao.remove(request.getParameter("id"));
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/login?action=login");
            } else if ("list".equals(action)) {
                List<Login> loginList = loginDao.findAllList();
                request.setAttribute("loginList", loginList);

                request.getRequestDispatcher("/WEB-INF/pages/login-list.jsp").forward(request, response);

            } else if ("logout".equals(action)) {
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/login?action=login");
            } else {
                response.sendRedirect(request.getContextPath() + "/error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Login login = loginDao.findLogin(email);
        if (login != null) {
            if (loginDao.checkLogin(email, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedEmail", email);
                session.setAttribute("userLogged",true);
                response.sendRedirect(request.getContextPath() + "/user-details?action=list");
            } else {
                response.sendRedirect(request.getContextPath() + "/login?action=login");
            }
        } else if ("create".equals(action)) {
            loginDao.create(email, password);
            response.sendRedirect(request.getContextPath() + "/login?action=login");
        } else {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
