package com.techelevator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();
        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();
        System.out.println("What is the source file?");
        String sourceFilePath = userInput.nextLine();
        System.out.println("What is the destination file?");
        String destinationFilePath = userInput.nextLine();

        Path sourcePath = Path.of(sourceFilePath);
        Path destinationPath = Path.of(destinationFilePath);

        if (!Files.exists(sourcePath)) {
            System.out.println("The source file does not exist. Please check the file path and try again.");
            return;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = line.replace(searchWord, replacementWord);
                writer.write(modifiedLine);
                writer.newLine();
            }
            System.out.println("The replacements have been made successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while processing the files. Please check the file paths and try again.");
        }
    }
}