<%@ page import="com.bankroot.beans.CategoryBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/Header.jsp"%>

<form method="post" action="addProduct">
    <div class="form-group">
        <label for="name">Nom du porduit :</label>
        <input type="text" name="name" id="name" class="form-control">
    </div>
    <div class="form-check">
        <input type="checkbox" class="form-check-input" id="exclusive" name="exclusive" value="1">
        <label class="form-check-label" for="exclusive">Produit exclusif</label>
    </div>
    <div class="form-check">
        <input type="checkbox" class="form-check-input" id="limited" name="limited" value="1">
        <label class="form-check-label" for="limited">Produit Limité</label>
    </div>
    <div>
        <select class="form-control" name="category_id">
            <option>Catégorie</option>
            <%
                @SuppressWarnings("unchecked")
                List<CategoryBean> categories = (List<CategoryBean>) request.getAttribute("categories");

                if(categories != null) {
                    for (CategoryBean categorie : categories) {
                    %><option value="<%= categorie.getId() %>"><%= categorie.getLabel() %></option><%
                    }
                }
            %>
        </select>
    </div>
    <input type="submit" class="btn btn-success">
</form>
<%
    if(categories!=null){
        for(CategoryBean categorie : categories){
            out.println("<p>"+categorie.getLabel()+"</p>");
        }
    }else {
%>
<h1>Vide</h1>
<%
    }
%>
<a href="index.jsp">Accueil</a>

<%@include file="./layout/Footer.jsp"%>