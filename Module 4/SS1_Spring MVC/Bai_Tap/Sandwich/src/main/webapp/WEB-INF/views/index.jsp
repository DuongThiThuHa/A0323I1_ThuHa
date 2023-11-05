<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<form action = "/sandwich" method = "post">
    <h1>Sandwich</h1>
    <table>
        <tr>
            <th>Lettuce</th>
            <th><input type = "checkbox" name = "sandwich" value="lettuce"></th>
        </tr>
        <tr>
            <th>Tomato</th>
            <th><input type = "checkbox" name = "sandwich" value="tomato"></th>
        </tr>
        <tr>
            <th>Cheese</th>
            <th><input type = "checkbox" name = "sandwich" value="cheese"></th>
        </tr>
        <button>Click</button>
    </table>
</form>
<div>Your choice: ${res}</div>
</body>
</html>