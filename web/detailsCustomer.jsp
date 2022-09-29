<%@ page import="java.util.List" %>
<%@ page import="com.bankroot.beans.CustomerBean" %>
<%@ page import="com.bankroot.beans.AccountBean" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.bankroot.beans.CustomerHasProductBean" %>
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
                    <a class="navbar-brand" href="#">Details</a>
                </div>
                <%@include file="./layout/Navbar.jsp" %>
                <!-- End Navbar -->
                <div class="panel-header panel-header-sm">
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="card card-user">
                                <div class="image">

                                </div>
                                <div class="card-body">
                                    <div class="author">
                                        <%
                                            List<CustomerBean> customerBeans = (List<CustomerBean>)request.getAttribute("result");

                                            for (CustomerBean customerBean:customerBeans){
                                                %>
                                        <a href="#">
                                            <h5 class="title"><%=customerBean.getName()+" "+customerBean.getFirstname()%></h5>
                                        </a>


                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-1pl-1">
                                            <div class="form-group text-center">
                                                <p><strong>Numéro de téléphone: </strong><%=customerBean.getPhone()%></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6 pr-1pl-1">
                                            <div class="form-group text-center">
                                                <p><strong>Email: </strong><%=customerBean.getEmail()%></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-1pl-1">
                                            <div class="form-group text-center">
                                                <p><strong>Age: </strong><%=Math.round(customerBean.getAge())+" "%>ans</p>
                                            </div>
                                        </div>
                                        <div class="col-md-6 pr-1pl-1">
                                            <div class="form-group text-center">
                                                <p><strong>Nombre d'enfant: </strong><%=customerBean.getChildren()%></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-1pl-1">
                                            <div class="form-group text-center">
                                                <p><strong>Statut professionel: </strong><%=customerBean.getStatusPro()%></p>
                                            </div>
                                        </div>
                                        <div class="col-md-6 pr-1pl-1">
                                            <div class="form-group text-center">
                                                <p><strong>Statut personnel: </strong><%=customerBean.getStatusPerso()%></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-6 pr-1pl-1">
                                            <table class="table">
                                                <tbody>
                                                <tr>
                                                    <!--<td>
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input class="form-check-input" type="checkbox" checked>
                                                                <span class="form-check-sign"></span>
                                                            </label>
                                                        </div>
                                                    </td>-->
                                                    <%
                                                        if(customerBean.isContact()){
                                                            out.println("<td class=\"text-center contacttt\">accepte d'être contacté</td>");
                                                        }else{
                                                            out.println("<td class=\"text-center contacttt\">n'accepte pas d'être contacté</td>");
                                                        }
                                                    %>

                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <%
                                            }
                                        %>
                                        <div class="col-md-3"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead class=" text-primary"><!-- montant date type-->
                                            <th>
                                                Montant
                                            </th>
                                            <th>
                                                Date
                                            </th>
                                            <th class="text-right">
                                                Type
                                            </th>
                                            </thead>
                                            <tbody>
                                            <%
                                                List<AccountBean> accountBeans = (List<AccountBean>)request.getAttribute("result1");
                                                float solde = (Float) request.getAttribute("solde");

                                                for(AccountBean accountBean : accountBeans){
                                                    Date date = accountBean.getDate();
                                                    DateFormat newformat = new SimpleDateFormat("dd/MM/yyyy");
                                                    String date1 = newformat.format(date);
                                                    %>

                                            <tr>
                                                <td>
                                                    <%=accountBean.getAmount()%>€
                                                </td>
                                                <td>
                                                    <%=date1%>
                                                </td>
                                                <td class="text-right">
                                                    <%=accountBean.getType()%>
                                                </td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th>Solde</th>
                                                <td><%=solde%> €</td>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <h6 class="text-center offredetail primary-text">Les Offres</h6>
                                            <tbody>
                                            <%
                                                List<CustomerHasProductBean> customerHasProductBeans = (List<CustomerHasProductBean>)request.getAttribute("product");

                                                for (CustomerHasProductBean customerHasProductBean : customerHasProductBeans){
                                                    Date date = customerHasProductBean.getDate();
                                                    DateFormat newformat = new SimpleDateFormat("dd/MM/yyyy");
                                                    String date2 = newformat.format(date);
                                                    %>

                                            <tr>
                                                <td>
                                                    <strong><%=customerHasProductBean.getProduct()%></strong>
                                                </td>
                                                <td class="text-center">
                                                    <%
                                                        if(customerHasProductBean.isStatus()){
                                                            out.println("Accepté");
                                                        }else {
                                                            out.println("Refusé");
                                                        }
                                                    %>
                                                </td>
                                                <td class="text-right">
                                                    <%=date2%>
                                                </td>
                                            </tr>
                                            <%
                                                }
                                            %>

                                            </tbody>
                                        </table>
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