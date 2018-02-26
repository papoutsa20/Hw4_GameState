package com.example.papoutsa20.gamestate;

import java.util.ArrayList;

/**
 * Created by fredenbe20 on 2/25/2018.
 */

public class UnoGameState {
    //Different groupings of cards
    ArrayList<Card> drawPile = new ArrayList<Card>();
    ArrayList<Card> discardPile = new ArrayList<Card>();
    ArrayList<Card> player1Hand = new ArrayList<Card>();
    ArrayList<Card> player2Hand = new ArrayList<Card>();
    ArrayList<Card> player3Hand = new ArrayList<Card>();
    ArrayList<Card> player4Hand = new ArrayList<Card>();

    //String-based info
    String player1Name;
    String player2Name;
    String player3Name;
    String player4Name;
    String currentPlayer;

    //number-based info
    int turn;
    int cardsInDraw;
    int cardsInDiscard;
    int numOfPlayers;
    int numPlayer1Cards;
    int numPlayer2Cards;
    int numPlayer3Cards;
    int numPlayer4Cards;

    //game direction
    boolean gameDirection; //true = clockwise; false = counterclockwise


    @Override
    public String toString() {
        String str = "";
        str += "Player1 #cards:" + player1Hand.size();
        str += "\n";
        str += "Player1 #cards:" + player2Hand.size();
        str += "\n";
        str += "Player1 #cards:" + player3Hand.size();
        str += "\n";
        str += "Player1 #cards:" + player4Hand.size();
        return str;
    }

    public boolean drawCard() {
        if (drawPile.size() < 1) return false;
        switch (this.turn % 4) {
            case 0:
                player1Hand.add(discardPile.remove(0));
                break;
            case 1:
                player2Hand.add(discardPile.remove(0));
                break;
            case 2:
                player3Hand.add(discardPile.remove(0));
                break;
            case 3:
                player4Hand.add(discardPile.remove(0));
                break;
        }
        return true;


    }

    public boolean placeCard(Card toPlace) {
        switch (this.turn % 4) {
            case 0:
                player1Hand.remove(toPlace);
                discardPile.add(0, toPlace);
                break;
            case 1:
                player2Hand.remove(toPlace);
                discardPile.add(0, toPlace);
                break;
            case 2:
                player3Hand.remove(toPlace);
                discardPile.add(0, toPlace);
                break;
            case 3:
                player4Hand.remove(toPlace);
                discardPile.add(0, toPlace);
                break;

        }
        return true;
    }


}
