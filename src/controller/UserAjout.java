package controller;

import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserAjout", urlPatterns = "/user/ajout")
public class UserAjout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nom = req.getParameter("nom"),
            prenom = req.getParameter("prenom"),
            email = req.getParameter("email"),
            password = req.getParameter("password");

        UserModel model = new UserModel();
        model.getUser().setNom(nom);
        model.getUser().setPrenom(prenom);
        model.getUser().setEmail(email);
        model.getUser().setPassword(password);

        model.ajouter();

        resp.sendRedirect("/login.jsp");
    }
}
