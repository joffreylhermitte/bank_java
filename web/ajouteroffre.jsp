<%@ page import="com.bankroot.beans.CategoryBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>
<%
    HttpSession session1 = request.getSession();
    String id = (String) session1.getAttribute("idUser");

    if(id==null){
        response.sendRedirect("login.jsp");
    }else{


%>
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
                                    <h5 class="title">Créer une offre</h5>
                                </div>
                                <div class="card-body">
                                    <form action="addProduct" method="post">
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Titre offre</label>
                                                    <input type="text" class="form-control" placeholder="titre de l'offre" name="name">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Exclusif</label>
                                                    <input type="checkbox" class="form-control" placeholder="titre de l'offre" name="exclusive">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Limité</label>
                                                    <input type="checkbox" class="form-control" placeholder="titre de l'offre" name="limited">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Catégorie</label>
                                                    <select class="form-control" name="category_id">
                                                        <option>Catégorie</option>
                                                        <%
                                                            @SuppressWarnings("unchecked")
                                                            List<CategoryBean> categories = (List<CategoryBean>) request.getAttribute("categories");

                                                            if(categories != null) {
                                                                for (CategoryBean categorie : categories) {
                                                        %><option value="<%= categorie.getId() %>"><%= categorie.getLabel() %></option><%
                                                            }
                                                        }
                                                    %>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4"></div>
                                            <div class="col-md-4">
                                                <div class="text-center form-group">
                                                    <button type="submit" class="form-control botto-edit btn btn-primary">créer</button>
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
                <%
                    }
                %>
