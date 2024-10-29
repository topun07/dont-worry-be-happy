package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    // create an instance variable to contain a list of cards
    private List<Card> listOfCards = new ArrayList<>();

    /**
     * Construct a deck of cards with suits and ranks
     *
     * @param suits
     * @param ranks
     */
public Deck(int[] suits, int[] ranks){
    for (int suit : suits){
        for (int rank : ranks){
            listOfCards.add(new Card(suit, rank)); // list of every single card in the deck
        }
    }
}

    /**
     * Deals a card from the deck.
     *
     * @return the top card from the deck, or null if deck is empty
     */
    public Card dealOne(){
        if (listOfCards.size() != 0){
            return listOfCards.remove(0);
        } else {
            return null;
        }
    }


    /**
     * Shuffles the deck of cards randomly.
     */
    public void shuffle(){
        Collections.shuffle(listOfCards); // part of the collections program
        // Alternative Solution for shuffling the deck of cards
        // Loop through the deck, on each iteration, swap
        // the current card with a randomly chosen one
    }


    /**
     * Build string representation of the deck in lieu of
     * toString() which needs to wait for inheritance and
     * override to be introduced to students.
     *
     * @return a simple string representation of the cards in the deck
     */
    public String deckString(){
        String str = " ";
        for (Card card : listOfCards){
            str += card.cardString(false) + "\n";
        } return str;
    }


}
