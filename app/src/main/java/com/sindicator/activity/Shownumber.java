package com.sindicator.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sindicator.R;

import java.util.ArrayList;

public class Shownumber extends AppCompatActivity {

    ListView lstnum;
    int police,amb,firestation,railway,airport,smc,bloodbank,eyebank,
            animalcare,newspaper,tourist,electricity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownumber);
        lstnum= (ListView) findViewById(R.id.lstemg);

        Intent i=getIntent();
        police=i.getIntExtra("policestation",0);
        amb=i.getIntExtra("ambulance",0);
        firestation=i.getIntExtra("fire_station",0);
        railway=i.getIntExtra("railway",0);
        airport=i.getIntExtra("airport",0);
        smc=i.getIntExtra("municipal",0);
        bloodbank=i.getIntExtra("bloodBank",0);
        eyebank=i.getIntExtra("eyeBank",0);
        animalcare=i.getIntExtra("animal_Care",0);
        newspaper=i.getIntExtra("newspaper",0);
        tourist=i.getIntExtra("tourist",0);
        electricity=i.getIntExtra("electricity",0);

        if(police == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(amb == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(firestation == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(railway == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(airport == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(smc == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(bloodbank == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(eyebank == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(animalcare == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(newspaper == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(tourist == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }

        else if(electricity == 1)
        {
            lstnum.setAdapter(new EmergencyAdp(getApplication()));
        }
    }

    class EmergencyList {
        String emename;
        String contact;


        public EmergencyList(String emename, String contact) {
            this.emename = emename;
            this.contact = contact;
        }
    }

    class EmergencyAdp extends BaseAdapter {

        ArrayList<EmergencyList> arrayList;
        Context context;
        LayoutInflater inflater;

        EmergencyAdp(Context context){
            this.context=context;
            arrayList=new ArrayList<>();
            Resources res=context.getResources();

            if(police == 1) {
                String[] name = res.getStringArray(R.array.Police);
                String[] contact = res.getStringArray(R.array.Pcontact);

                for (int i = 0; i < 14; i++) {
                    arrayList.add(new EmergencyList(name[i], contact[i]));
                }
            }

            else if(amb == 1) {
                String[] amname = res.getStringArray(R.array.Amb);
                String[] amcontact = res.getStringArray(R.array.AmbNum);

                for (int i = 0; i < 9; i++) {
                    arrayList.add(new EmergencyList(amname[i], amcontact[i]));
                }
            }

            else if(firestation == 1) {
                String[] firename = res.getStringArray(R.array.FireStation);
                String[] firecontact = res.getStringArray(R.array.FireNum);

                for (int i = 0; i < 10; i++) {
                    arrayList.add(new EmergencyList(firename[i], firecontact[i]));
                }
            }

            else if(railway == 1) {
                String[] railname = res.getStringArray(R.array.Railway_name);
                String[] railcontact = res.getStringArray(R.array.Railway_contact);

                for (int i = 0; i < 4; i++) {
                    arrayList.add(new EmergencyList(railname[i], railcontact[i]));
                }

            }

            else if(airport == 1) {
                String[] airportname = res.getStringArray(R.array.Airport_name);
                String[] airportcontact = res.getStringArray(R.array.Airport_contact);

                for (int i = 0; i < 2; i++) {
                    arrayList.add(new EmergencyList(airportname[i], airportcontact[i]));
                }
            }

            else if(smc == 1) {
                String[] smcname = res.getStringArray(R.array.CRP_name);
                String[] smccontact = res.getStringArray(R.array.CRP_contact);

                for (int i = 0; i < 2; i++) {
                    arrayList.add(new EmergencyList(smcname[i], smccontact[i]));
                }
            }

            else if(bloodbank == 1) {
                String[] bloodname = res.getStringArray(R.array.Bloodbank_name);
                String[] bloodcontact = res.getStringArray(R.array.Bloodbank_contact);

                for (int i = 0; i < 8; i++) {
                    arrayList.add(new EmergencyList(bloodname[i], bloodcontact[i]));
                }
            }

            else if(eyebank == 1) {
                String[] eyename = res.getStringArray(R.array.Eyebank_name);
                String[] eyecontact = res.getStringArray(R.array.Eyebank_contact);

                for (int i = 0; i < 3; i++) {
                    arrayList.add(new EmergencyList(eyename[i], eyecontact[i]));
                }
            }

            else if(animalcare == 1) {
                String[] animalcare = res.getStringArray(R.array.AnimalCare);
                String[] animalcarenum = res.getStringArray(R.array.AnimalNum);

                for (int i = 0; i < 3; i++) {
                    arrayList.add(new EmergencyList(animalcare[i], animalcarenum[i]));
                }
            }

            else if(newspaper == 1) {
                String[] newsname = res.getStringArray(R.array.NewsPaper);
                String[] newscontact = res.getStringArray(R.array.NewsPaperNum);

                for (int i = 0; i < 11; i++) {
                    arrayList.add(new EmergencyList(newsname[i], newscontact[i]));
                }
            }

            else if(tourist == 1) {
                String[] tourist = res.getStringArray(R.array.Tourist);
                String[] touristcontact = res.getStringArray(R.array.TouristNum);

                for (int i = 0; i < 1; i++) {
                    arrayList.add(new EmergencyList(tourist[i], touristcontact[i]));
                }
            }

            else if(electricity == 1) {
                String[] elename = res.getStringArray(R.array.Electricity_name);
                String[] elecontact = res.getStringArray(R.array.Electricity_contact);

                for (int i = 0; i < 17; i++) {
                    arrayList.add(new EmergencyList(elename[i], elecontact[i]));
                }
            }
        }
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, final ViewGroup viewGroup) {
            TextView emename;
            TextView emecontact;
            ImageButton imgage;

            Typeface tf=Typeface.createFromAsset(context.getAssets(),"Dustismo_Roman.ttf");
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v=inflater.inflate(R.layout.emelist, viewGroup,false);
            emename= (TextView) v.findViewById(R.id.emename);
            emecontact= (TextView) v.findViewById(R.id.emecontact);
            imgage = (ImageButton) v.findViewById(R.id.imgeme);

            EmergencyList el=arrayList.get(i);
            emename.setText(el.emename);
            emecontact.setText(el.contact);
            imgage.setImageResource(R.drawable.circle);

            emename.setTypeface(tf);
            emecontact.setTypeface(tf);

            imgage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EmergencyList list = arrayList.get(i);
                    Intent intent = new Intent((Intent.ACTION_CALL), Uri.parse("tel:" + list.emename.toString()));
                    startActivity(intent);
                }
            });
            return v;
        }
    }
}
