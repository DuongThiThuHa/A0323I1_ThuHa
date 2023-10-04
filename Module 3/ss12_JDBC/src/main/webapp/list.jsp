<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>User Managerment</h2>
<h3>
    <a href="/users?action=create">Add new user</a>
</h3>
<table border="-1">
    <h2>List of users</h2>
    <thead>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Country</td>
        <td>Actions</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${listUser}" var="user">
        <tr>
            <td>
                <c:out value="${user.id}"/>
            </td>
            <td>
                <c:out value="${user.name}"/>
            </td>
            <td>
                <c:out value="${user.email}"/>
            </td>
            <td>
                <c:out value="${user.country}"/>
            </td>

            <td>
                <a href="/users?action=edit&id=${user.id}">Edit</a>
                <a href="/users?action=delete&id=${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
