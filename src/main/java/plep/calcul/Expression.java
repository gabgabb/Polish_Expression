package plep.calcul;

import java.util.Stack;

// Interface d'implémentation des fonctions de calcul
public interface Expression {

    public Stack empile(int difficulte);

    public double depile(Stack pile);

    public void ajoutPileOperant(Operateur operande, Stack pile);

    public void ajoutPileNombre(double operante, Stack pile);

    public double calcul(double c1, double c2, Operateur ope);

    public double calcul(double c1, Operateur ope);

    public String toStringPile(Stack pile);

}
