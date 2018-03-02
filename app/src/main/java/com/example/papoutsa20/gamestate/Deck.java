package com.example.papoutsa20.gamestate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by steli on 3/2/2018.
 */

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck(boolean isEmpty) {
        if (!isEmpty) {
            String[] str = {"Reverse", "Draw two", "Wild", "Wild draw 2", "Skip"};
            for (String specialCard : str) {
                deck.add(new Card(-1, specialCard, "Red"));
                deck.add(new Card(-1, specialCard, "Yellow"));
                deck.add(new Card(-1, specialCard, "Green"));
                deck.add(new Card(-1, specialCard, "Blue"));
                deck.add(new Card(-1, specialCard, "Red"));
                deck.add(new Card(-1, specialCard, "Yellow"));
                deck.add(new Card(-1, specialCard, "Green"));
                deck.add(new Card(-1, specialCard, "Blue"));
            }

            for (int i = 0; i < 10; i++) {
                deck.add(new Card(i, null, "Red"));
                deck.add(new Card(i, null, "Yellow"));
                deck.add(new Card(i, null, "Green"));
                deck.add(new Card(i, null, "Blue"));
                if (i != 0) {
                    deck.add(new Card(i, null, "Red"));
                    deck.add(new Card(i, null, "Yellow"));
                    deck.add(new Card(i, null, "Green"));
                    deck.add(new Card(i, null, "Blue"));
                }

            }
            this.suffle();

        }
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

    public Card getCardAt(int index){return deck.get(index);}

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public int getDeckSize(){return deck.size();}

    public Card getTopCard(){return deck.get(0);}


}

