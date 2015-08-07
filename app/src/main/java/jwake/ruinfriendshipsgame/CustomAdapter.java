package jwake.ruinfriendshipsgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends ArrayAdapter<Friends> {


    CustomAdapter(Context context, ArrayList<Friends> friends) {
        super(context, R.layout.custom_row, friends);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        Friends singleProfile = getItem(position);
        TextView customNameText = (TextView) customView.findViewById(R.id.customNameText);
        TextView customPointText = (TextView) customView.findViewById(R.id.customPointText);

        customNameText.setText(singleProfile.getName());
        customPointText.setText(singleProfile.getPoints()+"");

        return customView;
    }
}
