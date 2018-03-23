package com.example.papoutsa20.gamestate;

/**
 * Created by fredenbe20 on 2/25/2018.
 *
 * The card class is an object for an uno card with a specific value,
 * type, and color.
 *
 * @author Stelios Papoutsakis
 * @author Chris Fishback
 * @author Alli Jacobs
 * @author Mason Fredenberg
 */

public class Card {

    //description variables for the card
    private int cardVal;
    private String type;
    private String color;

    public Card(int cardVal, String type, String color)
    {
        this.cardVal = cardVal;
        this.color = color;
        this.type = type;
    }

    //getters
    public int getCardVal() {
        return cardVal;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }


}
