
package net.yanzm.mth.sample.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import net.yanzm.mth.MaterialTabHost;
import net.yanzm.mth.sample.R;
import net.yanzm.mth.sample.adapter.AdapterDrawer;
import net.yanzm.mth.sample.fragment.FragmentFeed;
import net.yanzm.mth.sample.fragment.FragmentFriends;

import java.util.Locale;
import java.util.Random;

public class SampleActivity extends ActionBarActivity {
    public static final String KEY_DRAWABLE_ID = "drawableId";
    DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    private RectF mRect1 = new RectF();
    private RectF mRect2 = new RectF();



    ListView listView;

    int[] photos = {R.drawable.photo1, R.drawable.phpto2, R.drawable.photo3};
    KenBurnsView imageView;

    CircularImageView mHeaderLogo;
    CircularImageView titleLogo;
    Button btn_f;


    int[] resId = {R.drawable.ic_timer_auto_black_24dp
            , R.drawable.ic_history_black_24dp, R.drawable.ic_settings_black_24dp
            , R.drawable.ic_adjust_black_24dp, R.drawable.ic_store_black_24dp
            , R.drawable.ic_nature_black_24dp};

    String[] list = {"My Profile", "Live History", "Setting"
            , "Max point", "Tattoo Store", "Terms & Policeies","Test"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        imageView = (KenBurnsView) findViewById(R.id.header_picture);


        mHeaderLogo = (CircularImageView) findViewById(R.id.header_thumbnail);

       // btn_f = (Button) findViewById(R.id.btn_f);
        listView = (ListView) findViewById(R.id.list_drawer);
        AdapterDrawer adapterDrawer = new AdapterDrawer(getApplication(),list,resId);
        listView.setAdapter(adapterDrawer);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_LONG).show();
                    mDrawerLayout.closeDrawers();
                }
                if(position == 1){
                    Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplication(),ActivityVideos.class);
                    startActivity(i);
                    mDrawerLayout.closeDrawers();
                }
                if(position == 2){
                    Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplication(),ActivityAddFriends.class);
                    startActivity(i);
                    mDrawerLayout.closeDrawers();
                }
                if(position == 3){
                    Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplication(),ActivityChannels.class);
                    startActivity(i);
                    mDrawerLayout.closeDrawers();
                }
                if(position == 4){
                    Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplication(),ActivityCreateGroup.class);
                    startActivity(i);
                    mDrawerLayout.closeDrawers();
                }
                if(position == 5){
                    Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_LONG).show();
                    mDrawerLayout.closeDrawers();
                }
            }
        });

        Picasso.with(this)
                .load("https://graph.facebook.com/v2.1/12962/picture?type=large")
                .placeholder(R.drawable.ic_launcher)
                .fit().centerCrop()
                .placeholder(R.drawable.vdomax)
                //.transform(new RoundedTransformation(50, 4))
                .into(mHeaderLogo);



        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

//        btn_f.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplication(), "Check", Toast.LENGTH_LONG).show();
//
//                FragmentFriends oneFragment = new FragmentFriends();
//                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.add(R.id.container, oneFragment);
//                transaction.commit();
//
//                mDrawerLayout.closeDrawers();
//
//            }
//        });

        setNavigationStatusBar();


        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        mDrawerToggle.syncState();


        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                // change images randomly
                Random ran = new Random();
                int i = ran.nextInt(photos.length);
                //set image resources
                imageView.setImageResource(photos[i]);
                i++;
                if (i > photos.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 7000);  //for interval...
            }
        };
        handler.postDelayed(runnable, 7000); //for initial delay..


        MaterialTabHost tabHost = (MaterialTabHost) findViewById(android.R.id.tabhost);
        tabHost.setType(MaterialTabHost.Type.FullScreenWidth);
//        tabHost.setType(MaterialTabHost.Type.Centered);
//        tabHost.setType(MaterialTabHost.Type.LeftOffset);


        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(pagerAdapter.getPageTitle(i));
        }

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(tabHost);

        tabHost.setOnTabChangeListener(new MaterialTabHost.OnTabChangeListener() {
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
            }
        });


    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return new FragmentFeed();
                case 1:
                    return new FragmentFeed();
                case 2:
                    return new FragmentFeed();
                case 3:
                    return new FragmentFriends();
                case 4:
                    return new FragmentFeed();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return "Posts";
                case 1:
                    return "Followers";
                case 2:
                    return "Following";
                case 3:
                    return "Friends";
                case 4:
                    return "Loves";


            }
            return null;
        }
    }

    public void setNavigationStatusBar() {

        // Fix portrait issues
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Fix issues for KitKat setting Status Bar color primary
            if (Build.VERSION.SDK_INT >= 19) {
                TypedValue typedValue19 = new TypedValue();
                SampleActivity.this.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue19, true);
                final int color = typedValue19.data;

            }

            // Fix issues for Lollipop, setting Status Bar color primary dark
            if (Build.VERSION.SDK_INT >= 21) {
                TypedValue typedValue21 = new TypedValue();
                SampleActivity.this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue21, true);
                final int color = typedValue21.data;

            }
        }

        // Fix landscape issues (only Lollipop)
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (Build.VERSION.SDK_INT >= 19) {
                TypedValue typedValue19 = new TypedValue();
                SampleActivity.this.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue19, true);
                final int color = typedValue19.data;

            }
            if (Build.VERSION.SDK_INT >= 21) {
                TypedValue typedValue = new TypedValue();
                SampleActivity.this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
                final int color = typedValue.data;
                mDrawerLayout.setStatusBarBackgroundColor(color);
            }

        }
    }


}
