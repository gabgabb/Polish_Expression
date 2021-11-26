package plep.service;

import plep.calcul.Expression;
import plep.calcul.ExpressionImpl;
import plep.utils.Constantes;

import java.util.Stack;

public class Calcul {

    public Stack GenerationPile(int difficulte){
        return Constantes.EXPRESSION.empile(difficulte);
    }

    public String afficherCalcul(int difficulte){

        String affichageCalcul = "";
        affichageCalcul = Constantes.EXPRESSION.calculHumain(GenerationPile(difficulte));

        return affichageCalcul;
    }

    public int resultatPile(Stack pile){
        return Constantes.EXPRESSION.depile(pile);
    }

    public boolean verifReponseCalcul(int resultatPile,int reponse){

        boolean bonneReponse=false;

        if(resultatPile==reponse) {
            bonneReponse=true;

        }
        return bonneReponse;
    }

}
