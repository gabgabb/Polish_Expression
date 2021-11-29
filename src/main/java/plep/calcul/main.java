package plep.calcul;

import plep.service.Calcul;

import java.util.Stack;

public class main {
    public static void main(String[] args) {

       Calcul cal = new Calcul();
       Stack pile = cal.GenerationPile(3);
        System.out.println(pile);
        cal.afficherCalcul(pile);
        System.out.println(cal.afficherCalcul(pile));

        System.out.println("Résultat = " + cal.resultatCalcul(pile));

    }
}
