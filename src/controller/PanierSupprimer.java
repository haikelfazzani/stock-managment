package controller;

import beans.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PanierSupprimer", urlPatterns = "/panier/supprimer")
public class PanierSupprimer extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String libelle = request.getParameter("libelle");
        ArrayList<Produit> produitList = (ArrayList<Produit>) session.getAttribute("produitList");

        if(produitList.size() > 0 ){
            for(int i = 0 ; i < produitList.size() ; i++) {
                if(produitList.get(i).getLibelle().equals(libelle.trim())) {
                    produitList.remove(i);
                    break;
                }
            }
        }

        session.setAttribute("produitList", produitList);
        request.getRequestDispatcher("/panier.jsp").forward(request,response);
    }
}
