package plep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static plep.utils.Constantes.UTILISATEUR_BDD;

@WebServlet("/login")
public class loginUtilisateurController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String error;

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(UTILISATEUR_BDD.checkLogin(username,password)!=null){
            req.setAttribute("utilisateurs", UTILISATEUR_BDD.recupUtilisateur(10));
            UTILISATEUR_BDD.setLogUser(req.getSession(), UTILISATEUR_BDD.checkLogin(username,password));

            this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/listerUtilisateur.jsp").forward(req, resp);
        } else {
            error="Username ou mot de passe incorrect.";
            req.setAttribute("error", error);
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(req, resp);

        }

    }
}
