package com.example.papoutsa20.gamestate;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by fredenbe20 on 2/25/2018.
 * Authors: Stelios Papoutsakis, Chris Fishback,
 * Alli Jacobs, Mason Fredenberg
 */

public class UnoGameState {
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
    private int player1NumCards;
    private int player2NumCards;
    private int player3NumCards;
    private int player4NumCards;


    //card based info
    protected Card topOfDiscard;

    //game direction
    private boolean gameDirection; //true = clockwise; false = counterclockwise

    //Deck drawpile and discardpile
    private Deck drawPile = new Deck();
    private Deck discardPile = new Deck();


    /*
    * regular constructor
    */
    public UnoGameState() {
        //filling the drawPile with Cards
        //dealing 7 cards to each player from the top of the deck in traditional fasion

        this.drawPile.add108();


        this.numOfPlayers = 4;
        for (int i = 0; i < numOfPlayers; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0) {
                    this.player1Hand.add(drawPile.take());
                } else if (i == 1) {

                    this.player2Hand.add(drawPile.take());
                } else if (i == 2) {
                    this.player3Hand.add(drawPile.take());
                } else if (i == 3) {
                    this.player4Hand.add(drawPile.take());
                }
            }
        }

        //setting all of the integer-based info
        this.turn = 0;
        this.cardsInDraw = drawPile.getDeckSize();
        this.cardsInDiscard = discardPile.getDeckSize();
        this.player1NumCards = player1Hand.size();
        this.player2NumCards = player2Hand.size();
        this.player3NumCards = player3Hand.size();
        this.player4NumCards = player4Hand.size();


        //setting game direction clockwise
        this.gameDirection = true;

        //setting the player names
        this.player1Name = "";
        this.player2Name = "";
        this.player3Name = "";
        this.player4Name = "";

        //setting the first turn player
        this.turn = 0;
        this.currentPlayerHand = player1Hand;

        //moving the top card from drawPile to discardPile
        this.discardPile.put(drawPile.take());

        this.topOfDiscard = discardPile.getTopCard();
        this.color = topOfDiscard.getColor();
    }

    /*
    * this constructor is used to make a deep copy of the game state
    */
    public UnoGameState(UnoGameState masterGameState, int playerID) {

        // telling the game state whose turn it is
        this.turn = playerID;

        //copying over the drawPile ** -1 added to fixed bug that crashed program
        for (int i = 0; i < (masterGameState.cardsInDraw - 1); i++) {
            Card card = masterGameState.drawPile.getCard(i);
            this.drawPile.put(new Card(card.getCardVal(),
                    card.getType(),
                    card.getColor()), i);

        }

        //copying top of discardPile
        this.topOfDiscard = new Card(masterGameState.topOfDiscard.getCardVal()
                ,masterGameState.topOfDiscard.getType(),masterGameState.topOfDiscard.getColor());


        //copying currentPlayer's hand
        if (this.turn == 0) {
            for (int i = 0; i < masterGameState.player1Hand.size(); i++) {
                this.player1Hand.add(i, new Card(masterGameState.player1Hand.get(i).getCardVal(),
                        masterGameState.player1Hand.get(i).getType(),
                        masterGameState.player1Hand.get(i).getColor()));

            }
            this.currentPlayerHand = player1Hand;
            this.currentPlayer = masterGameState.player1Name;
        } else if (this.turn == 1) {
            for (int i = 0; i < masterGameState.player2Hand.size(); i++) {
                this.player2Hand.add(i, new Card(masterGameState.player2Hand.get(i).getCardVal(),
                        masterGameState.player2Hand.get(i).getType(),
                        masterGameState.player2Hand.get(i).getColor()));
            }
            this.currentPlayerHand = player2Hand;
            this.currentPlayer = masterGameState.player2Name;
        } else if (this.turn == 2) {
            for (int i = 0; i < masterGameState.player3Hand.size(); i++) {
                this.player3Hand.add(i, new Card(masterGameState.player3Hand.get(i).getCardVal(),
                        masterGameState.player3Hand.get(i).getType(),
                        masterGameState.player3Hand.get(i).getColor()));

            }
            this.currentPlayerHand = player3Hand;
            this.currentPlayer = masterGameState.player3Name;
        } else if (this.turn == 3) {
            for (int i = 0; i < masterGameState.player4Hand.size(); i++) {
                this.player4Hand.add(i, new Card(masterGameState.player4Hand.get(i).getCardVal(),
                        masterGameState.player4Hand.get(i).getType(),
                        masterGameState.player4Hand.get(i).getColor()));
            }
            this.currentPlayerHand = player4Hand;
            this.currentPlayer = masterGameState.player4Name;

        }
        //copying color
        this.color = this.topOfDiscard.getColor();


        //copying each Integer-based variable
        this.numOfPlayers = masterGameState.numOfPlayers;
        this.player1NumCards = masterGameState.player1Hand.size();
        this.player2NumCards = masterGameState.player2Hand.size();
        this.player3NumCards = masterGameState.player3Hand.size();
        this.player4NumCards = masterGameState.player4Hand.size();


        //copying gameDirection
        this.gameDirection = masterGameState.gameDirection;


    }

    /*
    * method converts all variables into strings
    */
    @Override
    public String toString() {
        String str = "\n";
        str = "# cards in draw pile: " + drawPile.getDeckSize();
        str += "\n";

        str += "Player1 #cards: " + this.player1NumCards;
        str += "\n";

        str += "Player2 #cards: " + this.player2NumCards;
        str += "\n";

        str += "Player3 #cards: " + this.player3NumCards;
        str += "\n";

        str += "Player4 #cards: " + this.player4NumCards;
        str += "\n";

        str += "current player: " + this.turn;
        str += "\n";
        str += "card Val: ";
        for (Card card : this.currentPlayerHand) {
            str += " " + card.getCardVal();
        }
        str += "\n";

        str += "Top card in discard pile: " + this.topOfDiscard.getCardVal();
        str += "\n";
        str += "Game direction: " + this.gameDirection;
        str += "\n";
        str+= "Current color: " + this.color;

        str += "\n";
        str += "\n";
        str += "\n";


        return str;
    }

    /*
    * draws a card from the deck and puts it into the players hand
    * @return true if player can draw a card
    */
    public boolean drawCard(int playerId) {
        //return false if there are no cards to draw from
        if (this.drawPile.getDeckSize() < 1 || playerId != this.turn) return false;
        //gets the player and adds a card to his/her hand
        this.currentPlayerHand.add(this.drawPile.take());
        switch (playerId) {
            case 0:
                player1NumCards++;
                break;
            case 1:
                player2NumCards++;
                break;
            case 2:
                player3NumCards++;
                break;
            case 3:
                player4NumCards++;
                break;

        }


        return true;
    }


    /* method places a card onto the discard pile
    * @return true if player can place card
    */
    public boolean placeCard(int playerId, Card toPlace) {

        if (playerId != this.turn) return false;

        //gets the player, removes the card,
        //and adds the card to the discard pile
        currentPlayerHand.remove(toPlace);
        discardPile.put(toPlace);
        switch (playerId) {
            case 0:
                player1NumCards--;
                break;
            case 1:
                player2NumCards--;
                break;
            case 2:
                player3NumCards--;
                break;
            case 3:
                player4NumCards--;
                break;

        }


        return true;
    }

    /*
    * method draws a card and moves turn on to the next player
    * @return true if skip turn is possible
    */
    public boolean skipTurn(int playerId) {
        if (playerId != this.turn) return false;

        drawCard(playerId);
        this.turn++;

        return true;
    }

    /*
    * method that quits game
    * @return true
    */
    public boolean quit(int playerId) {
        System.exit(0);
        return true;
    }

    /*
    * method that is called to see if player has uno
    * @return true if player has uno, false otherwise
    */
    public boolean hasUno(int playerId) {

        switch (playerId) {
            case 0:
                if (this.player1NumCards < 1) return true;
                return false;
            case 1:
                if (this.player2NumCards < 1) return true;
                return false;
            case 2:
                if (this.player3NumCards < 1) return true;
                return false;
            case 3:
                if (this.player4NumCards < 1) return true;
                return false;
        }

        return false;
    }

    //getters and setters
    public void setColor(String color) {
        this.color = color;
    }

    public int getTurn() {
        return turn;
    }

    public int getCurrentPlayer() {
        return turn;
    }

    public ArrayList<Card> getCurrentPlayerHand() {
        return currentPlayerHand;
    }

}