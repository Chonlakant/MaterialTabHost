package net.yanzm.mth.sample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.gc.materialdesign.views.ButtonFlat;
import com.squareup.picasso.Picasso;

import net.yanzm.mth.sample.activity.ActivityComment;
import net.yanzm.mth.sample.model.Post;
import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.RoundedTransformation;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

public class AdapterJson extends RecyclerView.Adapter<AdapterJson.ContactViewHolder> {


    public static Context context;
    public static ArrayList<Post> list = new ArrayList<Post>();
    public static String url1 = "http://ihdmovie.xyz/root/api/feed_get.php?uid=1";
    public static AQuery aq;

    public AdapterJson(Context context, ArrayList<Post> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void onBindViewHolder(ContactViewHolder contactViewHolder, int position) {

        Post item = list.get(position);

        contactViewHolder.month.setText(item.getName());

        contactViewHolder.date.setText(item.getDate());
        contactViewHolder.number1.setText(item.getLoveCount());
        contactViewHolder.number2.setText(item.getCommentCount());
        contactViewHolder.number3.setText(item.getShareCount());
        //contactViewHolder.messen.setText(item.getMessen());




        contactViewHolder.messen.setText(Html.fromHtml("<strong><em>" + item.getMessage() + "</em></strong>"));


        Picasso.with(context)
                .load(item.getImageProfileUrl())
                .centerCrop()
                .resize(100, 100)
                .transform(new RoundedTransformation(50, 4))
                .into(contactViewHolder.ImageUrl);

        Picasso.with(context)
                .load(item.getImagePostUrl())
                .fit().centerCrop()
                .into(contactViewHolder.image_messen);


    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_feed, viewGroup, false);



        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vTitle;

        TextView month;
        TextView date;
        TextView number1;
        TextView number2;
        TextView number3;
        TextView messen;
        //TextView view;
        ImageView ImageUrl;
        ImageView image_messen;
        ButtonFlat  btnComment;

        public ContactViewHolder(View v) {
            super(v);
//            vName =  (TextView) v.findViewById(R.id.txtName);
//            vSurname = (TextView)  v.findViewById(R.id.txtSurname);
//            vEmail = (TextView)  v.findViewById(R.id.txtEmail);
//            vTitle = (TextView) v.findViewById(R.id.title);


            month = (TextView) v.findViewById(R.id.Aung);
            date = (TextView) v.findViewById(R.id.day);
            number1 = (TextView) v.findViewById(R.id.number1);
            number2 = (TextView) v.findViewById(R.id.number2);
            number3 = (TextView) v.findViewById(R.id.number3);
            messen = (TextView) v.findViewById(R.id.messng);
            // view = (TextView) v.findViewById(R.id.view);
            ImageUrl = (ImageView) v.findViewById(R.id.imageView);
            image_messen = (ImageView) v.findViewById(R.id.image_center);

            btnComment = (ButtonFlat) v.findViewById(R.id.btn_comment);

            image_messen.setOnClickListener(this);
            ImageUrl.setOnClickListener(this);
            btnComment.setOnClickListener(this);

        }



        @Override
        public void onClick(View view ) {


            aq = new AQuery(view.getContext());
            if (view.getId() == R.id.image_center) {



            } else if (view.getId() == R.id.btn_comment) {

                Intent i = new Intent(view.getContext(), ActivityComment.class);
                context.startActivity(i);

            }

            Toast.makeText(view.getContext(), "view = " + view.getId() + " position = " + getPosition(), Toast.LENGTH_SHORT).show();
        }



    }
}