package ru.job4j.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
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
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/plain");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        List<User> users = this.logic.users();
        writer.append("List of users:").append(System.lineSeparator());
        if (users.size() > 0) {
            users.forEach(u -> writer.append(u.toString()));
        } else {
            writer.append("1. The list is empty.").append(System.lineSeparator());
            writer.append("2. POST request example: curl -d \"action=[add or update or delete]");
            writer.append("&id=[int number]");
            writer.append("&name=[Name]");
            writer.append("&login=[Login]");
            writer.append("&email=[Email]");
            writer.append("-X POST http://localhost:8080/items/users");
        }
        writer.flush();
    }
}