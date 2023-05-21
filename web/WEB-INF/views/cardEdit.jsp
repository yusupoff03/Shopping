<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.05.2023
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/cards/edit/${userId}" method="post">
  <input name="number" type="text" placeholder="${card.number}" value="${card.number}"/>
  <input name="password" type="password" placeholder="${card.password}" value="${card.password}"/>
  <input list="types" name="type" placeholder="${card.cardType}" value="${card.cardType}"/>
  <datalist id="types">
    <option value="VISA"></option>
    <option value="HUMO"></option>
    <option value="UZ_CARD"></option>
    <option value="MASTER_CARD"></option>
  </datalist>
  <input name="balance" type="number" placeholder="${card.balance}" min="0" value="${card.balance}" />
  <input type="hidden" name="cardId" value="${card.id}">
  <button type="submit">Edit</button>
</form>
</body>
</html>
