package net.yanzm.mth.sample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.model.itemChannels;
import net.yanzm.mth.sample.model.live;

import java.util.ArrayList;
//AdapterVideos

/**
 * Created by root1 on 1/31/15.
 */
public class Adapter_Channels extends BaseAdapter {

    Context context;


    public ArrayList<live> list = new ArrayList<live>();

    public Adapter_Channels(Context context, ArrayList<live> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = mInflater.inflate(R.layout.item_channels, parent, false);
        TextView name;
        ImageView ImageUrl;
        ImageView vdo_url;
        live item = list.get(position);
        name = (TextView) row.findViewById(R.id.text);

        ImageUrl = (ImageView) row.findViewById(R.id.picture);
        vdo_url = (ImageView) row.findViewById(R.id.image_center);

        name.setText(item.getNameLive());

        Picasso.with(context)
                .load(item.getPhotoLive())
              //  .transform(new RoundedTransformation(50, 4))
               .centerCrop()
                .resize(100, 100)
                .into(ImageUrl);

//        Picasso.with(context)
//                .load(item.getVdo_url())
//                .centerCrop()
//                .resize(100, 100)
//                .into(vdo_url);
        return row;
    }
}

