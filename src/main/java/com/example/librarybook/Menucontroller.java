package com.example.librarybook;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class Menucontroller {

    private Appli application;

    public void setApplication(Appli application) {
        this.application = application;
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

