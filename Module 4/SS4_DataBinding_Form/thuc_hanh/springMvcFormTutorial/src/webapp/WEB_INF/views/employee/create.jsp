<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create a new employee</title>
</head>

<body>
<h3>Create Employee</h3>
<%--@elvariable id="employee" type=""--%>
<form:form method="post" action="addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    ID:
                </form:label>
            </td>
            <td><form:input path="id"></form:input></td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    Name:
                </form:label>
            </td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td>
                <form:label path="numberPhone">
                    Number Phone:
                </form:label>
            </td>
            <td><form:input path="numberPhone"></form:input></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>