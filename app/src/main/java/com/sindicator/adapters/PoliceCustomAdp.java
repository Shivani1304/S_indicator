package com.sindicator.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sindicator.R;
import com.sindicator.models.PoliceModelClass;

import java.util.ArrayList;

/**
 * Created by Shivani on 1/10/2017.
 */

public class PoliceCustomAdp extends BaseAdapter {

    Context context;
    ArrayList<PoliceModelClass> arrayList=new ArrayList<>();
    LayoutInflater inflater;


    public PoliceCustomAdp(Context context,ArrayList<PoliceModelClass> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
        inflater=LayoutInflater.from(this.context);
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

        View view1=inflater.inflate(R.layout.items_police,viewGroup,false);

        TextView police_station= (TextView) view1.findViewById(R.id.police);
        TextView contactnum= (TextView) view1.findViewById(R.id.connum);
        TextView areaname= (TextView) view1.findViewById(R.id.area);

        Typeface tf=Typeface.createFromAsset(context.getAssets(),"Dustismo_Roman.ttf");
        police_station.setTypeface(tf);
        contactnum.setTypeface(tf);
        areaname.setTypeface(tf);

        PoliceModelClass policeModelClass=arrayList.get(i);
        police_station.setText(policeModelClass.getP_station());
        contactnum.setText(policeModelClass.getContactnumber());
        areaname.setText(policeModelClass.getArea());

        return view1;
    }
}
