package controller;

import model.CategorieModel;
import model.ProduitModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProduitLister", urlPatterns = "/produit/lister")
public class ProduitLister extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProduitModel model = new ProduitModel();

        CategorieModel categorieModel = new CategorieModel();

        request.setAttribute("produits" , model.getProduits());
        request.setAttribute("catProduits" , categorieModel.getCategories());

        request.getRequestDispatcher("/produit.jsp").forward(request,response);

    }
}
