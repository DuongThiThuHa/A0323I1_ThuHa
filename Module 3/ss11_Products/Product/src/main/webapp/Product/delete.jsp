<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<form action="/product" method="post">
    <label for="product">ID</label>
    <select name="productID" id="product">
        <c:forEach items="${products}" var="element">
            <option value="${element.id}">${element.id}: ${element.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Delete">
    <input type="hidden" name="action" value="delete">
</form>
<a href="/product">Return to show list</a>
</body>
</html>