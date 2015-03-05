package net.yanzm.mth.sample.fragment;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.RoundedTransformation;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;


public class FragmentPhotofeed extends Fragment {

      Context context;
    ImageViewTouch imageFeedBig;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_feed_big, container, false);

        context = getActivity();
        Bundle extras = getArguments();
         String url = extras.getString("url");
        Log.d("url:",url);

        //Toast.makeText(getActivity(),""+url,Toast.LENGTH_SHORT).show();

        imageFeedBig = (ImageViewTouch) rootView.findViewById(R.id.image);

     //   imageFeedBig.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Picasso.with(context)
                .load(url)
                .into(imageFeedBig);


        return rootView;
    }



}