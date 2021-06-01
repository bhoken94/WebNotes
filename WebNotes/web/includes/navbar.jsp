<%@ page import="com.alessandra.webnotes.model.Utente" %><%--
  Created by IntelliJ IDEA.
  User: Alessandra
  Date: 12/01/2020
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/note">WebNotes</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/note">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <%if(request.getSession().getAttribute("userLogged")!=null){%>
                    <%Utente userLogged = (Utente) request.getSession().getAttribute("userLogged");%>
                    <a class="nav-link" >Welcome back, <%=userLogged.getUsername()%></a>
            </li>
            <li class="nav-item">
                <a class="btn btn-light" href="${pageContext.request.contextPath}/logout">Logout</a>
            </li>
            <li class="nav-item">
                <%}else{%>
                    <a class="nav-link" href="${pageContext.request.contextPath}/public/login.jsp">Login</a>
            </li>
            <li class="nav-item">
                <a class="btn btn-light" href="${pageContext.request.contextPath}/public/registration.jsp">SignUp</a>
            </li>
            <%}%>
        </ul>

    </div>
</nav>