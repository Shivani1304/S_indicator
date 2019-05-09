package com.sindicator.adapters;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sindicator.R;

import com.sindicator.models.PicnicModelClass;

import java.util.ArrayList;

/**
 * Created by Shivani on 12/28/2016.
 */

public class CustomAdapter extends BaseAdapter {

    ArrayList<PicnicModelClass> arrayList=new ArrayList<>();
    Context context;
    LayoutInflater inflater;


    public CustomAdapter(Context context, ArrayList<PicnicModelClass> arrayList)
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
        View v= inflater.inflate(R.layout.items,viewGroup,false);
        TextView txtpicnic= (TextView) v.findViewById(R.id.txtpicnic);
        TextView txtdis= (TextView) v.findViewById(R.id.txtdis);

        Typeface tf=Typeface.createFromAsset(context.getAssets(),"Dustismo_Roman.ttf");
        txtpicnic.setTypeface(tf);
        txtdis.setTypeface(tf);

        PicnicModelClass m=arrayList.get(i);
        txtpicnic.setText(m.getPicnicname());
        txtdis.setText(m.getDiscription());
        return v;
    }
}
