package controller;

import model.ProduitModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProduitSupprimer", urlPatterns = "/produit/supprimer")
public class ProduitSupprimer extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String libelle = request.getParameter("libelle");
        ProduitModel model = new ProduitModel();
        model.setLibelle(libelle);
        boolean isDeleted = model.supprimer();

        if(isDeleted) {
            request.setAttribute("isDeleted" , libelle + " a été supprimer");
            request.getRequestDispatcher("/produit.jsp").forward(request,response);
        }

    }
}
