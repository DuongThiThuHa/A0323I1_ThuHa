<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thue phong</title>
    <style>
        /* styles.css */
        h1 {
            color: #333;
        }

        table {
            margin-top: 20px;
        }

        table td {
            padding: 5px;
        }

        input[type="text"], select {
            width: 200px;
            padding: 5px;
        }

        input[type="submit"], button {
            margin-top: 10px;
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover, button:hover {
            background-color: #0056b3;
        }

        input[type="hidden"] {
            display: none;
        }

        a {
            text-decoration: none;
        }

        .error {
            color: red;
            padding: 0;
        }
    </style>
</head>
<body>
<h1 align="center">Thue phong</h1>
<form action="/tro" method="post">
    <table>
        <tr>
            <td>Ma phong</td>
            <td><input type="text" name="id" value="${phongTro.id}"/></td>
        </tr>

        <tr>
            <td>Ten nguoi thue</td>
            <td>
                <select name="maNguoiThue">
                    <c:forEach var="p" items="${nguoiThueList}">
                        <option value="${p.id}">${p.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Ngay thue</td>
            <td><input type="date" disabled value="<fmt:formatDate value='${Date}' pattern='yyyy-MM-dd'/>"
                       id="birthday"
                       name="rent_date"/></td>
        </tr>

    </table>
    <input type="submit" value="Muon phong">
    <button><a onclick="confirmBack()">huy</a></button>
    <input type="hidden" name="action" value="rent">
</form>
</body>
<script>
    function confirmBack() {
        if (confirm("ban co muon quay lai ?")) {
            window.location.href = "/tro";
        }
    }
</script>
</html>

