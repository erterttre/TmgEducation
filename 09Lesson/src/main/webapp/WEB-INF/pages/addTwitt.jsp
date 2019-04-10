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
<spring:form modelAttribute="twittFromServer" method="post" action="/Twitter/twitt/tt">
    <h4>Top Twitt</h4>
    <spring:input path="topMessage"/>
    <h4>Body Twitt</h4>
    <spring:input path="bodyMessage"/>
    <h4>Time</h4>
    <spring:input path="timeMessage"/>
    <h4>User Id</h4>
    <spring:input path="userId"/>
<spring:button>AddTwitt</spring:button>
    <a href="/Twitter/twitt/usertwitt">See my Twitts</a>
</spring:form>
</body>
</html>
