<%@ page import="com.bankroot.beans.ProductBean" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produits</title>
</head>
<body>
    <h1>Produits</h1>
    <p><a href="addProduct" >Ajouter un produit</a></p>
    <%
        @SuppressWarnings("unchecked")
        List<ProductBean> products = (List<ProductBean>) request.getAttribute("products");

        if(products != null) {
            for (ProductBean product : products) {
                out.println("<p>"+product.getName()+"</p>");
                out.println("<p>"+product.getLimited()+"</p>");
                out.println("<p>"+product.getExclusive()+"</p>");
                out.println("<p>"+product.getCategory_id()+"</p>");
                out.println("<p><a href='delete?id=" + product.getId() + "' >Supprimer</a></p>");
            }
        } else {
            out.println("<p>vide</p>");
        }
    %>
</body>
</html>
