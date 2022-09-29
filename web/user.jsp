<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>
<%
    HttpSession session1 = request.getSession();
    String id = (String)session1.getAttribute("idUser");

    if(id==null){
        response.sendRedirect("login.jsp");
    }else {


%>
<body class="user-profile">
<%
    String name = (String)request.getAttribute("name");
    String firstname = (String)request.getAttribute("firstname");
    String email = (String)request.getAttribute("email");
%>
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
                    <a class="navbar-brand" href="#">Votre Profil</a>
                </div>
                <%@include file="./layout/Navbar.jsp" %>
                <!-- End Navbar -->
                <div class="panel-header panel-header-sm">
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="title">Informations</h5>
                                </div>
                                <div class="card-body">
                                    <form action="#" method="post">
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1" >Adresse Email</label>
                                                    <input type="email" class="form-control" placeholder="Email" id="exampleInputEmail1" value="<%=email%>" readonly>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 pr-1">
                                                <div class="form-group">
                                                    <label>Nom</label>
                                                    <input type="text" class="form-control" placeholder="Votre Nom" value="<%=name%>" readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-1">
                                                <div class="form-group">
                                                    <label>Prénom</label>
                                                    <input type="text" class="form-control" placeholder="Votre Prénom" value="<%=firstname%>" readonly>
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
                                                <!--<div class="text-center form-group">
                                                    <button type="submit" class="form-control botto-edit btn btn-primary">éditer</button>
                                                </div>-->
                                            </div>
                                            <div class="col-md-4"></div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card card-user">
                                <div class="image">
                                    <img src="./assets/img/bgUser.jpg" alt="...">
                                </div>
                                <div class="card-body">
                                    <div class="author">
                                        <a href="#">
                                            <img class="avatar border-gray" src="./assets/img/default-avatar.png" alt="...">
                                            <h5 class="title"><%=name+" "%><%=firstname%></h5>
                                        </a>
                                    </div>
                                    <p class="description text-center">
                                        "...................
                                        <br> .........................
                                        <br> .........................
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="./layout/Footer.jsp" %>

<%
    }
%>