<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/create"
           method="post" modelAttribute="music">
    Tên<form:input path="name"></form:input>
    Nghệ sĩ : <form:input path="artist"></form:input>
    Thể loại :<form:input path="type"></form:input>
    Đường dẫn: <form:input path="link"></form:input>
    <input type="submit" value="change">
</form:form>
<p>${message}</p>
</body>
</html>
