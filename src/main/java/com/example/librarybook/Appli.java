package com.example.librarybook;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Appli extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création de l'interface graphique
        VBox root = new VBox();
        Scene scene = new Scene(root, 600, 400);

        // Création des composants
        TableView<Livre> livresTable = new TableView<>();
        TextField searchBar = new TextField();
        Button addButton = new Button("Ajouter");
        Button deleteButton = new Button("Supprimer");
        Button updateButton = new Button("Mettre à jour");
        Button clearButton = new Button("Effacer");
        Button reviseButton = new Button("Réviser");
        ComboBox<String> filterComboBox = new ComboBox<>();
        // Ajoutez les options pour filtrer
        filterComboBox.getItems().addAll("Filtrer par genre", "Filtrer par année de sortie", "Filtrer par auteur");

        // Ajouter les composants à la racine
        root.getChildren().addAll(searchBar, addButton, deleteButton, updateButton, clearButton, reviseButton, filterComboBox, livresTable);

        // Affichage de la fenêtre
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion de bibliothèque");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
