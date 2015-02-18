package net.yanzm.mth.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by root1 on 2/7/15.
 */
public class Activity_VideoPlaying extends Activity {
    public AQuery aq;
    private int page;
    String url = "http://ihdmovie.xyz/root/api/feed_get.php?uid=1";
    ArrayList<item_vieos> list = new ArrayList<item_vieos>();
    AdapterVideos adapterJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_video_playing);

        ImageView imageView = (ImageView) findViewById(R.id.imageView10);
        Picasso.with(getApplication())
                .load("http://placehold.it/350x250")
                .placeholder(R.drawable.ic_launcher)
                .centerCrop()
                .resize(100, 100)
                .transform(new RoundedTransformation(50, 4))
                .into(imageView);

        TextView txt_title = (TextView) findViewById(R.id.textView10);
        txt_title.setText("Aung Epicband");
        TextView txt_music = (TextView) findViewById(R.id.textView11);
        txt_music.setText("New Single - Epic [Official MV - HD]");
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


                item_vieos list_item = new item_vieos();
                list_item.setImage_url(ImageUrl);
                list_item.setTitle(month);
                list_item.setDetail(number4);
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
