<%@include file="/partials/head-nav.jsp"%>

        <div class="m-col-9">
            <ul class="nav-top">
                <li id="btn-close"><a href="#"><i class="fas fa-list-ul"></i> Login</a></li>
            </ul>

            <div class="row mt-5">
                <div class="col-12">

                    <form action="/user/login" method="post" class="form-auth">
                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" name="email" class="form-control" placeholder="Enter email">
                        </div>

                        <div class="form-group">
                            <label>Mot de pass</label>
                            <input type="password" name="password" class="form-control" placeholder="Entrer Password">
                        </div>

                        <div class="form-group form-check">
                            <input type="checkbox" name="beconnected" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">il faut cocher avant de presser boutton login</label>
                        </div>

                        <button type="submit" class="btn btn-success">Login</button>
                    </form>

                </div><!-- /COL-12 -->
            </div>
        </div>

    </div>
</div>


<script src="assets/custom.js"></script>
</body>
</html>


