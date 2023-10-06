<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>List Product</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Date release</th>
        <th>Change</th>
    </tr>
    <c:forEach items="${products}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.quantity}</td>
            <td>${s.price}</td>
            <td><fmt:formatDate value="${s.dateRelease}" pattern="dd/MM/yyyy"/></td>
            <td><a href="/product?action=update&id=${s.id}">Update Product.</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/product?action=create">Add new Product.</a>
<a href="/product?action=delete">Delete Product.</a>
</body>
</html>