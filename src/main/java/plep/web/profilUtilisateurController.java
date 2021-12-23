package plep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static plep.utils.Constantes.UTILISATEUR_BDD;

@WebServlet("/profil")
public class profilUtilisateurController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("parties",UTILISATEUR_BDD.recupUtilisateur(UTILISATEUR_BDD.getLogUser(req.getSession()).getUsername()));
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/profileUtilisateur.jsp").forward(req, resp);
    }
}

