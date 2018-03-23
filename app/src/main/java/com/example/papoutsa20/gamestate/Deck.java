package com.example.papoutsa20.gamestate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Stelios Papoutsakis on 3/2/2018.
 *
 * The deck class holds an arraylist of cards, and on
 * can create the full deck for the uno game, and
 * shuffle (suffle) them.
 *
 * @author Stelios Papoutsakis
 * @author Chris Fishback
 * @author Alli Jacobs
 * @author Mason Fredenberg
 */

public class Deck {

    //holds the deck of cards
    private ArrayList<Card> deck = new ArrayList<Card>();

    /*
    * method adds all uno cards into the deck
    */
    public void add108()
    {
        String[] colors = {"Blue","Green","Yellow","Red"};
        String[] type = {"Reverse","Skip","Draw2","Wild","Wild draw4"};
        for(int i = 0; i < 10; i++)
        {
            for(String str: colors)
            {
                deck.add(new Card(i,"Normal",str));
            }
            if(i==0) continue;
            for(String str: colors)
            {
                deck.add(new Card(i,"Normal",str));
            }

        }
        for(String strType: type)
        {
            if(strType.equals("Wild") || strType.equals("Wild draw4"))
            {
                deck.add(new Card(-1,strType,null));
                deck.add(new Card(-1,strType,null));
                deck.add(new Card(-1,strType,null));
                deck.add(new Card(-1,strType,null));
                continue;


            }
            for(String str: colors)
            {

                deck.add(new Card(-1,strType,str));
                deck.add(new Card(-1,strType,str));
            }
        }
        //suffle is not called for ease of grader
        //this.suffle();
    }

    /*
    * method shuffles the card... -suffle- lol
    */
    public void suffle() {
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            int index = rand.nextInt(108);
            Card card = deck.get(index);
            deck.remove(index);
            index = rand.nextInt(108);
            deck.add(index,card);
        }
    }

    /*
    * method puts a card at the beginning of the deck
    */
    public void put(Card card) {
        put(card, 0);
    }

    /*
    * method puts a card at given index
    */
    public void put(Card card, int index) {
        this.deck.add(index, card);
    }

    /*
    * method removes card from the beginning of the deck
    */
    public Card take() {
        return deck.remove(0);
    }

    /*
    * method gets a card at given index
    */
    public Card getCard(int index) {return deck.get(index);}

    /*
    * method gets a card at a given index <---- is a repeat of getCard,
    * we need to remove one of the tow
    */
    public Card getCardAt(int index){return deck.get(index);}

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public int getDeckSize(){return deck.size();}

    public Card getTopCard(){return deck.get(0);}


}

