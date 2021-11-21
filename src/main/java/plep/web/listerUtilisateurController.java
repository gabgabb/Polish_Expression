package plep.web;

import plep.entite.Utilisateur;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static plep.utils.Constantes.*;


@WebServlet("/utilisateur/lister")
public class listerUtilisateurController extends HttpServlet {

    public listerUtilisateurController() {
            super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Utilisateur> listerUser = CONNEXION_BDD.recupUtilisateur();

        request.setAttribute("utilisateurs", listerUser);
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/listerUtilisateur.jsp").forward(request, response);
    }
}
