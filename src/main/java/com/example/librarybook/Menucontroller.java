package com.example.librarybook;

import javafx.fxml.FXML;

import java.io.IOException;

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
