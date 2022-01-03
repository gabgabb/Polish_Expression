package plep.service;

import plep.entite.Partie;
import plep.entite.Utilisateur;
import plep.utils.Constantes;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class PartieBDD {

    // Enregistre le score
    public void enregistrerScore(Partie partie, int score) {

        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();
        String sql = "UPDATE partie SET score = ? WHERE idpartie = ? ;";

        try {
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setInt(1, score);
            statement.setInt(2, partie.getIdPartie());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Créé la partie dans la BDD
    public Partie creationPartie(Utilisateur user) {
        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();

        Date date = new Date();
        Partie nouvellePartie = new Partie();

        nouvellePartie.setDatePartie(date);
        nouvellePartie.setUtilisateur(user);

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO partie(datePartie, usernamePartie) VALUES(?, ?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, new java.sql.Date(nouvellePartie.getDate().getTime()));
            preparedStatement.setString(2, user.getUsername());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    nouvellePartie.setIdPartie((int) generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture de la connexion
            Constantes.CONNEXION_BDD.fermetureConnexion(connexion);
        }
        return nouvellePartie;
    }

    // Calcul la moyenne des parties d'un utilisateur
    public int calculMoyenne(Utilisateur user){
        List<Partie> ListePartie = Constantes.UTILISATEUR_BDD.recupPartieUtilisateur(user.getUsername());
        int moyenne = 0;
        for (Partie partie: ListePartie) {
            moyenne+=partie.getScore();
        }
        moyenne = moyenne/ListePartie.size();
        return moyenne;
    }

    // Retourne le nombre de parties effectuées par un utilisateur
    public int nbPartie(Utilisateur user) {
        List<Partie> ListePartie = Constantes.UTILISATEUR_BDD.recupPartieUtilisateur(user.getUsername());
        int nbPartie = 0;
        for (Partie partie : ListePartie) {
            nbPartie++;
        }
        return nbPartie;
    }
}
