package com.example.librarybook;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    @FXML
    private TableView<Livre> livreTable;

    @FXML
    private TableColumn<Livre, String> titreColumn;

    @FXML
    private TableColumn<Livre, String> auteursColumn;

    @FXML
    private TableColumn<Livre, String> genreColumn;

    @FXML
    private TableColumn<Livre, String> anneeSortieColumn;

    @FXML
    private TableColumn<Livre, String> disponibleSurAchatColumn;

    @FXML
    private TableColumn<Livre, String> critiquesColumn;

    private ObservableList<Livre> livres = FXCollections.observableArrayList();


    @FXML
    private void ajouterLivre() {
        String titre = titreField.getText();
        String auteurs = auteursField.getText();
        String genre = genreField.getText();
        String anneeSortie = anneeSortieField.getText();
        String disponibleSurAchat = disponibleSurAchatField.getText();
        String critiques = critiquesField.getText();
        String statutLecture = statutLectureField.getText();


        Livre livre = new Livre(titre, auteurs, genre, anneeSortie, disponibleSurAchat, critiques, statutLecture);


        livres.add(livre);


        livreTable.setItems(livres);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("/Users/quentincontreau/developpement/LibraryBook/src/main/java/com/example/librarybook/bbouks.csv", true));
            writer.println(livre.toCSVString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        effacerChamps();
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
