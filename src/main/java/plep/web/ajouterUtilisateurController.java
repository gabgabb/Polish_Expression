package plep.web;

import com.google.gson.Gson;
import org.json.JSONObject;
import plep.entite.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import static plep.utils.Constantes.UTILISATEUR_BDD;

@WebServlet("/ajouter")
public class ajouterUtilisateurController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/ajouterUtilisateur.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("usernameData");
        System.out.println("USERNAME : " + username);
        JSONObject sendToAjax = new JSONObject();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(request.getParameter("prenom"));
        utilisateur.setNom(request.getParameter("nom"));
        utilisateur.setUsername(request.getParameter("username"));
        utilisateur.setPassword(request.getParameter("password"));

        if (UTILISATEUR_BDD.usernameAvailable(username)){

            UTILISATEUR_BDD.ajouterUtilisateur(utilisateur);
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(request, response);
        } else {
            boolean estUtilise = true;
            sendToAjax.put("estUtilise", estUtilise);
            sendToAjax.put("username", username);
            System.out.println(" sendtoajax 2 : " +  sendToAjax);
            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();
            writer.append(sendToAjax.toString());

        }
    }
}