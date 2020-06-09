<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alae</title>
</head>
<body>
this is ${user.firstName}
<ul>
    <c:forEach items="${users}" var="user">
    <a href="?action=detail&id=${user.firstName}">
            ${user.lastName}<a/>
        </c:forEach>
</ul>
</body>
</html>
