<%@ page import="com.bankroot.beans.ProductBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bankroot.beans.CategoryBean" %>
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
                                    <h5 class="title">Modifier une offre</h5>
                                </div>
                                <div class="card-body">
                                    <form action="updateProduct" method="post">
                                        <%
                                            String idProduct = (String) request.getAttribute("id");
                                            String label = (String) request.getAttribute("label");
                                            List<ProductBean> product = (List<ProductBean>) request.getAttribute("product");
                                            List<CategoryBean> categories = (List<CategoryBean>) request.getAttribute("categories");

                                        %>
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Titre offre</label>
                                                    <%
                                                        for(ProductBean productBean:product){


                                                    %>
                                                    <input type="text" class="form-control" value="<%=productBean.getName()%>" name="name">

                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Exclusif</label>
                                                    <%
                                                        if(productBean.getExclusive()){


                                                    %>
                                                    <input type="checkbox" name="test" checked>
                                                    <%
                                                        }else{
                                                            %>
                                                    <input type="checkbox" name="test">
                                                    <%

                                                        }
                                                    %>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Limité</label>
                                                    <%
                                                        if(productBean.getLimited()){


                                                    %>
                                                    <input type="checkbox" name="limited" checked>
                                                    <%
                                                    }else{
                                                    %>
                                                    <input type="checkbox" name="limited">
                                                    <%

                                                        }
                                                    %>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <select name="category_id">
                                                    <option value="<%= productBean.getCategory_id() %>"><%= ProductBean.getCategoryLabel(productBean.getCategory_id()) %></option>
                                                    <option>--------------</option>
                                                    <%
                                                        for(CategoryBean categoryBean:categories){
                                                            %>
                                                    <option value="<%= categoryBean.getId() %>"><%= categoryBean.getLabel() %></option>
                                                    <%
                                                        }
                                                    %>

                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4"></div>
                                            <div class="col-md-4">
                                                <div class="text-center form-group">
                                                    <input type="hidden" name="id" value="<%= idProduct %>">
                                                    <button type="submit" class="form-control botto-edit btn btn-primary">modifier</button>
                                                </div>
                                            </div>
                                            <div class="col-md-4"></div>
                                        </div>
                                        <%
                                            }
                                        %>
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

