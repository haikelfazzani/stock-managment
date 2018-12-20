<%@ page import="beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="/partials/head-nav.jsp" %>

<%
    if (session.getAttribute("user") != null) {
        User user = (User) session.getAttribute("user");
%>
<div class="m-col-9">
    <ul class="nav-top">
        <li id="btn-close" style="flex: 1;"><a href="#"><i class="fas fa-list-ul"></i> <%= user.getNom() %>
        </a></li>

        <% if (session.getAttribute("produitList") != null) {
                ArrayList<String> list = (ArrayList<String>) session.getAttribute("produitList");
        %>
        <li style="float: right"><a href="#"><i class="fas fa-shopping-cart"></i> <%= list.size() %></a></li>
        <% }%>
    </ul>

    <div class="row">

        <div class="col-4">
            <img class="img-profile mb-3" src="/assets/img/1.png" alt="">
            <h4><i class="fas fa-user"></i> <%= user.getNom() %> <%= user.getPrenom()%>
            </h4>
            <a href="/user/supprimer?email=<%= user.getEmail() %>" class="btn btn-danger mt-3">Supprimer</a>
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
                    <label>Nouveau mot de pass</label>
                    <input type="password" name="password" class="form-control" value="<%= user.getPassword() %>">
                </div>

                <button type="submit" class="btn btn-success">Modifier</button>
            </form>

            <% if (request.getAttribute("userUpdated") != null) { %>
            <div class="alert alert-success" role="alert">
                <%= request.getAttribute("userUpdated") %>
            </div>
            <% }%>
        </div>

        <div class="col-12">
            <h3>Panier</h3>
            <table class="table table-dark mb-5">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Libelle</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <% if (session.getAttribute("produitList") != null) {
                    ArrayList<String> list = (ArrayList<String>) session.getAttribute("produitList");
                    if (list.size() > 0) {
                        int i = 0;
                        for (String s : list) {%>
                <tr>
                    <td><%= i++ %></td>
                    <td><%= s %></td>
                    <td><a class="btn btn-danger" href="/panier/supprimer?libelle=<%= s %>"><i class="fas fa-trash-alt"></i></a></td>
                </tr>
                <%} } }%>

                </tbody>
            </table>
        </div>
    </div>
</div>
<% } %>
</div>
</div>


<script src="assets/custom.js"></script>
</body>
</html>

