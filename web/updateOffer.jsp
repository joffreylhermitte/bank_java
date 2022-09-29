<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>
<body class="user-profile">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>
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
                                    <h5 class="title">Modifier la condition</h5>
                                </div>
                                <div class="card-body">
                                    <form action="UpdateOffer" method="get">
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">
                                                <div class="form-group">
                                                    <label>Conditions</label>
                                                    <select class="form-control" id="exampleFormControlSelect1" name="condition" id=" condition">
                                                        <%
                                                            JSONArray array =(JSONArray) request.getAttribute("array");
                                                            for(int i = 0; i < array.length() ; i++){
                                                                JSONObject object = array.getJSONObject(i);
                                                        %>
                                                        <option value="<% out.print(i);%>"><% out.print(object.getString("name"));%></option>
                                                        <%

                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 pr-1pl-1">

                                            </div>
                                        </div>
                                        <%
                                            String condition = request.getParameter("condition");
                                            if (condition != null){
                                        %>
                                        <form action="UpdateOffer" method="get">
                                            <div class="row">
                                                <div class="col-md-4 pr-1pl-1">
                                                    <div class="form-group">
                                                        <label>Nom de la condition</label>
                                                        <input type="text" class="form-control" placeholder="nom condition" name="name">
                                                    </div>
                                                </div>


                                                <div class="col-md-4 pr-1pl-1">
                                                    <div class="form-group">
                                                        <label>Valeur</label>
                                                        <input type="text" class="form-control" placeholder="valeur" name="value">
                                                    </div>
                                                </div>

                                                <div class="col-md-4 pr-1pl-1">
                                                    <div class="form-group">
                                                        <label>Opérateur</label>
                                                        <select class="form-control"  name="operator">
                                                            <option><</option>
                                                            <option>></option>
                                                            <option>=</option>
                                                        </select>
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
                                                        <input type="text" name="conditionID" value="<% out.print(condition);%>" hidden>
                                                        <input type="text" name="product" value="<% out.print(request.getAttribute("products"));%>" hidden>

                                                        <button type="submit" class="form-control botto-edit btn btn-primary">Modifier</button>

                                                    </div>
                                                </div>
                                                <div class="col-md-4"></div>
                                            </div>
                                        </form>
                                        <!--
                                        <form action="UpdateOffer" method="get">
                                            <input type="text" name="name">
                                            <input type="text" name="value">
                                            <select name="operator" id="operator" >
                                                <option value="<"><</option>
                                                <option value=">">></option>
                                                <option value="=">=</option>
                                            </select>
                                            <input type="text" name="conditionID" value="<% out.print(condition);%>" hidden>
                                            <input type="text" name="product" value="<% out.print(request.getAttribute("products"));%>" hidden>

                                            <input type="submit">
                                        </form>-->
                                        <%
                                            }


                                        %>
                                        <div class="row">
                                            <div class="col-md-4"></div>
                                            <div class="col-md-4">
                                                <div class="text-center form-group">
                                                    <input type="text" name="product" value="<% out.print(request.getAttribute("products"));%>" hidden>
                                                        <%
                                                        if (condition == null){
                                                    %>
                                                    <button type="submit" class="form-control botto-edit btn btn-primary">
                                                        suivant
                                                    </button>
                                                        <%
}
                                                    %>
                                    </form>

                                </div>
                            </div>
                            <div class="col-md-4"></div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </nav>

    </div>
</div>
</div>

<%@include file="./layout/Footer.jsp" %>



