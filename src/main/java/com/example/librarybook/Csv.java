package com.example.librarybook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Csv {
    public Csv() {

        File csvFile = new File("/Users/quentincontreau/developpement/LibraryBook/src/main/resources/com/example/librarybook/bbouks.csv"); // Nom du fichier CSV
        BufferedReader reader = null; // Déclaration du BufferedReader
        String line = "";
        System.out.println(csvFile); // Affichage des noms des colonnes

        try {
            reader = new BufferedReader(new FileReader(csvFile)); // Initialisation du BufferedReader avec le fichier CSV
            while ((line = reader.readLine()) != null) { // Lecture des lignes du fichier CSV
                String[] row = line.split(","); // Séparation des valeurs de la ligne
                for (String index : row) // Parcours des valeurs de la ligne
                    System.out.print(index + " "); // Affichage de chaque valeur
                System.out.println(); // Saut de ligne après chaque ligne du fichier
            }
        } catch (IOException e) {
            e.printStackTrace(); // Gestion des exceptions d'entrée/sortie
        } finally {
            if (reader != null) {
                try {
                    reader.close(); // Fermeture du BufferedReader
                } catch (IOException e) {
                    e.printStackTrace(); // Gestion des exceptions d'entrée/sortie lors de la fermeture du BufferedReader
                }
            }
        }
    }
}
