package plep.utils;

import plep.calcul.ExpressionImpl;
import plep.service.Calcul;
import plep.service.ConnexionBDD;
import plep.service.UtilisateurBDD;

public interface Constantes {

    ConnexionBDD CONNEXION_BDD = new ConnexionBDD();
    UtilisateurBDD UTILISATEUR_BDD = new UtilisateurBDD();
    ExpressionImpl EXPRESSION = new ExpressionImpl();
    Calcul CALCUL = new Calcul();
}
