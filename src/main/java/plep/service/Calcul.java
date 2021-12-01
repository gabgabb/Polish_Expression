package plep.service;

import plep.utils.Constantes;
import java.util.Stack;

public class Calcul {

    public Stack GenerationPile(int difficulte){
        return Constantes.EXPRESSION.empile(difficulte);
    }

    public String afficherCalcul(Stack pile){

        Stack cloneCalcul = (Stack) pile.clone();
        Stack pileBonOrdre = new Stack<>();

        while(cloneCalcul.size()>0){
            pileBonOrdre.push(cloneCalcul.pop());

        }
        System.out.println(pileBonOrdre);

        return Constantes.EXPRESSION.toStringPile(pileBonOrdre);

    }

    public int resultatCalcul(Stack pile){
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
