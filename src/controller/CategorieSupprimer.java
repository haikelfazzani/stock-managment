package controller;

import model.CategorieModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="CategorieSupprimer" , urlPatterns = "/categorie/supprimer")
public class CategorieSupprimer extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String idCat = request.getParameter("id");

        CategorieModel model = new CategorieModel();
        model.setIdCat(idCat);
        model.supprimer();

        request.setAttribute("categorieDelete" , idCat + " a été supprimer");
        request.getRequestDispatcher("/categorie.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
