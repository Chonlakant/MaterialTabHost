package net.yanzm.mth.sample.onclick;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.fragment.FragmentFeed;

/*
 * Here you can control what to do next when the user selects an item
 */
public class OnItemClickListenerListViewItem implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        final Context context = view.getContext();

        Button button = (Button) view.findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item: " , Toast.LENGTH_SHORT).show();

            }
        });
        // just toast it


    }

}