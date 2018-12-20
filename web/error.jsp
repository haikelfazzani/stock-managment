<%@page isErrorPage="true" %>

<%@include file="/partials/head-nav.jsp"%>

        <div class="m-col-9">
            <ul class="nav-top">
                <li id="btn-close"><a href="#"><i class="fas fa-list-ul"></i></a></li>
            </ul>

            <div class="row">
                <div class="col-12">

                    <div class="alert alert-danger" role="alert">
                        <%= exception.getMessage() %>
                    </div>

                </div><!-- /COL-12 -->
            </div>
        </div>

    </div>
</div>


<script src="assets/custom.js"></script>
</body>
</html>

