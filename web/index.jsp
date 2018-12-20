<%@ page import="model.ProduitModel" %>
<%@ page import="beans.Produit" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="/partials/head-nav.jsp"%>

        <div class="m-col-9">
            <ul class="nav-top">
                <li id="btn-close" style="flex: 1;"><a href="#"><i class="fas fa-list-ul"></i> Acceuil</a></li>
                <% if (session.getAttribute("produitList") != null) {
                    ArrayList<String> list = (ArrayList<String>) session.getAttribute("produitList");
                    if(list.size() > 0 ) {
                %>
                <li style="float: right"><a href="#"><i class="fas fa-shopping-cart"></i> <%= list.size() %></a></li>
                <% } } %>
            </ul>

            <div class="row">

                <div class="col-12 mt-4">
                    <img style="border: 1px solid #e2e2e2; border-radius: 5px; max-width: 100%" src="/assets/img/2.jpg" alt="">
                    <form class="form-row mt-4 form-search" action="/chercher">
                        <div class="col-10">
                            <input type="text" name="libelle" class="form-control" placeholder="chercher par libelle">
                        </div>

                        <div class="col-2">
                            <button type="submit" class="btn btn-success"><i class="fas fa-search"></i> CHERCHER</button>
                        </div>

                    </form>
                </div>

                <%
                    ProduitModel model = new ProduitModel();
                    if(model.getProduits().size() > 0) {
                        for(Produit p : model.getProduits()) {%>

                <div class="col-3 mb-5 mt-3">
                    <div class="card">
                        <!--<img class="card-img-top" src="/assets/img/1.png" alt="Card image cap">-->
                        <div class="card-body">
                            <h5 class="card-title"><%= p.getLibelle() %></h5>
                            <p class="card-text"><i class="fas fa-hand-holding-usd"></i> <%= p.getPrixUnitaire()%></p>
                            <p class="card-text"><i class="fas fa-info"></i> <%= p.getCategorie().getDescription() %></p>
                            <a href="/panier?produit=<%=p.getLibelle()%>" class="btn btn-primary"><i class="fas fa-plus"></i></a>
                            <a href="/panier?produit=<%=p.getLibelle()%>" style="float: right; margin-top: 5px; color: #FFC107;"><i class="fas fa-star"></i></a>
                        </div>
                    </div>
                </div><!-- /COL-3 -->
                <%} }%>

            </div><!-- /ROW -->
        </div>

    </div>
</div>


    <script src="assets/custom.js"></script>
</body>
</html>
