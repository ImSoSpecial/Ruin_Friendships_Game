package jwake.ruinfriendshipsgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CardActivity extends Activity {

    DataBaseForCards dbManager;
    TextView cardTextView;
    TextView clockTextView;
    ArrayList<Cards> cardsArrayList;
    ArrayList<Cards> trashCards;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        cardTextView = (TextView) findViewById(R.id.CardTextView);
        dbManager = new DataBaseForCards(this, null, null, 1);

        cardsArrayList = new ArrayList<Cards>();
        trashCards = new ArrayList();
        clockTextView = (TextView) findViewById(R.id.clockTextView);

        cardsArrayList = dbManager.getAllCardsArray();
        random = new Random();
        //randomize
        randomCard();

        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                clockTextView.setText("0:" +millisUntilFinished / 1000 + "");
            }

            public void onFinish() {
                clockTextView.setText("done!");
            }
        }.start();
    }

    public void randomCard() {
        int r = random.nextInt(cardsArrayList.size());
        cardTextView.setText(cardsArrayList.get(r).get_cardName());
        trashCards.add(cardsArrayList.get(r));
        cardsArrayList.remove(r);
        System.out.println("Size: "+cardsArrayList.size());
    }

    public void onStopClicked(View view) {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

    //timer

}
