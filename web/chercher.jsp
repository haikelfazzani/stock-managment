<%@ page import="beans.Produit" %>
<%@include file="/partials/head-nav.jsp"%>

<div class="m-col-9">
    <ul class="nav-top">
        <li id="btn-close" style="flex: 1;"><a href="#"><i class="fas fa-list-ul"></i> Acceuil</a></li>
    </ul>

    <div class="row">

        <div class="col-12 mt-4">
            <form class="form-row form-search" action="/chercher">
                <div class="col-10">
                    <input type="text" name="libelle" class="form-control" placeholder="chercher par libelle">
                </div>

                <div class="col-2">
                    <button type="submit" class="btn btn-success"><i class="fas fa-search"></i> CHERCHER</button>
                </div>

            </form>
        </div>

        <%
            if(request.getAttribute("produit") != null) {
                Produit p = (Produit) request.getAttribute("produit");
        %>

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
        <% }%>

    </div><!-- /ROW -->
</div>

</div>
</div>


<script src="assets/custom.js"></script>
</body>
</html>
