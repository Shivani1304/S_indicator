package com.sindicator.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.sindicator.BuilderManager;
import com.sindicator.R;
import com.sindicator.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotelModule extends ActionBarActivity implements ActionBar.TabListener {

    private ViewPager viewPager;
    private HotelTab adp;
    private ActionBar actionBar;
    private int[] tabs={R.drawable.fivestar,
            R.drawable.fourstar,
            R.drawable.threestar,
            R.drawable.twostar};

    private BoomMenuButton bmb;

    @SuppressWarnings("WrongConstant")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_module);

        viewPager = (ViewPager) findViewById(R.id.viewcontent);
        actionBar = getSupportActionBar();
        adp = new HotelTab(getSupportFragmentManager());
        viewPager.setAdapter(adp);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setIcon(tab_name)
                    .setTabListener(this));

            //   ******************************** Boom menu***********************************************************************

            bmb = (BoomMenuButton) findViewById(R.id.bmb);
            bmb.setButtonEnum(ButtonEnum.SimpleCircle);
            bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_2);
            bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_4_2);

            for (int i = 0; i < 4; i++) {

                bmb.addBuilder(BuilderManager.getSimpleCircleButtonBuilder());

            }
            bmb.setOnBoomListener(new OnBoomListener() {
                @Override
                public void onClicked(int index, BoomButton boomButton) {
                    if (index == 0) {
                        Intent i=new Intent(HotelModule.this,MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                    if (index == 1) {

                    }
                    if (index == 2) {

                    }

                    if (index == 3) {
                        HotelModule.this.finish();
                    }
                }

                @Override
                public void onBackgroundClick() {

                }

                @Override
                public void onBoomWillHide() {

                }

                @Override
                public void onBoomDidHide() {

                }

                @Override
                public void onBoomWillShow() {

                }

                @Override
                public void onBoomDidShow() {

                }
            });
            }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
