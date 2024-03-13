package com.example.librarybook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
    private TableView<Livre> livreTable;

    @FXML
    private TableColumn<Livre, String> titreColumn;

    @FXML
    private TableColumn<Livre, List<String>> auteursColumn;

    @FXML
    private TableColumn<Livre, String> genreColumn;

    @FXML
    private TableColumn<Livre, Integer> anneeSortieColumn;

    @FXML
    private TableColumn<Livre, Boolean> disponibleSurAchatColumn;

    @FXML
    private TableColumn<Livre, List<String>> critiquesColumn;

    private ObservableList<Livre> livres = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        titreColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));
        auteursColumn.setCellValueFactory(new PropertyValueFactory<>("auteurs"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        anneeSortieColumn.setCellValueFactory(new PropertyValueFactory<>("anneeSortie"));
        disponibleSurAchatColumn.setCellValueFactory(new PropertyValueFactory<>("disponibleSurAchat"));
        critiquesColumn.setCellValueFactory(new PropertyValueFactory<>("critiques"));
    }

    @FXML
    private void ajouterLivre() {
        String titre = titreField.getText();
        String auteurs = auteursField.getText();

        String genre = genreField.getText();
        int anneeSortie = Integer.parseInt(anneeSortieField.getText());

        boolean disponibleSurAchat;
        try {
            disponibleSurAchat = Boolean.parseBoolean(disponibleSurAchatField.getText());
        } catch (Exception e) {
            System.out.println("Erreur : la valeur de disponibleSurAchat doit être true ou false.");
            return;
        }

        String critiques = critiquesField.getText();

        List<String> listeAuteurs = Arrays.asList(auteurs.split(","));

        List<String> listeCritiques = Arrays.asList(critiques.split(","));

        Livre livre = new Livre(titre, listeAuteurs, genre, anneeSortie, disponibleSurAchat, listeCritiques, "Non lu");

        livres.add(livre);
        livreTable.setItems(livres);

        try (PrintWriter writer = new PrintWriter(new FileWriter("bbouks.csv", true))) {
            writer.println(livre.toCSVString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


