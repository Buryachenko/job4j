package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class UserUpdateServlet extends HttpServlet {

    public UserUpdateServlet() {
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.valueOf(req.getParameter("id"));
        Optional<User> opt = ValidateService.getInstance().getUser(id);
        req.setAttribute("user", opt.orElseGet(User::new));
        req.getRequestDispatcher("/WEB-INF/view/edit.jsp").forward(req, resp);
    }
}
