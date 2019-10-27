<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.10.2019
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
    <link rel="stylesheet" href="style/index.css" type="text/css"/>
</head>
<body>
<%@include file="menu.html" %>
<div class="form-style-10">
    <h1>Read!<span>find up info about users!</span></h1>
    <form action="/information" method="post">
        <div class="section"><span>1</span>User's Id</div>
        <div class="inner-wrap">
            <label>Enter user's id <input type="number" name="id"/></label>
        </div>
        <div class="button-section">
            <input type="submit" name="Sign Up"/>
        </div>
    </form>
    <div class="section"><span>2</span>Information</div>
    <div class="inner-wrap">
        <label>Name: <output>${user.name}</output></label>
        <label>Email: <output>${user.email}</output></label>
        <label>Password: <output>${user.password}</output></label>
        <label>Gender: <output>${user.gender}</output></label>
    </div>
</div>
</body>
</html>
