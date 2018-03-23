package com.example.papoutsa20.gamestate;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fishback20 on 3/22/2018.
 */
public class UnoGameStateTest {
    @Test
    public void drawCard() throws Exception {
        UnoGameState uno = new UnoGameState();
        Deck newDeck = uno.getDrawPile();
        for(int i = 0; i < 79; i++)
        {
            newDeck.getDeck().remove(0);
        }
        assertFalse(uno.drawCard(uno.getCurrentPlayer()));
        assertFalse(uno.drawCard(uno.getCurrentPlayer() + 1));

    }

    @Test
    public void placeCard() throws Exception {
        UnoGameState uno = new UnoGameState();
        assertFalse(uno.placeCard(uno.getCurrentPlayer() + 1, new Card(0,"wild","blue")));
        uno.getCurrentPlayerHand().clear();
        assertFalse(uno.placeCard(uno.getCurrentPlayer(), new Card(0,"wild","blue")));

    }

    @Test
    public void skipTurn() throws Exception {
        UnoGameState uno = new UnoGameState();
        assertFalse(uno.skipTurn(uno.getCurrentPlayer()+1));

    }

    @Test
    public void quit() throws Exception {

    }

    @Test
    public void hasUno() throws Exception {
        UnoGameState uno = new UnoGameState();
        assertFalse(uno.hasUno(uno.getCurrentPlayer()));

        for(int i = 0; i < 6; i++) {
            uno.placeCard(0,uno.getCurrentPlayerHand().remove(0));
        }



        //assertEquals(uno.getCurrentPlayerHand().size(),1);
        //Log.i("Numbes", uno.getCurrentPlayerHand().size() + "");
        assertTrue(uno.hasUno(uno.getCurrentPlayer()));




    }

}