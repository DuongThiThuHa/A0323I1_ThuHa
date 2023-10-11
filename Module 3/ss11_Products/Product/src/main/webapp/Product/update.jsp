<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>Update product</h1>
<form action="/product" method="post">
    <table border="-1">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Date release</td>
        </tr>
        <tr>
            <td><input type="text" name="id" value="${product.id}"/></td>
            <td><input type="text" name="name" value="${product.name}"/></td>
            <td><input type="text" name="quantity" value="${product.quantity}"/></td>
            <td><input type="text" name="price" value="${product.price}"/></td>
            <td><input type="text" name="dateRelease" value="${dateRelease}"/></td>
    </table>
    <input type="hidden" name="action" value="Update">
    <input type="submit" id="submitBtn" value="update">
</form>
<a href="/product">Return to show list</a>
</body>
</html>