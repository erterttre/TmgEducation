<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nikol
  Date: 01.04.19
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form modelAttribute="userFromServer" method="post" action="/Twitter/user/chek">
    <h4>Name</h4>
    <spring:input path="userName"/>
    <h4>Password</h4>
    <spring:input path="userPassword"/>
    <spring:button>Authorization</spring:button>
</spring:form>
</body>
</html>
