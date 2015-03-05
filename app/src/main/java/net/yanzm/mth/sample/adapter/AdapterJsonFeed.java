package net.yanzm.mth.sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFlat;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.RoundedTransformation;
import net.yanzm.mth.sample.model.Post;

import java.util.ArrayList;
import java.util.Random;

public class AdapterJsonFeed extends RecyclerView.Adapter<AdapterJsonFeed.ViewHolder> {


    ArrayList<Post> list = new ArrayList<Post>();
    public static Context context;

    OnItemClickListener mItemClickListener;


    public AdapterJsonFeed(Context context, ArrayList<Post> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.item_feed, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post item = list.get(position);

        holder.month.setText(item.getName());

        holder.date.setText(item.getDate());
        holder.number1.setText(item.getLoveCount());
        holder.number2.setText(item.getCommentCount());
        holder.number3.setText(item.getShareCount());
        //contactViewHolder.messen.setText(item.getMessen());


        holder.messen.setText(Html.fromHtml("<strong><em>" + item.getMessage() + "</em></strong>"));


        Picasso.with(context)
                .load(item.getImageProfileUrl())
                .centerCrop()
                .resize(100, 100)
                .transform(new RoundedTransformation(50, 4))
                .into(holder.ImageUrl);

        Picasso.with(context)
                .load(item.getImagePostUrl())
                .fit().centerCrop()
                .into(holder.image_messen);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView month;
        TextView date;
        TextView number1;
        TextView number2;
        TextView number3;
        TextView messen;
        //TextView view;
        ImageView ImageUrl;
        ImageView image_messen;
        ButtonFlat btnComment;

        TextView vName, vSex, vId, vAge;

        public ViewHolder(View view) {
            super(view);
            month = (TextView) view.findViewById(R.id.Aung);
            date = (TextView) view.findViewById(R.id.day);
            number1 = (TextView) view.findViewById(R.id.number1);
            number2 = (TextView) view.findViewById(R.id.number2);
            number3 = (TextView) view.findViewById(R.id.number3);
            messen = (TextView) view.findViewById(R.id.messng);
            // view = (TextView) v.findViewById(R.id.view);
            ImageUrl = (ImageView) view.findViewById(R.id.imageView);
            image_messen = (ImageView) view.findViewById(R.id.image_center);

            btnComment = (ButtonFlat) view.findViewById(R.id.btn_comment);

            image_messen.setOnClickListener(this);
            ImageUrl.setOnClickListener(this);
            btnComment.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.image_center:
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(v, getPosition());
                    }
                    break;

            }
        }

    }



    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    /*
     * Snippet from http://stackoverflow.com/a/363692/1008278
     */
    public static int randInt(int min, int max) {
        final Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    /* ==========This Part is not necessary========= */

}