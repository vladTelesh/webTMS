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
    <title>Update</title>
    <link rel="stylesheet" href="style/index.css" type="text/css"/>
</head>
<body>
<%@include file="menu.html" %>
<div class="form-style-10">
    <h1>Update!<span>Update user from system!</span></h1>
    <form action="/manipulation-data" method="post">
        <div class="section"><span>1</span>User's Id</div>
        <div class="inner-wrap">
            <label>Enter user's id <input type="number" name="id"/></label>
            <input type="hidden" name="flag" value="update">
        </div>
        <div class="button-section">
            <input type="submit" name="Sign Up"/>
        </div>
    </form>
</div>
</body>
</html>
