package plep.utils;

import plep.calcul.ExpressionImpl;
import plep.calcul.CalculWeb;
import plep.service.PartieBDD;
import plep.service.ConnexionBDD;
import plep.service.UtilisateurBDD;

public interface Constantes {

    ConnexionBDD CONNEXION_BDD = new ConnexionBDD();
    UtilisateurBDD UTILISATEUR_BDD = new UtilisateurBDD();
    ExpressionImpl EXPRESSION = new ExpressionImpl();
    CalculWeb CALCUL_WEB = new CalculWeb();
    PartieBDD PARTIE_BDD = new PartieBDD();

}
