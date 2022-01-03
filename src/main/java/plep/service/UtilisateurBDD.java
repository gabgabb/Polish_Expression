package plep.service;

import plep.entite.Partie;
import plep.entite.Utilisateur;
import plep.utils.Constantes;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurBDD {

    // Récupère le top 10 des utilisateurs de la BDD
    public List<Partie> recupTopUser() {

        List<Partie> ListPartie = new ArrayList<>();

        Statement statement;
        ResultSet resultat = null;

        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();

        try {
            statement = connexion.createStatement();
            // Exécution de la requête
            resultat = statement.executeQuery("SELECT username, score, datePartie, COUNT(idpartie) OVER (PARTITION BY username ) as nbPartie FROM utilisateur INNER JOIN partie ON utilisateur.username = partie.usernamePartie ORDER BY score DESC LIMIT 10 ;");

            // Récupération des données
            while (resultat.next()) {
                String username = resultat.getString("username");
                int score = resultat.getInt("score");
                Date date = resultat.getDate("datePartie");
                int nbPartie = resultat.getInt("nbPartie");

                Utilisateur utilisateur = new Utilisateur();
                Partie partie = new Partie();

                utilisateur.setUsername(username);
                utilisateur.setNbPartie(nbPartie);
                partie.setScore(score);
                partie.setDatePartie(date);
                partie.setUtilisateur(utilisateur);

                ListPartie.add(partie);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture de la connexion
            Constantes.CONNEXION_BDD.fermetureConnexion(resultat, connexion);
        }
        return ListPartie;
    }

    // Récupère les parties d'un utilisateur
    public List<Partie> recupPartieUtilisateur(String usernameProfile) {

        List<Partie> ListPartie = new ArrayList<>();

        Statement statement;
        ResultSet resultat = null;

        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();

        try {
            statement = connexion.createStatement();
            // Exécution de la requête
            resultat = statement.executeQuery("SELECT username, score, datePartie, COUNT(idpartie) OVER (PARTITION BY username ) as nbPartie FROM utilisateur INNER JOIN partie ON utilisateur.username = partie.usernamePartie  WHERE username='" + usernameProfile + "' ORDER BY datePartie ;");

            // Récupération des données
            while (resultat.next()) {
                int score = resultat.getInt("score");
                Date date = resultat.getDate("datePartie");
                int nbPartie = resultat.getInt("nbPartie");

                Utilisateur utilisateur = new Utilisateur();
                Partie partie = new Partie();

                utilisateur.setUsername(usernameProfile);
                utilisateur.setNbPartie(nbPartie);
                partie.setScore(score);
                partie.setDatePartie(date);
                partie.setUtilisateur(utilisateur);

                ListPartie.add(partie);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture de la connexion
            Constantes.CONNEXION_BDD.fermetureConnexion(resultat, connexion);
        }
        return ListPartie;
    }

    // Ajoute un utilisateur à la BDD depuis le formulaire
    public void ajouterUtilisateur(Utilisateur utilisateur) {

        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur(prenom, nom, username, password) VALUES(?, ?, ?, SHA1(?));");
            preparedStatement.setString(1, utilisateur.getPrenom());
            preparedStatement.setString(2, utilisateur.getNom());
            preparedStatement.setString(3, utilisateur.getUsername());
            preparedStatement.setString(4, utilisateur.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture de la connexion
            Constantes.CONNEXION_BDD.fermetureConnexion(connexion);
        }
    }

    // Vérifie si le username est disponible
    public boolean usernameAvailable(String username) {
        boolean isAvailable = true;
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
    public Utilisateur checkLogin(String username, String password) {

        if (username.length() >= 4 && password.length() >= 4) {
            Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();
            String sql = "SELECT * FROM utilisateur WHERE username = ? and password = SHA1(?) ;";
            ResultSet resultat = null;
            try {
                PreparedStatement statement = connexion.prepareStatement(sql);

                statement.setString(1, username);
                statement.setString(2, password);

                resultat = statement.executeQuery();

                if (resultat.next()) {

                    Utilisateur userLogin = new Utilisateur();
                    userLogin.setUsername(username);
                    userLogin.setPassword(password);
                    return userLogin;
                }

            } catch (SQLException exception) {
                exception.printStackTrace();
            } finally {
                // Fermeture de la connexion
                Constantes.CONNEXION_BDD.fermetureConnexion(resultat, connexion);
            }
        }
        return null;
    }

    // Récupère les informations d'un utilisateur
    public Utilisateur infoUser(String Username) {

        Connection connexion = Constantes.CONNEXION_BDD.loadDatabase();
        Statement statement;
        ResultSet resultat = null;

        try {
            statement = connexion.createStatement();
            // Exécution de la requête
            resultat = statement.executeQuery("SELECT nom,prenom FROM utilisateur WHERE username='" + Username + "' ;");

            if (resultat.next()) {

                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");

                Utilisateur user = new Utilisateur();
                user.setNom(nom);
                user.setPrenom(prenom);

                return user;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            // Fermeture de la connexion
            Constantes.CONNEXION_BDD.fermetureConnexion(resultat, connexion);
        }
        return null;
    }

    // Conservez les informations de l'utilisateur
    public void setLogUser(HttpSession session, Utilisateur logUtilisateur) {
        session.setAttribute("logUtilisateur", logUtilisateur);
    }

    // Obtenez les informations de l'utilisateur
    public Utilisateur getLogUser(HttpSession session) {
        return (Utilisateur) session.getAttribute("logUtilisateur");
    }
}
