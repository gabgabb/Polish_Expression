package plep.web;

import plep.entite.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static plep.utils.Constantes.PARTIE_BDD;
import static plep.utils.Constantes.UTILISATEUR_BDD;

@WebServlet("/profil")
public class profilUtilisateurController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fixe les variables à afficher sur la page profil selon l'utilisateur
        Utilisateur user = UTILISATEUR_BDD.getLogUser(req.getSession());
        req.getSession().setAttribute("parties", UTILISATEUR_BDD.recupPartieUtilisateur(user.getUsername()));
        req.getSession().setAttribute("nom", UTILISATEUR_BDD.infoUser(user.getUsername()).getNom());
        req.getSession().setAttribute("prenom", UTILISATEUR_BDD.infoUser(user.getUsername()).getPrenom());
        req.getSession().setAttribute("username", user.getUsername());
        req.getSession().setAttribute("nbpartie", PARTIE_BDD.nbPartie(user));
        req.getSession().setAttribute("moyenne", PARTIE_BDD.calculMoyenne(user));

        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/profileUtilisateur.jsp").forward(req, resp);
    }
}

