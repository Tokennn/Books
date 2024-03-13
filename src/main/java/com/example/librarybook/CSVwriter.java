package com.example.librarybook;

import java.io.FileWriter;
import java.io.IOException;

public class CSVwriter {
    public static void writeToCSV(String fileName, String[] data) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (String value : data) {
                writer.append(value);
                writer.append(",");
            }
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}