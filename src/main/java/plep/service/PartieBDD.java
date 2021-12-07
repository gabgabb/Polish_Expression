package plep.service;

import plep.entite.Partie;
import plep.entite.Utilisateur;
import plep.utils.Constantes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class PartieBDD {

    public void enregistrerScore(Utilisateur user, int score) {

        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();
        String sql = "UPDATE partie SET score = ? WHERE username = ? ;";

        try {
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setInt(1, score);
            statement.setString(2, user.getUsername());
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
        nouvellePartie.setUser(user.getUsername());

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO partie(datePartie, username) VALUES(?, ?);");
            preparedStatement.setDate(1, new java.sql.Date(nouvellePartie.getDatePartie().getTime()));
            preparedStatement.setString(2, user.getUsername());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture de la connexion
            Constantes.CONNEXION_BDD.fermetureConnexion(connexion);
        }

        return nouvellePartie;
    }
}