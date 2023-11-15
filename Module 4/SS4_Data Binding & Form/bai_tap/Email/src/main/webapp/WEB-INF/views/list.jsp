<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 13/11/2023
  Time: 5:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Mail</h1>
<table border = 1>
    <tr>
        <th>ID</th>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th></th>
    </tr>
    <c:forEach items="${email}" var="m">
        <tr>
            <td>${m.mailID}</td>
            <td>${m.language}</td>
            <td>${m.pageSize}</td>
            <td>
                <c:if test="${m.haveSpamsFilter == true}">Yes</c:if>
                <c:if test="${m.haveSpamsFilter == false}">No</c:if>
            </td>
            <td>${m.signature}</td>
            <td><button><a href="/email/edit?id=${email.emailId}">Update</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
