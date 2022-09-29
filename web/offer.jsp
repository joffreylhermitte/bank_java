<%@ page import="java.util.List" %>
<%@ page import="com.bankroot.beans.ConditionBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp" %>
<body>
    <%
    List offer = (List) request.getAttribute("offer");

    out.println(offer);


    %>
<a href="products">Retour</a>

</body>
<%@include file="./layout/Footer.jsp" %>
