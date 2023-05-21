<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.05.2023
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
    <style>
        html {
            font-family: 'Lora', sans-serif;
            width: 100%;
        }
     .button{
         text-align: center;
         color: #00abf0;
         background: #081b29;
     }
     .h4{
         color: #081b29;
     }

        body {
            margin: 5% auto 0 auto;
            width: 90%;
            max-width: 1125px;
        }

        h1 {
            font-size: 28px;
            margin-bottom: 2.5%;
        }

        input,
        span,
        label,
        textarea {
            font-family: 'Ubuntu', sans-serif;
            display: block;
            margin: 10px;
            padding: 5px;
            border: none;
            font-size: 22px;
        }

        textarea:focus,
        input:focus {
            outline: 0;
        }

        /* Question */

        input.question,
        textarea.question {
            font-size: 48px;
            font-weight: 300;
            border-radius: 2px;
            margin: 0;
            border: none;
            width: 80%;
            background: rgba(0, 0, 0, 0);
            transition: padding-top 0.2s ease, margin-top 0.2s ease;
            overflow-x: hidden; /* Hack to make "rows" attribute apply in Firefox. */
        }

        /* Underline and Placeholder */

        input.question + label,
        textarea.question + label {
            display: block;
            position: relative;
            white-space: nowrap;
            padding: 0;
            margin: 0;
            width: 10%;
            border-top: 1px solid red;
            -webkit-transition: width 0.4s ease;
            transition: width 0.4s ease;
            height: 0px;
        }

        input.question:focus + label,
        textarea.question:focus + label {
            width: 80%;
        }

        input.question:focus,
        input.question:valid {
            padding-top: 35px;
        }

        textarea.question:valid,
        textarea.question:focus {
            margin-top: 35px;
        }

        input.question:focus + label > span,
        input.question:valid + label > span {
            top: -100px;
            font-size: 22px;
            color: #333;
        }

        textarea.question:focus + label > span,
        textarea.question:valid + label > span {
            top: -150px;
            font-size: 22px;
            color: #333;
        }

        input.question:valid + label,
        textarea.question:valid + label {
            border-color: green;
        }

        input.question:invalid,
        textarea.question:invalid {
            box-shadow: none;
        }

        input.question + label > span,
        textarea.question + label > span {
            font-weight: 300;
            margin: 0;
            position: absolute;
            color: #8F8F8F;
            font-size: 48px;
            top: -66px;
            left: 0px;
            z-index: -1;
            -webkit-transition: top 0.2s ease, font-size 0.2s ease, color 0.2s ease;
            transition: top 0.2s ease, font-size 0.2s ease, color 0.2s ease;
        }

        input[type="submit"] {
            -webkit-transition: opacity 0.2s ease, background 0.2s ease;
            transition: opacity 0.2s ease, background 0.2s ease;
            display: block;
            opacity: 0;
            margin: 10px 0 0 0;
            padding: 10px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #EEE;
        }

        input[type="submit"]:active {
            background: #999;
        }

        input.question:valid ~ input[type="submit"], textarea.question:valid ~ input[type="submit"] {
            -webkit-animation: appear 1s forwards;
            animation: appear 1s forwards;
        }

        input.question:invalid ~ input[type="submit"], textarea.question:invalid ~ input[type="submit"] {
            display: none;
        }

        @-webkit-keyframes appear {
            100% {
                opacity: 1;
            }
        }

        @keyframes appear {
            100% {
                opacity: 1;
            }
        }

    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/add-product/${userId}" method="post">
    <input list="types" name="type" class="question" id="type" required autocomplete="off"/>
    <label for="type"><span>Product type</span></label>
    <datalist id="types">
        <option value="TV"></option>
        <option value="LAPTOP"></option>
        <option value="PHONE"></option>
    </datalist>
    <input name="manufacturer" type="text" class="question" id="manufacturer" required autocomplete="off"/>
    <label for="manufacturer"><span>Product manufacturer</span></label>
    <input name="model" type="text" class="question" id="model" required autocomplete="off"/>
    <label for="model"><span>Product model</span></label>
    <input name="balance" type="number" class="question" id="balance" required autocomplete="off" min="0"/>
    <label for="balance"><span>Product cost</span></label>
    <input name="amount" type="number" class="question" id="amount" required autocomplete="off" min="1"/>
    <label for="amount"><span>Product amount</span></label>
    <button type="submit" class="button">Add Product</button>
</form>
<h4 class="h4"><c:if test="${message!=null}">${message}</c:if></h4>
</body>
</html>
