package net.yanzm.mth.sample.fragment;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.adapter.AdapterJson;
import net.yanzm.mth.sample.model.Comment;
import net.yanzm.mth.sample.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentFeed extends Fragment {
    String url = "http://ihdmovie.xyz/root/api/feed_get.php?uid=1";
    String url2 = "http://ihdmovie.xyz/feed.json";
    String url3 = "http://ihdmovie.xyz/feed3.json";
    ArrayList<Post> list = new ArrayList<Post>();
    AdapterJson adapterJson;
    RelativeLayout layoutMenu;

    public AQuery aq;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_feed, container, false);

        aq = new AQuery(getActivity());
        adapterJson = new AdapterJson(getActivity(), list);


        layoutMenu = (RelativeLayout)rootView.findViewById(R.id.layoutMenu);

        RecyclerView recList = (RecyclerView) rootView.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);


        recList.setAdapter(adapterJson);

        recList.setOnTouchListener(new View.OnTouchListener() {

            final int DISTANCE = 3;

            float startY = 0;
            float dist = 0;
            boolean isMenuHide = false;
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = event.getAction();

                if (action == MotionEvent.ACTION_DOWN) {
                    startY = event.getY();
                } else if (action == MotionEvent.ACTION_MOVE) {
                    dist = event.getY() - startY;

                    if ((pxToDp((int) dist) <= -DISTANCE) && !isMenuHide) {
                        isMenuHide = true;
                        hideMenuBar();
                    } else if ((pxToDp((int) dist) > DISTANCE) && isMenuHide) {
                        isMenuHide = false;
                        showMenuBar();
                    }

                    if ((isMenuHide && (pxToDp((int) dist) <= -DISTANCE))
                            || (!isMenuHide && (pxToDp((int) dist) > 0))) {
                        startY = event.getY();
                    }
                } else if (action == MotionEvent.ACTION_UP) {
                    startY = 0;
                }

                return false;
            }
        });

        aq.ajax(url3, JSONObject.class, this, "getJson");

        return rootView;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//
//    }

    public void getJson(String url, JSONObject jo, AjaxStatus status)
            throws JSONException {
        AQUtility.debug("jo", jo);
        Log.d("Check_Feed:", "Test1");
        if (jo != null) {
            JSONArray ja = jo.getJSONArray("posts");
            for (int i = 0; i < ja.length(); i++) {
                JSONObject obj = ja.getJSONObject(i);

                JSONObject media = obj.getJSONObject("media");
                String avatarId = media.getString("id");
                String imagePhotoUrl = media.getString("url");
                String extension = media.getString("extension");

                String imagePhotoFullUrl = "https://www.vdomax.com/" + imagePhotoUrl + "." + extension + "";
                Log.i(".......", imagePhotoFullUrl);

                String imageAvatarUrl = "https://graph.facebook.com/v2.1/" + avatarId + "/picture?type=large";


                JSONObject author = obj.getJSONObject("author");
                String name = author.getString("name");

                //Log.d("Check",obj.toString());

                String name_title = obj.getString("type1");
                String loveCount = obj.getString("love_count");
                String number2 = obj.getString("follow_count");
                String commentCount = obj.getString("comment_count");
                String viewCount = obj.getString("view");
                String message = obj.getString("text");
                String date = obj.getString("timestamp");

//                String view = obj.getString("view");
//                String image_messen = obj.getString("image_messen");
//                String number4 = obj.getString("number4");
//              String date = obj.getString("date");

                String shortMessage;
                if (message.length() > 200)
                    shortMessage = message.substring(0, 199);
                else
                    shortMessage = message;


                ArrayList<Comment> comments = new ArrayList<>();
                if (Integer.parseInt(commentCount) > 0) {
                    JSONArray commentJsonArray = obj.getJSONArray("comment");

                    for (int a = 0; a < commentJsonArray.length(); a++) {
                        JSONObject commentJsonObject = commentJsonArray.getJSONObject(a);
                        String commentText = commentJsonObject.optString("text");
                        JSONObject accountJsonObject = commentJsonObject.getJSONObject("account");
                        String commentId = accountJsonObject.optString("id");
                        String commentName = accountJsonObject.optString("name");

                        Comment comment = new Comment(null, commentName, null, null, commentText, commentId);
                        comments.add(comment);
                    }

                }

                // Use view_count instead of share_count (share_count data is empty now)
                Post post = new Post(imageAvatarUrl, name, date, loveCount, commentCount, viewCount
                        , message, shortMessage, viewCount, imagePhotoFullUrl);
                post.setComments(comments);

               // post.setComments();


//                Post list_item = new Post();
//                list_item.setImageUrl(Avatra);
//                list_item.setName(name);
//                list_item.setDate(day);
//                list_item.setLoveCount(number1);
//                list_item.setCommentCount(number2);
//                list_item.setSherdCount(number3);
//                list_item.setMessage(sub);
//                list_item.setImage_messen(photo);
//                list_item.setView(view);
//                Log.d("Check", ImageUrl);
//
//
                list.add(post);
            }
            adapterJson.notifyDataSetChanged();
            AQUtility.debug("done");

        } else {
            AQUtility.debug("error!");
        }
    }


    public int pxToDp(int px) {
        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        int dp = Math.round(px / (dm.densityDpi
                / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

    public void showMenuBar() {
        AnimatorSet animSet = new AnimatorSet();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(layoutMenu
                , View.TRANSLATION_Y, 0);

        animSet.playTogether(anim1);
        animSet.setDuration(300);
        animSet.start();
    }

    public void hideMenuBar() {
        AnimatorSet animSet = new AnimatorSet();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(layoutMenu
                , View.TRANSLATION_Y, layoutMenu.getHeight());

        animSet.playTogether(anim1);
        animSet.setDuration(300);
        animSet.start();
    }

}