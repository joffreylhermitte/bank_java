<%@ page import="java.util.List" %>
<%@ page import="com.bankroot.beans.CustomerBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>
<%
  HttpSession session1 = request.getSession();
  String id = (String)session1.getAttribute("idUser");

  if(id==null){
    response.sendRedirect("login.jsp");
  }else {


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
            <a class="navbar-brand" href="#">Liste des clients</a>
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
                <h4 class="card-title">Liste des clients</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table">
                    <thead class=" text-primary">
                      <th>
                        Nom
                      </th>
                      <th class="text-right">
                        Détail
                      </th>
                    </thead>
                    <tbody>
                    <%
                      List<CustomerBean> customerBeans = (List<CustomerBean>)request.getAttribute("result");

                      for (CustomerBean customerBean : customerBeans){
                        out.println("<tr><td>"+customerBean.getName()+" "+customerBean.getFirstname()+"</td>" +
                                "<td class='text-right'><a href='DetailsCustomers?id="+customerBean.getId()+"'>Détails</a></td></tr>");

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