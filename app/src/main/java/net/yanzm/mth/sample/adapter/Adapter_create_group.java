package net.yanzm.mth.sample.adapter;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.RoundedTransformation;
import net.yanzm.mth.sample.model.item_create_group;

import java.util.ArrayList;

/**
 * Created by root1 on 2/1/15.
 */
public class Adapter_create_group extends BaseAdapter {

    Context context;


    public ArrayList<item_create_group> list = new ArrayList<item_create_group>();

    public Adapter_create_group(Context context, ArrayList<item_create_group> list) {
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

        View row = mInflater.inflate(R.layout.item_creategroup, parent, false);

        Toolbar toolbar = (Toolbar) row.findViewById(R.id.toolbar);
        toolbar.setTitle("Sam Savek (@samsavek)");
        TextView txt_group_name;
        TextView count;
        TextView members;
        TextView add;
        ImageView image_url_group;
        ImageView image_url_add;
        item_create_group item = list.get(position);
        txt_group_name = (TextView) row.findViewById(R.id.txt_group_name);
        count = (TextView) row.findViewById(R.id.count);
        members = (TextView) row.findViewById(R.id.members);
        add = (TextView) row.findViewById(R.id.add);
        image_url_group = (ImageView) row.findViewById(R.id.image_url_group);
        image_url_add = (ImageView) row.findViewById(R.id.image_url_add);

        txt_group_name.setText(item.getGroup_name());
        count.setText(item.getCount());
        members.setText(item.getMembers());
        add.setText(item.getAdd());

        Picasso.with(context)
                .load(item.getImage_url_group())
                .transform(new RoundedTransformation(50, 4))
                .resize(100, 100)
                .into(image_url_group);

        Picasso.with(context)
                .load(item.getImage_url_add())
                .transform(new RoundedTransformation(50, 4))
                .resize(100, 100)
                .into(image_url_add);
        return row;
    }
}
