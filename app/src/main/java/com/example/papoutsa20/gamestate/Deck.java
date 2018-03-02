package com.example.papoutsa20.gamestate;

import java.util.ArrayList;

/**
 * Created by steli on 3/2/2018.
 */

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck(boolean isEmpty) {
     if(!isEmpty) {
         String[] str = {"Reverse", "Draw two", "Wild", "Wild draw 2", "Skip"};
         for(String specialCard: str)
         {
             deck.add(new Card(-1,specialCard,"Red"));
             deck.add(new Card(-1,specialCard,"Yellow"));
             deck.add(new Card(-1,specialCard,"Green"));
             deck.add(new Card(-1,specialCard,"Blue"));
         }

         for(int i = 0; i < 10; i++)
         {
             deck.add(new Card(i,null,"Red"));
             deck.add(new Card(i,null,"Yellow"));
             deck.add(new Card(i,null,"Green"));
             deck.add(new Card(i,null,"Blue"));
             deck.add(new Card(i,null,"Red"));
             deck.add(new Card(i,null,"Yellow"));
             deck.add(new Card(i,null,"Green"));
             deck.add(new Card(i,null,"Blue"));
             if(i != 0)
             {
                 deck.add(new Card(i,null,"Red"));
                 deck.add(new Card(i,null,"Yellow"));
                 deck.add(new Card(i,null,"Green"));
                 deck.add(new Card(i,null,"Blue"));
             }

         }

     }
    }




}

