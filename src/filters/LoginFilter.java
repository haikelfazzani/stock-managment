package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;

        String  email = request.getParameter("email"),
                password = request.getParameter("password");

        if(email.length() > 0 && password.length() > 0) {
            chain.doFilter(req,resp);
        }
        else {
            request.setAttribute("champsVid" , "il faut remplir tous les champs");
            request.getRequestDispatcher("/login.jsp").forward(request,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
