package com.techelevator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		System.out.println("Enter the destination file:");
		String destinationFilePath = userInput.nextLine();

		Path destinationPath = Path.of(destinationFilePath);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {
			for (int i = 1; i <= 300; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					writer.write("FizzBuzz");
				} else if (i % 3 == 0) {
					writer.write("Fizz");
				} else if (i % 5 == 0) {
					writer.write("Buzz");
				} else {
					writer.write(String.valueOf(i));
				}
				writer.newLine();
			}
			System.out.println("FizzBuzz results have been written successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file. Please check the file path and try again.");
		}
	}
}