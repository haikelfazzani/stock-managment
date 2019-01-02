<%@ page import="java.util.List" %>
<%@ page import="beans.Categorie" %>

<%@include file="/partials/head-nav.jsp"%>

        <div class="m-col-9">
            <ul class="nav-top">
                <li id="btn-close"><a href="#"><i class="fas fa-list-ul"></i> Categorie</a></li>
            </ul>

            <% if(session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if(user.getNom().equals("admin")) {%>

            <div class="row">
                <div class="col-12 mt-3">
                    <h3><i class="fas fa-address-card"></i> Ajouter une categorie</h3>
                    <form action="/categorie/ajout" method="post" class="form-row form-ajout">
                        <div class="col">
                            <input type="text" name="nom" class="form-control" placeholder="Nom Categorie">
                        </div>
                        <div class="col">
                            <input type="text" name="description" class="form-control" placeholder="Description">
                        </div>

                        <div class="col">
                            <button type="submit" class="btn btn-success btn-block">Ajouter</button>
                        </div>
                    </form>

                    <h3 class="mt-3"><i class="fas fa-list-ul"></i> List Des Categories</h3>
                    <table class="table table-dark">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nom</th>
                            <th scope="col">Description</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <%
                            if (request.getAttribute("categories") != null) {
                                List<Categorie> categorieList = (List<Categorie>) request.getAttribute("categories");
                                if (categorieList.size() > 0) {
                                    int i = 0;
                        %>
                        <tbody>
                        <% for (Categorie c : categorieList) { %>
                        <tr>
                            <td><%= i++ %>
                            </td>
                            <td><%= c.getIdCat() %>
                            </td>
                            <td><%= c.getDescription() %>
                            </td>
                            <td><a class="btn btn-danger"
                                   href="/categorie/supprimer?id=<%= c.getIdCat() %>"><i class="fas fa-trash-alt"></i></a></td>
                        </tr>
                        <% } } }%>
                        </tbody>
                    </table>

                    <% if (request.getAttribute("categorieDelete") != null) { %>
                    <div class="alert alert-danger" role="alert">
                        <%= request.getAttribute("categorieDelete") %>
                    </div>
                    <% }%>
                </div>
            </div>
        </div>

<% }else { response.sendRedirect("/index.jsp"); } }else { response.sendRedirect("/index.jsp"); }%>

    </div>
</div>


<script src="assets/custom.js"></script>
</body>
</html>
