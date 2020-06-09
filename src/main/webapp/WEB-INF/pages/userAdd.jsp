<%--
  Created by IntelliJ IDEA.
  User: ANNASSI Nahid
  Date: 05/06/2020
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../template/header.jsp"/>

User Add page<br/>

<c:url var="postUserUrl" value="/userdetail"></c:url>

<ul>
    <li>PageScope : ${pageScope.postUserUrl}</li>
    <li>RequestScope : ${requestScope.postUserUrl}</li>
    <li>SessionScope : ${sessionScope.postUserUrl}</li>
    <li>ApplicationScope : ${applicationScope.postUserUrl}</li>
</ul>

<form action="${postUserUrl}" method="post">
    Last name : <input type="text" name="lastname"><br/>
    First name : <input type="text" name="firstname"><br/>
    Salary : <input type="number" name="salary"><br/>
    <button type="submit">OK</button>
</form>

<jsp:include page="../template/footer.jsp"/>
</body>
</html>
