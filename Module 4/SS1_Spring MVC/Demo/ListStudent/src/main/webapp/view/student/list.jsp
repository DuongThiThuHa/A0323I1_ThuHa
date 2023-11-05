<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 01/11/2023
  Time: 8:02 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<h1>List Student</h1>
<table>
  <thead>
  <tr>
    <td>ID</td>
    <td>Name</td>
    <td>Age</td>
    <td>Address</td>
  </tr>
  </thead>

  <tbody>
  <c:forEach items="${students}" var="student" varStatus="loop">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.age}</td>
      <td>${student.address}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
