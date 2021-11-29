package plep.web;

import plep.entite.Utilisateur;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static plep.utils.Constantes.UTILISATEUR_BDD;

@WebServlet("/ajouter")
public class ajouterUtilisateurController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/ajouterUtilisateur.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(request.getParameter("prenom"));
        utilisateur.setNom(request.getParameter("nom"));
        utilisateur.setUsername(request.getParameter("username"));
        utilisateur.setPassword(request.getParameter("password"));

        if(UTILISATEUR_BDD.usernameAvailable(utilisateur)) {

            out.println("<span style='color:green;'>Username available</span>");
            UTILISATEUR_BDD.ajouterUtilisateur(utilisateur);

            this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(request, response);
        } else {
            out.print("<span style='color:red;'>Username unavailable</span>");
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/ajouterUtilisateur.jsp").forward(request, response);
        }






    }
}