package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() {

		File inputFile;
		while (true) {
			//#1 Ask for the path to the file
			System.out.println("Where is the quiz file?");
			String path = userInput.nextLine();

			//Check if the file exists and prompt again if it does not
			inputFile = new File(path);
			if (!inputFile.exists()) {
				System.out.println(path + " does not exist");
				continue;
			} else if (!inputFile.isFile()) {
				System.out.println(path + " is not a file");
				continue;
			}
			break;
		}

		ArrayList<QuizQuestion> quizQuestions =  new ArrayList<>();
		//#2 Read the file,
		try(Scanner fileScanner = new Scanner(inputFile))
		{
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				//#3 Extract questions and answers
				try {
					QuizQuestion q = new QuizQuestion(line);
					quizQuestions.add(q);
				}
				catch (Exception e) {
					System.out.println("Invalid question");
				}

			}
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		int numberOfQuestions = quizQuestions.size();
		int numberOfCorrectAnswers = 0;

	//for each question

		for(QuizQuestion quizQuestion : quizQuestions) {
			//Display the question and answers
			System.out.println();
			System.out.println(quizQuestion.getQuestion());

			for (int i = 0; i < quizQuestion.getAnswers().length; i++) {
				System.out.println((i+1) + ")" + quizQuestion.getAnswers()[i]);
			}

			//Get the answer
			System.out.println();
			System.out.println("Your Answer:");
			String userAnswer = userInput.nextLine();

			//Compare answer with correct one
			//Tell the user if the answer is correct or incorrect count correct and incorrect answers.
			if(quizQuestion.isCorrectAnswer(userAnswer)) {
				System.out.println("Correct!");
				numberOfCorrectAnswers++;
			}
			else
				System.out.println("Invalid Answer!");
			//Next question
		}

	//Display correct/incorrect counter
		System.out.println();
		System.out.println("You got " + numberOfCorrectAnswers + " answers correct out of the total " + numberOfQuestions + " questions asked.");
	}
}
