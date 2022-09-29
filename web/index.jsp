<%@ page import="java.util.List" %>
<%@ page import="com.bankroot.beans.CustomerBean" %>
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
          <a class="navbar-brand" href="#">Dashboard</a>
        </div>
        <%@include file="./layout/Navbar.jsp" %>
        <!-- End Navbar -->
        <div class="panel-header panel-header-lg">
          <canvas id="bigDashboardChart"></canvas>
        </div>
        <div class="content">
          <div class="row">
            <div class="col-lg-6">
              <div class="card card-chart">
                <div class="card-header">
                  <h4 class="card-title">Activité sur le site</h4>
                  <div class="dropdown">
                    <button type="button" class="btn btn-round btn-default dropdown-toggle btn-simple btn-icon no-caret" data-toggle="dropdown">
                      <i class="now-ui-icons loader_gear"></i>
                    </button>
                    <div class="dropdown-menu dropdown-menu-right">
                      <a class="dropdown-item text-danger" href="#">supprimer les données</a>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <div class="chart-area">
                    <canvas id="lineChartExample"></canvas>
                  </div>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="now-ui-icons arrows-1_refresh-69"></i> Juste actualisé
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-md-8">
              <div class="card card-chart">
                <div class="card-header">
                  <h4 class="card-title">Nombre de client</h4>
                  <div class="dropdown">
                    <button type="button" class="btn btn-round btn-default dropdown-toggle btn-simple btn-icon no-caret" data-toggle="dropdown">
                      <i class="now-ui-icons loader_gear"></i>
                    </button>
                    <div class="dropdown-menu dropdown-menu-right">
                      <a class="dropdown-item text-danger" href="#">supprimer les données</a>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <div class="chart-area">
                    <canvas id="lineChartExampleWithNumbersAndGrid"></canvas>
                  </div>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="now-ui-icons arrows-1_refresh-69"></i>Juste actualisé
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <div class="card  card-tasks">
                <div class="card-header ">
                  <h4 class="card-title">Dernières offres</h4>
                </div>
                <div class="card-body ">
                  <div class="table-full-width table-responsive">
                    <table class="table">
                      <tbody>
                      <%
                        List<ProductBean> productBeans = (List)request.getAttribute("product");

                        for(ProductBean productBean:productBeans){


                      %>
                      <tr>
                        <td>
                          <span class="text-left"><%=productBean.getName()%></span>
                        </td>
                                               </td>
                        <td class="td-actions text-right">
                          <a href="updateProduct?id=<%=productBean.getId()%>"><button type="button" rel="tooltip" title="" class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Edit Task">
                            <i class="now-ui-icons ui-2_settings-90"></i>
                          </button></a>
                          <a href="delete?id=<%=productBean.getId()%>"><button type="button" rel="tooltip" title="" class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Remove">
                            <i class="now-ui-icons ui-1_simple-remove"></i>
                          </button></a>
                        </td>
                      </tr>
                      <%
                        }
                      %>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="card-footer ">
                  <hr>
                  <div class="stats">
                    <i class="now-ui-icons loader_refresh spin"></i>actualisé il y a 3 minutes
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="card">
                <div class="card-header">
                  <h4 class="card-title">Derniers clients</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead class=" text-primary">
                      <th>
                        Nom
                      </th>
                      <th class="text-right">
                        Détails
                      </th>
                      </thead>
                      <tbody>
                      <%
                        List<CustomerBean> customer = (List)request.getAttribute("customer");

                        for(CustomerBean customerBean:customer){


                      %>
                      <tr>
                        <td>
                          <%=customerBean.getName()+" "%><%=customerBean.getFirstname()%>
                        </td>
                        <td class="text-right">
                          <button type="button" rel="tooltip" title="" class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Edit Task">
                            <a href="DetailsCustomers?id=<%=customerBean.getId()%>"><i class="okkk now-ui-icons arrows-1_minimal-right"></i></a>
                          </button>
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