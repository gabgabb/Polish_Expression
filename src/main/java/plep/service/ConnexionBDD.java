package plep.service;

import plep.entite.Utilisateur;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnexionBDD {

        private Connection connexion = null;

        public void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ignored) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "root");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public List<Utilisateur> recupUtilisateur(int limit) {

            List<Utilisateur> utilisateurs = new ArrayList<>();
            Statement statement;
            ResultSet resultat = null;

            loadDatabase();

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
                try {
                    if (resultat != null)
                        resultat.close();
                    if (connexion != null)
                        connexion.close();
                } catch (SQLException ignore) {
                }
            }
            return utilisateurs;
        }

        public void ajouterUtilisateur(Utilisateur utilisateur) {
            loadDatabase();

            String username = utilisateur.getUsername();

            if (username.length() > 0 && username != null) {
                String verifSql = "SELECT username FROM utilisateur WHERE username='" + username + "' LIMIT 1";


                try {
                    PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur(prenom, nom, username, password) VALUES(?, ?, ?, SHA1(?));");
                    preparedStatement.setString(1, utilisateur.getPrenom());
                    preparedStatement.setString(2, utilisateur.getNom());
                    preparedStatement.setString(3, utilisateur.getUsername());
                    preparedStatement.setString(4, utilisateur.getPassword());
                    System.out.println(preparedStatement);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public boolean usernameAvailable(Utilisateur utilisateur){
            boolean isAvailable = true;
            String username =  utilisateur.getUsername();
            ResultSet resultat;

            if(username.length()>0){
                String sql = "SELECT username from utilisateur WHERE username='" + username + "' ;";
                loadDatabase();

                try {
                    Statement statement = connexion.createStatement();
                    resultat = statement.executeQuery(sql);
                    if(resultat.next()){
                        isAvailable = false;
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }

            return isAvailable;
        }
    }

