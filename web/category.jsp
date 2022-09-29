<%@ page import="com.bankroot.beans.CategoryBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>
<body class="user-profile">
<%
    String id = request.getParameter("id");
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
                    <a class="navbar-brand" href="#">Catégories</a>
                </div>
                <%@include file="./layout/Navbar.jsp" %>
                <!-- End Navbar -->
                <div class="panel-header panel-header-sm">
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="title">Sous-catégorie</h5>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <form action="subCategory" method="get">
                                            <div class="row">
                                                <div class="col-md-2"></div>
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <select class="form-control" name="id">
                                                            <%     @SuppressWarnings("unchecked")

                                                            List<CategoryBean> mainCategory = (List<CategoryBean>) request.getAttribute("mainCategory");
                                                                if(mainCategory != null) {
                                                                    for (CategoryBean mainCategories : mainCategory) {
                                                                        out.println("<option value=\"" +mainCategories.getId()+ "\">"+mainCategories.getLabel()+"</option>");

                                                                    }
                                                                } else {
                                                                    out.println("<option>Aucune categories</option>");
                                                                }
                                                            %>

                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="col-md-5">
                                                    <div class="text-center form-group">
                                                        <button type="submit" class="form-control botto-edit btn btn-primary">Chercher</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>

                                    <%
                                        if(id!=null){


                                    %>

                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead class=" text-primary">
                                            <th>
                                                nom
                                            </th>

                                            </thead>
                                            <tbody>
                                            <%
                                                List<CategoryBean> category = (List<CategoryBean>) request.getAttribute("subCategory");
                                                for(CategoryBean categoryBean:category){


                                            %>
                                            <tr>
                                                <td>
                                                    <%=categoryBean.getLabel()%>
                                                </td>

                                            </tr>
                                            <%
                                                }
                                            %>
                                            </tbody>
                                        </table>
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="title">Ajout sous-catégorie</h5>
                                </div>
                                <div class="card-body">
                                    <form action="addCategory" method="post">
                                        <div class="row">
                                            <div class="col-md-5 pr-1">
                                                <div class="form-group">
                                                    <label>Catégorie</label>
                                                    <select class="form-control" id="exampleFormControlSelect1" name="category">
                                                        <%
                                                            //List<CategoryBean> mainCategory = (List<CategoryBean>) request.getAttribute("mainCategory");

                                                            for(CategoryBean mainCategories: mainCategory){
                                                                %>
                                                        <option value="<%=mainCategories.getId()%>"><%=mainCategories.getLabel()%></option>
                                                        <%
                                                            }
                                                        %>

                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-2"></div>
                                            <div class="col-md-5 pl-1">
                                                <div class="form-group">
                                                    <label>Nom de la sous-catégorie</label>
                                                    <input type="text" class="form-control" placeholder="nom de sous catégorie" name="label">
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

