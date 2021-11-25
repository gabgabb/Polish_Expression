package plep.calcul;
import plep.utils.TypeOperateur;

import java.util.Random;

public class Operateur {

    public int operateur;
    public String res;

    public Operateur(int operateur) {
        this.operateur = operateur;
        this.res="";
    }

    public boolean isBinaire() {
        return this.operateur<4;
    }

}