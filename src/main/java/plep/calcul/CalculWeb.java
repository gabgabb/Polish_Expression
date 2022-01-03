package plep.calcul;

import plep.utils.Constantes;

import java.util.Stack;

public class CalculWeb {

    // Génère la pile selon une difficulté
    public Stack GenerationPile(int difficulte) {
        return Constantes.EXPRESSION.empile(difficulte);
    }

    // Permet d'afficher le calcul depuis une pile
    public String afficherCalcul(Stack pile) {

        Stack cloneCalcul = (Stack) pile.clone();
        Stack pileBonOrdre = new Stack<>();

        // Clone la pile pour la push dans une nouvelle
        while (cloneCalcul.size() > 0) {
            pileBonOrdre.push(cloneCalcul.pop());
        }
        return Constantes.EXPRESSION.toStringPile(pileBonOrdre);
    }

    // Génère le résultat d'une pile
    public double resultatCalcul(Stack pile) {
        Stack cloneCalcul = (Stack) pile.clone();
        return Math.round(Constantes.EXPRESSION.depile(cloneCalcul) * 100) / 100.0;
    }

    // Vérifie si la réponse et la le résultat corresponde
    public boolean verifReponseCalcul(double resultatPile, double reponse) {
        boolean bonneReponse = false;
        if (resultatPile == reponse) {
            bonneReponse = true;
        }
        return bonneReponse;
    }
}
