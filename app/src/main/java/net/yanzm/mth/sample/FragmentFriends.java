package net.yanzm.mth.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentFriends extends Fragment {
    String url = "http://ihdmovie.xyz/root/api/feed_get.php?uid=1";
    String url2 = "http://ihdmovie.xyz/feed.json";
    String url3 = "http://ihdmovie.xyz/feed2.json";

    ArrayList<ItemFeed> list = new ArrayList<ItemFeed>();
    AdapterFriends adapterJson;
    GridView gridView;

    public AQuery aq;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);

        aq = new AQuery(getActivity());
        adapterJson = new AdapterFriends(getActivity(), list);
        gridView = (GridView) rootView.findViewById(R.id.gridView1);
        gridView.setAdapter(adapterJson);


        aq.ajax(url3, JSONObject.class, this, "getjson");

        return rootView;
    }
    public void getjson(String url, JSONObject jo, AjaxStatus status)
            throws JSONException {
        AQUtility.debug("jo", jo);

        if (jo != null) {
            JSONArray ja = jo.optJSONArray("users");
            for (int i = 0; i < ja.length(); i++) {
                JSONObject obj = ja.optJSONObject(i);

                JSONObject location = obj.optJSONObject("avatar");

                String url_avatra;

                if(location != null)
                    url_avatra = location.optString("url");
                else
                    url_avatra = "themes/vdomax1.1/images/default-female-avatar.png";


                String Avatra = "https://www.vdomax.com/"+url_avatra+"";
                Log.i("Test_chcl",Avatra);

                String name_title = obj.optString("name");


                ItemFeed list_item = new ItemFeed();
                list_item.setImageUrl(Avatra);
                list_item.setMonth(name_title);

//
//
                list.add(list_item);
            }
            adapterJson.notifyDataSetChanged();
            AQUtility.debug("done");

        } else {
            AQUtility.debug("error!");
        }
    }
}