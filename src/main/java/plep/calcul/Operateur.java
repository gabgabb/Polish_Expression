package plep.calcul;
import java.util.Random;

public class Operateur {

    public int operateur;

    public Operateur(int operateur) {
        this.operateur = operateur;
    }

    public boolean isBinaire() {
        return this.operateur<4;
    }


}