<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<form action ="${pageContext.servletContext.contextPath}/" method="post">
    <p><h1>USER INFORMATION</h1>
    <table border='1'>
        <caption></caption>
        <tr><th>ID</th><th>NAME</th><th>LOGIN</th><th>EMAIL</th><th>CREATE DATE</th><th>ACTION</th></tr>
        <c:forEach var ="user" items="${users}">
            <tr>
                <td><q><c:out value="${user.id}"/></q></td>
                <td><q><c:out value="${user.name}"/></q></td>
                <td><q><c:out value="${user.login}"/></q></td>
                <td><q><c:out value="${user.email}"/></q></td>
                <td><q><c:out value="${user.createDate}"/></q></td>
                <td>
                    <input type="submit" formaction="${pageContext.servletContext.contextPath}/?id=${user.id}" method="post" name="action" value="DELETE">
                    <input type="submit" formaction="${pageContext.servletContext.contextPath}/edit?id=${user.id}" method="post" value="EDIT">
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><input type="submit" formaction="${pageContext.servletContext.contextPath}/create" method="post" value="ADD NEW USER">
</form>
</body>
</html>
