package com.techelevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() {
		
		File inputFile;
		while (true)
			// ask for the path to the file
			System.out.println("Where is the quiz file?");
			String filePath = userInput.nextLine();

			// check if the file exists and prompt again if it doesnt
			inputFile = new File(filePath);
			if (!inputFile.exists()) {
				System.out.println((filePath + " does not exist."));
				continue;
			} else if (!inputFile.isFile()) {
				System.out.println(filePath + " is not a file");
				continue;
			}
			break;

		}
	}
}
			/*List<QuizQuestion> quizQuestions = loadQuizQuestions(filePath);
			if (quizQuestions.isEmpty()) {
				System.out.println("No quiz questions loaded. Please check the file and try again.");
				return;
			}
			int correctAnswersCount = 0;
			for (QuizQuestion question : quizQuestions) {
				if (askQuestion(question)) {
					correctAnswersCount++;
				}
			}

			System.out.println("You got " + correctAnswersCount + " answer(s) correct out of the " + quizQuestions.size() + " questions asked.");
		}
		private List<QuizQuestion> loadQuizQuestions (String filePath){
			List<QuizQuestion> quizQuestions = new ArrayList<>();
			try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split("\\|");
					String question = parts[0];
					String[] choices = new String[parts.length - 1];
					int correctAnswerIndex = -1;

					for (int i = 1; i < parts.length; i++) {
						if (parts[i].endsWith("*")) {
							correctAnswerIndex = i - 1;
							choices[i - 1] = parts[i].substring(0, parts[i].length() - 1);
						} else {
							choices[i - 1] = parts[i];
						}
					}

					quizQuestions.add(new QuizQuestion(question, choices, correctAnswerIndex));
				}
			} catch (IOException e) {
				System.out.println("An error occurred while reading the file. Please check the file path and try again.");
			}

			return quizQuestions;
		}

		private boolean askQuestion (QuizQuestion question){
			System.out.println(question.getQuestion());
			String[] choices = question.getChoices();
			for (int i = 0; i < choices.length; i++) {
				System.out.println((i + 1) + ". " + choices[i]);
			}

			System.out.print("Your answer: ");
			int userAnswer = Integer.parseInt(userInput.nextLine());

			if (userAnswer - 1 == question.getCorrectAnswerIndex()) {
				System.out.println("RIGHT!");
				return true;
			} else {
				System.out.println("WRONG!");
				return false;
			}
		}
	}
}*/