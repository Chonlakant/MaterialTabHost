package net.yanzm.mth.sample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.adapter.Adapter_Channels;
import net.yanzm.mth.sample.model.itemChannels;
import net.yanzm.mth.sample.model.live;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityChannels extends Activity {
    // Store instance variables
    //private String title;
    public AQuery aq;
    private int page;
    String url = "http://ihdmovie.xyz/root/api/feed_get.php?uid=1";
    String urlLive = "http://api.vdomax.com/live/history/161";
    ArrayList<live> list = new ArrayList<live>();
    Adapter_Channels adapterJson;
    GridView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_channels);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sam Savek (@samsavek)");
        aq = new AQuery(this);
        adapterJson = new Adapter_Channels(this, list);
        listView = (GridView) findViewById(R.id.gridview);

        listView.setAdapter(adapterJson);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"sd",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),ActivityVideoPlaying.class);
                startActivity(i);
            }
        });

        aq.ajax(urlLive, JSONObject.class, this, "getjson");

    }
    public void getjson(String url, JSONObject jo, AjaxStatus status)
            throws JSONException {
        AQUtility.debug("jo", jo);

        if (jo != null) {
            JSONArray ja = jo.getJSONArray("history");
            for (int i = 0; i < ja.length(); i++) {
                JSONObject obj = ja.getJSONObject(i);

                 String photoLive = obj.optString("thumb");
                String nameLive = obj.optString("name");



                live live = new live(null,photoLive,nameLive,null,null,null);
                list.add(live);
            }
            adapterJson.notifyDataSetChanged();
            AQUtility.debug("done");

        } else {
            AQUtility.debug("error!");
        }
    }
}