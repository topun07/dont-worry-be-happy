package com.techelevator;

public class Exercise04_Cards {

    /*
    The folks at Scamper Shipping like to play a bit
    of virtual poker at lunch, Five Card Draw, no Jokers. The deck
    is represented an array of strings, encoded as:

        * "1-C" through "10-C", "J-C", "Q-C", "K-C"
        * "1-D" through "10-D", "J-D", "Q-D", "K-D"
        * "1-H" through "10-H", "J-H", "Q-H", "K-H"
        * "1-S" through "10-S", "J-S", "Q-S", "K-S"
    
    A hand is made up of a 5 card array. For example:
        ["3-H", "4-D", "10-S", "9-D", "2-S"]
     */

    /*
    Given a 5 card array, return the value of the first card.

    Examples:
    getFirstCard(["3-H", "7-H", "5-H", "8-H", "6-H"]) → "3-H"
    getFirstCard(["1-C", "1-D", "1-H", "1-S", "2-C"]) → "1-C"
    getFirstCard(["K-C", "Q-D", "J-H", "10-S", "Q-C"]) → "K-C"
    */
    public String getFirstCard(String[] hand) {
        return hand[0];
    }

    public String getFirstHand(String[] args) {
        String[] hand1 = {"3-H", "7-H", "5-H", "8-H", "6-H"};
        String[] hand2 = {"1-C", "1-D", "1-H", "1-S", "2-C"};
        String[] hand3 = {"K-C", "Q-D", "J-H", "10-S", "Q-C"};

        return getFirstCard(hand1);
        /*In this code, the getFirstCard method takes a 5 card array hand representing a poker hand. It simply returns the value of the first card in the hand array. The main method demonstrates the usage of this getFirstCard method with different hands*/
    }




    /*
    One of the players feels lucky and discards the first card from their hand.

    Given a 5 card array, remove the first card, and return a new 4 card
    array made up of the second through fifth cards of the original array.

    Note: The given 5 card array is always guaranteed to have 5 elements.

    Examples:
    discardFirstCard(["3-H", "7-H", "5-H", "8-H", "6-H"]) → ["7-H", "5-H", "8-H", "6-H"]
    discardFirstCard(["1-C", "1-D", "1-H", "1-S", "2-C"]) → ["1-D", "1-H", "1-S", "2-C"]
    discardFirstCard(["K-C", "Q-D", "J-H", "10-S", "Q-C"]) → ["Q-D", "J-H", "10-S", "Q-C"]
     */
    public String[] discardFirstCard(String[] hand) {
        //create a new array to store the remaining 4 cards
        String[] newHand = new String[4];

        //copy the second through fifth cards of the original array to the new array
        for (int i = 1; i<hand.length; i++){
            newHand[i-1] = hand[i];
        }

        return newHand;
        /*In this code, the discardFirstCard method takes a 5 card array hand representing a poker hand. It creates a new array newHand of size 4 to store the remaining cards. Then, it copies the second through fifth cards of the original array to the new array using a for loop. Finally, it returns the new array. The main method demonstrates the usage of this discardFirstCard method with different hands.*/
    }

    /*
    Once a player has drawn the top card from the deck, they must discard it.

    Given a deck of cards, return a new deck containing all the cards except
    the first from the original deck.

    Note: The new array returned is one element shorter than the original,
    except when the deck has no cards. Then the array returned must be empty.

    Examples:
    discardTopCard(["8-D", "10-H", "J-C", "8-D", "6-S", "Q-C", "2-D"]) → ["10-H", "J-C", "8-D", "6-S", "Q-C", "2-D"]
    discardTopCard(["4-D", "6-S", "K-D"]) → ["6-S", "K-D"]
    discardTopCard(["9-H"]) → []
    discardTopCard([]) → []
     */
    public String[] discardTopCard(String[] remainingDeck) {
        if (remainingDeck.length <= 1) {
            return new String[]{}; //return an empty array if the deck has 0 or 1 cards
        }
        //create a new array to store the remaining cards (one element shorter)
        String[] newDeck = new String[remainingDeck.length -1];

        //copy cards from the original deck to the new deck, skipping the first card
        for (int i = 1; i < remainingDeck.length;i++){
            newDeck[i - 1] = remainingDeck[i];
        }
        return newDeck;
        /*In this code, the discardTopCard method takes an array deck representing a deck of cards. If the deck has 0 or 1 cards, it returns an empty array. Otherwise, it creates a new array newDeck of size one less than the original and copies all cards from the original deck to the new deck, skipping the first card using a for loop. Finally, it returns the new deck. The main method demonstrates the usage of this discardTopCard method with different decks.*/
    }    
}
