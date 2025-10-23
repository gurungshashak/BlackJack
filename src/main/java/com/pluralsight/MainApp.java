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
            Card card = deck.deal();

            System.out.print(player1Name + " Would you Like to Stay or Hit(h/s): ");
            String player1Choice = input.nextLine().toUpperCase();
            System.out.print(player2Name + " Would you Like to Hit(h/s): ");
            String player2Choice = input.nextLine().toLowerCase();

            boolean player1Hits = player1Choice.equals("");
            boolean player2Hits = player2Choice.equals("");

            int player1Value = player1Hand.getValue();
            int player2Value = player2Hand.getValue();

            if(player1Value == 21 && player2Value == 21){
                System.out.println(player1Name + " Hand Worth Is " + player1Value);
                System.out.println(player2Name + " Hand Worth Is " + player2Value);
                System.out.println("Its A Draw!!! Run It Again!!!");
                break;
            }else if(player1Value == 21 ){
                System.out.println(player1Name + " BlackJack!!");
                player1Hits = false;
            }else if(player2Value == 21 ){
                System.out.println(player2Name + " BlackJack!!");
                player2Hits = false;
            }

            if(player1Choice.equalsIgnoreCase("H")){
                player1Hand.deal(card);
            } if(player1Choice.equalsIgnoreCase("S")){
                player1Hits = false;
            }
            if(player2Choice.equalsIgnoreCase("H")){
                player2Hand.deal(card);
            }if(player2Choice.equalsIgnoreCase("S")){
                player2Hits = false;
            }
            if(player1Value == player2Value ){
                System.out.println(player1Name + " Hand Worth Is " + player1Value);
                System.out.println(player2Name + " Hand Worth Is " + player2Value);
                System.out.println("Its A Draw!!! Run It Again!!!");
                break;
            }

            if(player1Value > player2Value){
                System.out.println(player1Name + " Hand Worth Is " + player1Value);
                System.out.println(player2Name + " Hand Worth Is " + player2Value + "\n");
                System.out.println(player1Name + " Has Won!!");
            }else if(player1Value < player2Value){
                System.out.println(player1Name + " Hand Worth Is " + player1Value);
                System.out.println(player2Name + " Hand Worth Is " + player2Value + "\n");
                System.out.println(player1Name + " Has Won!!");
            }

        }

    }
    public static void homeScreen(){
        System.out.println("Welcome to the BlackJack");
        System.out.println("========================");
    }
}
