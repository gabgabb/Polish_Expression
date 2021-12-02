package plep.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Stack;
import static plep.utils.Constantes.CALCUL;
import com.google.gson.Gson;
import org.json.JSONObject;



@WebServlet("/calculMental")
public class calculController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //if (UTILISATEUR_BDD.getLogUser(req.getSession()) != null) {
             //int diff = (int) req.getAttribute("difficulte");
            Stack calcul = CALCUL.GenerationPile(2);
            req.setAttribute("ReponseCalcul", CALCUL.resultatCalcul(calcul));
            req.setAttribute("StringCalcul", CALCUL.afficherCalcul(calcul));
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/calcul/jeu.jsp").forward(req, resp);
        /*} else {
            String error = "Veuillez vous connecter ou créer un compte.";
            req.setAttribute("error", error);
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(req, resp);

        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        int nbCalcul = 0;
        int score = 0;
        while (nbCalcul <= 2) {
            Stack calc = CALCUL.GenerationPile(1);
            int res = CALCUL.resultatCalcul(calc);
            if (nbCalcul == 0) {
                if (CALCUL.verifReponseCalcul(Integer.parseInt(req.getParameter("ReponseCalcul")), Integer.parseInt(req.getParameter("response")))) {
                    score++;
                }
            }
             else if(CALCUL.verifReponseCalcul(res,Integer.parseInt(req.getParameter("reponse")))) {
                score++;
            }
                nbCalcul++;
                System.out.println(nbCalcul);
                int reponse = Integer.parseInt(req.getParameter("reponse"));
                System.out.println(reponse);*/
                JSONObject data = new Gson().fromJson(req.getReader(), JSONObject.class);
                System.out.println("CONTER : " + data.get("nbCalcul"));
                System.out.println("REPONSE : " + data.get("reponse"));
                resp.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.

                Stack calc = CALCUL.GenerationPile(1);
                String aff = CALCUL.afficherCalcul(calc);
                resp.getWriter().write(aff);
                }
            //UTILISATEUR_BDD.enregistrerScore(UTILISATEUR_BDD.getLogUser(req.getSession()), score);
            //resp.getWriter().write(score);
        }
    //}



