<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach</title>
</head>
<body>

</body>
</html>
<html>
<head>
    <title>Tro</title>
    <style>
        table {
            margin: 20px 0;
            border-collapse: collapse;
            width: 100%;
        }

        th {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            background-color: #007bff;
            color: #fff;
        }

        td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            background-color: #f5f5f5;
        }

        tr:nth-child(even) td {
            background-color: #ddd;
        }

        tr:hover {
            background-color: #f0f0f0;
        }

        h1 {
            color: #333;
        }

        a {
            font-size: 16px;
            text-decoration: none;
            color: black;
        }

        a:hover {
            color: blue;
        }

        .page {
            color: #007bff;
            padding: 10px 20px;
            background-color: #ddd;
        }

        .page:hover {
            color: #ddd;
            background-color: darkgreen;
        }

        td a:hover {
            text-decoration: underline;
        }

        .error {
            color: red;
            font-size: 17px;
        }
    </style>
</head>
<body>
<h1 align="center">Danh sach</h1>
<table>
    <tr>
        <th>Ma Phong Tro</th>
        <th>Ten Tro</th>
    </tr>
    <c:forEach var="p" items="${phongtroList}">
        <tr>
            <td>${p.code}</td>
            <td>${p.name}</td>
            <td>
                <button><a href="/book?action=rent&id=${c.code}">Thue</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
