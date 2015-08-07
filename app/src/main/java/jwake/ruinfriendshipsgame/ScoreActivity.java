package jwake.ruinfriendshipsgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreActivity extends Activity {

    ArrayList friends;
    TextView output;
    int max = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Array of friends
        friends = new ArrayList();
        Friends friends1 = new Friends("Adrian", 0);
        friends.add(friends1);
        friends.add(new Friends("Lotus", 0));
        friends.add(new Friends("Steve", 0));

        ListAdapter friendsListAdapter = new CustomAdapter(this, friends);
        ListView scoreListView = (ListView) findViewById(R.id.scoreListView);
        scoreListView.setAdapter(friendsListAdapter);
    }

    public void onGetCardClicked(View view) {
        Intent intent = new Intent(this, CardActivity.class);
        startActivity(intent);
    }



    public void onIncrementClicked(View view) {
        output = (TextView) findViewById(R.id.customPointText);
        System.out.println(output.getText().toString());
        if( Integer.parseInt(output.getText().toString()) < max) {
            System.out.println("increment + 1");
            output.setText(Integer.parseInt(output.getText().toString()) + 1 + "");
        }

        //else do nothing
    }

    public void onDecrementClicked(View view) {
        output = (TextView) findViewById(R.id.customPointText);
        System.out.println(output.getText().toString());
        if( Integer.parseInt(output.getText().toString()) > 0) {
            System.out.println("decrement - 1");
            output.setText(Integer.parseInt(output.getText().toString()) - 1 + "");
        }
    }
}
