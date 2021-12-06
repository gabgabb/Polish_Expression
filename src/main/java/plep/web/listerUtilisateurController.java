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
            request.setAttribute("utilisateurs", UTILISATEUR_BDD.recupUtilisateur(10));
            request.getRequestDispatcher("/WEB-INF/view/utilisateur/listerUtilisateur.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String diff = req.getParameter("diff");
            req.getSession().setAttribute("difficulte", diff);
            resp.sendRedirect("calculMental");
    }
}
