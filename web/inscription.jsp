<%--
  Created by IntelliJ IDEA.
  User: joffrey
  Date: 2018-12-03
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp"%>

<form method="post" action="Register">
    <div class="form-group">
        <label for="name">Nom :</label><input type="text" name="name" id="name" class="form-control">
    </div>
    <div class="form-group">
        <label for="email">Email :</label><input type="email" name="email" id="email" class="form-control">
    </div>
    <div class="form-group">
        <label for="password">Mot de passe :</label><input type="password" name="password" id="password" class="form-control">
    </div>
    <input type="submit" class="btn btn-success">
</form>
<a href="index.jsp">Accueil</a>

<%@include file="./layout/Footer.jsp"%>
