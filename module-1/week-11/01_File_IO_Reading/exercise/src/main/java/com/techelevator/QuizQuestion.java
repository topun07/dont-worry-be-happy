package com.techelevator;

public class QuizQuestion {
    private String question;
    private String[] choices;
    private int correctAnswerIndex;

    public QuizQuestion(String question, String[] choices, int correctAnswerIndex) {
        this.question = question;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
