package plep.calcul;

import java.util.Stack;

public class main {
    public static void main(String[] args) {

        ExpressionImpl expression = new ExpressionImpl();

        Stack pile= expression.empile(2);
        expression.calculHumain(pile);
        expression.depile(pile);

    }
}
