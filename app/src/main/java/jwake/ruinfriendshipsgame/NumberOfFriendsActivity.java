package jwake.ruinfriendshipsgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class NumberOfFriendsActivity extends Activity {

    NumberPicker numberPicker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_of_friends);
        numberPicker = (NumberPicker) findViewById(R.id.pickNumber);
        numberPicker.setMinValue(3);
        numberPicker.setMaxValue(12);
        numberPicker.setWrapSelectorWheel(false);
    }


    public void onGoButtonClicked(View view) {
        Intent intent = new Intent(this, AddFriendsActivity.class);
        intent.putExtra("myNumberPickerValue",numberPicker.getValue());
        startActivity(intent);
    }

    public void onExistButtonClicked(View view) {

        //work needs to be done before going to score activity

        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }
}
