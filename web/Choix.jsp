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
                                    <h5 class="title">Modifier l'offre</h5>
                                </div>
                                <div class="card-body">

                                    <div class="container-response">
                                        <div class="choice-container text-center">


                                            <div id="choice22" class="choix choice2 two">
                                                <div class="round">
                                                    <i class="fa fa-check two" aria-hidden="true"></i>
                                                </div>
                                                <p>Modifier <br />Condition</p>
                                            </div>

                                            <div id="choice33" class="choix choice3 three">
                                                <div class="round">
                                                    <i class="fa fa-check three" aria-hidden="true"></i>
                                                </div>
                                                <p>Ajouter <br />Condition</p>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="./layout/Footer.jsp" %>

