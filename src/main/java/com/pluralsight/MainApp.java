package com.pluralsight;

import java.util.Scanner;

//Prompt the user for the number of players that will be playing the game. Then create that many Hands.
//If you have time. Take turns and allow each player to choose if they want to Hit to take another card, or to Stay.
//Ace is worth 11 points by default. Add logic to count Ace as 1 point if 11 would cause the hand to bust.

public class MainApp {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();

        homeScreen();
        System.out.print("Please Enter Player 1's Name: ");
        String player1Name = input.nextLine();

        System.out.print("Please Enter Player 2's Name: ");
        String player2Name = input.nextLine();

        deck.shuffle();

        // deal 5 cards
        for(int i = 0; i < 2; i++) {
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the hand
            player1Hand.deal(card);
            player2Hand.deal(card);
        }

        int handValue = player1Hand.getValue();
        System.out.println(player1Name + " hand is worth " + handValue);
        int handValue2 = player2Hand.getValue();
        System.out.println(player2Name + " hand is worth " + handValue);

        while(true){
            System.out.print(player1Name + " Would You Like To Hit or Stay (H/S): ");
            String player1Choice = input.nextLine().toUpperCase();

            System.out.print(player2Name + " Would You Like To Hit or Stay (H/S): ");
            String player2Choice = input.nextLine().toUpperCase();

            Card card1 = deck.deal();

            if(player1Choice.equals("H")){
                player1Hand.deal(card1);
            }else if(player1Choice.equals("S")){
                break;
            }

            if(player2Choice.equals("H")){
                player2Hand.deal(card1);
            }else if(player2Choice.equals("S")){
                break;
            }

            int player1Value = player1Hand.getValue();
            System.out.println(player1Name + " hand is worth " + player1Value);
            int player2Value = player2Hand.getValue();
            System.out.println(player2Name + " hand is worth " + player2Value);

            if(player1Hand.getValue() >= 21) break;
            if(player2Hand.getValue() >= 21) break;

        }


    }
    public static void homeScreen(){
        System.out.println("Welcome to the BlackJack");
        System.out.println("========================");
    }
}
