package plep.web;

import plep.service.Calcul;
import plep.utils.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static plep.utils.Constantes.UTILISATEUR_BDD;

@WebServlet("/calculMental")
public class calculController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calcul ConstCalcul = Constantes.CALCUL;

        //if (UTILISATEUR_BDD.getLogUser(req.getSession()) != null) {
             int diff = (int) req.getAttribute("difficulte");
            req.setAttribute("calcul", ConstCalcul.afficherCalcul(ConstCalcul.GenerationPile(diff)));
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/calcul/jeu.jsp").forward(req, resp);
        /*} else {
            String error = "Veuillez vous connecter ou créer un compte.";
            req.setAttribute("error", error);
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(req, resp);

        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
