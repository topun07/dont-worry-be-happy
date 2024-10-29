package com.techelevator;

public class FruitTree {
    // instance variables
    private String typeOfFruit;
    private int piecesOfFruitLeft;

//constructor with parameters
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit){
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
}
    public Boolean pickFruit(int numberOfPiecesToRemove){
        if (piecesOfFruitLeft >= numberOfPiecesToRemove){
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        } else{
            return false;
        }
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }
}