package plep.calcul;

import plep.utils.TypeOperateur;

import java.util.Stack;

public class ExpressionImpl implements Expression {

    // Génère une pile de calcul selon une difficulté précisé
    @Override
    public Stack empile(int difficulte) {
        // Créé une nouvelle pile
        Stack pile = new Stack();
        // Pour n difficulté
        for (int i = 0; i < difficulte; i++) {
            // Vérifie si la boucle suivante est égale à la difficulté
            if (i + 1 == difficulte) {
                // Génère un opérateur random
                int operateur = (int) (Math.random() * 6);
                Operateur ope = new Operateur(operateur);
                ajoutPileOperant(ope, pile);
                // S'il est binaire
                if (ope.isBinaire()) {
                    // Si l'opérateur est un divisé, évite les divisés par 0
                    if (ope.operateur == 2) {
                        ajoutPileNombre((int) (Math.random() * 9 + 1), pile);
                        ajoutPileNombre((int) (Math.random() * 9 + 1), pile);
                    } else {
                        ajoutPileNombre(Math.round(Math.random() * 10 * 100) / 100.00, pile);
                        ajoutPileNombre(Math.round(Math.random() * 10 * 100) / 100.00, pile);
                    }
                    // Si l'opérateur est unaire
                } else {
                    ajoutPileNombre(Math.round(Math.random() * 10 * 100) / 100.00, pile);
                }
                // Si c'est le premier tour de boucle
            } else if (i == 0) {
                // Génère un opérateur random
                int operateur = (int) (Math.random() * 6);
                Operateur ope = new Operateur(operateur);
                ajoutPileOperant(ope, pile);
                // Si l'opérateur est binaire
                if (ope.isBinaire()) {
                    ajoutPileNombre(Math.round(Math.random() * 10 * 100) / 100.00, pile);
                }
                // Si c'est un autre tour de boucle
            } else {
                // Génère un opérateur random
                int operateur = (int) (Math.random() * 4);
                Operateur ope = new Operateur(operateur);
                ajoutPileOperant(ope, pile);
                // Si l'opérateur est unaire
                if (!(ope.isBinaire())) {
                    // Génère soit un nombre soit un autre opérateur unaire
                    if ((int) (Math.random() * 2) == 1) {
                        ajoutPileNombre(Math.round(Math.random() * 10 * 100) / 100.00, pile);
                    } else {
                        operateur = (int) ((Math.random() * 2) + 3);
                        Operateur ope2 = new Operateur(operateur);
                        ajoutPileOperant(ope2, pile);

                    }
                } else if (ope.operateur == 2) {
                    ajoutPileNombre((int) (Math.random() * 9 + 1), pile);
                } else {
                    ajoutPileNombre(Math.round(Math.random() * 10 * 100) / 100.00, pile);
                }
            }
        }
        return pile;
    }

    // Dépile pour faire le calcul du résultat
    @Override
    public double depile(Stack pileCalcul) {
        Stack pileResultat = new Stack();

        while (pileCalcul.size() > 0) {
            // Si l'objet est un opérateur
            if (pileCalcul.peek() instanceof Operateur) {
                Operateur ope = (Operateur) pileCalcul.pop();
                // Si l'opérateur est binaire
                if (ope.isBinaire()) {
                    // Pop les deux nombres
                    double chiffre1 = (double) pileResultat.pop();
                    double chiffre2 = (double) pileResultat.pop();
                    // Effectue le calcul des deux chiffres
                    ajoutPileNombre(calcul(chiffre1, chiffre2, ope), pileResultat);
                    // Si l'opérateur est unaire
                } else {
                    // Pop un nombre
                    double chiffre1 = (double) pileResultat.pop();
                    // Effectue le calcul du chiffre
                    ajoutPileNombre(calcul(chiffre1, ope), pileResultat);
                }
                // Si l'objet est un chiffre
            } else {
                pileResultat.push(pileCalcul.pop());
            }
        }
        // Retourne le résultat
        return (double) pileResultat.peek();
    }

    // Ajout d'un opérant à la pile
    @Override
    public void ajoutPileOperant(Operateur operande, Stack pile) {
        pile.push(operande);
    }

    // Ajout d'un nombre à la pile
    @Override
    public void ajoutPileNombre(double operante, Stack pile) {
        pile.push(operante);
    }

    // Permet le calcul des opérateurs binaires
    public double calcul(double c1, double c2, Operateur ope) {

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

    // Permet le calcul des opérateurs unaires
    public double calcul(double c1, Operateur ope) {
        switch (TypeOperateur.values()[ope.operateur]) {
            case RACINE:
                ope.res = "√";
                return Math.sqrt(c1);
            case INVERSE:
                ope.res = "inv";
                return Math.pow(c1, -1);
        }
        return 0;
    }

    // Permet d'afficher la pile du calcul en affichage plus humain pour permettre le calcul mental
    public String toStringPile(Stack pile) {

        if (pile.peek() instanceof Double) {
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
