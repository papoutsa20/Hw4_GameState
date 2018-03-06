package com.example.papoutsa20.gamestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @Authors: Stelios Papoutsakis, Chris Fishback,
 * Alli Jacobs, Mason Fredenberg
 */
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

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

            //create an original instance of UnoGameState
            UnoGameState firstInstance = new UnoGameState();

            //create second instance of the game state for a deep copy of
            // firstInstance
            UnoGameState secondInstance = new UnoGameState(firstInstance,0);

            //make changes to first instance to see if the deep copy works
            firstInstance.drawCard(firstInstance.getCurrentPlayer());
            this.tv.setText("Player 1 has drawn a card\n");
            firstInstance.placeCard(firstInstance.getCurrentPlayer(),
                    firstInstance.getCurrentPlayerHand().get(0));
            this.tv.setText(this.tv.getText() +"Player 1 has placed a card\n");
            this.tv.setText(this.tv.getText() +"does player 1 have uno?" +
                    firstInstance.hasUno
                            (firstInstance.getCurrentPlayer()) + "\n");
            firstInstance.skipTurn(firstInstance.getCurrentPlayer());
            this.tv.setText(this.tv.getText() +
                    "Player 1 has skipped their turn!!\n");

            //below line is commented as otherwise it would quit the program
            //firstInstance.quit(firstInstance.getCurrentPlayer());

            //create new instances to check deep copy
            UnoGameState thirdInstance = new UnoGameState();
            UnoGameState fourthInstance = new UnoGameState(thirdInstance,0);

            //send values of second and fourth instance to the view to test deep copy
            this.tv.setText(this.tv.getText() + "Tostring of second instance!\n"
                    + secondInstance.toString() + "\n");
            this.tv.setText(this.tv.getText() + "Tostring of fourth instance!\n"
                    + fourthInstance.toString() + "\n");


        }

    }


}

