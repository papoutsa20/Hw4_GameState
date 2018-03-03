package com.example.papoutsa20.gamestate;

import java.util.ArrayList;

/**
 * Created by fredenbe20 on 2/25/2018.
 * Authors: Stelios Papoutsakis, Chris Fishback,
 *          Alli Jacobs, Mason Fredenberg
 */

public class UnoGameState{
    //Different groupings of cards
    private ArrayList<Card> player1Hand = new ArrayList<Card>();
    private ArrayList<Card> player2Hand = new ArrayList<Card>();
    private ArrayList<Card> player3Hand = new ArrayList<Card>();
    private ArrayList<Card> player4Hand = new ArrayList<Card>();



    private ArrayList<Card> currentPlayerHand;

    //String-based info
    private String player1Name;
    private String player2Name;
    private String player3Name;
    private String player4Name;
    private String currentPlayer;
    private String color;

    //number-based info
    private int turn;
    private int cardsInDraw;
    private int cardsInDiscard;
    private int numOfPlayers;
    private int numPlayer1Cards;
    private int numPlayer2Cards;
    private int numPlayer3Cards;
    private int numPlayer4Cards;
    private int numCurrentPlayerCards;

    //card based info
    protected Card topOfDiscard;

    //game direction
    private boolean gameDirection; //true = clockwise; false = counterclockwise

    //Deck drawpile and discardpile
    private Deck drawPile= new Deck(false);
    private Deck discardPile=new Deck(true);


    public UnoGameState(){
        //filling the drawPile with Cards
        //dealing 7 cards to each player from the top of the deck in traditional fasion
        numOfPlayers = 4;
        for(int i = 0; i < numOfPlayers; i++){
            for(int j = 0; j < 7; j++ ){
                if(i == 0){
                    player1Hand.add(drawPile.take());
                }
                else if(i == 1){

                    player2Hand.add(drawPile.take());
                }
                else if(i == 2){
                    player3Hand.add(drawPile.take());
                }
                else if(i == 3){
                    player4Hand.add(drawPile.take());
                }
            }
        }

        //setting all of the integer-based info
        turn = 0;
        cardsInDraw = drawPile.getDeckSize();
        cardsInDiscard = discardPile.getDeckSize();

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
        turn = 0;
        currentPlayerHand = player1Hand;
        numCurrentPlayerCards = numPlayer1Cards;

        //moving the top card from drawPile to discardPile
        discardPile.put(drawPile.take());

        topOfDiscard = discardPile.getTopCard();
    }

    public UnoGameState(UnoGameState masterGameState){

        //copying over the drawPile
        for(int i = 0; i < (masterGameState.cardsInDraw-1); i++){
            this.drawPile.put(masterGameState.drawPile.getCardAt(i), i);
        }

        //copying top of discardPile
        this.topOfDiscard = new Card(masterGameState.topOfDiscard.getCardVal(),masterGameState.topOfDiscard.getType()
                ,masterGameState.topOfDiscard.getColor());

        //copying currentPlayer's hand
        if(masterGameState.turn == 0){
            for(int i = 0; i < masterGameState.numCurrentPlayerCards; i++){
                this.player1Hand.add(i, masterGameState.currentPlayerHand.get(i));

            }
            this.currentPlayerHand = player1Hand;
        }
        else if(masterGameState.turn == 1){
            for(int i = 0; i < masterGameState.numCurrentPlayerCards; i++){
                this.player2Hand.add(i, masterGameState.currentPlayerHand.get(i));
            }
            this.currentPlayerHand = player2Hand;
        }
        else if(masterGameState.turn == 2){
            for(int i = 0; i < masterGameState.numCurrentPlayerCards; i++){
                this.player3Hand.add(i, masterGameState.currentPlayerHand.get(i));

            }
            this.currentPlayerHand = player3Hand;
        }
        else if(masterGameState.turn == 3){
            for(int i = 0; i < masterGameState.numCurrentPlayerCards; i++){
                this.player4Hand.add(i, masterGameState.currentPlayerHand.get(i));
            }
            this.currentPlayerHand = player4Hand;

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
        if (drawPile.getDeckSize() < 1 || playerId != this.turn) return false;
        //gets the player and adds a card to his/her hand
        this.currentPlayerHand.add(drawPile.take());
        return true;
        }





    /*method places a card onto the discard pile
    @return true if player can place card
     */
    public boolean placeCard(int playerId,Card toPlace) {

        if (playerId != this.turn) return false;

        //gets the player, removes the card,
        //and adds the card to the discard pile
       currentPlayerHand.remove(toPlace);
        discardPile.put(toPlace);
        return true;
    }

    /*
  method draws a card and moves turn on to the next player
   @ return true
    */
    public boolean skipTurn(int playerId)
    {
        if (playerId != this.turn) return false;

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
        return turn;
    }

    public ArrayList<Card> getCurrentPlayerHand() {
        return currentPlayerHand;
    }

}