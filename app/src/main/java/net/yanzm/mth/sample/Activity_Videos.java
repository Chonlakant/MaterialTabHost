package net.yanzm.mth.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Activity_Videos extends Activity {
    // Store instance variables
    //private String title;
    public AQuery aq;
    private int page;
    String url = "http://ihdmovie.xyz/root/api/feed_get.php?uid=1";
    ArrayList<item_vieos> list = new ArrayList<item_vieos>();
    AdapterVideos adapterJson;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_videos);
        aq = new AQuery(getApplication());
        adapterJson = new AdapterVideos(getApplicationContext(), list);
        listView = (ListView) findViewById(R.id.listView4);
        aq.ajax(url, JSONObject.class, this, "getjson");
        listView.setAdapter(adapterJson);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){

                    Toast.makeText(getApplicationContext(),"Text",Toast.LENGTH_SHORT).show();
                }
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
                String ImageUrl = obj.getString("image");
                String month = obj.getString("month");
                String number2 = obj.getString("number2");
                String number4 = obj.getString("image_messen");


                item_vieos list_item = new item_vieos();
                list_item.setImage_url(number4);
                list_item.setTitle(month);
                list_item.setDetail(month);
                list_item.setTxt1(number2);
                list_item.setTxt2(number2);

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