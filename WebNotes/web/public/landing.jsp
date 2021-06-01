<%--
  Created by IntelliJ IDEA.
  User: Alessandra
  Date: 15/01/2020
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/includes/bootstrap.jsp"%>
    <title>WebNotes</title>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">WebNotes</h1>
        <p class="lead">CRUD based App by Alessandra</p>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/public/registration.jsp" role="button">SignUp</a>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/public/login.jsp" role="button">Login</a>
    </div>
</div>

<section id="services" class="container">
    <h2 class="display-4 text-center mt-5 mb-3">Functions</h2>

    <div class="row text-center">
        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <div class="card-body">
                    <h4 class="card-title">Add</h4>
                    <p class="card-text">Aggiungi, elimina e modifica una nota</p>
                </div>
                <div class="card-footer py-4">
                    <a href="${pageContext.request.contextPath}/public/registration.jsp" class="btn btn-secondary">Inizia Ora</a>
                </div>
            </div>
        </div>

        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <div class="card-body">
                    <h4 class="card-title">Note for every user</h4>
                    <p class="card-text">Ogni utente ha le proprie note</p>
                </div>
                <div class="card-footer py-4">
                    <a href="#" class="btn btn-secondary">Link vuoto</a>
                </div>
            </div>
        </div>

        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <div class="card-body">
                    <h4 class="card-title">E' figo</h4>
                    <p class="card-text">La mia app è figa perchè varia</p>
                </div>
                <div class="card-footer py-4">
                    <a href="#" class="btn btn-secondary">Inizia Ora</a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
