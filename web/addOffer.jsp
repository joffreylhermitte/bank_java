
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>

<body>
    <%
    String product = (String) request.getAttribute("products");
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>
<body class="user-profile">
<div class="wrapper ">
    <%@include file="./layout/Sidebar.jsp" %>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg fixed-top navbar-transparent  bg-primary  navbar-absolute">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <div class="navbar-toggle">
                        <button type="button" class="navbar-toggler">
                            <span class="navbar-toggler-bar bar1"></span>
                            <span class="navbar-toggler-bar bar2"></span>
                            <span class="navbar-toggler-bar bar3"></span>
                        </button>
                    </div>
                    <a class="navbar-brand" href="#">Nos Offres</a>
                </div>
                <%@include file="./layout/Navbar.jsp" %>
                <!-- End Navbar -->
                <div class="panel-header panel-header-sm">
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="title">Ajoutez la condition</h5>
                                </div>
                                <div class="card-body">
                                    <form action="AddOffer" method="post">
                                        <div class="row">
                                            <div class="col-md-4 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Nom de la condition</label>
                                                    <input type="text" class="form-control" placeholder="nom condition" name="name">
                                                </div>
                                            </div>


                                            <div class="col-md-4 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Valeur</label>
                                                    <input type="text" class="form-control" placeholder="valeur" name="value">
                                                </div>
                                            </div>

                                            <div class="col-md-4 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Op??rateur</label>
                                                    <select class="form-control" id="exampleFormControlSelect1" name="operator">
                                                        <option><</option>
                                                        <option>></option>
                                                        <option>=</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">

                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4"></div>
                                            <div class="col-md-4">
                                                <div class="text-center form-group">
                                                    <input type="text"  name="productID" value="<% out.print(product); %>" hidden>

                                                    <button type="submit" class="form-control botto-edit btn btn-primary">Ajouter</button>
                                                </div>
                                            </div>
                                            <div class="col-md-4"></div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="./layout/Footer.jsp" %>


                <%@include file="./layout/Footer.jsp" %>

