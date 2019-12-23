package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
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
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", this.logic.users());
        req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, resp);
    }
}