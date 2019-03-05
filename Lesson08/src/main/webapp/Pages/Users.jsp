<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.02.2019
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${users}" var="users">
        <tr>
            <td>${users.id}</td>
            <td><c:out value="${users.name}" /></td>
            <td><c:out value="${users.password}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
