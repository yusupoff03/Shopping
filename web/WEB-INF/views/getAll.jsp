<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.05.2023
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <style>
    h1{
      font-size: 30px;
      color: #fff;
      text-transform: uppercase;
      font-weight: 300;
      text-align: center;
      margin-bottom: 15px;
    }
    table{
      width:100%;
      table-layout: fixed;
    }
    .tbl-header{
      background-color: rgba(255,255,255,0.3);
    }
    .tbl-content{
      height:300px;
      overflow-x:auto;
      margin-top: 0px;
      border: 1px solid rgba(255,255,255,0.3);
    }
    th{
      padding: 20px 15px;
      text-align: left;
      font-weight: 500;
      font-size: 12px;
      color: #fff;
      text-transform: uppercase;
    }
    td{
      padding: 15px;
      text-align: left;
      vertical-align:middle;
      font-weight: 300;
      font-size: 12px;
      color: #fff;
      border-bottom: solid 1px rgba(255,255,255,0.1);
    }


    /* demo styles */

    @import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
    body{
      background: -webkit-linear-gradient(left, #25c481, #25b7c4);
      background: linear-gradient(to right, #25c481, #25b7c4);
      font-family: 'Roboto', sans-serif;
    }
    section{
      margin: 50px;
    }


    /* follow me template */
    .made-with-love {
      margin-top: 40px;
      padding: 10px;
      clear: left;
      text-align: center;
      font-size: 10px;
      font-family: arial;
      color: #fff;
    }
    .made-with-love i {
      font-style: normal;
      color: #F50057;
      font-size: 14px;
      position: relative;
      top: 2px;
    }
    .made-with-love a {
      color: #fff;
      text-decoration: none;
    }
    .made-with-love a:hover {
      text-decoration: underline;
    }


    /* for custom scrollbar for webkit browser*/

    ::-webkit-scrollbar {
      width: 6px;
    }
    ::-webkit-scrollbar-track {
      -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    }
    ::-webkit-scrollbar-thumb {
      -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    }</style>
</head>
<body>
<div class="container">
  <table class="table">
    <thead>
    <th>Type</th>
    <th>Manufacturer</th>
    <th>Model</th>
    <th>Balance</th>
    <th>Amount</th>
    <th>Created Date</th>
    </thead>
    <tbody>
    <jsp:useBean id="products" scope="request" type="java.util.List<org.example.model.product.Product>"/>
    <c:forEach items="${products}" var="product">
      <tr>
        <td>${product.type}</td>
        <td>${product.manufacturer}</td>
        <td>${product.model}</td>
        <td>${product.balance}</td>
        <td>${product.amount}</td>
        <td>${product.created_date}</td>
        <td>
          <form action="${pageContext.request.contextPath}/add-order/${userId}">
            <input name="productId" type="hidden" value="${product.id}">
            <button type="submit"><i class='bx bx-cart-add'></i></button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<a href="${pageContext.request.contextPath}/back/${userId}">Back</a>
</body>
</html>
