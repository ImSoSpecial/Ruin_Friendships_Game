package jwake.ruinfriendshipsgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddFriendsActivity extends Activity {

    //Variables
    int numOfFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);

        numOfFriends = getIntent().getExtras().getInt("myNumberPickerValue");

        //ListAdapter listAdapter = new ArrayAdapter<String>();
    }

    public void onDoneClicked(View view) {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }
}
