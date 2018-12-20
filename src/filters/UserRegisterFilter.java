package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "UserRegisterFilter", urlPatterns = "/user/ajout")
public class UserRegisterFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;

        String nom = request.getParameter("nom"),
                prenom = request.getParameter("prenom"),
                email = request.getParameter("email"),
                password = request.getParameter("password");

        if(nom.length() > 0 && prenom.length() > 0 && email.length() > 0 && password.length() > 0) {
            chain.doFilter(req,resp);
        }
        else {
            request.setAttribute("emptyField" , "il faut remplir tous les champs");
            request.getRequestDispatcher("/register.jsp").forward(request,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
