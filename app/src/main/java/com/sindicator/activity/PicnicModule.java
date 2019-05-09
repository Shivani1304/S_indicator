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
import com.sindicator.models.PicnicModelClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class PicnicModule extends AppCompatActivity {

    ListView lstvw;
    ArrayList<PicnicModelClass> arrayList = new ArrayList<>();
    CustomAdapter adp;
    ProgressDialog pd;
    ArrayList<HashMap<String, String>> a1;
    private BoomMenuButton bmb;
    private static String url = "http://192.168.43.67/project/picnic_webservice.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picnic_module);

        pd = new ProgressDialog(PicnicModule.this);
        lstvw = (ListView) findViewById(R.id.lstvw);
        a1 = new ArrayList<>();
        new selectdata().execute();

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
                    Intent i=new Intent(PicnicModule.this,MainActivity.class);
                    startActivity(i);

                }
                if (index == 1) {

                }
                if (index == 2) {

                }

                if (index == 3) {
                    PicnicModule.this.finish();
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

    public class selectdata extends AsyncTask<String,String,String>
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
                        PicnicModelClass m=new PicnicModelClass();
                        m.setPicnicname(jsonObject.getString("content_name"));
                        m.setDiscription(jsonObject.getString("description"));

                        arrayList.add(m);
                    }
                    adp = new CustomAdapter(PicnicModule.this, arrayList);
                    lstvw.setAdapter(adp);
                    pd.dismiss();
                    super.onPostExecute(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


