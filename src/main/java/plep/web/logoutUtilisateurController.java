package plep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class logoutUtilisateurController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String message = "Déconnexion effectuée";
            req.setAttribute("error", message);
            req.removeAttribute("logUtilisateur");
            req.getSession().invalidate();
            req.getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(req,resp);

    }
}
