package com.sindicator.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.sindicator.BuilderManager;
import com.sindicator.ConnectionDetectorplace;
import com.sindicator.R;
import com.sindicator.adapters.CustomGridAdp;

public class NearbySearch extends AppCompatActivity {
    GridView grid;
    ConnectionDetectorplace cd;
    private BoomMenuButton bmb;
    Boolean isInternetPresent = false;
    String[] web = {
            "Bank",
            "ATM",
            "Cafe",
            "Electrician",
            "Food",
            "Gas Station",
            "Library",
            "Plumber",
            "School",
            "Movie Theater",
            "Chemist",
            "Embassy",
    };
    int[] imageId = {
            R.drawable.bank,
            R.drawable.atm,
            R.drawable.building,
            R.drawable.electrician,
            R.drawable.store,
            R.drawable.gasstation,
            R.drawable.books,
            R.drawable.plumber,
            R.drawable.school,
            R.drawable.videocamera,
            R.drawable.antibiotic,
            R.drawable.embassy,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_search);

        CustomGridAdp adapter = new CustomGridAdp(NearbySearch.this, web, imageId);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        cd = new ConnectionDetectorplace(getApplicationContext());

        //   ******************************** Boom menu***********************************************************************

        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        bmb.setButtonEnum(ButtonEnum.SimpleCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_2);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_4_2);

        for (int i = 0; i < 4; i++) {

            bmb.addBuilder(BuilderManager.getSimpleCircleButtonBuilder());

        }
        bmb.setOnBoomListener(new OnBoomListener(){


            @Override
            public void onClicked(int index, BoomButton boomButton) {
                if (index == 0) {
                    Intent intent = new Intent(NearbySearch.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                if (index == 1) {

                }
                if (index == 2) {

                }

                if (index == 3) {
                    NearbySearch.this.finish();
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
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Toast.makeText(MainActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                Bundle b = new Bundle();
                Intent i;
                isInternetPresent = cd.isConnectingToInternet();
                if (isInternetPresent) {
                    switch (position) {

                        case 0:

                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "hospital");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 1:
                            i = new Intent(getApplicationContext(), AA.class);
                            //Bundle b = new Bundle();
                            b.putString("type", "police");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 2:
                            i = new Intent(getApplicationContext(), AA.class);
                            //Bundle b = new Bundle();
                            // b.putDouble("atm", 2.123456780009);
                            b.putString("type", "atm");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 3:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "courthouse");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 4:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "dentist");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 5:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "doctor");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 6:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "fire_station");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 7:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "health");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 8:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "pharmacy");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 9:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "post_office");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 10:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "physiotherapist");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 11:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "airport");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 12:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "bank");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 13:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "bus_station");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                        case 14:
                            i = new Intent(getApplicationContext(), AA.class);
                            b.putString("type", "train_station");
                            i.putExtras(b);
                            startActivity(i);
                            break;
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
