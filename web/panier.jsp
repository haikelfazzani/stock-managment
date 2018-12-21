<%@ page import="beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Produit" %>
<%@include file="/partials/head-nav.jsp" %>

<%
    if (session.getAttribute("user") != null) {
        User user = (User) session.getAttribute("user");

        if (session.getAttribute("produitList") != null) {
            ArrayList<Produit> list = (ArrayList<Produit>) session.getAttribute("produitList");
            if (list.size() > 0) {
%>
<div class="m-col-9">
    <ul class="nav-top">
        <li id="btn-close" style="flex: 1;"><a href="#"><i class="fas fa-list-ul"></i> Panier</a></li>
    </ul>

    <div class="row mt-3">

        <div class="col-12">
            <h3><i class="fas fa-cart-arrow-down"></i> Panier (<%= list.size() %>)</h3>
            <table class="table table-dark mb-5">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Libelle</th>
                    <th scope="col">Pirx unitiare</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <%  int i = 0;
                    for (Produit p : list) {%>
                <tr>
                    <td><%= i++ %></td>
                    <td><%= p.getLibelle() %></td>
                    <td><%= p.getPrixUnitaire() %></td>
                    <td><a class="btn btn-danger" href="/panier/supprimer?libelle=<%= p.getLibelle() %>">
                        <i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
                <%} } else { response.sendRedirect("/index.jsp"); }}%>

                </tbody>
            </table>
        </div>
    </div>
</div>
<% }else { response.sendRedirect("/login.jsp");}%>
</div>
</div>


<script src="assets/custom.js"></script>
</body>
</html>

