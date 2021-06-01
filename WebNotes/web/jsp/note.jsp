<%@ page import="com.alessandra.webnotes.model.Note" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: a_san
  Date: 02/01/2020
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/includes/bootstrap.jsp"%>
    <title>WebNotes</title>
</head>
<body>
<%@ include file="/includes/navbar.jsp"%>

<main>
<div class="jumbotron container mt-3">
    <h1 class="display-4">WebNotes</h1>
    <p class="lead">CRUD based App by Alessandra</p>
    <hr class="my-4">
    <p>Add,edit and remove a Note</p>
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/jsp/new.jsp" role="button">Add note</a>
</div>
<section class="container">
    <div class="row">

    <%List<Note> listaNote = (ArrayList<Note>) request.getSession().getAttribute("notes");%>

    <%if(listaNote!=null && listaNote.size()>0) {%>
    <%for (Note nota:listaNote) {%>
            <div class="card col-md-4 mr-3 mb-3">
                <h5 class="card-header">Nota ID <%=nota.getId()%></h5>
                <div class="card-body">
                    <h5 class="card-title"><%=nota.getTitolo()%></h5>
                    <p class="card-text"><%=nota.getContenuto()%></p>
                    <div class="btn-group">
                        <form action="${pageContext.request.contextPath}/edit" method="post">
                            <input type="hidden" value="<%=nota.getId()%>" name="notaIdEdit">
                            <button class="btn btn-warning mr-3" style="color: white">Edit</button>
                        </form>
                        <form action="${pageContext.request.contextPath}/delete" method="post">
                            <input type="hidden" value="<%=nota.getId()%>" name="notaIdDelete">
                            <button class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </div>
        </div>
    <%}%>
    <%}else {%>
        <h1>Nessuna nota inserita.</h1>
        <%}%>
    </div>

</section>
</main>
</body>
</html>
