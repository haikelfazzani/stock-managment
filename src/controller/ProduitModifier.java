package controller;

import beans.Categorie;
import beans.Produit;
import model.ProduitModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProduitModifier", urlPatterns = "/produit/modifier")
public class ProduitModifier extends HttpServlet {

    private ProduitModel model = new ProduitModel();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String libelle = request.getParameter("libelle");
        Double prix = Double.parseDouble(request.getParameter("prix"));
        String cat = request.getParameter("categorie");

        model.getProduit().setLibelle(libelle);
        model.getProduit().setPrixUnitaire(prix);

        Categorie c = new Categorie();
        c.setIdCat(cat);
        model.getProduit().setCategorie(c);
        model.setLibelle(libelle);
        model.modifier();

        request.getRequestDispatcher("/produit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String libelle = request.getParameter("libelle");

        model.setLibelle(libelle);
        Produit p = model.getProduitByLibelle();

        request.setAttribute("produitByLibelle" , p);
        request.getRequestDispatcher("/produit/lister").forward(request,response);
    }
}
