package com.sindicator.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.sindicator.BuilderManager;
import com.sindicator.JSONParser;
import com.sindicator.R;
import com.sindicator.adapters.CustomAdapter;
import com.sindicator.adapters.PoliceCustomAdp;
import com.sindicator.models.PicnicModelClass;
import com.sindicator.models.PoliceModelClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class PolicestationModule extends AppCompatActivity {
    ListView stationname;
    ArrayList<PoliceModelClass> arrayList = new ArrayList<>();
    PoliceCustomAdp adp;
    ProgressDialog pd;
    ArrayList<HashMap<String, String>> a1;
    private BoomMenuButton bmb;

    private static String url = "http://192.168.43.67/project/police_webservice.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policestation_module);

         stationname = (ListView) findViewById(R.id.stationname);
         pd = new ProgressDialog(this);
         a1 = new ArrayList<>();
         new policedata().execute();

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
                    Intent i=new Intent(PolicestationModule.this,MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (index == 1) {

                }
                if (index == 2) {

                }

                if (index == 3) {
                    PolicestationModule.this.finish();
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

    public class policedata extends AsyncTask<String,String,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setMessage("Loading");
            pd.setIndeterminate(true);
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            JSONParser jsonParser = new JSONParser();
            String jstr = jsonParser.getJSONFromUrl(url);
            return jstr;
        }


        @Override
        protected void onPostExecute(String s) {
            if (s != null) {
                try {
                    Log.e("error",s);
                    JSONObject obj = new JSONObject(s);
                    JSONArray array = obj.getJSONArray("a1");
                    //JSONArray array=new JSONArray("data");
                    for(int i=0;i<array.length();i++)
                    {
                        JSONObject jsonObject=array.getJSONObject(i);
                        PoliceModelClass police=new PoliceModelClass();
                        police.setP_station(jsonObject.getString("police station name"));
                        police.setContactnumber(jsonObject.getString("phone no"));
                        police.setArea(jsonObject.getString("area"));
                        arrayList.add(police);
                    }
                    adp = new PoliceCustomAdp(PolicestationModule.this,arrayList);
                    stationname.setAdapter(adp);
                    pd.dismiss();
                    super.onPostExecute(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
