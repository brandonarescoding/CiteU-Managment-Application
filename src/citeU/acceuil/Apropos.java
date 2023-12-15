package citeU.acceuil;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;

public class Apropos {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    static void createAndShowGUI() {
        JFrame frame = new JFrame("A propos");
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setEditable(false);

        try {
            InputStream inputStream = Apropos.class.getResourceAsStream("Apropos.html");
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                StringBuilder content = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();

                textPane.setText(content.toString());
            } else {
                textPane.setText("Erreur : Impossible de charger le fichier HTML.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            textPane.setText("Erreur de lecture du fichier : " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(textPane);
        frame.add(scrollPane);
        
        // Ajout d'un WindowListener pour gérer la fermeture de la fenêtre
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                int choice = JOptionPane.showConfirmDialog(frame,
                        "Voulez-vous revenir à la page d'accueil ?", "Fermer la fenêtre A propos",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (choice == JOptionPane.YES_OPTION) {
                    Acceuil acceuil = new Acceuil();
                    acceuil.setLocationRelativeTo(null);
                    acceuil.setVisible(true);
                    frame.dispose();
                } else {
                    System.exit(0); // Quitte définitivement le programme
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
