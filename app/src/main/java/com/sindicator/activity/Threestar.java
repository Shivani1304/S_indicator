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
public class Threestar extends Fragment {

    ListView threestarlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.threestar, container, false);
        threestarlist = (ListView) view.findViewById(R.id.threestar);
        threestarlist.setAdapter(new ThreeAdp(getContext()));

        return view;
    }

    class ThreeStarList {
        String hotelname;
        String hoteladr;

        public ThreeStarList(String hotelname, String hoteladr){
            this.hotelname = hotelname;
            this.hoteladr = hoteladr;
        }
    }

    class ThreeAdp extends BaseAdapter{

        ArrayList<ThreeStarList> arrayList;
        Context context;
        LayoutInflater inflater;

        ThreeAdp(Context context)
        {
            this.context=context;
            arrayList=new ArrayList<>();
            Resources res=context.getResources();

            String[] hotel_name=res.getStringArray(R.array.threename);
            String[] hotel_adr=res.getStringArray(R.array.threeadr);

            for (int i=0;i<6;i++)
            {
                arrayList.add(new ThreeStarList(hotel_name[i],hotel_adr[i]));
            }
        }


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return arrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            TextView hotels;
            TextView adrs;
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            Typeface tf=Typeface.createFromAsset(context.getAssets(),"Dustismo_Roman.ttf");

            View v=inflater.inflate(R.layout.hotel_layout,viewGroup,false);
            hotels= (TextView) v.findViewById(R.id.txthotel);
            adrs= (TextView) v.findViewById(R.id.txthoteladr);

            hotels.setTypeface(tf);
            adrs.setTypeface(tf);

            ThreeStarList threeStarList=arrayList.get(i);
            hotels.setText(threeStarList.hotelname);
            adrs.setText(threeStarList.hoteladr);
            return v;
        }
    }
}