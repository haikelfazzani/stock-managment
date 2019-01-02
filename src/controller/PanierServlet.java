package controller;

import beans.Produit;
import model.ProduitModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PanierServlet", urlPatterns = "/panier")
public class PanierServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String produit = request.getParameter("produit");

        ProduitModel model = new ProduitModel();
        model.setLibelle(produit);
        Produit p = model.getProduitByLibelle();

        ArrayList<Produit> produitList = new ArrayList<>();

        HttpSession session = request.getSession();

        if(session.getAttribute("produitList") != null) {
            produitList = (ArrayList<Produit>) session.getAttribute("produitList");
            produitList.add(p);
        }
        else {
            produitList.add(p);
            session.setAttribute("produitList", produitList);
        }



        session.setAttribute("produitList", produitList);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
