<%--
  Created by IntelliJ IDEA.
  User: Alessandra
  Date: 12/01/2020
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/includes/bootstrap.jsp"%>
    <title>Register</title>
</head>
<body>
<%@ include file="/includes/navbar.jsp"%>
<main class="container mt-4">
    <h1>Sign Up</h1>
    <form action="${pageContext.request.contextPath}/newUser" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input name="username" type="text" class="form-control" id="username" aria-describedby="emailHelp" placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input name="password" type="password" class="form-control" id="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</main>
</body>
</html>
