package controller.user;

import beans.User;
import model.AchatModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Profile", urlPatterns = "/user/profile")
public class Profile extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.getAttribute("user") != null) {

            User user = (User) session.getAttribute("user");
            AchatModel model = new AchatModel();
            model.setUserId(user.getId());

            if(model.getAchatsByUser().size() > 0) {
                session.setAttribute("achats", model.getAchatsByUser());
                request.getRequestDispatcher("/profile.jsp").forward(request,response);
            }
        }

    }
}
