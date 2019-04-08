<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${twitt} Twitts</title>
    <style>.sub {color: midnightblue;}</style>
</head>
<body>
<p>
<h1>Your tweets</h1>
<div>
            <ul>
                <c:forEach items="${twitt}" var="twitt">
                    <li style="color: deepskyblue">
                        <ul>
                            <li class="sub">Topic: ${twitt.topMessage}</li>
                            <li class="sub">Body: ${twitt.bodyMessage}</li>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
    <a href="/Twitter/twitt/createtwitt">Create Twitt</a>
</div>
</body>
</html>
