<%@ page import="java.util.List" %>
<%@ page import="com.bankroot.beans.ProductBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>
<%
    HttpSession session1 = request.getSession();
    String id = (String) session1.getAttribute("idUser");

    if(id==null){
        response.sendRedirect("login.jsp");
    }else{


%>
<body class="">
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
                                    <div class="dropdown pull-right">
                                        <button type="button" class="btn btn-round btn-default dropdown-toggle btn-simple btn-icon no-caret" data-toggle="dropdown">
                                            <i class="now-ui-icons ui-1_simple-add"></i>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="addProduct">Créer une offre</a>
                                            <a class="dropdown-item" href="Choix.jsp">Administrer les offres</a>
                                        </div>
                                    </div>

                                    <h5 class="title">Nos Offres</h5>
                                </div>
                                <div class="card-body">


                                    <div class="container">
                                        <div class="row">
                                            <%
                                                List<ProductBean> productBeans = (List) request.getAttribute("products");

                                                for(ProductBean productBean:productBeans){


                                            %>
                                            <div class="col-sm-3">
                                                <div class="flip">
                                                    <div class="card">
                                                        <div class="face front">
                                                            <div class="inner">
                                                                <img src="./assets/img/offres.jpg">
                                                                <figcaption><%=productBean.getName()%></figcaption>


                                                            </div>
                                                        </div>
                                                        <div class="face back">
                                                            <span class="text-left">Offre : <%=productBean.getName()%></span>
                                                            <div class="table-full-width table-responsive">
                                                                <table class="table">
                                                                    <tr>
                                                                        <td class="text-left"><p><a href="CustomersProduct?idProduct=<%=productBean.getId()%>">Clients éligibles</a></p> </td>
                                                                        <td class="text-left"><p><a href="Offer?id=<%=productBean.getId()%>">Vérifier clients</a></p> </td>
                                                                        <td class="td-actions text-right">
                                                                            <a href="updateProduct?id=<%=productBean.getId()%>"><button type="button" rel="tooltip" title="modifier" class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Edit Task">
                                                                                <i class="now-ui-icons ui-2_settings-90"></i>
                                                                            </button></a>
                                                                            <a href="delete?id=<%=productBean.getId()%>"><button type="button" rel="tooltip" title="supprimer" class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Remove">
                                                                                <i class="now-ui-icons ui-1_simple-remove"></i>
                                                                            </button></a>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-1"></div>
                                            <%
                                                }
                                            %>

                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="./layout/Footer.jsp" %>

                <%
                    }
                %>
