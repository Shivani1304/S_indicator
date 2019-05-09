package com.sindicator.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sindicator.R;

import java.util.ArrayList;

/**
 * Created by sony on 29-01-2017.
 */
public class Fivestar extends Fragment {

    ListView fivestarlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View viewitem = inflater.inflate(R.layout.fivestar,container,false);
        fivestarlist = (ListView) viewitem.findViewById(R.id.fivestar);
        fivestarlist.setAdapter(new FiveAdp(getActivity()));
        return viewitem;
    }


    class FiveStarList {
        String hotelname;
        String hoteladr;

        public FiveStarList(String hotelname, String hoteladr) {
            this.hotelname = hotelname;
            this.hoteladr = hoteladr;
        }
    }
        class FiveAdp extends BaseAdapter {

            ArrayList<FiveStarList> arrayList;
            Context context;
            LayoutInflater inflater;

            FiveAdp(Context context)
            {
                this.context=context;
                arrayList=new ArrayList<FiveStarList>();
                Resources res=context.getResources();

                String[] hotel_name=res.getStringArray(R.array.Fivename);
                String[] hotel_adr=res.getStringArray(R.array.Fiveadr);

                for (int i=0;i<2;i++)
                {
                    arrayList.add(new FiveStarList(hotel_name[i],hotel_adr[i]));
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
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView hotels;
                TextView adrs;
                inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                Typeface tf=Typeface.createFromAsset(context.getAssets(),"Dustismo_Roman.ttf");

                View v=inflater.inflate(R.layout.hotel_layout,parent,false);
                hotels= (TextView) v.findViewById(R.id.txthotel);
                adrs= (TextView) v.findViewById(R.id.txthoteladr);

                hotels.setTypeface(tf);
                adrs.setTypeface(tf);

                FiveStarList fiveStarList=arrayList.get(position);
                hotels.setText(fiveStarList.hotelname);
                adrs.setText(fiveStarList.hoteladr);
                return v;
            }
        }
    }

