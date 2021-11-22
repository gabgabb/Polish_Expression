package plep.web;

import plep.entite.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static plep.utils.Constantes.CONNEXION_BDD;

@WebServlet("/ajouter")
public class ajouterUtilisateurController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/ajouterUtilisateur.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(request.getParameter("prenom"));
        utilisateur.setNom(request.getParameter("nom"));
        utilisateur.setUsername(request.getParameter("username"));
        utilisateur.setPassword(request.getParameter("password"));

        CONNEXION_BDD.ajouterUtilisateur(utilisateur);

        request.setAttribute("utilisateurs", CONNEXION_BDD.recupTopUtilisateur());

        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/listerUtilisateur.jsp").forward(request, response);
    }
}