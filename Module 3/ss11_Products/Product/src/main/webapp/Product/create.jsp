<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Product</title>
</head>
<body>
<h1>Create product</h1>
<form action="/product" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="number" name="id"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="number" name="quantity"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>Date release</td>
            <td><input type="text" placeholder="dd/MM/yyyy" name="dateRelease"/></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
    <input id="submitBtn" type="submit" value="Add">
</form>
<a href="/product">Return to show list</a>
</body>
</html>