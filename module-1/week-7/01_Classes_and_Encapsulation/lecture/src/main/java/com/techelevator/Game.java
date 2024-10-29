package com.techelevator;

public class Game {
    // create an instance variable deck of type Deck, pokerSuits and
    // pokerRanks of type integer array
    private Deck deck;
    int[] pokerSuits;
    int[] pokerRanks;


    /**
     * Construct a game and its deck of cards.
     */
    public Game(){
        pokerSuits = new int[]{SPADES, DIAMONDS, CLUBS, HEARTS};
        pokerRanks = new int[]{ACE, TWO,  THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, KING, QUEEN};
        deck = new Deck(pokerSuits, pokerRanks);

    }


    /**
     * Get the underlying deck of the game.
     *
     * @return deck
     */
    public Deck getDeck(){
        return this.deck;
    }


    /**
     * Get the name of the suit using suit parameter
     * as index into suitNames array.
     *
     * @param suit
     *
     * @return name of the suit
     */
    public static String getSuitName (int suit){
        return suitNames[suit];

    }


    /**
     * Get the symbol of the suit using suit parameter
     * as index into suitSymbols array.
     *
     * @param suit
     *
     * @return Unicode character (symbol) of the suit
     */
    public static char getSuitsSymbol(int suit){
        return suitSymbols[suit];
    }


    /**
     * Get the name of the rank using rank parameter
     * as index into rankNames array.
     *
     * @param rank
     *
     * @return name of the rank
     */
    public static String getRankName(int rank){
        return rankNames[rank];
    }

    // Constants
    public static final int SPADES = 0;
    public static final int DIAMONDS = 1;
    public static final int CLUBS = 2;
    public static final int HEARTS = 3;

    public static final int ACE = 0;
    public static final int TWO = 1;
    public static final int THREE = 2;
    public static final int FOUR = 3;
    public static final int FIVE = 4;
    public static final int SIX = 5;
    public static final int SEVEN = 6;
    public static final int EIGHT = 7;
    public static final int NINE = 8;
    public static final int TEN = 9;
    public static final int JACK = 10;
    public static final int QUEEN = 11;
    public static final int KING = 12;

    private static final String[] suitNames = new String[] { "Spades", "Diamonds", "Clubs", "Hearts" };
    private static final char[] suitSymbols = new char[] { '\u2660', '\u2666', '\u2663', '\u2665' };
    private static final String[] rankNames = new String[] { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King" };


}
