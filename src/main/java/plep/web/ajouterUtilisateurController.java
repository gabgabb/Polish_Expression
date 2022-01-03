package plep.web;

import org.json.JSONObject;
import plep.entite.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static plep.utils.Constantes.UTILISATEUR_BDD;

@WebServlet("/ajouter")
public class ajouterUtilisateurController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/ajouterUtilisateur.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bouton = request.getParameter("Creer");
        // Permet de lire les données envoyés dans le json depuis l'ajax
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonString = "";
        jsonString = br.readLine();

        JSONObject sendToAjax = new JSONObject();
        // On crée un json si le bouton submit n'a pas été cliqué
        JSONObject receiveJson = null;
        if (bouton == null) {
            receiveJson = new JSONObject(jsonString);
        }

        boolean estUtilise = false;
        // Vérifie si l'username n'est pas null et que l'username est disponible
        if (request.getParameter("username") != null && UTILISATEUR_BDD.usernameAvailable(request.getParameter("username"))) {
            // Vérifie si tous les champs sont remplis
            if (request.getParameter("prenom") != null && request.getParameter("nom") != null
                    && request.getParameter("username") != null && request.getParameter("password") != null
                    && request.getParameter("Creer") != null) {
                // Créé un nouvel utilisateur et l'ajoute à la BDD
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setPrenom(request.getParameter("prenom"));
                utilisateur.setNom(request.getParameter("nom"));
                utilisateur.setUsername(request.getParameter("username"));
                utilisateur.setPassword(request.getParameter("password"));

                UTILISATEUR_BDD.ajouterUtilisateur(utilisateur);
                this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(request, response);
            }
        }
        if (UTILISATEUR_BDD.usernameAvailable((String) receiveJson.get("usernamedata"))) {
            estUtilise = false;
        } else {
            estUtilise = true;
        }
        // Vérifie si usernamedata n'est pas null et envoie le booléen pour vérifier si l'username est disponible ou non
        if (receiveJson.get("usernamedata") != null) {
            sendToAjax.put("estUtilise", estUtilise);
            sendToAjax.put("username", receiveJson.get("usernamedata"));
            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();
            writer.append(sendToAjax.toString());
        }
    }
}
