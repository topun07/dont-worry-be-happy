package com.techelevator;

import java.io.InvalidObjectException;

public class QuizQuestion {
    private String question;
    private String correctAnswer = "";
    private String[] answers;

    public QuizQuestion(String line) throws InvalidObjectException {

        if(line == null || line.equals(""))
            throw new InvalidObjectException("Question line can't be empty");

        String[] parts = line.split("\\|");
        this.question = parts[0];
        this.correctAnswer = "";
        this.answers = new String[parts.length-1];
        for (int i = 1; i < parts.length; i++) {
            String answer = parts[i];
            if (answer.endsWith("*")) {
                answer = answer.substring(0, answer.length()-1);
                correctAnswer = answer;
            }
            answers[i-1] = answer ;
        }

        if(correctAnswer == null)
            throw new InvalidObjectException("THis question does not have a correct answer");

        if(answers[0] == null)
            throw new InvalidObjectException("This question does not have any answers");
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public boolean isCorrectAnswer(String userAnswerNo) {
        int index = Integer.parseInt(userAnswerNo);
        String userAnswer = getAnswers()[index-1];
        return this.correctAnswer.equals(userAnswer);
    }
}
