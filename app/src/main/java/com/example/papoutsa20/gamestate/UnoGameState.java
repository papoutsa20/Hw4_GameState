package com.example.papoutsa20.gamestate;

import java.util.ArrayList;

/**
 * Created by fredenbe20 on 2/25/2018.
 * Authors: Stelios Papoutsakis, Chris Fishback,
 *          Alli Jacobs, Mason Fredenberg
 */

public class UnoGameState{
    //Different groupings of cards
    ArrayList<Card> player1Hand = new ArrayList<Card>();
    ArrayList<Card> player2Hand = new ArrayList<Card>();
    ArrayList<Card> player3Hand = new ArrayList<Card>();
    ArrayList<Card> player4Hand = new ArrayList<Card>();



    ArrayList<Card> currentPlayerHand = new ArrayList<Card>();

    //String-based info
    String player1Name;
    String player2Name;
    String player3Name;
    String player4Name;
    String color;

    //number-based info
    int turn;
    int cardsInDraw;
    int cardsInDiscard;
    int numOfPlayers;
    int numPlayer1Cards;
    int numPlayer2Cards;
    int numPlayer3Cards;
    int numPlayer4Cards;
    int numCurrentPlayerCards;
    int currentPlayer;

    //card based info
    Card topOfDiscard;

    //game direction
    boolean gameDirection; //true = clockwise; false = counterclockwise

    //Deck drawpile and discardpile
    Deck drawPile= new Deck(false);
    Deck discardPile=new Deck(true);


    public UnoGameState(){
        //filling the drawPile with Cards
        //dealing 7 cards to each player from the top of the deck in traditional fasion
        for(int i = 0; i < 7; i++){
            for(int j = 1; j <= numOfPlayers; ){
                if(j == 1){
                    player1Hand.add(drawPile.take());
                }
                else if(j == 2){

                    player2Hand.add(drawPile.take());
                }
                else if(j == 3){
                    player3Hand.add(drawPile.take());
                }
                else if(j == 4){
                    player4Hand.add(drawPile.take());
                }
            }
        }

        //setting all of the integer-based info
        turn = 0;
        cardsInDraw = drawPile.getDeckSize();
        cardsInDiscard = discardPile.getDeckSize();
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
        currentPlayer = turn;
        currentPlayerHand = player1Hand;
        numCurrentPlayerCards = numPlayer1Cards;

        //moving the top card from drawPile to discardPile
        discardPile.put(drawPile.take());

        topOfDiscard = discardPile.getTopCard();
    }

    public UnoGameState(UnoGameState masterGameState){
        //copying over the drawPile
        for(int i = 0; i < masterGameState.cardsInDraw; i++){
            this.drawPile.put(masterGameState.drawPile.getCardAt(i), i);
        }

        //copying top of discardPile
        this.topOfDiscard = masterGameState.topOfDiscard;

        //copying currentPlayer's hand
        if(masterGameState.currentPlayer == 0){
            for(int i = 0; i < masterGameState.numCurrentPlayerCards; i++){
                this.currentPlayerHand.add(i, masterGameState.currentPlayerHand.get(i));
            }
        }
        else if(masterGameState.currentPlayer == 1){
            for(int i = 0; i < masterGameState.numCurrentPlayerCards; i++){
                this.currentPlayerHand.add(i, masterGameState.currentPlayerHand.get(i));
            }
        }
        else if(masterGameState.currentPlayer == 2){
            for(int i = 0; i < masterGameState.numCurrentPlayerCards; i++){
                this.currentPlayerHand.add(i, masterGameState.currentPlayerHand.get(i));
            }
        }
        else if(masterGameState.currentPlayer == 3){
            for(int i = 0; i < masterGameState.numCurrentPlayerCards; i++){
                this.currentPlayerHand.add(i, masterGameState.currentPlayerHand.get(i));
            }
        }


        //copying each Integer-based variable
        this.turn = masterGameState.turn;
        this.numOfPlayers = masterGameState.numOfPlayers;
        this.numPlayer1Cards = masterGameState.numPlayer1Cards;
        this.numPlayer2Cards = masterGameState.numPlayer2Cards;
        this.numPlayer3Cards = masterGameState.numPlayer3Cards;
        this.numPlayer4Cards = masterGameState.numPlayer4Cards;
        this.numCurrentPlayerCards = masterGameState.numCurrentPlayerCards;
        this.currentPlayer = masterGameState.currentPlayer;

        //copying gameDirection
        this.gameDirection = masterGameState.gameDirection;





    }


    //method converts all variables into a string
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


        //return false if there are no cards to draw from
    public boolean drawCard(int playerId) {
        if (drawPile.getDeckSize() < 1) return false;
        //gets the player and adds a card to his/her hand
        switch (playerId) {
            case 0:
                player1Hand.add(discardPile.take());
                break;
            case 1:
                player2Hand.add(discardPile.take());
                break;
            case 2:
                player3Hand.add(discardPile.take());
                break;
            case 3:
                player4Hand.add(discardPile.take());
                break;
        }
        return true;


    }

    /*method places a card onto the discard pile
    @return true if player can place card
     */
    public boolean placeCard(int playerId,Card toPlace) {

        //gets the player, removes the card,
        //and adds the card to the discard pile
        switch (playerId) {
            case 0:
                player1Hand.remove(toPlace);
                discardPile.put(toPlace);
                break;
            case 1:
                player2Hand.remove(toPlace);
                discardPile.put(toPlace);
                break;
            case 2:
                player3Hand.remove(toPlace);
                discardPile.put(toPlace);
                break;
            case 3:
                player4Hand.remove(toPlace);
                discardPile.put(toPlace);
                break;

        }
        return true;
    }

    /*
  method draws a card and moves turn on to the next player
   @ return true
    */
    public boolean skipTurn(int playerId)
    {
        drawCard(playerId);
        this.turn++;
        return true;
    }

    /*
    method that quits game
    @ return true
     */
    public boolean quit(int playerId){
        System.exit(0);
        return true;
    }

    /*
    method that is called to see if player has uno
    @ return true if player has uno, false otherwise
     */
    public boolean hasUno(int playerId) {
        switch (playerId) {
            case 0:
                if (player1Hand.size() < 1) return true;
                return false;
            case 1:
                if (player2Hand.size() < 1) return true;
                return false;
            case 2:
                if (player3Hand.size() < 1) return true;
                return false;
            case 3:
                if (player4Hand.size() < 1) return true;
                return false;
        }
        return false;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCurrentPlayer()
    {
        return currentPlayer;
    }

    public ArrayList<Card> getCurrentPlayerHand() {
        return currentPlayerHand;
    }

}