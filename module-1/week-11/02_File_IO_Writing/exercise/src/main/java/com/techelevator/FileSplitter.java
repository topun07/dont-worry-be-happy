package com.techelevator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileSplitter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FileSplitter fileSplitter = new FileSplitter();
		fileSplitter.run();
	}

	public void run() {
		System.out.println("Where is the input file (please include the path to the file)?");
		String inputFilePath = userInput.nextLine();
		System.out.println("How many lines of text (max) should there be in the split files?");
		int maxLinesPerFile = Integer.parseInt(userInput.nextLine());

		Path inputPath = Path.of(inputFilePath);

		if (!Files.exists(inputPath)) {
			System.out.println("The input file does not exist. Please check the file path and try again.");
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
			int fileCount = 1;
			String line;
			int lineCount = 0;
			BufferedWriter writer = createNewFileWriter(inputFilePath, fileCount);

			while ((line = reader.readLine()) != null) {
				if (lineCount == maxLinesPerFile) {
					writer.close();
					fileCount++;
					lineCount = 0;
					writer = createNewFileWriter(inputFilePath, fileCount);
				}

				writer.write(line);
				writer.newLine();
				lineCount++;
			}

			writer.close();
			System.out.println("File splitting completed successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while processing the files. Please check the file paths and try again.");
		}
	}

	private BufferedWriter createNewFileWriter(String inputFilePath, int fileCount) throws IOException {
		String baseName = inputFilePath.substring(0, inputFilePath.lastIndexOf('.'));
		String extension = inputFilePath.substring(inputFilePath.lastIndexOf('.'));
		String newFileName = baseName + "-" + fileCount + extension;
		System.out.println("Generating " + newFileName);
		return new BufferedWriter(new FileWriter(newFileName));
	}
}