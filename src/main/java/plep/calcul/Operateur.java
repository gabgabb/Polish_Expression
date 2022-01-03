package plep.calcul;

public class Operateur {

    public int operateur;
    public String res;

    // Constructeur opérateur
    public Operateur(int operateur) {
        this.operateur = operateur;
        this.res = "";
    }

    // Vérifie si l'opérateur est < à 4
    public boolean isBinaire() {
        return this.operateur < 4;
    }

}