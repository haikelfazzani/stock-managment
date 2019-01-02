package controller;

import beans.Produit;
import model.ProduitModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChercherServlet", urlPatterns = "/chercher")
public class ChercherServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String libelle = request.getParameter("libelle");

        ProduitModel model = new ProduitModel();
        model.setLibelle(libelle.toLowerCase().trim());

        Produit p = model.getProduitByLibelle();
        request.setAttribute("produit" , p);
        request.getRequestDispatcher("/chercher.jsp").forward(request,response);
    }
}
