<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login List</title>
</head>
<body>
<h1>Hello, I will be a list</h1>
<ul>
    <c:forEach items="${loginList}" var="login">
        <li>${login.email}</li>
    </c:forEach>
</ul>
</body>
</html>

