package controller;

import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserModifier", urlPatterns = "/user/modifier")
public class UserModifier extends HttpServlet {

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

        model.setEmail(email);
        model.modifier();

        req.setAttribute("userUpdated" , "vos informations sont modifiers");
        req.getRequestDispatcher("/profile.jsp").forward(req,resp);
    }

}
