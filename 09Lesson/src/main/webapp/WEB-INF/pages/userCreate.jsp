<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nikol
  Date: 03.04.19
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form modelAttribute="userAdd" method="post" action="/Twitter/user/cu">
    <h4>Name</h4>
    <spring:input path="userName"/>
    <h4>Password</h4>
    <spring:input path="userPassword"/>
    <h4>Country</h4>
    <spring:input path="userCountry"/>
    <h4>Date</h4>
    <spring:input path="registrationDate"/>
    <spring:button>AddUser</spring:button>
    <a href="/Twitter/user/chek">Go to Auth</a>
</spring:form>
</body>
</html>
