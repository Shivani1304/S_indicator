package com.sindicator.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ScrollView;

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

public class EmergencyModule extends AppCompatActivity {

    Button Policestation, Ambulances, Firestation, Railway, Airport, Municipal, Blodbank, Eyebank, Animal_care, Newspaper, Tourist, Electricity;
    ScrollView sc;
    private BoomMenuButton bmb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_module);

        sc = (ScrollView) findViewById(R.id.sc);

        Policestation = (Button) findViewById(R.id.policestation);
        Ambulances = (Button) findViewById(R.id.Ambulances);
        Firestation = (Button) findViewById(R.id.Firestation);
        Railway = (Button) findViewById(R.id.Railway);
        Airport = (Button) findViewById(R.id.Airport);
        Municipal = (Button) findViewById(R.id.Municipal);
        Blodbank = (Button) findViewById(R.id.BloodBank);
        Eyebank = (Button) findViewById(R.id.EyeBank);
        Animal_care = (Button) findViewById(R.id.Animal_care);
        Newspaper = (Button) findViewById(R.id.Newspaper);
        Tourist = (Button) findViewById(R.id.Tourist);
        Electricity = (Button) findViewById(R.id.Electricity);

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
                    Intent i=new Intent(EmergencyModule.this,MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (index == 1) {

                }
                if (index == 2) {

                }

                if (index == 3) {
                    EmergencyModule.this.finish();
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

    public void click(View view){
        Intent i=new Intent(getApplicationContext(),Shownumber.class);
        switch (view.getId()) {
            case R.id.policestation:

                i.putExtra("policestation",1);
                startActivity(i);
                break;

            case R.id.Ambulances:

                i.putExtra("ambulance", 1);
                startActivity(i);
                break;

            case R.id.Firestation:

                i.putExtra("fire_station", 1);
                startActivity(i);
                break;

            case R.id.Railway:

                i.putExtra("railway", 1);
                startActivity(i);
                break;

            case R.id.Airport:

                i.putExtra("airport", 1);
                startActivity(i);
                break;

            case R.id.Municipal:

                i.putExtra("municipal", 1);
                startActivity(i);
                break;

            case R.id.BloodBank:

                i.putExtra("bloodBank", 1);
                startActivity(i);
                break;

            case R.id.EyeBank:

                i.putExtra("eyeBank", 1);
                startActivity(i);
                break;

            case R.id.Animal_care:

                i.putExtra("animal_Care", 1);
                startActivity(i);
                break;

            case R.id.Newspaper:

                i.putExtra("newspaper", 1);
                startActivity(i);
                break;

            case R.id.Tourist:

                i.putExtra("tourist", 1);
                startActivity(i);
                break;

            case R.id.Electricity:

                i.putExtra("electricity", 1);
                startActivity(i);
                break;

        }
    }

}

