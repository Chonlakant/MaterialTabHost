package net.yanzm.mth.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by root1 on 1/30/15.
 */
public class Adapter_Listview extends BaseAdapter {

    Context context;


    public ArrayList<item_friends> list = new ArrayList<item_friends>();

    public Adapter_Listview(Context context, ArrayList<item_friends> list) {
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

        View row = mInflater.inflate(R.layout.item_grid, parent, false);
        Button btn ;
        TextView month;
        TextView date;
        ImageView ImageUrl;
        item_friends item = list.get(position);
        month = (TextView) row.findViewById(R.id.item_title);
        btn = (Button) row.findViewById(R.id.btn_follow);
        //date = (TextView) row.findViewById(R.id.textView2);
        ImageUrl = (ImageView) row.findViewById(R.id.item_img);

        month.setText(item.getTxt_name());
        //date.setText(item.getTxt_friends());

        Picasso.with(context)
                .load(item.getImageurl())
                .transform(new RoundedTransformation(50, 4))
                .centerCrop()
                .resize(100, 100)
                .into(ImageUrl);
        return row;
    }
}
