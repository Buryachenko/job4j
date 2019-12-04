package ru.job4j.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import static ru.job4j.servlets.Message.Type.*;

public class UserServlet extends HttpServlet {
    private final Map<Message.Type, Function<User, Boolean>> dispatch = new HashMap<>();
    private final ValidateService logic = ValidateService.getInstance();

    public UserServlet() {
        init();
    }

    public void init() {
        this.load(ADD, this.logic.add());
        this.load(UPDATE, this.logic.update());
        this.load(DELETE, this.logic.delete());
    }

    private void load(Message.Type type, Function<User, Boolean> handle) {
        this.dispatch.put(type, handle);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setLogin(req.getParameter("login"));
        user.setEmail(req.getParameter("email"));
        user.setCreateDate(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
        String action = req.getParameter("action").toUpperCase();
        Message.Type type = valueOf(action);
        String id = req.getParameter("id");
        if (id != null && (id).matches("^-?\\d+$")) {
            user.setId(Integer.parseInt(id));
        } else if (type == ADD) {
            user.setId(user.hashCode());
        }
        this.dispatch.get(type).apply(user);
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder tableUsers = new StringBuilder("<table border-color = 'blue' border = '1'>");
        tableUsers.append("<caption></caption>");
        tableUsers.append(  "<tr>" +
                "<th>ID</th>" +
                "<th>NAME</th>" +
                "<th>LOGIN</th>" +
                "<th>EMAIL</th>" +
                "<th>CREATE DATE</th>" +
                "<th></th>" +
                "<th></th>" +
                "</tr>"
        );
        this.logic.users().forEach(user -> tableUsers
                .append("<tr>" +
                        "<td>" + user.getId() + "</td>" +
                        "<td>" + user.getName() + "</td>" +
                        "<td>" + user.getLogin() + "</td>" +
                        "<td>" + user.getEmail() + "</td>" +
                        "<td>" + user.getCreateDate() + "</td>" +
                        "<td> <input type = 'submit' formaction = '"+ req.getContextPath() +
                        "/list?id=" + user.getId() + "' method='post' name = 'action' value = 'DELETE'></td>" +
                        "<td> <input type = 'submit' formaction = '"+ req.getContextPath() +
                        "/edit?id=" + user.getId() + "' method='get' name = 'action' value = 'EDIT'</td>" +
                        "</tr>"));
        tableUsers.append("</table>");
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
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
                "<p><h1>USER INFORMATION</h1></p>" +
                "<form action = '"+ req.getContextPath()+ "/list' method='post'>" +
                tableUsers.toString() + "<br>" +
                "<input type = 'submit' value = 'ADD NEW USER' formaction = '" + req.getContextPath() +
                "/create' method='post'>" +
                "</form>" +
                "</body>" +
                "</html>"
        );
        writer.flush();
    }
}