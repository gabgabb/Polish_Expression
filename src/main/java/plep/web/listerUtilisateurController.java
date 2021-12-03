package plep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static plep.utils.Constantes.*;


@WebServlet("/meilleur_score")
public class listerUtilisateurController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UTILISATEUR_BDD.getLogUser(request.getSession()) != null) {
            request.setAttribute("difficulte", request.getParameter("diff"));
            request.setAttribute("utilisateurs", UTILISATEUR_BDD.recupUtilisateur(10));
            request.getRequestDispatcher("/WEB-INF/view/utilisateur/listerUtilisateur.jsp").forward(request, response);
        } else {
            String error = "Veuillez vous connecter ou créer un compte.";
            request.setAttribute("error", error);
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(request, response);

        }
    }
}
