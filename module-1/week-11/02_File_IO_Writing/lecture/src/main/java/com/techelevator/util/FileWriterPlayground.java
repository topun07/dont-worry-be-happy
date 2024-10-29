package com.techelevator.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileWriterPlayground {

    public static void main(String[] args) {
        String fileName = "example.txt";
        String textToWrite = "Hello, world!";
        String textToAppend = "Appended text.";

        writeAndAppendUsingPrintWriter(fileName, textToWrite, textToAppend);
        writeAndAppendUsingFileWriter(fileName, textToWrite, textToAppend);
        writeAndAppendUsingBufferedWriter(fileName, textToWrite, textToAppend);
        writeAndAppendUsingFiles(fileName, textToWrite, textToAppend);

    }

    public static void writeAndAppendUsingPrintWriter(String fileName, String textToWrite, String textToAppend) {
        try {
            // Writing to the file
            PrintWriter writer = new PrintWriter(fileName);
            writer.println(textToWrite);
            writer.close();

            // Appending to the file
            writer = new PrintWriter(new FileOutputStream(fileName, true)); // `true` indicates append mode
            writer.println(textToAppend);
            writer.close();

            System.out.println("PrintWriter: File written and appended successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeAndAppendUsingFileWriter(String fileName, String textToWrite, String textToAppend) {
        try {
            // Writing to the file
            FileWriter writer = new FileWriter(fileName);
            writer.write(textToWrite);
            writer.close();

            // Appending to the file
            writer = new FileWriter(fileName, true); // `true` indicates append mode
            writer.write("\n" + textToAppend);
            writer.close();

            System.out.println("FileWriter: File written and appended successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try(FileWriter writer = new FileWriter(fileName)) {
            writer.write("ABCD");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void writeAndAppendUsingBufferedWriter(String fileName, String textToWrite, String textToAppend) {
        try {
            // Writing to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(textToWrite);
            writer.close();

            // Appending to the file
            writer = new BufferedWriter(new FileWriter(fileName, true)); // `true` indicates append mode
            writer.write("\n" + textToAppend);
            writer.close();

            System.out.println("BufferedWriter: File written and appended successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeAndAppendUsingFiles(String fileName, String textToWrite, String textToAppend) {
        try {
            // Writing to the file
            Files.write(Paths.get(fileName), textToWrite.getBytes());

            // Appending to the file
            Files.write(Paths.get(fileName), Arrays.asList("\n" + textToAppend), StandardOpenOption.APPEND);

            System.out.println("Files: File written and appended successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
