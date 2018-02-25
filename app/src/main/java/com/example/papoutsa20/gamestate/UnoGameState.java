package com.example.papoutsa20.gamestate;

import java.util.ArrayList;

/**
 * Created by fishback20 on 2/25/2018.
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

}
