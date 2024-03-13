package com.example.librarybook;

import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;

public class Livre {
    private final StringProperty titre;
    private final ListProperty<String> auteurs;
    private final StringProperty genre;
    private final IntegerProperty anneeSortie;
    private final BooleanProperty disponibleSurAchat;
    private final ListProperty<String> critiques;
    private final StringProperty statutLecture;

    public Livre(String titre, List<String> auteurs, String genre, int anneeSortie, boolean disponibleSurAchat, List<String> critiques, String statutLecture) {
        this.titre = new SimpleStringProperty(titre);
        this.auteurs = new SimpleListProperty<>(FXCollections.observableArrayList(auteurs));
        this.genre = new SimpleStringProperty(genre);
        this.anneeSortie = new SimpleIntegerProperty(anneeSortie);
        this.disponibleSurAchat = new SimpleBooleanProperty(disponibleSurAchat);
        this.critiques = new SimpleListProperty<>(FXCollections.observableArrayList(critiques));
        this.statutLecture = new SimpleStringProperty(statutLecture);
    }

    public String getTitre() {
        return titre.get();
    }

    public StringProperty titreProperty() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre.set(titre);
    }

    public List<String> getAuteurs() {
        return auteurs.get();
    }

    public ListProperty<String> auteursProperty() {
        return auteurs;
    }

    public void setAuteurs(List<String> auteurs) {
        this.auteurs.set(FXCollections.observableArrayList(auteurs));
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public int getAnneeSortie() {
        return anneeSortie.get();
    }

    public IntegerProperty anneeSortieProperty() {
        return anneeSortie;
    }

    public void setAnneeSortie(int anneeSortie) {
        this.anneeSortie.set(anneeSortie);
    }

    public boolean isDisponibleSurAchat() {
        return disponibleSurAchat.get();
    }

    public BooleanProperty disponibleSurAchatProperty() {
        return disponibleSurAchat;
    }

    public void setDisponibleSurAchat(boolean disponibleSurAchat) {
        this.disponibleSurAchat.set(disponibleSurAchat);
    }

    public List<String> getCritiques() {
        return critiques.get();
    }

    public ListProperty<String> critiquesProperty() {
        return critiques;
    }

    public void setCritiques(List<String> critiques) {
        this.critiques.set(FXCollections.observableArrayList(critiques));
    }

    public String getStatutLecture() {
        return statutLecture.get();
    }

    public StringProperty statutLectureProperty() {
        return statutLecture;
    }

    public void setStatutLecture(String statutLecture) {
        this.statutLecture.set(statutLecture);
    }

    public String toCSVString() {
        String auteurString = String.join(",", auteurs);
        String critiqueString = String.join(",", critiques);
        return titre + "," + auteurString + "," + genre + "," + anneeSortie + "," + disponibleSurAchat + "," + critiqueString + "," + statutLecture;
    }
}
