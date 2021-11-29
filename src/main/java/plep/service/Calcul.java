package plep.service;

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

    public int suiteCalcul(int diff, int reponseUtilisateur){
        int nbCalcul=0;
        int score =0;
        while(nbCalcul<=9){
            afficherCalcul(diff);
            Stack calculpile = GenerationPile(diff);
            int resultat = resultatPile(calculpile);

            if(verifReponseCalcul(resultat, reponseUtilisateur)){
                score++;
            }
            nbCalcul++;
        }
        return score;
    }
}
