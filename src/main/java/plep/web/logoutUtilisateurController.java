package plep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Logout")
public class logoutUtilisateurController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.removeAttribute("logUtilisateur");
            req.getSession().invalidate();
            req.getRequestDispatcher("/WEB-INF/view/utilisateur/loginUtilisateurController.jsp").forward(req,resp);

    }
}
