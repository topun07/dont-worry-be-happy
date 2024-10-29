package com.techelevator;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("What is the fully qualified name of the file that should be searched?");
		String filePath = userInput.nextLine();
		System.out.println("What is the search word you are looking for?");
		String searchWord = userInput.nextLine();
		System.out.println("Should the search be case sensitive? (Y\\N)");
		String caseSensitiveInput = userInput.nextLine();
		boolean caseSensitive = caseSensitiveInput.equalsIgnoreCase("Y");

		searchFile(filePath, searchWord, caseSensitive);
	}

	private void searchFile(String filePath, String searchWord, boolean caseSensitive) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			int lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				if (matchesSearchWord(line, searchWord, caseSensitive)) {
					System.out.println(lineNumber + ") " + line);
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file. Please check the file path and try again.");
		}
	} private boolean matchesSearchWord(String line, String searchWord, boolean caseSensitive) {
		if (caseSensitive) {
			return line.contains(searchWord);
		} else {
			return line.toLowerCase().contains(searchWord.toLowerCase());
		}
	}
}