package plep.calcul;

import plep.utils.Constantes;

import java.util.Stack;

public class CalculWeb {

    public Stack GenerationPile(int difficulte) {
        return Constantes.EXPRESSION.empile(difficulte);
    }

    public String afficherCalcul(Stack pile) {

        Stack cloneCalcul = (Stack) pile.clone();
        Stack pileBonOrdre = new Stack<>();

        while (cloneCalcul.size() > 0) {
            pileBonOrdre.push(cloneCalcul.pop());
        }

        return Constantes.EXPRESSION.toStringPile(pileBonOrdre);

    }

    public int resultatCalcul(Stack pile) {
        Stack cloneCalcul = (Stack) pile.clone();
        return Constantes.EXPRESSION.depile(cloneCalcul);
    }

    public boolean verifReponseCalcul(int resultatPile, int reponse) {

        boolean bonneReponse = false;

        if (resultatPile == reponse) {
            bonneReponse = true;

        }
        return bonneReponse;
    }
}
