package org.example.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FileHandler {
    public final String fileName;

    protected FileHandler(String fileName) {
        this.fileName = fileName;
    }

    protected ArrayList<String> convertFileToLines(String fileName) {
        ArrayList<String> fileLine = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileLine.add(scanner.nextLine());
            }
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return fileLine;
    }
}
