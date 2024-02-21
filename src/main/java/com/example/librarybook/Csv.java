package com.example.librarybook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Csv {
    public Csv() {

        File csvFile = new File("/Users/quentincontreau/developpement/LibraryBook/src/main/resources/com/example/librarybook/bbouks.csv"); // Nom du fichier CSV
        BufferedReader reader = null;
        String line = "";
        System.out.println(csvFile);

        try {
            reader = new BufferedReader(new FileReader(csvFile));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row)
                    System.out.print(index + " ");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
