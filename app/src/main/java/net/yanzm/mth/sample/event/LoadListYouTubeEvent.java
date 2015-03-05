package net.yanzm.mth.sample.event;

import java.util.ArrayList;

/**
 * Created by root1 on 3/3/15.
 */
public class LoadListYouTubeEvent {
    public ArrayList<LoadYouTubeEvent> arrayMovieLoaded= new ArrayList<>();
    public LoadListYouTubeEvent(ArrayList<LoadYouTubeEvent> arrayMovieLoaded) {
        this.arrayMovieLoaded = arrayMovieLoaded;
    }

}

