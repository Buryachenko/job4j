<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create</title>
    <style>
        h1 {
            color: blue;
            border-color: blue white;
            border-style: solid;
        }
    </style>
</head>
<body>
<form action ="${pageContext.servletContext.contextPath}/?action=add" method="post">
    <p><h1>Create New User</h1></p> <br>
    <p> Name: <input type="text" name="name"> </p> <br>
    <p> Login: <input type="text" name="login"> </p> <br>
    <p> Email: <input type="text" name="email"> </p> <br>
    <input type ="submit" value="REGISTR">
</form>
</body>
</html>