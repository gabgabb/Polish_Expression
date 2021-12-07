package plep.entite;

import java.util.Date;

public class Partie {

    private String username;
    private Date datePartie;
    private int score;

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public Date getDatePartie() {
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
