/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author brandoniscoding
 */
public class Utils {
    public class SQLiteConnection {
    private Connection conn;

    public void connect() {
        String url = "jdbc:sqlite:chemin_vers_votre_base_de_donnees.sqlite"; // Chemin vers votre fichier SQLite

        try {
            // Établissement de la connexion
            conn = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Connexion réussie"); // Message de confirmation
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la connexion : " + e.getMessage()); // Message d'erreur
        }
    }
}
}
