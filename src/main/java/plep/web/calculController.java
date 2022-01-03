package plep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.stream.Collectors;

import org.json.JSONObject;
import plep.entite.Partie;
import plep.utils.Constantes;

@WebServlet("/calculMental")
public class calculController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Getter pour afficher le premier calcul
        int diff = Integer.parseInt((String) req.getSession().getAttribute("difficulte"));
        int nbCalcul = 0;
        int score = 0;

        Stack calcul = Constantes.CALCUL_WEB.GenerationPile(diff);

        req.getSession().setAttribute("Score", score);
        req.getSession().setAttribute("nbCalcul", nbCalcul);
        req.getSession().setAttribute("ReponseCalcul", Constantes.CALCUL_WEB.resultatCalcul(calcul));
        req.getSession().setAttribute("StringCalcul", Constantes.CALCUL_WEB.afficherCalcul(calcul));

        req.getRequestDispatcher("/WEB-INF/view/calcul/jeu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int nbCalcul = (Integer) req.getSession().getAttribute("nbCalcul");
        int score = (Integer) req.getSession().getAttribute("Score");

        JSONObject sendToAjax = new JSONObject();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        // On effectue 10 calculs avant d'afficher le score
        if (nbCalcul <= 10) {
            // Permet de récupérer les datas du ajax envoyé
            String data = req.getReader().lines().collect(Collectors.joining());
            JSONObject jsondata = new JSONObject(data);

            boolean bonneReponse = false;

            // Vérification pour le premier calcul
            if (nbCalcul == 0) {

                Object reponsePremierCalcul = req.getSession().getAttribute("ReponseCalcul");

                if (Constantes.CALCUL_WEB.verifReponseCalcul((Double) reponsePremierCalcul, Double.parseDouble((String) jsondata.get("reponse")))) {
                    score++;
                    bonneReponse = true;
                }
                nbCalcul++;
                // Vérification pour les 9 autres calculs
            } else if (nbCalcul != 10) {

                if (Constantes.CALCUL_WEB.verifReponseCalcul((Double) req.getSession().getAttribute("ReponsePrecedente"), Double.parseDouble((String) jsondata.get("reponse")))) {
                    score++;
                    req.getSession().setAttribute("Score", score);
                    bonneReponse = true;
                }
                nbCalcul++;
                // Affichage du score si dernier calcul a été effectué et redirige à la page profil
                if (nbCalcul == 10) {
                    sendToAjax.put("score", score);
                    Constantes.PARTIE_BDD.enregistrerScore((Partie) req.getSession().getAttribute("Partie"), score);
                    sendToAjax.put("redirect", "profil");
                }
            }
            // Génère le calcul suivant et envoie les informations à l'ajax comme la l'affichage ou la réponse
            if (nbCalcul != 10) {
                sendToAjax.put("bonneReponse", bonneReponse);
                Stack calc = Constantes.CALCUL_WEB.GenerationPile(Integer.parseInt((String) req.getSession().getAttribute("difficulte")));
                double reponseCalcul = Constantes.CALCUL_WEB.resultatCalcul(calc);
                sendToAjax.put("affichageCalcul", Constantes.CALCUL_WEB.afficherCalcul(calc));
                req.getSession().setAttribute("ReponsePrecedente", reponseCalcul);
            }
            // Incrémente le nombre de calcul
            req.getSession().setAttribute("nbCalcul", nbCalcul);
            sendToAjax.put("nbCalcul", nbCalcul);

            // Envoie du json à l'ajax
            writer.append(sendToAjax.toString());
        }
    }
}



