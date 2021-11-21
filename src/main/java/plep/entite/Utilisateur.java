package plep.entite;

public class Utilisateur {

        private String prenom;
        private String nom;
        private String username;
        private String password;
        private int score;

    public Utilisateur(String prenom, String nom, String username, String password, int score) {
        this.prenom = prenom;
        this.nom = nom;
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public String getPrenom() {return prenom;}

    public void setPrenom(String prenom) {this.prenom = prenom;}

    public String getNom() {return nom;}

    public void setNom(String nom) {this.nom = nom;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public int getScore() {return score;}

    public void setScore(int score) {this.score = score;}
}
