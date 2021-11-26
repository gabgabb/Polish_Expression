package plep.service;

import plep.entite.Utilisateur;
import plep.utils.Constantes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurBDD {

    // Récupère la liste des utilisateurs de la BDD
    public List<Utilisateur> recupUtilisateur(int limit) {

        List<Utilisateur> utilisateurs = new ArrayList<>();
        Statement statement;
        ResultSet resultat = null;

        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();

        try {
            statement = connexion.createStatement();
            if( limit > 0) {
                // Exécution de la requête
                resultat = statement.executeQuery("SELECT username,score FROM utilisateur ORDER BY score DESC LIMIT " + limit + ";");
                System.out.println(resultat);
            } else {
                resultat = statement.executeQuery("SELECT username,password FROM utilisateur ;");
            }
            // Récupération des données
            while (resultat.next()) {
                String username = resultat.getString("username");
                int score = resultat.getInt("score");

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setUsername(username);
                utilisateur.setScore(score);

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException ignored) {

        } finally {
            // Fermeture de la connexion
            Constantes.CONNEXION_BDD.fermetureConnexion(resultat, connexion);
        }
        return utilisateurs;
    }

    // Ajoute un utilisateur à la BDD depuis le formulaire
    public void ajouterUtilisateur(Utilisateur utilisateur) {

        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();

        String username = utilisateur.getUsername();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur(prenom, nom, username, password) VALUES(?, ?, ?, SHA1(?));");
            preparedStatement.setString(1, utilisateur.getPrenom());
            preparedStatement.setString(2, utilisateur.getNom());
            preparedStatement.setString(3, utilisateur.getUsername());
            preparedStatement.setString(4, utilisateur.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Fermeture de la connexion
            Constantes.CONNEXION_BDD.fermetureConnexion(connexion);
        }
    }

    // Vérifie si le username est disponible
    public boolean usernameAvailable(Utilisateur utilisateur) {
        boolean isAvailable = true;
        String username = utilisateur.getUsername();
        ResultSet resultat = null;

        if (username.length() > 0) {
            String sql = "SELECT username from utilisateur WHERE username='" + username + "' ;";
            Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();

            try {
                Statement statement = connexion.createStatement();
                resultat = statement.executeQuery(sql);
                if (resultat.next()) {
                    isAvailable = false;
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            } finally {
                // Fermeture de la connexion
                Constantes.CONNEXION_BDD.fermetureConnexion(resultat, connexion);
            }
        }
        return isAvailable;
    }

    // Vérifie si le login est présent dans la BDD
    public boolean checkLogin(String username, String password) {

        boolean isCorrect = false;

        if (username.length() >= 4 && password.length() >= 4) {
            Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();
            String sql = "SELECT * FROM utilisateur WHERE username = ? and password = SHA1(?)";
            ResultSet resultat = null;
            try {
                PreparedStatement statement = connexion.prepareStatement(sql);

                statement.setString(1, username);
                statement.setString(2, password);

                resultat = statement.executeQuery();

                isCorrect = resultat.next();

            } catch (SQLException exception) {
                exception.printStackTrace();
            } finally {
                // Fermeture de la connexion
                Constantes.CONNEXION_BDD.fermetureConnexion(resultat, connexion);
            }
        }
        return isCorrect;
    }
}
