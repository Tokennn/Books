package com.example.librarybook;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.ConcurrentMap;

public class Appli extends Application {

    @FXML
    private Button updateButton;
    @FXML
    private Button addButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button deleteButton;
    @FXML
    private ComboBox filterComboBox;
    @FXML
    private TableView livresTable;
    @FXML
    private Button reviseButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("livre.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Library");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
