<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<form action="/student?action=create">Add Student</form>
<table border="-1">
    <thead>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Date Of Birth</td>
        <td>Address</td>
        <td>Email</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="student" var="student" varStatus="loop">
        <tr>
            <td>
                <a href="/student?action=update&id=${requestScope[student.id]}">Update</a>
            </td>
            <td>
                <a href="/student?action=delete&id=${requestScope[student.id]}">Delete</a>
            </td>
            <td>
                <a href="/student?action=view&id=${requestScope[student.id]}">View</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
