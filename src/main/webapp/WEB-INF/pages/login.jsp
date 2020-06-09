<%--
  Created by IntelliJ IDEA.
  User: ANNASSI Alae
  Date: 08/06/2020
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="loginUrl" value="/login?action=login"/>
<c:url var="logoutUrl" value="/login?action=logout"/>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <c:if test="${sessionScope.loggedEmail == null}">
            <form name="login" action="${loginUrl}" method="post">
                <label>Email:</label>
                <input type="email" name="email"/>

                <label>Password:</label>
                <input type="password" name="password"/>
                <button type="submit">OK</button>
            </form>
            <a href="login?action=create"> are you a new user ?</a>
        </c:if>

        <c:if test="${sessionScope.loggedEmail != null}">
            User ${sessionScope.loggedEmail} is already logged
            <a href="${logoutUrl}"> Logout</a>
        </c:if>
    </body>
</html>
