package net.yanzm.mth.sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.squareup.picasso.Picasso;

import net.yanzm.mth.sample.model.ItemFeed;
import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.RoundedTransformation;

import java.util.ArrayList;

public class AdapterJson extends RecyclerView.Adapter<AdapterJson.ContactViewHolder> {


    Context context;
    public static ArrayList<ItemFeed> list = new ArrayList<ItemFeed>();
    public static String url1 = "http://ihdmovie.xyz/root/api/feed_get.php?uid=1";
    public static AQuery aq;

    public AdapterJson(Context context, ArrayList<ItemFeed> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void onBindViewHolder(ContactViewHolder contactViewHolder, int position) {

        ItemFeed item = list.get(position);

        contactViewHolder.month.setText(item.getMonth());

        contactViewHolder.date.setText(item.getDate());
        contactViewHolder.number1.setText(item.getNumber1());
        contactViewHolder.number2.setText(item.getNumber2());
        contactViewHolder.number3.setText(item.getNumber3());
        //contactViewHolder.messen.setText(item.getMessen());

        contactViewHolder.messen.setText(Html.fromHtml("<strong><em>" + item.getMessen() + "</em></strong>"));


        Picasso.with(context)
                .load(item.getImageUrl())
                .centerCrop()
                .resize(100, 100)
                .transform(new RoundedTransformation(50, 4))
                .into(contactViewHolder.ImageUrl);

        Picasso.with(context)
                .load(item.getImage_messen())
                .placeholder(R.drawable.vdomax)

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

            image_messen.setOnClickListener(this);
            ImageUrl.setOnClickListener(this);

        }



        @Override
        public void onClick(View view ) {


            aq = new AQuery(view.getContext());
            if (view.getId() == R.id.image_center) {



            } else if (view.getId() == R.id.imageView) {



            }

            //Toast.makeText(view.getContext(), "view = " + view.getId() + " position = " + getPosition(), Toast.LENGTH_SHORT).show();
        }



    }
}