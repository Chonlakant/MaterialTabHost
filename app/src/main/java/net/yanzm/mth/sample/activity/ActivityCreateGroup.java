package net.yanzm.mth.sample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.adapter.Adapter_Listview;
import net.yanzm.mth.sample.model.item_friends;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityCreateGroup extends Activity {
    // Store instance variables
    //private String title;
    public AQuery aq;
    private int page;
    String url = "http://ihdmovie.xyz/root/api/feed_get.php?uid=1";
    ArrayList<item_friends> list = new ArrayList<item_friends>();
    Adapter_Listview adapterJson;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_creategroup);
        aq = new AQuery(getApplication());
        adapterJson = new Adapter_Listview(getApplicationContext(), list);
        listView = (ListView) findViewById(R.id.listView3);
        aq.ajax(url, JSONObject.class, this, "getjson");
       // listView.setAdapter(adapterJson);

        TextView txt_group = (TextView) findViewById(R.id.textView);
        txt_group.setText("Group Name");

        TextView members = (TextView) findViewById(R.id.messng);
        members.setText("Members (4)");

        TextView count = (TextView) findViewById(R.id.view);
        count.setText("0/20");
        CircularImageView image_url_group = (CircularImageView) findViewById(R.id.imageView6);
        //CircularImageView image_url_add = (CircularImageView) findViewById(R.id.image_url_add);

        Picasso.with(this)
                .load("https://graph.facebook.com/v2.1/12962/picture?type=large")
                .placeholder(R.drawable.ic_launcher)
                .fit().centerCrop()

                //.transform(new RoundedTransformation(50, 4))
                .into(image_url_group);

//        Picasso.with(this)
//                .load("https://graph.facebook.com/v2.1/12962/picture?type=large")
//                .placeholder(R.drawable.ic_launcher)
//                .fit().centerCrop()
//
//                //.transform(new RoundedTransformation(50, 4))
//                .into(image_url_add);

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
                String number4 = obj.getString("number4");


                item_friends list_item = new item_friends();
                list_item.setImageurl(ImageUrl);
                list_item.setTxt_friends(month);


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