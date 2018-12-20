<%@ page import="model.ProduitModel" %>
<%@ page import="beans.Produit" %>
<%@include file="/partials/head-nav.jsp"%>

        <div class="m-col-9">
            <ul class="nav-top">
                <li id="btn-close"><a href="#"><i class="fas fa-list-ul"></i> Acceuil</a></li>
            </ul>

            <div class="row">
                <%
                    ProduitModel model = new ProduitModel();
                    if(model.getProduits().size() > 0) {
                        for(Produit p : model.getProduits()) {%>

                <div class="col-3 mb-3 mt-3">
                    <div class="card">
                        <!--<img class="card-img-top" src="/assets/img/1.png" alt="Card image cap">-->
                        <div class="card-body">
                            <h5 class="card-title"><%= p.getLibelle() %></h5>
                            <p class="card-text"><%= p.getPrixUnitaire()%></p>
                            <p class="card-text"><%= p.getCategorie().getDescription() %></p>
                            <a href="#" class="btn btn-primary"><i class="fas fa-shopping-cart"></i> Panier</a>
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
