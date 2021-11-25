package plep.calcul;
import java.util.Stack;

public interface Expression {

    public Stack empile(int difficulte);

    public int depile(Stack pile);

    public void ajoutPileOperant(Operateur operande, Stack pile);

    public void ajoutPileNombre(int operante, Stack pile);

    public int calcul(int c1, int c2, Operateur ope);

    public int calcul(int c1, Operateur ope);

    public String calculHumain(Stack pile);
}
