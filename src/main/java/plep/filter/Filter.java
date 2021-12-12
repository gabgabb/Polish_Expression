package plep.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        javax.servlet.Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/";
        String createURI = request.getContextPath() + "/ajouter";

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        boolean loggedIn = session != null && session.getAttribute("logUtilisateur") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean createRequest = request.getRequestURI().equals(createURI);

        if (loggedIn || loginRequest || createRequest || request.getRequestURI().endsWith(".css")) {
            filterChain.doFilter(request, response);
        } else {
            String error = "Veuillez vous connecter ou créer un compte.";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/login").forward(request,response);
        }
    }

    @Override
    public void destroy() {
        javax.servlet.Filter.super.destroy();
    }
}
