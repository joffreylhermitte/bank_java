
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="layout/Header.jsp"%>
<body id="LoginForm">
<div class="container">
    <h1 class="form-heading">Connexion</h1>
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>Connexion employé</h2>
                <p>Veuillez entrer votre email ainsi que votre mot de passe</p>
            </div>
            <form id="Login" action="Login" method="post">

                <div class="form-group">


                    <input type="email" class="form-control" id="inputEmail" placeholder="Adresse email" name="email">

                </div>

                <div class="form-group">

                    <input type="password" class="form-control" id="inputPassword" placeholder="Mot de passe" name="password">

                </div>

                <button type="submit" class="btn btn-primary">Connexion</button>

            </form>
        </div>
    </div>
</div>


<!--   Core JS Files   -->
<script src="assets/js/core/jquery.min.js"></script>
<script src="assets/js/core/popper.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>
<script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Chart JS -->
<script src="assets/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Bankroot Dashboard: parallax effects, scripts for the example pages etc -->
<script src="assets/js/bankroot.js" type="text/javascript"></script>
<script>
    $(document).ready(function() {
        demo.initDashboardPageCharts();
    });
</script>
</body>
<%@include file="layout/Footer.jsp"%>
