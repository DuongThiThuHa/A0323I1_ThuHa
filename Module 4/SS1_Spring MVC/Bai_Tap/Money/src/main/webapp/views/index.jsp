<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 05/11/2023
  Time: 9:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action = "/convert" method="post">
    <div>USD: <input name="usd" value="${usd}"></div>
    <div>Result: <input name="result" value="${res}"></div>
    <button>Convert</button>
</form>
</body>
</html>
