package controller;

import beans.Categorie;
import model.ProduitModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProduitAjout", urlPatterns = "/produit/ajout")
public class ProduitAjout extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String liblle = request.getParameter("libelle");
        String prixString = request.getParameter("prix");
        prixString = prixString.replaceAll("\\s+","");

        Double prix = Double.parseDouble(prixString);
        String categorie = request.getParameter("categorie");

        ProduitModel model = new ProduitModel();
        model.getProduit().setLibelle(liblle.toLowerCase().trim());
        model.getProduit().setPrixUnitaire(prix);
        Categorie c = new Categorie();
        c.setIdCat(categorie);
        model.getProduit().setCategorie(c);

        boolean isAdd = model.ajouter();

        if(isAdd) {
            request.getRequestDispatcher("/produit.jsp").forward(request,response);
        }
    }

}
