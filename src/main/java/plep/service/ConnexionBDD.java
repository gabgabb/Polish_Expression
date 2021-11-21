package plep.service;

import plep.entite.Utilisateur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnexionBDD {

        private Connection connexion = null;

        public List<Utilisateur> recupUtilisateur() {
            List<Utilisateur> utilisateurs = new ArrayList<>();
            Statement statement;
            ResultSet resultat = null;

            loadDatabase();

            try {
                statement = connexion.createStatement();

                // Exécution de la requête
                resultat = statement.executeQuery("SELECT username,password,score FROM utilisateur ORDER BY score DESC LIMIT 10;");

                // Récupération des données
                while (resultat.next()) {
                    String username = resultat.getString("username");
                    String password = resultat.getString("password");
                    int score = resultat.getInt("score");
                    System.out.println(username);

                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setUsername(username);
                    utilisateur.setPassword(password);
                    utilisateur.setScore(score);

                    utilisateurs.add(utilisateur);
                    System.out.println("LISTE "+utilisateurs.get(0).getUsername());
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

        private void loadDatabase() {
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

        public void ajouterUtilisateur(Utilisateur utilisateur) {
            loadDatabase();

            try {
                PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur(prenom, nom, username, password) VALUES(?, ?, ?, ?);");
                preparedStatement.setString(1, utilisateur.getPrenom());
                preparedStatement.setString(2, utilisateur.getNom());
                preparedStatement.setString(3, utilisateur.getUsername());
                preparedStatement.setString(4, utilisateur.getPassword());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

