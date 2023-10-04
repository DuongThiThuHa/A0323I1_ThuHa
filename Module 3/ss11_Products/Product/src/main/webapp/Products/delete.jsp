<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Delete Product</H1>
</p>
<p>
  <a href="/products?action=list">Back to list</a>
</p>
<form method="post" action="/products">


  <table border="1">
    <tr>
      <td>Name:</td>
      <td><input type="text" name="name" id="name" value="${product.productName}"></td>
    </tr>
    <tr>
      <td>Price:</td>
      <td><input type="text" name="price" id="email" value="${product.price}"></td>
    </tr>
    <tr>
      <td>Description:</td>
      <td>
        <input type="text" name="desc" id="desc" value="${product.description}"></td>

    </tr>

    <tr style="collapse: 2">
      <td><input type="submit" value="Update customer"></td>
    </tr>
  </table>
  <input type="hidden" name="action" value="delete">
  <input type="hidden" name="id" value="${product.id}">
</form>
</body>
</html>
