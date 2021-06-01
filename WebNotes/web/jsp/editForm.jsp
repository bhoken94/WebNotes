<%@ page import="com.alessandra.webnotes.model.Note" %>
<%--
  Created by IntelliJ IDEA.
  User: a_san
  Date: 04/01/2020
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/includes/bootstrap.jsp"%>
    <title>Edit Form</title>
</head>
<body>

<%@include file="/includes/navbar.jsp"%>

<main class="container mt-5">
    <%Note nota = (Note) request.getSession().getAttribute("notaById");%>
    <h1>Edit Nota id <%=nota.getId()%></h1>

    <%if(nota!=null) {%>

    <form action="${pageContext.request.contextPath}/update" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="titoloEdit" value="<%=nota.getTitolo()%>">
            <small id="emailHelp" class="form-text text-muted">Title of the note</small>
        </div>
        <div class="form-group">
            <label for="content">Content</label>
            <textarea class="form-control" id="content" rows="8" name="contenutoEdit"><%=nota.getContenuto()%></textarea>
            <input type="hidden" value="<%=nota.getId()%>" name="notaId">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="${pageContext.request.contextPath}/note" class="btn btn-secondary">Back</a>
        </div>
    </form>

    <%}else{%>
    <div class="container">
        <p>Id non trovato</p>
    </div>
    <%}%>

</main>
</body>
</html>
