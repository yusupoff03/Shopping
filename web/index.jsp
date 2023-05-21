<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.04.2023
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online shopping</title>
    <style>* {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Poppins, sans-serif;
    }

    body {
        background-color: #081b29;
        color: #ededed;
    }

    .header {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        padding: 20px 10%;
        background: yellowgreen;
        display: flex;
        justify-content: space-between;
        align-items: center;
        z-index: 100;
    }

    .logo {
        font-size: 25px;
        color: #ededed;
        text-decoration: none;
        font-weight: 600;
    }

    .navbar a {
        font-size: 18px;
        color: #ededed;
        text-decoration: none;
        font-weight: 500;
        margin-left: 35px;
        transition: .3s;
    }

    .navbar a:hover {
        color: #00abf0;
    }

    .home {
        height: 100vh;
        display: flex;
        align-items: center;
        padding: 0 10%;
    }

    .home-content {
        max-width: 600px;
        margin: 20px 0 40px;
        line-height: 1.2;
    }

    .home-content h1 {
        font-size: 56px;
        font-weight: 700;
    }

    .home-content .btn-box {
        display: flex;
        justify-content: space-between;
        width: 345px;
        height: 50px;
    }

    .btn-box a {
        position: relative;
        display: inline-flex;
        justify-content: center;
        align-items: center;
        width: 150px;
        height: 100%;
        background: #00abf0;
        border: 2px solid #00abf0;
        border-radius: 8px;
        font-size: 19px;
        color: #081b29;
        text-decoration: none;
        font-weight: 600;
        letter-spacing: 1px;
        z-index: 1;
        overflow: hidden;
        transition: .5s;
    }
    .btn-box a:hover{
        color: #00abf0;
    }
    .btn-box a:nth-child(2) {
        background: transparent;
        color: #00abf0;
    }
    .btn-box a:nth-child(2):hover{
        background: #00abf0;
        color: #081b29;
    }
    .btn-box a:nth-child(2)::before{
        background: #00abf0;
    }

    .btn-box a::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 0;
        height: 100%;
        background: #081b29;
        z-index: -1;
        transition: .5s;
    }
    .btn-box a:hover::before {
        width: 100%;
    }

    .home-sci{
        position: absolute;
        bottom: 40px;
        width: 170px;
        display: flex;
        justify-content: space-between;
    }
    .home-sci a{
        position: relative;
        display: inline-flex;
        justify-content: center;
        align-items: center;
        width: 40px;
        height: 40px;
        background: transparent;
        border: 2px solid #00abf0;
        border-radius: 50%;
        font-size: 20px;
        color: #00abf0;
        text-decoration: none;
        z-index: 1;
        overflow: hidden;
        transition: .5s;
    }
    .home-sci a:hover{
        color: #081b29;
    }
    .home-sci a::before{
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 0;
        height: 100%;
        background: #00abf0;
        z-index: -1;
    }
    .home-sci a:hover::before{
        width: 100%;
    }</style>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<header class="header">
    <a href="#" class="logo">Shop</a>
    <nav class="navbar">
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Services</a>
        <a href="#">Help?</a>
    </nav>
</header>
<section class="home">
    <div class="home-content">
        <h1> Online shop </h1>
        <p>Contrary to popular belief, Lorem Ipsum is not simply random text.
            It has roots in a piece of classical Latin literature from 45 BC,
            making it over 2000 years old. Richard McClintock,
            a Latin professor at Hampden-Sydney College in Virginia,
            looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage,
            and going through the cites of the word in classical literature,
            discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of
            "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC.
            This book is a treatise on the theory of ethics, very popular during the Renaissance.
            The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.

            The standard chunk of Lorem Ipsum used since the 1500s is reproduced below
            for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum"
            by Cicero are also reproduced in their exact original form, accompanied by English versions
            from the 1914 translation by H. Rackham.</p>

        <div class="btn-box">
            <a href="${pageContext.request.contextPath}/sign-up">Sign Up</a>
            <a href="${pageContext.request.contextPath}/sign-in">Sign In</a>
        </div>
    </div>
    <div class="home-sci">
        <a href="https://www.facebook.com/" target="_blank"><i class='bx bxl-facebook-circle'></i></a>
        <a href="https://instagram.com/yusupoff__03?igshid=ZDdkNTZiNTM=" target="_blank"><i class='bx bxl-instagram'></i></a>
        <a href="https://t.me/Yusupov0377" target="_blank"><i class='bx bxl-telegram' ></i></a>
    </div>
</section>
</body>
</html>
