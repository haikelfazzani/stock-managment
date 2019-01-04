<%@ page import="beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Achat" %>
<%@ page import="java.util.List" %>
<%@include file="/partials/head-nav.jsp" %>

<%
    if (session.getAttribute("user") != null) {
        User user = (User) session.getAttribute("user");
%>
<div class="m-col-9 mt-5">
    <ul class="nav-top">
        <li id="btn-close" style="flex: 1;"><a href="#"><i class="fas fa-list-ul"></i> Profile</a></li>

        <% if (session.getAttribute("produitList") != null) {
                ArrayList<String> list = (ArrayList<String>) session.getAttribute("produitList");
        %>
        <li style="float: right"><a href="/panier.jsp"><i class="fas fa-shopping-cart"></i> <%= list.size() %></a></li>
        <% }%>

    </ul>

    <div class="row mt-3 mb-5">


        <div class="col-4">
            <img class="img-profile mb-3" src="/assets/img/1.png" alt="">
        </div><!-- /COL-4 -->

        <div class="col-8">

            <form class="form-profile" action="/user/modifier" method="post">

                <div class="form-group">
                    <label>Nom</label>
                    <input type="text" name="nom" class="form-control" value="<%= user.getNom() %>">
                </div>

                <div class="form-group">
                    <label>Prenom</label>
                    <input type="text" name="prenom" class="form-control" value="<%= user.getPrenom() %>">
                </div>

                <div class="form-group">
                    <label>Email address</label>
                    <input type="email" name="email" class="form-control" value="<%= user.getEmail() %>">
                </div>

                <div class="form-group">
                    <label>Mot de pass</label>
                    <input type="password" name="password" class="form-control" value="<%= user.getPassword() %>">
                </div>

                <button type="submit" class="btn btn-success"><i class="fas fa-pen-square"></i></button>
                <a href="/user/supprimer?email=<%= user.getEmail() %>" id="btn-delete" class="btn btn-danger" style="float: right"><i class="fas fa-trash-alt"></i></a>
            </form>

            <% if (request.getAttribute("userUpdated") != null) { %>
            <div class="alert alert-success" role="alert">
                <%= request.getAttribute("userUpdated") %>
            </div>
            <% }%>
        </div>

        <div class="col-md-12">
            <h3><i class="fas fa-list-ul"></i> Vos Achats</h3>
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Libelle</th>
                    <th scope="col">Prix Unitaire</th>
                    <th scope="col">Categorie</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>

                <tbody>
                <% if (session.getAttribute("achats") != null) {
                    List<Achat> achatList = (List<Achat>) session.getAttribute("achats");
                    if(achatList.size() > 0) {
                        int i = 0;
                        for (Achat achat : achatList) {%>
                <tr>
                    <td><%= i++ %></td>
                    <td><%= achat.getLibelle() %>
                    </td>
                    <td><%= achat.getPrix() %>
                    </td>
                    <td><%= achat.getCategorie() %></td>
                </tr>
                <%} } } %>
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

