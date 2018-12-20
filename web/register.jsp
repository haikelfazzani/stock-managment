<%@include file="/partials/head-nav.jsp"%>

        <div class="m-col-9">
            <ul class="nav-top">
                <li id="btn-close"><a href="#"><i class="fas fa-list-ul"></i> Register</a></li>
            </ul>

            <div class="row mt-5">
                <div class="col-12">
                    <form action="/user/ajout" method="post" class="form-auth">

                        <div class="form-group">
                            <label>Nom</label>
                            <input type="text" name="nom" class="form-control" placeholder="Enter nom">
                        </div>

                        <div class="form-group">
                            <label>Prenom</label>
                            <input type="text" name="prenom" class="form-control" placeholder="Enter prenom">
                        </div>

                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" name="email" class="form-control" placeholder="Enter email">
                        </div>

                        <div class="form-group">
                            <label>Mot de pass</label>
                            <input type="password" name="password" class="form-control" placeholder="Entrer Password">
                        </div>

                        <button type="submit" class="btn btn-success">Register</button>
                    </form>

                    <% if (request.getAttribute("emptyField") != null) { %>
                    <div class="alert alert-danger mt-3 mb-3" role="alert"
                         style="margin: auto; max-width: 500px;">

                        <%= request.getAttribute("emptyField") %>
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


