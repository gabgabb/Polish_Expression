package plep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static plep.utils.Constantes.*;


@WebServlet("/meilleur_score")
public class listerUtilisateurController extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.setAttribute("utilisateurs", CONNEXION_BDD.recupUtilisateur());
            request.getRequestDispatcher("/WEB-INF/view/utilisateur/listerUtilisateur.jsp").forward(request, response);
        }
}
