package controller;

import beans.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "UserLogin", urlPatterns = "/user/login")
public class UserLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String  email = req.getParameter("email"),
                password = req.getParameter("password"),
                beConnected = req.getParameter("beconnected");

        UserModel model = new UserModel();
        model.setEmail(email);
        User user = model.getUserByEmail();

        if(user != null) {
            if(user.getPassword().equals(password)) {
                if(beConnected.equals("on")) {
                    //String userString = "islogin";

                    //Cookie cookie = new Cookie("userCookie",userString);
                    //cookie.setMaxAge(3600);
                    //resp.addCookie(cookie);

                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    resp.sendRedirect("/profile.jsp");
                }
            }
        }
    }
}
