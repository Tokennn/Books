package com.example.librarybook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class Appli extends Application {
    private Stage primaryStage;
    private Menucontroller menuController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        afficherMenu();
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("bouks.jpg")));
    }



    public void afficherMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("livre.fxml"));
        Parent root = fxmlLoader.load();

        menuController = fxmlLoader.getController();
        menuController.setApplication(this);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Books Library");
        primaryStage.show();
    }

    // Méthodes pour afficher différentes pages
    public void afficherPageAjouter() throws IOException {
        afficherPage("Addbbouton.fxml");
    }

    public void afficherPageSupprimer() throws IOException {
        afficherPage("Deletebbouton.fxml");
    }

    public void afficherPageEffacer() throws IOException {
        afficherPage("Clearbbouton.fxml");
    }

    public void afficherPageReviser() throws IOException {
        afficherPage("Revisebbouton.fxml");
    }

    public void afficherPageMettreAJour() throws IOException {
        afficherPage("Updatebbouton.fxml");
    }

    public void afficherPage(String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return null;
    }
}
