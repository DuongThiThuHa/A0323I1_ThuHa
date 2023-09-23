<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form method="post" action="/calculator-servlet">
    <div>
        <label>First Operand:</label>
        <input type="number" name="number1">
    </div>
    <div>
        <label>Operand:</label>
        <input type="number" name="number">
    </div>
    <div>
        <label>Second Operand:</label>
        <select name="number">
            <option value="+">Add</option>
            <option value="-">Sub</option>
            <option value="*">Mul</option>
            <option value="/">Div</option>
        </select>
    </div>
    <button>Calculator</button>
</form>
</body>
</html>
