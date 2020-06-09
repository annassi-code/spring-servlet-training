<%--
  Created by IntelliJ IDEA.
  User: ANNASSI Alae
  Date: 05/06/2020
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

Users list

<ul>
    <c:forEach items="${userList}" var="user">
        <li>
            <a href="?action=detail&id=${user.firstName}">${user.firstName} ${user.lastName}</a> -

            <c:choose>
                <c:when test="${user.budget < 800}">Low</c:when>
                <c:when test="${user.budget > 1800}">High</c:when>
                <c:otherwise>Medium</c:otherwise>
            </c:choose>

        </li>
    </c:forEach>

</ul>

</body>
</html>
