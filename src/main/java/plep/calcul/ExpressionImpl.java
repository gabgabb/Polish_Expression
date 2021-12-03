package plep.calcul;

import plep.utils.TypeOperateur;

import java.util.Stack;

public class ExpressionImpl implements Expression {

    // Génère une pile de calcul selon une difficulté précisé
    @Override
    public Stack empile(int difficulte) {

        Stack pile = new Stack();

        for (int i = 0; i < difficulte; i++) {

            if (i + 1 == difficulte) {

                int operateur = (int) (Math.random() * 6);
                Operateur ope = new Operateur(operateur);
                ajoutPileOperant(ope, pile);

                if (ope.isBinaire()) {
                    if (ope.operateur == 2) {
                        ajoutPileNombre((int) ((Math.random() * 9) + 1), pile);
                        ajoutPileNombre((int) ((Math.random() * 9) + 1), pile);
                    } else {
                        ajoutPileNombre((int) (Math.random() * 10), pile);
                        ajoutPileNombre((int) (Math.random() * 10), pile);
                    }
                } else {
                    ajoutPileNombre((int) (Math.random() * 10), pile);
                }

            } else if (i == 0) {
                int operateur = (int) (Math.random() * 6);
                Operateur ope = new Operateur(operateur);
                ajoutPileOperant(ope, pile);

                if (ope.isBinaire()) {
                    ajoutPileNombre((int) (Math.random() * 10), pile);
                }
            } else {

                int operateur = (int) (Math.random() * 4);
                Operateur ope = new Operateur(operateur);
                ajoutPileOperant(ope, pile);

                if (!(ope.isBinaire())) {
                    if ((int) (Math.random() * 2) == 1) {
                        ajoutPileNombre((int) (Math.random() * 10), pile);
                    } else {
                        operateur = (int) ((Math.random() * 2) + 3);
                        Operateur ope2 = new Operateur(operateur);
                        ajoutPileOperant(ope2, pile);

                    }
                } else if (ope.operateur == 2) {
                    ajoutPileNombre((int) ((Math.random() * 9) + 1), pile);
                } else {
                    ajoutPileNombre((int) (Math.random() * 10), pile);
                }
            }
        }
        return pile;
    }

    // Dépile pour faire le calcul du résultat
    @Override
    public int depile(Stack pileCalcul) {
        Stack pileResultat = new Stack();

        while (pileCalcul.size() > 0) {

            if (pileCalcul.peek() instanceof Operateur) {
                Operateur ope = (Operateur) pileCalcul.pop();

                if (ope.isBinaire()) {
                    int chiffre1 = (int) pileResultat.pop();
                    int chiffre2 = (int) pileResultat.pop();
                    ajoutPileNombre(calcul(chiffre1, chiffre2, ope), pileResultat);

                } else {
                    int chiffre1 = (int) pileResultat.pop();
                    ajoutPileNombre(calcul(chiffre1, ope), pileResultat);
                }
            } else {
                pileResultat.push(pileCalcul.pop());

            }
        }
        System.out.println("Résultat :" + pileResultat.peek());
        return (int) pileResultat.peek();
    }

    // Ajout d'un opérant à la pile
    @Override
    public void ajoutPileOperant(Operateur operande, Stack pile) {
        pile.push(operande);
    }

    @Override
    public void ajoutPileNombre(int operante, Stack pile) {
        pile.push(operante);
    }

    public int calcul(int c1, int c2, Operateur ope) {

        switch (TypeOperateur.values()[ope.operateur]) {
            case PLUS:
                ope.res = "+";
                return c1 + c2;
            case MOINS:
                ope.res = "-";
                return c2 - c1;
            case DIVISE:
                ope.res = "/";
                return c2 / c1;
            case MULTIPLIE:
                ope.res = "*";
                return c1 * c2;
        }
        return 0;
    }

    public int calcul(int c1, Operateur ope) {
        switch (TypeOperateur.values()[ope.operateur]) {
            case RACINE:
                ope.res = "√";
                return (int) Math.sqrt(c1);
            case INVERSE:
                ope.res = "inv";
                return (int) Math.pow(c1, -1);
        }
        return 0;
    }

    public String toStringPile(Stack pile) {

        if (pile.peek() instanceof Integer) {
            return String.valueOf(pile.pop());
        }
        if (pile.peek() instanceof Operateur) {
            Operateur ope = (Operateur) pile.pop();

            if (!(ope.isBinaire())) {
                return ("( " + TypeOperateur.mapping(TypeOperateur.values()[ope.operateur]) + " (  " + toStringPile(pile) + " )" + " )");

            } else {
                String premier = toStringPile(pile);
                String second = toStringPile(pile);

                return ("( " + second + " " + TypeOperateur.mapping(TypeOperateur.values()[ope.operateur]) + " " + premier + " )");
            }
        }
        return null;
    }
}
