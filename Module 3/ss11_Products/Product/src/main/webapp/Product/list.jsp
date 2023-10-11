<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>List Product</h1>
<table border="-1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Date release</th>
        <th>Change</th>
    </tr>
    <c:forEach items="${product}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.quantity}</td>
            <td>${product.price}</td>
            <td><fmt:formatDate value="${product.dateRelease}" pattern="dd/MM/yyyy"/></td>

            <td><a href="/product?action=update&id=${product.id}">Update Product.</a></td>
            <td><a href="/product?action=create">Add Product.</a></td>
            <td><a href="/product?action=delete">Delete Product.</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>