<%--
  Created by IntelliJ IDEA.
  User: Alessandra
  Date: 16/01/2020
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/includes/bootstrap.jsp"%>
    <title>Login</title>
</head>
<body>
    <%@include file="/includes/navbar.jsp"%>
    <main class="container mt-4">
            <h2>Login</h2>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input name="user" type="text" class="form-control" id="username" aria-describedby="emailHelp" placeholder="Enter username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input name="pass" type="password" class="form-control" id="password" placeholder="Password" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

    </main>
</body>
</html>
