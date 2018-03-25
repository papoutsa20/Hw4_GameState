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
    private int cardVal; //1-9: numbers, 10: skip, 11: reverse,
                         //12: draw2, 13: wild, 14: wild draw 4
    private String color;

    public Card(int cardVal, String color)
    {
        this.cardVal = cardVal;
        this.color = color;
    }

    //getters
    public int getCardVal() {
        return cardVal;
    }

    public String getColor() {
        return color;
    }


}
