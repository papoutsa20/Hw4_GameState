package com.example.papoutsa20.gamestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Authors: Stelios Papoutsakis, Chris Fishback,
 *          Alli Jacobs, Mason Fredenberg
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button test = (Button) findViewById(R.id.buttonTest);
        test.setOnClickListener(this);
        this.tv = (EditText) findViewById(R.id.TestText);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.buttonTest) {
            this.tv.setText("");

            UnoGameState firstInstance = new UnoGameState();
            UnoGameState secondInstance = new UnoGameState(firstInstance);

            firstInstance.drawCard(firstInstance.getCurrentPlayer());
            this.tv.setText("Player 1 has drawn a card\n");

            firstInstance.placeCard(firstInstance.getCurrentPlayer(), firstInstance.getCurrentPlayerHand().get(0));
            this.tv.setText(this.tv.getText() + "Player 1 has placed a card\n");
            this.tv.setText(this.tv.getText() + "does player 1 have uno?" +
                    firstInstance.hasUno(firstInstance.currentPlayer) + "\n");

            firstInstance.skipTurn(firstInstance.getCurrentPlayer());
            this.tv.setText(this.tv.getText() + "Player 1 has skipped their turn!!\n");

            UnoGameState thirdInstance = new UnoGameState();
            UnoGameState fourthInstance = new UnoGameState(thirdInstance);
            this.tv.setText(this.tv.getText() + "Tostring of second instance!" + secondInstance.toString()
                    + "\n");
            this.tv.setText(this.tv.getText() + "Tostring of fourth instance!" + fourthInstance.toString()
                    + "\n");


        }

    }


}

