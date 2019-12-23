<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<form action ="${pageContext.servletContext.contextPath}/edit" method="post">
    <p><h1>Update Current User</h1></p><br>
    <p> Name: <input type="text" name="name" value="${user.name}"/></p><br>
    <p> Login: <input type='text' name='login' value="${user.login}"/></p><br>
    <p> Email: <input type='text' name='email' value="${user.email}"/></p><br>
    <input type = 'submit' formaction ="${pageContext.servletContext.contextPath}/?id=${user.id}" method="post" name = "action" value="UPDATE">
</form>
</body>
</html>
