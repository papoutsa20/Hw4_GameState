package com.example.papoutsa20.gamestate;

import java.util.ArrayList;

/**
 * Created by fredenbe20 on 2/25/2018.
 */

public class UnoGameState{
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


    public UnoGameState(){
        //filling the drawPilw with Cards
        for(int i = 0; i < 108; i++){
            drawPile.add(i,new Card());
        }
        //dealing 7 cards to each player from the top of the deck in traditional fasion
        for(int i = 0; i < 7; i++){
            for(int j = 1; j <= numOfPlayers; ){
                if(j == 1){
                    player1Hand.add(drawPile.get(0));
                    drawPile.remove(0);
                }
                else if(j == 2){

                    player2Hand.add(drawPile.get(0));
                    drawPile.remove(0);
                }
                else if(j == 3){
                    player3Hand.add(drawPile.get(0));
                    drawPile.remove(0);
                }
                else if(j == 4){
                    player4Hand.add(drawPile.get(0));
                    drawPile.remove(0);
                }
            }
        }

        //setting all of the integer-based info
        turn = 0;
        cardsInDraw = drawPile.size();
        cardsInDiscard = discardPile.size();
        numOfPlayers = 4;
        numPlayer1Cards = player1Hand.size();
        numPlayer2Cards = player2Hand.size();
        numPlayer3Cards = player3Hand.size();
        numPlayer4Cards = player4Hand.size();

        //setting game direction clockwise
        gameDirection = true;

        //setting the player names
        player1Name = "";
        player2Name = "";
        player3Name = "";
        player4Name = "";

        //setting the first turn player
        currentPlayer = player1Name;

        //moving the top card from drawPile to discard
        discardPile.add(0, drawPile.get(0));
        drawPile.remove(0);
    }

    @Override
    public String toString()
    {
       String str = "";
        str+= "" + player1Hand.size();
        str += "\n";
        str+= "" + player2Hand.size();
        str += "\n";
        str+= "" + player3Hand.size();
        str += "\n";
        str+= "" + player4Hand.size();
        return str;
    }


}
