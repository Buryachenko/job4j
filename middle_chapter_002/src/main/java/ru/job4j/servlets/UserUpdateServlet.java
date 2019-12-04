package ru.job4j.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class UserUpdateServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    public UserUpdateServlet() {
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final User user;
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        Optional<User> opt = this.logic.users().stream().filter(u -> Integer.toString(u.getId()).equals(id)).findFirst();
        user = opt.orElseGet(User::new);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html" +
                "<html lang = \"en\">" +
                "<head>" +
                "<meta charset = \"UTF-8\">" +
                "<title>Edit</title>" +
                "<style>" +
                "h1 {" +
                "color : blue;" +
                "border-color: blue white;" +
                "border-style: solid;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<form action = '"+req.getContextPath()+ "/edit' method='post'>" +
                "<p><h1>Update Current User</h1></p> <br>" +
                "<p> Name: <input type='text' name='name' value = '" + user.getName() + "'/> </p> <br>" +
                "<p> Login: <input type='text' name='login' value = '" + user.getLogin() + "'/> </p> <br>" +
                "<p> Email: <input type='text' name='email' value = '" + user.getEmail() + "'/> </p> <br>" +
                "<input type = 'submit' formaction = '"+ req.getContextPath() +
                "/list?id=" + user.getId() + "' method='post' name = 'action' value = 'UPDATE'>" +
                "</form>" +
                "</body>" +
                "</html>"
        );
        writer.flush();
    }
}
