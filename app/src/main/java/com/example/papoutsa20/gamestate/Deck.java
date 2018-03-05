package com.example.papoutsa20.gamestate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by steli on 3/2/2018.
 * *Authors: Stelios Papoutsakis, Chris Fishback,
 *           Alli Jacobs, Mason Fredenberg
 */

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

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
        this.suffle();
    }

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

    public void put(Card card) {
        put(card, 0);
    }

    public void put(Card card, int index) {
        this.deck.add(index, card);
    }

    public Card take() {
        return deck.remove(0);
    }
    public Card getCard(int index) {return deck.get(index);}

    public Card getCardAt(int index){return deck.get(index);}

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public int getDeckSize(){return deck.size();}

    public Card getTopCard(){return deck.get(0);}


}

