package plep.service;

import java.sql.*;

public class ConnexionBDD {

    private Connection connexion = null;

    // Charge la BDD
    public Connection loadDatabase() {
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
        return connexion;
    }

    // Ferme une connexion
    public void fermetureConnexion(ResultSet resultat, Connection connexion) {

        try {
            if (resultat != null)
                resultat.close();
            if (connexion != null)
                connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ferme une connexion
    public void fermetureConnexion(Connection connexion) {

        try {
            if (connexion != null)
                connexion.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
