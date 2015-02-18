package net.yanzm.mth.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
//AdapterVideos

/**
 * Created by root1 on 1/31/15.
 */
public class AdapterVideos extends BaseAdapter {

    Context context;


    public ArrayList<item_vieos> list = new ArrayList<item_vieos>();

    public AdapterVideos(Context context, ArrayList<item_vieos> list) {
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

        View row = mInflater.inflate(R.layout.item_videos, parent, false);
        TextView title;
        TextView detail;
        TextView txt1;
        TextView txt2;
        ImageView ImageUrl;
        ImageView image_title;
        item_vieos item = list.get(position);
        title = (TextView) row.findViewById(R.id.textView10);
        detail = (TextView) row.findViewById(R.id.textView11);
        txt1 = (TextView) row.findViewById(R.id.number2);
        txt2 = (TextView) row.findViewById(R.id.number3);
        ImageUrl = (ImageView) row.findViewById(R.id.imageView10);
        image_title = (ImageView) row.findViewById(R.id.image_title);

        title.setText(item.getTitle());
        detail.setText("New Single - Epic [Official MV - HD]");
//        HD.setText(item.getTxt1());
//        txt2.setText(item.getTxt2());

        Picasso.with(context)
                .load(item.getImage_url())
//                .centerCrop()
//                .resize(150, 100)
                .into(image_title);

        Picasso.with(context)
                .load(item.getImage_url())
                .transform(new RoundedTransformation(50, 4))
                .resize(100, 100)
                .into(ImageUrl);
        return row;
    }
}

