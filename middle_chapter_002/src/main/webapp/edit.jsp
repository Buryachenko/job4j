<%@ page import="ru.job4j.servlets.MemoryStore" %>
<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="java.util.Optional" %>
<%@ page import="ru.job4j.servlets.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <style>
        h1 {
            color: blue;
            border-color: blue white;
            border-style: solid;
        }
    </style>
</head>
<body>
<form action="<%=request.getContextPath()%>/edit" method="post">
    <p><h1>Update Current User</h1></p><br>
    <%
        final User user;
        String id = request.getParameter("id");
        Optional<User> opt = ValidateService.getInstance().users().stream().filter(u -> Integer.toString(u.getId()).equals(id)).findFirst();
        user = opt.orElseGet(User::new);
    %>
    <p> Name: <input type="text" name="name" value="<%=user.getName()%>"> </p><br>
    <p> Login: <input type='text' name='login' value="<%=user.getLogin()%>"> </p><br>
    <p> Email: <input type='text' name='email' value="<%=user.getEmail()%>"> </p><br>
    <input type = 'submit' formaction ="<%=request.getContextPath()%>/list?id=<%=user.getId()%>" method="post" name = "action" value="UPDATE">
</form>
</body>
</html>
