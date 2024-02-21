package com.example.librarybook;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Livre {
    private String titre;
    private List<String> auteurs;
    private String genre;
    private int anneeSortie;
    private int nombreMots;
    private boolean disponibleSurAchat;
    private List<String> critiques;
    private String statutLecture;


    public Livre(String titre, List<String> auteurs, String genre, int anneeSortie, int nombreMots, boolean disponibleSurAchat, List<String> critiques, String statutLecture) {
        this.titre = titre;
        this.auteurs = auteurs;
        this.genre = genre;
        this.anneeSortie = anneeSortie;
        this.nombreMots = nombreMots;
        this.disponibleSurAchat = disponibleSurAchat;
        this.critiques = critiques;
        this.statutLecture = statutLecture;
    }

    public Livre(String titre, List<String> split, String genre, int anneeSortie, boolean disponibleSurAchat, List<String> split1) {
    }

    public <E> Livre(String titre, List<E> split, String genre, int anneeSortie, boolean disponibleSurAchat, List<E> split1, String statutLecture) {
    }

    public Livre(String datum, String datum1, String datum2, String datum3, String datum4, String datum5) {
    }

    public Livre(String titre, String auteurs, String genre, String anneeSortie, String disponibleSurAchat, String critiques, String statutLecture) {
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<String> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(List<String> auteurs) {
        this.auteurs = auteurs;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(int anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public int getNombreMots() {
        return nombreMots;
    }

    public void setNombreMots(int nombreMots) {
        this.nombreMots = nombreMots;
    }

    public boolean isDisponibleSurAchat() {
        return disponibleSurAchat;
    }

    public void setDisponibleSurAchat(boolean disponibleSurAchat) {
        this.disponibleSurAchat = disponibleSurAchat;
    }

    public List<String> getCritiques() {
        return critiques;
    }

    public void setCritiques(List<String> critiques) {
        this.critiques = critiques;
    }

    public String getStatutLecture() {
        return statutLecture;
    }

    public void setStatutLecture(String statutLecture) {
        this.statutLecture = statutLecture;
    }

    public static void ecrireLivresCSV(List<Livre> livres, String nomFichier) {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(nomFichier), CSVFormat.DEFAULT
                .withHeader("Titre", "Auteurs", "Genre", "Année de sortie", "Nombre de pages",
                        "Disponible sur achat", "Critiques", "Statut de lecture"))) {
            for (Livre livre : livres) {
                printer.printRecord(livre.getTitre(),
                        String.join(";", livre.getAuteurs()),
                        livre.getGenre(),
                        livre.getAnneeSortie(),
                        livre.getNombreMots(),
                        livre.isDisponibleSurAchat(),
                        String.join(";", livre.getCritiques()),
                        livre.getStatutLecture());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Livre> lireLivresCSV(String nomFichier) {
        List<Livre> livres = new ArrayList<>();
        try (Reader reader = new FileReader(nomFichier);
             CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withFirstRecordAsHeader()
                     .withIgnoreHeaderCase()
                     .withTrim())) {
            for (CSVRecord record : parser) {
                Livre livre = new Livre(
                        record.get("Titre"),
                        List.of(record.get("Auteurs").split(";")),
                        record.get("Genre"),
                        Integer.parseInt(record.get("Année de sortie")),
                        Integer.parseInt(record.get("Nombre de mots")),
                        Boolean.parseBoolean(record.get("Disponible sur achat")),
                        List.of(record.get("Critiques").split(";")),
                        record.get("Statut de lecture"));
                livres.add(livre);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return livres;
    }

    public static void ajouterLivre(Livre livre, List<Livre> listeLivres) {
        listeLivres.add(livre);
    }

    public static void supprimerLivre(Livre livre, List<Livre> listeLivres) {
        listeLivres.remove(livre);
    }

    public static void mettreAJourLivre(Livre livre, List<Livre> listeLivres, Livre nouveauLivre) {
        int index = listeLivres.indexOf(livre);
        if (index != -1) {
            listeLivres.set(index, nouveauLivre);
        }
    }

    public static void effacerLivres(List<Livre> listeLivres) {
        listeLivres.clear();
    }

    public boolean toCSVString() {
        return false;
    }
}
