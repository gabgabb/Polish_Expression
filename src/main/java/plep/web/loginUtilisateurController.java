package plep.web;

import org.json.JSONObject;

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

@WebServlet("/login")
public class loginUtilisateurController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        // Permet de lire les données envoyés dans le json depuis l'ajax
        JSONObject sendToAjax = new JSONObject();
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String jsonString = "";
        jsonString = br.readLine();
        JSONObject receiveJson = new JSONObject(jsonString);

        String username = (String) receiveJson.get("usernamedata");
        String pwd = (String) receiveJson.get("pwddata");

        // Vérifie si l'utilisateur existe
        if (UTILISATEUR_BDD.checkLogin(username, pwd) != null) {
            // Redirige à la page d'acceuil et fixe l'utilisateur à la session
            UTILISATEUR_BDD.setLogUser(req.getSession(), UTILISATEUR_BDD.checkLogin(username, pwd));
            sendToAjax.put("redirect", "meilleur_score");
            writer.append(sendToAjax.toString());
        } else {
            // Renvoie à l'ajax l'erreur
            String error = "Mot de passe ou username incorrect.";
            sendToAjax.put("errorLogin", error);
            writer.append(sendToAjax.toString());
        }
    }
}
