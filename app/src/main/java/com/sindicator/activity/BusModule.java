package com.sindicator.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import com.sindicator.R;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.sindicator.BuilderManager;


import java.util.ArrayList;
import java.util.List;



public class BusModule extends AppCompatActivity {

    AutoCompleteTextView source,destination;
    Button search,selstop,selbus;
    TextView txtsource,txtdest;
    private BoomMenuButton bmb;

    String[] Junctions;
    String[] DestJunction;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_module);

        source = (AutoCompleteTextView) findViewById(R.id.source);
        destination = (AutoCompleteTextView) findViewById(R.id.destination);
        search = (Button) findViewById(R.id.search);
        selstop = (Button) findViewById(R.id.selstop);
        selbus = (Button) findViewById(R.id.selbus);
        txtsource= (TextView) findViewById(R.id.txtsource);
        txtdest= (TextView) findViewById(R.id.txtdest);

        Junctions=getResources().getStringArray(R.array.Junctions);
        DestJunction=getResources().getStringArray(R.array.Junctions);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Junctions);
        adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,DestJunction);
        source.setAdapter(adapter);
        destination.setAdapter(adp);

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
                    Intent i=new Intent(BusModule.this,MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (index == 1) {

                }
                if (index == 2) {

                }

                if (index == 3) {
                    BusModule.this.finish();
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
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                
            }
        });

        selstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        selbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
