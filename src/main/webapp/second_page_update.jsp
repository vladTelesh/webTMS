<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.10.2019
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) session.getAttribute("user");%>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="style/index.css" type="text/css"/>
</head>
<body>
<%@include file="menu.html"%>
<div class="form-style-10">
    <h1>Update!<span>Update user from system!</span></h1>
    <form action="/work_with_data" method="post">
        <div class="section"><span>1</span>First Name </div>
        <div class="inner-wrap">
            <label>Your Full Name <input type="text" name="name" required pattern=^[A-Z]{1}[a-z]+$ value="<%=user.getName()%>" /></label>
        </div>

        <div class="section"><span>2</span>Email & Gender</div>
        <div class="inner-wrap">
            <label>Email Address <input type="email" name="email" required value="<%=user.getEmail()%>" /></label>
            <label>Gender <select name="gender" value="<%=user.getGender()%>">
                <option>Male</option>
                <option>Female</option>
            </select> </label>
        </div>

        <div class="section"><span>3</span>Passwords</div>
        <div class="inner-wrap">
            <label>Password <input type="password" name="password" required value="<%=user.getPassword()%>" /></label>
            <label>Confirm Password <input type="password" required name="field6" /></label>
            <input type="hidden" name="flag" value="update">
        </div>
        <div class="button-section">
            <input type="submit" name="Sign Up" />
        </div>
    </form>
</div>
</body>
</html>
