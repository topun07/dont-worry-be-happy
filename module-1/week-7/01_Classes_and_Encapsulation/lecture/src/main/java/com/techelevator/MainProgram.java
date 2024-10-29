package com.techelevator;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

        // Create a new Game, which sets up the appropriate deck
        Game game = new Game();
        Card player1Card, player2Card;
        int player1Wins = 0, player2Wins = 0;
        boolean isPlayGame = 0;

        // Display the unshuffled deck


        // Shuffle the deck and redisplay


        // create a deck of cards for the game of WAR


        // START OF LOOP - loop through getting a card from each player
        // and determining who has the higher valued card


            // player 1 gets a card face down


            // get a card (face down) from deck for player 1


                // check if deck is empty


            // get a card (face down) from deck for player 2


                // check if deck is empty


            // determine who wins this hand, compare rank first


            // do you want to terminate game


        // END OF LOOP


        // finished with Game of War, identify winner

        /*
        System.out.println("The WINNER is:");
        if (player1Wins>player2Wins) {
            System.out.println("Player 1 wins " + player1Wins + " games, out of a total of " +
                    (player1Wins + player2Wins) + " games");
        } else if (player2Wins>player1Wins) {
            System.out.println("Player 2 wins " + player2Wins + " games, out of a total of " +
                    (player1Wins + player2Wins) + " games");
        } else {  // tie
            System.out.println("IT IS A TIE!!!!!!!");
        }
        */
    }

}
