package plep.entite;

import java.util.Date;

public class Partie {

    private Utilisateur user;
    private Date datePartie;
    private int score;

    public Utilisateur getUtilisateur() {
        return user;
    }

    public void setUtilisateur(Utilisateur user) {
        this.user = user;
    }

    public Date getDate() {
        return datePartie;
    }

    public void setDatePartie(Date datePartie) {
        this.datePartie = datePartie;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
