<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.05.2023
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy Menu</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/order-buy/${userId}" method="post">
    <input name="amount" type="number" min="1" max="${order.amount}">
    <input name="number" type="text" placeholder="Your card Number">
    <input name="password" type="text" placeholder="Your card Password">
    <input name="orderId" type="hidden" value="${order.id}">
    <input name="productId" type="hidden" value="${productId}">
    <input name="receiver_number" type="text" placeholder="Seller Card Number">
    <button type="submit">Buy</button>
</form>
<c:if test="${message!=null}">${message}</c:if>
</body>
</html>
