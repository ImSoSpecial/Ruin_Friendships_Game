package jwake.ruinfriendshipsgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CardActivity extends Activity {

    DataBaseForCards dbManager;
    TextView cardTextView;
    TextView clockTextView;
    ArrayList<Cards> cardsArrayList;
    ArrayList<Cards> trashCards;
    Random random;
    final CounterClass timer = new CounterClass(180000, 1000);

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
        clockTextView.setText("00:03:00");

        timer.start();
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
        timer.cancel();
    }

    //timer
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

            clockTextView.setText(hms);
        }

        @Override
        public void onFinish() {

        }
    }
}
