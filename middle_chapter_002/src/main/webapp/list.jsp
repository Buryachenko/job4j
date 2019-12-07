<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="ru.job4j.servlets.MemoryStore" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <style>
        q {
            font-family: Times, serif;
            font-style: italic;
            color: navy;
            quotes: none;
        }
        h1 {
            color: blue;
            border-color: blue white;
            border-style: solid;
        }
    </style>
</head>
<body>
<form action = "<%=request.getContextPath()%>/list" method="post">
    <p><h1>USER INFORMATION</h1></p>
    <table border-color = 'blue' border = '1'>
        <caption></caption>
        <tr><th>ID</th><th>NAME</th><th>LOGIN</th><th>EMAIL</th><th>CREATE DATE</th><th>ACTION</th></tr>
        <% for (User user : MemoryStore.getInstance().findAll()) {%>
        <tr>
            <td><q><%=user.getId()%></q></td>
            <td><q><%=user.getName()%></q></td>
            <td><q><%=user.getLogin()%></q></td>
            <td><q><%=user.getEmail()%></q></td>
            <td><q><%=user.getCreateDate()%></q></td>
            <td>
                <input type="submit" formaction="<%=request.getContextPath()%>/list?id=<%=user.getId()%>" method="post" name="action" value="DELETE">
                <input type="submit" formaction="<%=request.getContextPath()%>/edit?id=<%=user.getId()%>" method="post" value="EDIT">
            </td>
        </tr>
        <%}%>
    </table>
    <br>
    <input type="submit" formaction="<%=request.getContextPath()%>/create" method="post" value="ADD NEW USER">
</form>
</body>
</html>