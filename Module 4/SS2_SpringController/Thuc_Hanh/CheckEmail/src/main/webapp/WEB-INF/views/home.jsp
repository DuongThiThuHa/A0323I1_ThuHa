<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 06/11/2023
  Time: 7:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Email Validate</h1>
<form action="validate" method="post">
    <input type="text" name="email">
    <input type="submit" value="Validate">
    <h4 style="color: red">${message}</h4>
</form>
</body>
</html>
