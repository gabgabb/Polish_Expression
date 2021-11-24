package plep.calcul;

import plep.utils.TypeOperateur;

import java.util.Stack;

public class ExpressionImpl implements Expression {

    @Override
    public Stack empile(int difficulte) {
        Stack pile = new Stack();
        // TODO faire l'empilage
        StringBuilder res= new StringBuilder();
        for(int i=0; i<difficulte;i++) {

            int operateur = (int) (Math.random() * 6);
            Operateur ope = new Operateur(operateur);
            ajoutPileOperant(ope, pile);
            res.append(toString(ope));

                if (!(ope.isBinaire())) {
                    if ((int) (Math.random() * 2) == 1) {
                        ajoutPileNombre((int) (Math.random() * 10), pile);
                    } else {
                        operateur = (int) (Math.random() * 6);
                        Operateur ope2 = new Operateur(operateur);
                        ajoutPileOperant(ope2, pile);
                        res.append(toString(ope2));

                    }
                } else {
                    ajoutPileNombre((int) (Math.random() * 10), pile);
                }

                if (i + 1 == difficulte) {
                    if (ope.isBinaire()) {
                        ajoutPileNombre((int) (Math.random() * 10), pile);
                    } else {
                        ajoutPileNombre((int) (Math.random() * 10), pile);
                    }
                }
            }

        System.out.println(res);
        System.out.println(pile);
        return pile;
    }


    @Override
    public int depile(Stack pileCalcul) {

        Stack pileResultat = new Stack();

        while(pileCalcul.size()>0){
            if(pileCalcul.peek() instanceof Operateur){
               Operateur ope = (Operateur) pileCalcul.pop();

               if(ope.isBinaire()){
                  int chiffre1 = (int) pileResultat.pop();
                  int chiffre2 = (int) pileResultat.pop();

                  ajoutPileNombre(calcul(chiffre1,chiffre2,ope), pileResultat);

               } else {

                   int chiffre1 = (int) pileResultat.pop();

                   ajoutPileNombre(calcul(chiffre1,ope),pileResultat);

               }
            } else {
                pileResultat.push(pileCalcul.pop());
            }
    }
        System.out.println(pileResultat.peek());
        return (int) pileResultat.peek();
    }

    @Override
    public void ajoutPileOperant(Operateur operande, Stack pile) {
        pile.push(operande);
    }

    @Override
    public void ajoutPileNombre(int operante, Stack pile) {
        pile.push(operante);
    }

    public int calcul(int c1, int c2, Operateur ope){

        switch (TypeOperateur.values()[ope.operateur]){
            case PLUS:
                ope.res="plus";
                return c1+c2;
            case MOINS:
                ope.res="moins";
                return c1-c2;
            case DIVISE:
                ope.res="divise";
                return c1/c2;
            case MULTIPLIE:
                ope.res="multiplie";
                return c1*c2;
        }
        return 0;
    }

    public int calcul(int c1, Operateur ope){
        switch (TypeOperateur.values()[ope.operateur]){
            case RACINE:
                return (int) Math.sqrt(c1);
            case INVERSE:
                return  (int) Math.pow(c1,-1);
        }
        return 0;
    }


    public String toString(Operateur ope){

        switch (TypeOperateur.values()[ope.operateur]){
            case PLUS:
                 return ope.res="plus";
            case MOINS:
                return ope.res="moins";
            case DIVISE:
                return ope.res="divise";
            case MULTIPLIE:
                return ope.res="multiplie";
            case INVERSE:
                return ope.res="inverse";
            case RACINE:
                return ope.res="racine";

        }
        return null;
    }
}
