<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Gender</th>
            <th scope="col">CardID</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Customer Type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customer}" var="customer" varStatus="loop">
            <tr>
                <th scope="row">${customer.id}</th>
                <td>${customer.name}</td>
                <td>${customer.birthday}</td>
                <td>${customer.gender}</td>
                <td>${customer.cardID}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>${customer.CustomerType}</td>

                <td>${customer.email}</td>
                <td><a href="/customer?action=delete?id=${customer.id}">Delete</a></td>
                <td><a href="/customer?action=update?id=${customer.id}">Update</a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tr>

            <th colspan="9">
                <button><a href="/customer?action=create">Create</a></button>
            </th>
        </tr>
    </table>
</body>
</html>
