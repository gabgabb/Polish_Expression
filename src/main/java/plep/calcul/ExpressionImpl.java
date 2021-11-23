package plep.calcul;

import plep.utils.TypeOperateur;

import java.util.Stack;

public class ExpressionImpl implements Expression {

    @Override
    public Stack empile() {
        Stack pile = new Stack();

        for(int i=0; i<Math.random()*3;i++){
            int operateur = (int) (Math.random()*5);
            Operateur ope = new Operateur(operateur);

            if(ope.isBinaire()) {
                ajoutPileNombre((int) (Math.random() * 10), pile);
                ajoutPileNombre((int) (Math.random() * 10), pile);
            } else {
                ajoutPileNombre((int) (Math.random() * 10), pile);
            }
            ajoutPileOperant(ope, pile);

        }
        System.out.println(pile.toString());
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
                return c1+c2;
            case MOINS:
                return c1-c2;
            case DIVISE:
                return c1/c2;
            case MULTIPLIE:
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
}
