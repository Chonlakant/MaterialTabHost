package net.yanzm.mth.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Activity_channels extends Activity {
    // Store instance variables
    //private String title;
    public AQuery aq;
    private int page;
    String url = "http://ihdmovie.xyz/root/api/feed_get.php?uid=1";
    ArrayList<itemChannels> list = new ArrayList<itemChannels>();
    Adapter_Channels adapterJson;
    GridView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_channels);
        aq = new AQuery(this);
        adapterJson = new Adapter_Channels(this, list);
        listView = (GridView) findViewById(R.id.gridview);
        aq.ajax(url, JSONObject.class, this, "getjson");
        listView.setAdapter(adapterJson);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"sd",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),Activity_VideoPlaying.class);
                startActivity(i);
            }
        });

    }
    public void getjson(String url, JSONObject jo, AjaxStatus status)
            throws JSONException {
        AQUtility.debug("jo", jo);

        if (jo != null) {
            JSONArray ja = jo.getJSONArray("posts");
            for (int i = 0; i < ja.length(); i++) {
                JSONObject obj = ja.getJSONObject(i);

                //Log.d("Check",obj.toString());
                String ImageUrl = obj.getString("image_messen");
                String month = obj.getString("date");



                itemChannels list_item = new itemChannels();
                list_item.setName(month);
                list_item.setTitle_url(ImageUrl);
                list_item.setVdo_url(ImageUrl);


                Log.d("Check", ImageUrl);

                list.add(list_item);
            }
            adapterJson.notifyDataSetChanged();
            AQUtility.debug("done");

        } else {
            AQUtility.debug("error!");
        }
    }
}