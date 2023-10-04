<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sach khach hang</title>
</head>
<body>
<h1>Khach hang</h1>
<p>
    <a href="/customer-servlet?action=create">Them moi khach hang</a>
</p>

<table border="-1">
    <thead>
    <tr>
        <td>STT</td>
        <td>Ten</td>
        <td>Email</td>
        <td>Dia chi</td>
        <td>Chinh sua</td>
        <td>Xoa</td>
    </tr>
    </thead>

    <tbody>
        <c:forEach items='${customer}' var="customer" varStatus="loop">
            <tr>
                <td>
                    <a href="/customer-servlet?action=view&id=${customer.code}">${customer.name}
                    </a>
                </td>

                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
                    <a href="/customer-servlet?action=edit&id=${customer.id}">Chinh sua</a>
                </td>
                <td>
                    <a href="/customer-servlet?action=delete&id=${customer.id}">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
