<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.10.2019
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="style/index.css" type="text/css"/>
</head>
<body>
<%@include file="menu.html"%>
<div class="form-style-10">
    <h1>Sign Up Now!<span>Sign up and use the demo site!</span></h1>
    <form action="/work_with_data" method="post">
        <div class="section"><span>1</span>First Name </div>
        <div class="inner-wrap">
            <label>Your Full Name <input type="text"  required pattern=^[A-Z]{1}[a-z]+$ placeholder="Only english letters" name="name" /></label>
        </div>

        <div class="section"><span>2</span>Email & Gender</div>
        <div class="inner-wrap">
            <label>Email Address <input type="email" name="email" required placeholder="XXX@XXX.XX" /></label>
            <label>Gender <select name="gender">
                <option>Male</option>
                <option>Female</option>
            </select> </label>
        </div>

        <div class="section"><span>3</span>Passwords</div>
        <div class="inner-wrap">
            <label>Password <input type="password" required name="password" /></label>
            <label>Confirm Password <input type="password"  required name="field6" /></label>
            <input type="hidden" name="flag" value="creat">
        </div>
        <div class="button-section">
            <input type="submit" name="Sign Up" />
            <span class="privacy-policy">
     <input required type="checkbox" name="field7">You agree to our Terms and Policy.
     </span>
        </div>
    </form>
</div>
</body>
</html>
