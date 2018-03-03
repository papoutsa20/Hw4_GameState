package com.example.papoutsa20.gamestate;

/**
 * Created by fredenbe20 on 2/25/2018.
 * *Authors: Stelios Papoutsakis, Chris Fishback,
 *           Alli Jacobs, Mason Fredenberg
 */

public class Card {


    private int cardVal;
    private String type;
    private String color;

    public Card(int cardVal, String type, String color)
    {
        this.cardVal = cardVal;
        this.type = type;
        this.color = color;
    }

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
