package plep.service;

import plep.entite.Partie;
import plep.entite.Utilisateur;
import plep.utils.Constantes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class PartieBDD {

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

    public Partie creationPartie(Utilisateur user) {
        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();

        Date date = new Date();
        Partie nouvellePartie = new Partie();
        nouvellePartie.setDatePartie(date);
        nouvellePartie.setUtilisateur(user);

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO partie(datePartie, usernamePartie) VALUES(?, ?);");
            preparedStatement.setDate(1, new java.sql.Date(nouvellePartie.getDate().getTime()));
            preparedStatement.setString(2, user.getUsername());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture de la connexion
           // Constantes.CONNEXION_BDD.fermetureConnexion(connexion);
        }
        return nouvellePartie;
    }
}
