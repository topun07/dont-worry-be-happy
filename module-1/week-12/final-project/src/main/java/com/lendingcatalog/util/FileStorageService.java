package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        try (FileWriter writer = new FileWriter(filename, appendFile)){
            writer.write(contents);
        }catch (IOException e){
            throw new FileStorageException("Failed to write to file: " + filename, e);
        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        try{
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException e){
            throw new FileStorageException("Failed to read from file: " + filename, e);
        }
    }
}
