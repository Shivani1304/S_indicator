package com.sindicator.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sindicator.Prefmanager;
import com.sindicator.R;

public class AppIntro extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout layoutdots;
    private MyViewPageAdapter myadp;
    private TextView[] dots;
    private int[] layouts;
    Button btnnext, btnskip;
    private Prefmanager prefm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_app_intro);

        prefm=new Prefmanager(this);
        if(!prefm.isFirstTimeLAUNCH())
        {
            launchHomeScreen();
            finish();
        }

        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_app_intro);

        viewPager= (ViewPager) findViewById(R.id.viewpager);
        layoutdots= (LinearLayout) findViewById(R.id.lndots);
        btnnext= (Button) findViewById(R.id.btnnext);
        btnskip= (Button) findViewById(R.id.btnskip);

        layouts=new int[]
                {
                        R.layout.screen1,
                        R.layout.screen2,
                        R.layout.screen3,
                        R.layout.screen4

                };

        addBottomdots(0);

        changeStatusBarcolor();

        myadp=new MyViewPageAdapter();
        viewPager.setAdapter(myadp);
        viewPager.addOnPageChangeListener(viewPagerListener);


        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHomeScreen();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int crrt=getItem(+1);
                if(crrt<layouts.length)
                {
                    viewPager.setCurrentItem(crrt);
                }

                else
                {
                    launchHomeScreen();
                }
            }
        });

    }

    private int getItem(int i)
    {
        return viewPager.getCurrentItem() + i;
    }

    private void changeStatusBarcolor(){
    }


    private void addBottomdots(int i){
        dots=new TextView[layouts.length];
        int[] coloractive=getResources().getIntArray(R.array.array_dot_active);
        int[] colorinactive=getResources().getIntArray(R.array.array_dot_inactive);

        layoutdots.removeAllViews();
        for(int k=0;k<dots.length;k++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorinactive[i]);
            layoutdots.addView(dots[i]);
        }

        if(dots.length>0)
        {
            dots[i].setTextColor(coloractive[i]);
        }

    }

    ViewPager.OnPageChangeListener viewPagerListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomdots(position);

            if(position==layouts.length-1)
            {
                btnnext.setText("GOT IT");
                btnskip.setVisibility(View.GONE);
            }

            else
            {
                btnnext.setText("NEXT");
                btnskip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {


        }
    };

    private void launchHomeScreen(){
        prefm.setIsFirstTimeLaunch(false);
        startActivity(new Intent(AppIntro.this,MainActivity.class));
        finish();
    }

    private class MyViewPageAdapter extends PagerAdapter{

        private LayoutInflater inflater;

        public MyViewPageAdapter(){

        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v=inflater.inflate(layouts[position],container,false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view= (View) object;
            container.removeView(view);
        }

    }
}

