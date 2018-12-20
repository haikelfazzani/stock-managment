package controller;

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
        ArrayList<String> produitList = new ArrayList<>();

        HttpSession session = request.getSession();

        if(session.getAttribute("produitList") != null) {
            produitList = (ArrayList<String>) session.getAttribute("produitList");
            produitList.add(produit);
        }
        else {
            produitList.add(produit);
            session.setAttribute("produitList", produitList);
        }
        session.setAttribute("produitList", produitList);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
