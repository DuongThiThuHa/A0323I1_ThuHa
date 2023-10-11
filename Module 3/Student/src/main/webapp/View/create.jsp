<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Student</title>
</head>
<body>
<form action="/student?action=create" method="post">
    <table border="-1">
        <tr>
            <td>ID:</td>
            <td>
                <input type="number" name="id" id="id">
            </td>
            <td>
                Name:
            </td>
            <td>
                <input type="text" name="name" id="name">
            </td>
            <td>
                Date of birth :
            </td>
            <td>
                <input type="text" name="dateOfBirth" id="dateOfBirth">
            </td>
            <td>
                Address:
            </td>
            <td>
                <input type="text" name="address" id="address">
            </td>
            <td>
                Email:
            </td>
            <td>
                <input type="text" name="email" id="email">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
