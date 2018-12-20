package controller;

import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserSupprimer", urlPatterns = "/user/supprimer")
public class UserSupprimer extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        UserModel model = new UserModel();
        model.setEmail(email);
        model.supprimer();

        response.sendRedirect("/register.jsp");
    }
}
