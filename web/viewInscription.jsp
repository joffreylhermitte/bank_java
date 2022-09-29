
<%@ page import ="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Résultat inscription</title>
</head>
<body>
<%
    String name = (String) request.getAttribute("name");
    String email = (String) request.getAttribute("email");


    out.println("Nom : "+ name+"<br>");
    out.println("Email : "+ email);

%>
</body>
</html>
