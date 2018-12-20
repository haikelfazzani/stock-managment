package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "ChercherFilter", urlPatterns = "/chercher")
public class ChercherFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        String libelle = request.getParameter("libelle");

        if(libelle.trim().length() > 0) {
            chain.doFilter(req, resp);
        }else {
            request.setAttribute("errorChercher" , "Il faut remplir tous les champs !");
            request.getRequestDispatcher("/chercher.jsp").forward(request,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
