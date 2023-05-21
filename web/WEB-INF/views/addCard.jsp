<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.05.2023
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Card</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add-card/${userId}" method="post">
  <input name="number" type="text" placeholder="Card Number">
  <input name="password" type="password" placeholder="Password">
  <input list="types" name="type" placeholder="Type">
  <datalist id="types">
    <option value="VISA"></option>
    <option value="HUMO"></option>
    <option value="UZ_CARD"></option>
    <option value="MASTER_CARD"></option>
  </datalist>
  <input name="balance" type="number" placeholder="Balance">
  <button type="submit">Add</button>
</form>
<a href="${pageContext.request.contextPath}/back/${userId}">
  <button>Back</button>
</a>
</body>
</html>
