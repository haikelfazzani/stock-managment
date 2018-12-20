<%@ page import="java.util.List" %>
<%@ page import="beans.Categorie" %>
<%@ page import="beans.Produit" %>
<%@include file="/partials/head-nav.jsp" %>

<div class="m-col-9">
    <ul class="nav-top">
        <li id="btn-close"><a href="#"><i class="fas fa-list-ul"></i> Produits</a></li>
    </ul>

    <div class="row">
        <div class="col-12 mt-3 mb-5">
            <h3><i class="fas fa-address-card"></i> Ajouter un produit</h3>
            <form action="/produit/ajout" method="post" class="form-row form-ajout">
                <div class="col">
                    <input type="text" name="libelle" class="form-control" placeholder="Libelle">
                </div>

                <div class="col">
                    <input type="text" name="prix" class="form-control" placeholder="Prix">
                </div>

                <div class="col">
                    <select class="form-control" name="categorie">
                        <% if (request.getAttribute("catProduits") != null) {
                            List<Categorie> categorieList = (List<Categorie>) request.getAttribute("catProduits");
                            for (Categorie c : categorieList) {%>
                        <option value="<%= c.getIdCat()%>"><%= c.getIdCat()%>
                        </option>
                        <%} }%>
                    </select>
                </div>

                <div class="col">
                    <button type="submit" class="btn btn-success btn-block"><i class="fas fa-plus"></i> Ajouter</button>
                </div>
            </form>

            <!-- Modifier Produit -->

            <% if(request.getAttribute("produitByLibelle") != null) {
                Produit p = (Produit)request.getAttribute("produitByLibelle"); %>

            <h3><i class="fas fa-pen-square"></i> Modifier</h3>
            <form action="/produit/modifier" method="post" class="form-row form-ajout">
                <div class="col">
                    <input type="text" name="libelle" value="<%= p.getLibelle() %>" class="form-control" placeholder="Libelle">
                </div>

                <div class="col">
                    <input type="text" name="prix" value="<%= p.getPrixUnitaire() %>" class="form-control" placeholder="Prix">
                </div>

                <div class="col">
                    <select class="form-control" name="categorie">
                        <% if (request.getAttribute("catProduits") != null) {
                            List<Categorie> categorieList = (List<Categorie>) request.getAttribute("catProduits");
                            for (Categorie c : categorieList) {%>
                        <option value="<%= c.getIdCat()%>"><%= c.getIdCat()%></option>
                        <%} }%>
                    </select>
                </div>

                <div class="col">
                    <button type="submit" class="btn btn-success btn-block"><i class="fas fa-pen-square"></i> Modifier</button>
                </div>
            </form>
            <% }%>


            <h3><i class="fas fa-list-ul"></i> Les Produits</h3>
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
                <% if (request.getAttribute("produits") != null) {
                    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
                    if(produits.size() > 0) {
                        int i = 0;
                    for (Produit p : produits) {%>
                <tr>
                    <td><%= i++ %></td>
                    <td><%= p.getLibelle()%>
                    </td>
                    <td><%= p.getPrixUnitaire()%>
                    </td>
                    <td><%= p.getCategorie().getIdCat() %></td>
                    <td>
                        <a href="/produit/modifier?libelle=<%= p.getLibelle()%>" class="btn btn-success"><i class="fas fa-pen-square"></i></a>
                        <a href="/produit/supprimer?libelle=<%= p.getLibelle() %>" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
                <%} } } %>
                </tbody>

            </table>

            <% if (request.getAttribute("isDeleted") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("isDeleted") %>
            </div>
            <% }%>



        </div><!-- /COL-12 -->
    </div>
</div>

</div>
</div>


<script src="assets/custom.js"></script>
</body>
</html>
