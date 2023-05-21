<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.05.2023
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add to Order List</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add-order/${userId}"method="post">
  <input name="amount" type="number" min="1" max="${amount}" placeholder="Amount">
    <input name="productId" type="hidden" value="${productId}">
    <button type="submit">Add</button>
</form>
<a href="/back/${userId}"><button>Menu</button></a>
</body>
</html>
