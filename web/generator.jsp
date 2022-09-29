
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
                    <a class="navbar-brand" href="#">Générer des clients</a>
                </div>
                <%@include file="./layout/Navbar.jsp" %>
                <!-- End Navbar -->
                <div class="panel-header panel-header-sm">
                </div>
                <div class="content mt-5">
                    <div class="row">
                        <div class="col-md-12">
                           <form method="post" action="GenerateCustomer">
                               <div class="row">
                                   <div class="col-md-12 pr-1pl-1">
                                       <div class="form-group">
                                           <label>Nombre de client à générer</label>
                                           <input type="text" class="form-control" name="nombre">
                                       </div>
                                   </div>
                               </div>
                               <div class="text-center form-group">
                                   <button type="submit" class="form-control botto-edit btn btn-primary">générer</button>
                               </div>
                           </form>
                        </div>
                    </div>
                </div>
                <%@include file="./layout/Footer.jsp" %>


