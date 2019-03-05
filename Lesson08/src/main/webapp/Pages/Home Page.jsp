<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.02.2019
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Plugin tester</title>
</head>

<body>
<h1>Registration</h1>
<form action = "${pageContext.request.contextPath}/hello-db2" method = "POST">
    <table border = "0">

        <tr>
            <td><b>Name</b></td>
            <td><input type = "text" name = "name"
                        size = "70"/></td>
        </tr>

        <tr>
            <td><b>Password</b></td>
            <td><input type = "text" name = "password"
                        size = "65"/></td>
        </tr>

        <tr>
            <td colspan = "2"><input type = "submit" value = "Submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>
