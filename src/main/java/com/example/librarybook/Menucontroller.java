package com.example.librarybook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class Menucontroller {

    private Appli application;

    public void setApplication(Appli application) {
        this.application = application;
    }

    @FXML
    private TableView<Livre> livresTable;
    @FXML
    private TableColumn<Livre, String> titreColumn;
    @FXML
    private TableColumn<Livre, String> auteursColumn;
    @FXML
    private TableColumn<Livre, String> genreColumn;
    @FXML
    private TableColumn<Livre, Integer> anneeSortieColumn;
    @FXML
    private TableColumn<Livre, Integer> nombreMotsColumn;
    @FXML
    private TableColumn<Livre, Boolean> disponibleSurAchatColumn;


    private ObservableList<Livre> livres = FXCollections.observableArrayList();

    // Cette méthode sera appelée chaque fois qu'un nouveau livre est ajouté
    public void ajouterLivre(Livre livre) {
        livres.add(livre);
        livresTable.setItems(livres);
    }

    @FXML
    private void afficherPageAjouter() throws IOException {
        application.afficherPage("Addbbouton.fxml");
    }

    @FXML
    private void afficherPageSupprimer() throws IOException {
        application.afficherPage("Deletebbouton.fxml");
    }

    @FXML
    private void afficherPageEffacer() throws IOException {
        application.afficherPage("Clearbbouton.fxml");
    }

    @FXML
    private void afficherPageReviser() throws IOException {
        application.afficherPage("Revisebbouton.fxml");
    }

    @FXML
    private void afficherPageMettreAJour() throws IOException {
        application.afficherPage("Updatebbouton.fxml");
    }
}

