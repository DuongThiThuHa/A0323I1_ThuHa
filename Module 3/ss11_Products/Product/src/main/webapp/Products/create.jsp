<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new product</h1>
</p>
<p>
    <a href="/products?action=list">Back to list</a>
</p>
<form method="post" action="/products">
    <table>
        <tr>
            <td><lable> Product Name</lable></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><lable> Price</lable></td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td><lable> Description </lable></td>
            <td><input type="text" name="desc"></td>
        </tr>

        <tr style="collapse: 2">
            <input type="submit" value="ADD">
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>

</body>
</html>
