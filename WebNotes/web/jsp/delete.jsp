<%--
  Created by IntelliJ IDEA.
  User: a_san
  Date: 05/01/2020
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/includes/bootstrap.jsp"%>
    <title>Delete Note</title>
</head>
<body>

<%@include file="/includes/navbar.jsp"%>

<main class="container mt-5">

    <h1>Delete</h1>
    <h3>Select id</h3>
    <form action="${pageContext.request.contextPath}/delete" method="post">
        <div class="form-group">
            <label for="id">ID</label>
            <input id="id" type="number" name="noteId" class="form-control">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" value="submit">
            <a href="${pageContext.request.contextPath}/note" class="btn btn-secondary">Back</a>
        </div>
    </form>

</main>
</body>
</html>
