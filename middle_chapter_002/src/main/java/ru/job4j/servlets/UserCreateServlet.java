package ru.job4j.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserCreateServlet extends HttpServlet {

    public UserCreateServlet() {
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        writer.append("<!DOCTYPE html" +
                "<html lang = \"en\">" +
                "<head>" +
                "<meta charset = \"UTF-8\">" +
                "<title>Users</title>" +
                "<style>" +
                "h1 {" +
                "color : blue;" +
                "border-color: blue white;" +
                "border-style: solid;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<form action = '"+req.getContextPath()+ "/list?action=add' method='post'>" +
                "<p><h1> Create New User</h1> <br>" +
                "<p> Name: <input type='text' name='name'/> </p> <br>" +
                "<p> Login: <input type='text' name='login'/> </p> <br>" +
                "<p> Email: <input type='text' name='email'/> </p> <br>" +
                "<input type = 'submit' action = 'add' value = 'SUBMIT'>" +
                "</form>" +
                "</body>" +
                "</html>"
        );
        writer.flush();
    }
}