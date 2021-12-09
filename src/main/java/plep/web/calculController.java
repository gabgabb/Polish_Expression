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

        int diff = Integer.parseInt((String) req.getSession().getAttribute("difficulte"));
        System.out.print(diff);
        int nbCalcul = 0;
        int score = 0;
        Stack calcul = Constantes.CALCUL_WEB.GenerationPile(diff);
        req.setAttribute("Score", score);
        req.getAttribute("Score");
        req.setAttribute("nbCalcul", nbCalcul);
        req.getAttribute("nbCalcul");
        int resultat = Constantes.CALCUL_WEB.resultatCalcul(calcul);
        req.getSession().setAttribute("ReponseCalcul", resultat);
        System.out.println(" resultat" + resultat);
        String Stringcalc = Constantes.CALCUL_WEB.afficherCalcul(calcul);
        req.getSession().setAttribute("StringCalcul", Stringcalc);

        req.getServletContext().getRequestDispatcher("/WEB-INF/view/calcul/jeu.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nbCalcul = (Integer) req.getSession().getAttribute("nbCalcul");
        int score = (Integer) req.getSession().getAttribute("Score");

        if (nbCalcul <= 10) {

            String data = req.getReader().lines().collect(Collectors.joining());

            JSONObject jsondata = new JSONObject(data);
            System.out.println("yakak" + jsondata);

            JSONObject sendToAjax = new JSONObject();

            boolean bonneReponse = false;

            if (nbCalcul == 0) {

                Object reponsePremierCalcul = req.getSession().getAttribute("ReponseCalcul");

                if (Constantes.CALCUL_WEB.verifReponseCalcul((Integer) reponsePremierCalcul, Integer.parseInt((String) jsondata.get("reponse")))) {
                    score++;
                    System.out.println("SCORE 1: " + score);
                    bonneReponse = true;
                }
                nbCalcul++;
            } else if (nbCalcul != 10) {

                if (Constantes.CALCUL_WEB.verifReponseCalcul((Integer) req.getSession().getAttribute("ReponsePrecedente"), Integer.parseInt((String) jsondata.get("reponse")))) {
                    score++;
                    req.getSession().setAttribute("Score", score);
                    bonneReponse = true;
                }
                nbCalcul++;
                if (nbCalcul == 10) {
                    System.out.println("SCORE : " + score);
                    sendToAjax.put("score", score);
                    System.out.print(req.getSession().getAttribute("logUtilisateur"));
                    Constantes.PARTIE_BDD.enregistrerScore((Partie) req.getAttribute("Partie"), score);
                }
            }

            if (nbCalcul != 10) {
                sendToAjax.put("bonneReponse", bonneReponse);
                Stack calc = Constantes.CALCUL_WEB.GenerationPile(Integer.parseInt((String) req.getSession().getAttribute("difficulte")));
                int reponseCalcul = Constantes.CALCUL_WEB.resultatCalcul(calc);
                sendToAjax.put("affichageCalcul", Constantes.CALCUL_WEB.afficherCalcul(calc));
                req.getSession().setAttribute("ReponsePrecedente", reponseCalcul);
            }
            req.getSession().setAttribute("nbCalcul", nbCalcul);
            sendToAjax.put("nbCalcul", nbCalcul);

            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();

            writer.append(sendToAjax.toString());
        } else {
            resp.sendRedirect("meilleur_score");
        }
    }

}



