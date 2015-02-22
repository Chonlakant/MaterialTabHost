package net.yanzm.mth.sample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import net.yanzm.mth.sample.R;

/**
 * Created by root1 on 2/18/15.
 */
public class ActivityAddFriends extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friends);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sam Savek (@samsavek)");
    }
}
