<%@ page import="beans.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/error.jsp" %>

<html>
<head>
    <title>Gestion De STOCKS</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.css">
    <link rel="stylesheet" href="/assets/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
          integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
</head>
<body>

<div class="m-container">
    <div class="m-row">

        <div class="m-col-3">

            <nav class="nav-bar-left">
                <ul class="top-brand">
                    <li>
                        <small style="color: #fff; margin: 0;">Created by Haikel Fazzani</small>
                        <a style="padding: 0;" href="/index.jsp"><i class="fas fa-luggage-cart"></i> Stock Management</a>
                    </li>
                </ul>

                <ul class="nav-left">
                    <li><a href="/index.jsp"><i class="fas fa-home"></i> Home</a></li>

                    <% if(session.getAttribute("user") != null) {
                        User user = (User) session.getAttribute("user");
                        if(user.getNom().equals("admin")) {%>

                    <li><a href="/produit/lister"><i class="fab fa-product-hunt"></i> Products</a></li>
                    <li><a href="/categorie/lister"><i class="fas fa-draw-polygon"></i> Categories</a></li>
                    <%    } }%>

                    <% if(session.getAttribute("user") != null) {%>

                    <li><a href="/profile.jsp"><i class="fas fa-user"></i> Profile</a></li>
                    <li><a href="/user/logout"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
                    <% } else { %>

                    <li><a href="/login.jsp"><i class="fas fa-sign-in-alt"></i> Login</a></li>
                    <li><a href="/register.jsp"><i class="fas fa-user-plus"></i> Register</a></li>
                    <%}%>

                </ul>
            </nav>

        </div>