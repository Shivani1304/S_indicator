package com.sindicator.activity;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.sindicator.BuilderManager;
import com.sindicator.R;

public class HospitalModule extends ActionBarActivity implements TabLayout.OnTabSelectedListener, ActionBar.TabListener {

    private ViewPager viewPager;
    private Tabhost adp;
    private ActionBar actionBar;
    private String[] tabs = { "Government", "Private"};
    @SuppressWarnings("WrongConstant")

    private BoomMenuButton bmb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_module);

        viewPager = (ViewPager) findViewById(R.id.viewcontent);
        actionBar = getSupportActionBar();
        adp = new Tabhost(getSupportFragmentManager());
        viewPager.setAdapter(adp);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

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
                    Intent i=new Intent(HospitalModule.this,MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (index == 1) {

                }
                if (index == 2) {

                }

                if (index == 3) {
                    HospitalModule.this.finish();
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

        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(HospitalModule.this));
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
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

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
