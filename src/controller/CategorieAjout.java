package controller;

import model.CategorieModel;
import singeton.ConnectionDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CategorieAjout", urlPatterns = "/categorie/ajout")
public class CategorieAjout extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String description = request.getParameter("description");

        CategorieModel model = new CategorieModel();
        model.getCategorie().setIdCat(nom);
        model.getCategorie().setDescription(description);

        boolean isAdd = model.ajouter();

        if(isAdd) {
            request.setAttribute("categories", model.getCategories());
            request.getRequestDispatcher("/categorie.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }
}
