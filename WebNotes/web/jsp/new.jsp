<%--
  Created by IntelliJ IDEA.
  User: a_san
  Date: 05/01/2020
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/includes/bootstrap.jsp"%>
    <title>New Note</title>
</head>
<body>

<%@include file="/includes/navbar.jsp"%>

<main class="container mt-5">
    <h1>Add new Note</h1>

    <form action="${pageContext.request.contextPath}/new" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="newTitle">
            <small id="emailHelp" class="form-text text-muted">Title of the note</small>
        </div>
        <div class="form-group">
            <label for="content">Content</label>
            <textarea class="form-control" id="content" rows="8" name="newContenuto"></textarea>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="${pageContext.request.contextPath}/note" class="btn btn-secondary">Back</a>
        </div>
    </form>

</main>
</body>
</html>
