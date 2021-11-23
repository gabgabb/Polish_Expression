package plep.web;

import plep.utils.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static plep.utils.Constantes.CONNEXION_BDD;

@WebServlet("/login")
public class loginUtilisateurController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(Constantes.CONNEXION_BDD.checkLogin(username,password)){
            req.setAttribute("utilisateurs", CONNEXION_BDD.recupUtilisateur(10));
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/utilisateur/listerUtilisateur.jsp").forward(req, resp);
        } else {
            out.print("Sorry username or password error");

        }

        out.close();
    }
}
