package com.example.papoutsa20.gamestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private EditText tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    public void onClick(View v) {
        if (v.getId() == R.id.buttonTest) {
            this.tv.setText("");
            UnoGameState firstInstance = new UnoGameState();
            UnoGameState secondInstance = new UnoGameState(firstInstance,1);
            firstInstance.drawCard(firstInstance.getCurrentPlayer());
            this.tv.setText("Player 1 has drawn a card/n");
            firstInstance.placeCard(firstInstance.getCurrentPlayer(),firstInstance.getCurrentPlayerHand().get(0));
            this.tv.setText(this.tv.getText() + "Player 1 has placed a card/n");

        }

    }


    }
}
