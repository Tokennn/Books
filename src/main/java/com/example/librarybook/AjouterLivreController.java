package com.example.librarybook;

import com.example.librarybook.Livre;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AjouterLivreController {
    @FXML
    private TextField titreField;
    @FXML
    private TextField auteursField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField anneeSortieField;
    @FXML
    private TextField disponibleSurAchatField;
    @FXML
    private TextField critiquesField;
    @FXML
    private TextField statutLectureField;

    private List<Livre> listeLivres;

    public void setListeLivres(List<Livre> listeLivres) {
        this.listeLivres = listeLivres;
    }

    @FXML
    private void ajouterLivre() {
        String titre = titreField.getText();
        String auteurs = auteursField.getText();
        String genre = genreField.getText();
        String anneeSortie = anneeSortieField.getText();
        String disponibleSurAchat = disponibleSurAchatField.getText();
        String critiques = critiquesField.getText();

        // Ajouter le code pour écrire ces données dans votre fichier CSV
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("/Users/quentincontreau/developpement/LibraryBook/src/main/java/com/example/librarybook/bbouks.csv", true));
            writer.println(titre + "," + auteurs + "," + genre + "," + anneeSortie + "," + disponibleSurAchat + "," + critiques);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer les erreurs d'écriture dans le fichier CSV
        }
    }

    // Méthode pour effacer les champs après l'ajout
    private void effacerChamps() {
        titreField.clear();
        auteursField.clear();
        genreField.clear();
        anneeSortieField.clear();
        disponibleSurAchatField.clear();
        critiquesField.clear();
        statutLectureField.clear();
    }
}
