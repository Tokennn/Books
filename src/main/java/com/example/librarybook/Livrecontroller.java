package com.example.librarybook;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.List;

public class Livrecontroller {

    @FXML
    private TextField titreField;
    @FXML
    private TextField auteursField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField anneeSortieField;
    @FXML
    private TextField nombreMotsField;
    @FXML
    private TextField disponibleSurAchatField;
    @FXML
    private TextField critiquesField;
    @FXML
    private TextField statutLectureField;

    private List<Livre> listeLivres;

    // Méthode pour définir la liste de livres
    public void setListeLivres(List<Livre> listeLivres) {
        this.listeLivres = listeLivres;
    }

    // Méthode pour gérer l'ajout d'un nouveau livre
    @FXML
    private void ajouterLivre() {
        String titre = titreField.getText();
        String auteurs = auteursField.getText();
        String genre = genreField.getText();
        int anneeSortie = Integer.parseInt(anneeSortieField.getText());
        int nombreMots = Integer.parseInt(nombreMotsField.getText());
        boolean disponibleSurAchat = Boolean.parseBoolean(disponibleSurAchatField.getText());
        String critiques = critiquesField.getText();
        String statutLecture = statutLectureField.getText();

        // Créer un nouveau livre avec les données entrées
        Livre nouveauLivre = new Livre(titre, List.of(auteurs.split(";")), genre, anneeSortie, nombreMots, disponibleSurAchat, List.of(critiques.split(";")), statutLecture);

        // Ajouter le nouveau livre à la liste de livres
        Livre.ajouterLivre(nouveauLivre, listeLivres);

        // Effacer les champs après l'ajout
        effacerChamps();
    }

    // Méthode pour effacer les champs après l'ajout
    @FXML
    private void effacerChamps() {
        titreField.clear();
        auteursField.clear();
        genreField.clear();
        anneeSortieField.clear();
        nombreMotsField.clear();
        disponibleSurAchatField.clear();
        critiquesField.clear();
        statutLectureField.clear();
    }
}

