package net.yanzm.mth.sample.event;


import net.yanzm.mth.sample.model.Youtube;

import java.util.ArrayList;

/**
 * Created by root1 on 3/2/15.
 */
public class RespondEvent {

    public ArrayList<Youtube> youtubesList = new ArrayList<>();

    public RespondEvent(ArrayList<Youtube> youtubesList){

        this.youtubesList = youtubesList;

    }
}
