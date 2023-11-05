<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add new product</h1>
<form action="/product?action=create" method="post">

    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    <label for="price">Price:</label>
    <input type="number" id="price" name="price">
    <label for="quantity">Quantity:</label>
    <input typeof="number" id="quantity" name="quantity">
    <label for="color">Color:</label>
    <input typeof="text" id="color" name="color">
    <label for="category">Category:</label>
    <select class="form-select" name="categoryId" id="category">
        <c:forEach var="c" items="${list}">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select>
    <div>
        <button type="submit">Create</button>
    </div>
</form>
</body>
</html>
